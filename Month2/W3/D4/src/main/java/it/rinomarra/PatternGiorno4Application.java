package it.rinomarra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.joda.LocalDateParser;

import it.rinomarra.adapter.Adapter;
import it.rinomarra.adapter.Info;
import it.rinomarra.adapter.UseData;
import it.rinomarra.composite.ComponenteLibro;
import it.rinomarra.composite.Libro;
import it.rinomarra.composite.Pagina;
import it.rinomarra.composite.Sezione;

@SpringBootApplication
public class PatternGiorno4Application {
	
	private static List<ComponenteLibro> listaComponenti;
	private static List<String> autori;

	public static void main(String[] args){
		SpringApplication.run(PatternGiorno4Application.class, args);
		methodComposite();
	}
	
	public static void methodComposite() {		
		autori = new ArrayList<String>();
		listaComponenti = new ArrayList<ComponenteLibro>();
		autori.add("Mario Rossi");
		Libro libro = new Libro();
		Sezione sezione = new Sezione("Sezione1");
		Pagina paginaSezione = new Pagina(15);
		listaComponenti.add(sezione);
		listaComponenti.add(paginaSezione);
		libro.setAutori(autori);
		libro.setPrezzo(10.0d);
		libro.setTitolo("Primo Libro");
		Sezione sottoSezione = new Sezione("Sotto Sezione");
		Pagina pagineSottoSezione = new Pagina(15);
		listaComponenti.add(sottoSezione);
		listaComponenti.add(pagineSottoSezione);
		libro.setListaComponenti(listaComponenti);
		libro.stampa();
		int numeroTot = libro.getNumeroPagine();
		System.out.println("Numero totale pagine: "+numeroTot);
		
	}
	
	public static void methodAdapter() throws ParseException {
		Info info = new Info(); 
		info.setNome("Mario");
		info.setCognome("Rossi");
		String myDate = "1990/10/29";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sdf.parse(myDate);
		info.DataDiNascita(date);
		
		Adapter adapter = new Adapter(info);
		UseData useData = new UseData();
		useData.getData(adapter);
		System.out.println("Nome completo: "+adapter.getNomeCompleto());
		System.out.println("Età: "+	adapter.getEta());
	}

}
