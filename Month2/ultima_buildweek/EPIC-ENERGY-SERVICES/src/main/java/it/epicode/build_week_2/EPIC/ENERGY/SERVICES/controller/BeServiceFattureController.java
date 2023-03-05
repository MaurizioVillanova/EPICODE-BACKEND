package it.epicode.build_week_2.EPIC.ENERGY.SERVICES.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.Random;

import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceClienti;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.BeServiceFatture;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceClientiRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.repository.BeServiceFattureRepo;
import it.epicode.build_week_2.EPIC.ENERGY.SERVICES.service.BeServiceFattureService;
import com.itextpdf.text.BaseColor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfException;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Controller
public class BeServiceFattureController {
	
	@Autowired
	BeServiceFattureRepo fr;
	
	@Autowired
	BeServiceFattureService fs;
	
	@Autowired
	BeServiceClientiRepo clientiRepository;
	
	//FILTRO E PAGINATION CON RANGE FATTURE PER CLIENTE
	// http://localhost:8080/fatture-cliente/5
	@GetMapping("/fatture-cliente/{id}")
    public ResponseEntity<Page<BeServiceFatture>> trovaFatturePerClienteId(@PathVariable Long id,
                                                                          @RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BeServiceFatture> fatture = fr.findByClienteId(id, pageable);
        if (fatture.hasContent()) {
            return ResponseEntity.ok(fatture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	//FILTRO E PAGINATION CON RANGE FATTURE PER ANNO
	// http://localhost:8080/fatture-anno/2020
	@GetMapping("/fatture-anno/{anno}")
    public ResponseEntity<Page<BeServiceFatture>> trovaFatturePerAnno(@PathVariable Long anno,
                                                                          @RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BeServiceFatture> fatture = fr.findByAnno(anno, pageable);
        if (fatture.hasContent()) {
            return ResponseEntity.ok(fatture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	  //METODO PER FILTRARE E ORDINARE LE FATTURE IN BASE ALLO STATO PAGATO E NON PAGATO
		//localhost:8080/fatture-stato/pagata
		
		//localhost:8080/fatture-stato/non%20pagata
		
		@GetMapping("/fatture-stato/{stato}")
		public ResponseEntity<Page<BeServiceFatture>> trovaFatturePerStato(@PathVariable String stato,
		                                                                      @RequestParam(defaultValue = "0") int page,
		                                                                      @RequestParam(defaultValue = "10") int size) {
		    Pageable pageable = PageRequest.of(page, size);
		    Page<BeServiceFatture> fatture = fr.findByStato(stato, pageable);
		    if (fatture.hasContent()) {
		        return ResponseEntity.ok(fatture);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
		
		//----------METODO PER FILTRARE E ORDINARE FATTURE IN BASE ALL'IMPORTO 
		//localhost:8080/fatture-importo?min=100&max=1600
		@GetMapping("/fatture-importo")
		public ResponseEntity<Page<BeServiceFatture>> getFattureByImporto(
		        @RequestParam("min") BigDecimal minImporto, 
		        @RequestParam("max") BigDecimal maxImporto,
		        @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "10") int size) {

		    Pageable pageable = PageRequest.of(page, size);
		    Page<BeServiceFatture> fatture = fr.findByImportoBetween(minImporto, maxImporto, pageable);

		    if (fatture.hasContent()) {
		        return ResponseEntity.ok(fatture);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
		
		//FILTRO E PAGINATION FATTURE USANDO DATA
	    //http://localhost:8080/dataFattura?startDate=2020-01-01?page=0&size=10
	    @GetMapping("/dataFattura")
	    @ResponseBody
	    public ResponseEntity<Page<BeServiceFatture>> getFattureByDate(@RequestParam("startDate") String startDateStr, Pageable pageable) throws ParseException {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = format.parse(startDateStr);
	        Timestamp startTimestamp = new Timestamp(startDate.getTime());
	        Page<BeServiceFatture> fatture = fr.findFatturaByData(startTimestamp, pageable);
	        if (fatture.hasContent()) {
	            return ResponseEntity.ok(fatture);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
		
		//----------POST MAPPING FATTURE
		//localhost:8080/aggiungi/fattura
		
		 @CrossOrigin
			@PostMapping("/aggiungi/fattura")
		    public ResponseEntity<Object> create(@RequestBody BeServiceFatture d) {
			 BeServiceFatture fat = fs.save(d);

		        return new ResponseEntity<>(fat, HttpStatus.CREATED);
		    }
		
		 //--------------CHECK EXIST METHOD
		    private ResponseEntity<Object> checkExists(Optional<BeServiceFatture> obj) {
		        if( !obj.isPresent() ) {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }

		        return null;
		    }
		    
		 //-------DELETE FATTURE
		  //localhost:8080/elimina/fattura/70
		 
		 @DeleteMapping("elimina/fattura/{id}")
		    public ResponseEntity<Object> eliminaFattura(@PathVariable Long id) {
		        Optional<BeServiceFatture> fat = fs.getById(id);
		        ResponseEntity<Object> check = checkExists(fat);
		        if( check != null ) return check;

		        fs.delete(fat.get());
		        return new ResponseEntity<>(
		                String.format("Fattura con id %d eliminata!", id), HttpStatus.OK);
		    }
		 
		 //--------PUT FATTURE
		//localhost:8080/modifica/fattura/70
		 @PutMapping("modifica/fattura/{id}")
		    public ResponseEntity<Object> update(
		            @PathVariable Long id,
		            @RequestBody BeServiceFatture _fat) {

		        Optional<BeServiceFatture> fatObj = fs.getById(id);

		        ResponseEntity<Object> check = checkExists(fatObj);
		        if( check != null ) return check;

		        BeServiceFatture fat = fatObj.get();
		        fat.setAnno(_fat.getAnno());
		        fat.setData(_fat.getData());
		        fat.setBeServiceStatoFattura(_fat.getBeServiceStatoFattura());
		        fat.setBeServiceClienti(_fat.getBeServiceClienti());
		        fat.setImporto(_fat.getImporto());
		        fat.setNumero(_fat.getNumero());

		        return new ResponseEntity<>(fat, HttpStatus.CREATED);
		    }
		 /*
		//-------------FATTURE IN BASE AL NOME DEL CLIENTE
		    //http://localhost:8080/fatture-nomecliente/azue
		    
		    @CrossOrigin
		    @GetMapping("/fatture-nomecliente/{nome}")
		    public ResponseEntity<List<BeServiceFatture>> GetFatturePerClienteNome(@PathVariable String nome) {
		        List<BeServiceFatture> fatture = fr.findFattureByClienteNome(nome);
		        if (!fatture.isEmpty()) {
		            return new ResponseEntity<>(fatture, HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		    } */
		 
		 @CrossOrigin(origins = "http://127.0.0.1:5500")
         @GetMapping("/fatture-nomecliente/{nome}")
         public ResponseEntity<List<BeServiceFatture>> GetFatturePerClienteNome(@PathVariable String nome) {
             List<BeServiceFatture> fatture = fr.findFattureByClienteNome(nome);
             if (!fatture.isEmpty()) {
                 return new ResponseEntity<>(fatture, HttpStatus.OK);
             } else {
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }
         }
		    
		    @GetMapping(value = "/clienti/{clientId}/fatture/{fatturaId}", produces = MediaType.APPLICATION_PDF_VALUE)
			public ResponseEntity<byte[]> getFattura(@PathVariable Long clientId, @PathVariable Long fatturaId) throws DocumentException, IOException {
			    Optional<BeServiceClienti> optionalClienti = clientiRepository.findById(clientId);
			    if (optionalClienti.isPresent()) {
			        BeServiceClienti clienti = optionalClienti.get();
			        Optional<BeServiceFatture> optionalFattura = clienti.getBeServiceFattures().stream()
			                .filter(fattura -> fattura.getId().equals(fatturaId))
			                .findFirst();
			        if (optionalFattura.isPresent()) {
			            BeServiceFatture fattura = optionalFattura.get();
			            
			            Document document = new Document();
			            ByteArrayOutputStream baos = new ByteArrayOutputStream();
			            PdfWriter writer = PdfWriter.getInstance(document, baos);
			            document.open();
			            //FONTS
			            Font Fatturafont = FontFactory.getFont(FontFactory.COURIER, 22, Color.decode("#1EAF54"));
			            Font FontGlobal = FontFactory.getFont(FontFactory.HELVETICA, 16, Color.black);
			            Font LightGray = FontFactory.getFont(FontFactory.HELVETICA, 16, Color.gray);
			            

			            // Create a table with 2 columns and no border
			            PdfPTable tableHeader = new PdfPTable(2);
			            tableHeader.setWidthPercentage(100);
			            tableHeader.getDefaultCell().setBorder(Rectangle.NO_BORDER);

			            // Add the logo image to the first cell
			            PdfPCell logoCell = new PdfPCell();
			            Image logo = Image.getInstance("src/main/resources/epic.png");
			            logo.scaleToFit(200, 200);
			            logoCell.addElement(logo);
			            logoCell.setBorder(Rectangle.NO_BORDER);
			            tableHeader.addCell(logoCell);

			            // Add the text to the second cell
			         // Create cell for text
			            PdfPCell cell2 = new PdfPCell(new Phrase("Fattura", Fatturafont));
			            cell2.setBorder(Rectangle.NO_BORDER);
			            cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            tableHeader.addCell(cell2);
			            tableHeader.setSpacingAfter(50);
			            
			            PdfPTable tableGreetings = new PdfPTable(2);
			            tableGreetings.setSpacingAfter(70);
			            tableGreetings.setWidthPercentage(100);
			            tableGreetings.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			            PdfPCell riga1 = new PdfPCell(new Phrase("Spett.le "+ clienti.getNomeContatto() + " "+ clienti.getCognomeContatto() + ".", FontGlobal));
			            riga1.setBorder(Rectangle.NO_BORDER);
			            tableGreetings.addCell(riga1);
			            PdfPCell order = new PdfPCell(new Phrase("Ordine n°"+ fattura.getId()));
			            order.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            order.setBorder(Rectangle.NO_BORDER);
			            tableGreetings.addCell(order);
			            PdfPCell riga2 = new PdfPCell(new Phrase("Grazie per averci scelto come fornitori. "));
			            riga2.setBorder(Rectangle.NO_BORDER);
			            tableGreetings.addCell(riga2);
			            PdfPCell data = new PdfPCell(new Phrase(fattura.getData()+ " "));
			            data.setBorder(Rectangle.NO_BORDER);
			            data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            tableGreetings.addCell(data);
			            ///////////////////////////////////////////
			            PdfPTable oggetti = new PdfPTable(5);
			            oggetti.setWidthPercentage(100);
			            oggetti.setSpacingAfter(20);

			            // Adding headers to the table
			            PdfPCell item = new PdfPCell(new Phrase("Oggetto", FontGlobal));
			            item.setColspan(2);
			            item.setBorder(Rectangle.BOTTOM);
			            PdfPCell sku = new PdfPCell(new Phrase("SKU", FontGlobal));
			            sku.setBorder(Rectangle.BOTTOM);
			            sku.setHorizontalAlignment(Element.ALIGN_CENTER);
			            PdfPCell quantita = new PdfPCell(new Phrase("Quantità", FontGlobal));
			            quantita.setBorder(Rectangle.BOTTOM);
			            quantita.setHorizontalAlignment(Element.ALIGN_CENTER);
			            PdfPCell subtotal = new PdfPCell(new Phrase("Totale", FontGlobal));
			            subtotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            subtotal.setBorder(Rectangle.BOTTOM);
			            oggetti.addCell(item);
			            oggetti.addCell(sku);
			            oggetti.addCell(quantita);
			            oggetti.addCell(subtotal);
			            Color colorTransparency =  Color.gray; // #1EAF54
			            
			            // Adding data rows to the table using a for loop
			            for (int i = 0; i <= 5; i++) {
			                Integer row = i;
			                PdfPCell itemCell = new PdfPCell(new Phrase("Oggetto "+Integer.toString(i)));
			                itemCell.setColspan(2);
			                itemCell.setBorder(Rectangle.BOTTOM);
			                PdfPCell skuCell = new PdfPCell(new Phrase("CoD." + Integer.toString(i)));
			                skuCell.setBorder(Rectangle.BOTTOM);
			                skuCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                PdfPCell quantitaCell = new PdfPCell(new Phrase("--"));
			                quantitaCell.setBorder(Rectangle.BOTTOM);
			                quantitaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			                PdfPCell subtotalCell = new PdfPCell(new Phrase("-- €"));
			                subtotalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			                subtotalCell.setBorder(Rectangle.BOTTOM);
			                // Alternate row colors
			                if (i % 2 == 0) {
			                	itemCell.setBackgroundColor(colorTransparency);
			                	skuCell.setBackgroundColor(colorTransparency);
			                	quantitaCell.setBackgroundColor(colorTransparency);
			                	subtotalCell.setBackgroundColor(colorTransparency);
			                }
			                oggetti.addCell(itemCell);
			                oggetti.addCell(skuCell);
			                oggetti.addCell(quantitaCell);
			                oggetti.addCell(subtotalCell);
			                
			            }

			            //
			            PdfPTable totaleTable = new PdfPTable(1);
			            totaleTable.setSpacingAfter(60);
			            totaleTable.setWidthPercentage(100);
			            PdfPCell totale = new PdfPCell(new Phrase("Totale fattura "+fattura.getImporto()+ "€", FontGlobal));
			            totale.setBorder(Rectangle.NO_BORDER);
			            totale.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            totaleTable.addCell(totale);
			            double spedizioneCost = 9.99;
			            PdfPCell spedizione = new PdfPCell(new Phrase("Spedizione e trasporto " + spedizioneCost + "€", FontGlobal));
			            spedizione.setBorder(Rectangle.NO_BORDER);
			            spedizione.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            totaleTable.addCell(spedizione);
			            BigDecimal totale2 = BigDecimal.valueOf(spedizioneCost).add(fattura.getImporto());
			            PdfPCell totaleOrdine = new PdfPCell(new Phrase("Totale ordine " + totale2 + "€", FontGlobal));
			            totaleOrdine.setBorder(Rectangle.NO_BORDER);
			            totaleOrdine.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            totaleTable.addCell(totaleOrdine);
			            int ivaPerc = 22;
			            BigDecimal ivaBig = new BigDecimal(ivaPerc);
			            BigDecimal ivaValue = totale2.divide(ivaBig, 2, RoundingMode.HALF_UP);
			            PdfPCell iva = new PdfPCell(new Phrase("Iva 22% " + ivaValue + "€", FontGlobal));
			            iva.setBorder(Rectangle.NO_BORDER);
			            iva.setHorizontalAlignment(Element.ALIGN_RIGHT);
			            totaleTable.addCell(iva);
			            ////////////////////////////////////////
			            PdfPTable infoCliente = new PdfPTable(2);
			            infoCliente.setWidthPercentage(100);
			            infoCliente.setSpacingAfter(50);
			            PdfPCell informazioniFatturazione = new PdfPCell(new Phrase("Informazioni fatturazione", LightGray));
			            informazioniFatturazione.setBorder(Rectangle.NO_BORDER);
			            PdfPCell metodoPagamento = new PdfPCell(new Phrase("Metodo di pagamento", LightGray));
			            metodoPagamento.setBorder(Rectangle.NO_BORDER);
			            PdfPCell clienteInfo = new PdfPCell(new Phrase(clienti.getNomeContatto() + clienti.getCognomeContatto()));
			            clienteInfo.setBorder(Rectangle.NO_BORDER);
			            PdfPCell tipologiaPagamento = new PdfPCell(new Phrase("Carta di Credito"));
			            tipologiaPagamento.setBorder(Rectangle.NO_BORDER);
			            PdfPCell indirizzo = new PdfPCell(new Phrase(clienti.getBeServiceIndirizzi1().getVia()+", "+ clienti.getBeServiceIndirizzi1().getLocalita()+", CAP "+ clienti.getBeServiceIndirizzi1().getCap()));
			            indirizzo.setBorder(Rectangle.NO_BORDER);
			            PdfPCell tipologiaCarta = new PdfPCell(new Phrase("Carta di Credito VISA"));
			            tipologiaCarta.setBorder(Rectangle.NO_BORDER);
			            PdfPCell telefono= new PdfPCell(new Phrase(clienti.getTelefonoContatto()));
			            telefono.setBorder(Rectangle.NO_BORDER);
			            Random r = new Random(1000000);
			            int randomNumber = r.nextInt();
			            PdfPCell transazione = new PdfPCell(new Phrase("Transazione n° "+randomNumber));
			            transazione.setBorder(Rectangle.NO_BORDER);
			            infoCliente.addCell(informazioniFatturazione);
			            infoCliente.addCell(metodoPagamento);
			            infoCliente.addCell(clienteInfo);
			            infoCliente.addCell(tipologiaPagamento);
			            infoCliente.addCell(indirizzo);
			            infoCliente.addCell(tipologiaCarta);
			            infoCliente.addCell(telefono);
			            infoCliente.addCell(transazione);
			            //////////////////////////////////////////////
			            PdfPTable infoSpedizione = new PdfPTable(2);
			            infoSpedizione.setWidthPercentage(100);
			            PdfPCell informazioniSpedizione = new PdfPCell(new Phrase("Informazioni Spedizione", LightGray));
			            informazioniSpedizione.setBorder(Rectangle.NO_BORDER);
			            
			            PdfPCell metodoSpedizione = new PdfPCell(new Phrase("Tipologia spedizione", LightGray));
			            metodoSpedizione.setBorder(Rectangle.NO_BORDER);
			            PdfPCell ragioneSociale = new PdfPCell(new Phrase(clienti.getRagioneSociale()));
			            ragioneSociale.setBorder(Rectangle.NO_BORDER);
			            PdfPCell tipologiaSpedizone = new PdfPCell(new Phrase("Standard"));
			            tipologiaSpedizone.setBorder(Rectangle.NO_BORDER);
			            PdfPCell indirizzoAzienda = new PdfPCell(new Phrase(clienti.getBeServiceIndirizzi2().getVia()+ ", CAP "+clienti.getBeServiceIndirizzi2().getCap()));
			            indirizzoAzienda.setColspan(2);
			            indirizzoAzienda.setBorder(Rectangle.NO_BORDER);
			            PdfPCell indirizzoAzienda2 = new PdfPCell(new Phrase(clienti.getBeServiceIndirizzi2().getLocalita()+ ", "+ clienti.getBeServiceIndirizzi2().getBeServiceComuni().getNome()));
			            indirizzoAzienda2.setBorder(Rectangle.NO_BORDER);
			            indirizzoAzienda2.setColspan(2);
			            infoSpedizione.addCell(informazioniSpedizione);
			            infoSpedizione.addCell(metodoSpedizione);
			            infoSpedizione.addCell(ragioneSociale);
			            infoSpedizione.addCell(tipologiaSpedizone);
			            infoSpedizione.addCell(indirizzoAzienda);
			            infoSpedizione.addCell(indirizzoAzienda2);
			         
			            
			            
			            // Add the tables to the document
			            document.add(tableHeader);
			            document.add(tableGreetings);
			            document.add(oggetti);
			            document.add(totaleTable);
			            document.add(infoCliente);
			            document.add(infoSpedizione);

			            document.close();
			            byte[] contents = baos.toByteArray();
			            HttpHeaders headers = new HttpHeaders();
			            headers.setContentType(MediaType.APPLICATION_PDF);
			            headers.setContentDisposition(ContentDisposition.builder("inline").build());
			            headers.setContentLength(contents.length);
			            return new ResponseEntity<>(contents, headers, HttpStatus.OK);
			        }
			    }
			    return ResponseEntity.notFound().build();
			}
}
