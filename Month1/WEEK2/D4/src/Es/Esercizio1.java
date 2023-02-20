package Es;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Esercizio1 {

	private static Ordine ordineDiPiero;

	public static void main(String[] args) {
	   
	        Prodotto felpa = new Prodotto( 1256554, "Felpa Philippe Plaine", Categoria.BABY, 455.45 );
	        Prodotto berretto = new Prodotto( 1551654, "Berretto YYK", Categoria.BABY, 55 );
	        Prodotto guanti = new Prodotto( 1453654, "Guanti in pelle", Categoria.BOY, 155.45 );
	        Prodotto occhiali = new Prodotto( 1356754, "Occhiali da sole Rayban", Categoria.BOY, 95.95 );
	        Prodotto felpa2 = new Prodotto( 1256554, "Felpa Philippe Plae", Categoria.BOY, 55.45 );
	        Prodotto berretto2 = new Prodotto( 1551654, "Berretto NYYK", Categoria.BABY, 55 );
	        Prodotto guanti2 = new Prodotto( 1453654, "Guanti in pelle", Categoria.BOOKS, 155.45 );
	        Prodotto occhiali2 = new Prodotto( 1356754, "Occhiali da sole Rayban", Categoria.BOY, 95.95 );
	        Prodotto felpa3 = new Prodotto( 1256554, "Felpa  Plaine", Categoria.BOOKS, 455.45 );
	        Prodotto berretto3 = new Prodotto( 1551654, "Berretto ", Categoria.BABY, 55 );
	        Prodotto guanti3 = new Prodotto( 1453654, "Guanti ", Categoria.BOOKS, 155.45 );
	        Prodotto occhiali3 = new Prodotto( 1356754, "Occhiali da ", Categoria.BOY, 95.95 );
	        Prodotto felpa4 = new Prodotto( 1256554, "Felpa Philippe ", Categoria.BABY, 55.45 );
	        Prodotto berretto4 = new Prodotto( 1551654, "Berretto NY", Categoria.BOY, 55 );
	        Prodotto guanti4 = new Prodotto( 1453654, "Guanti in pelle", Categoria.BOOKS, 155.45 );
	        Prodotto occhiali4 = new Prodotto( 1356754, "Occhiali da sole Rayban", Categoria.BOY, 95.95 );

	        //LISTA DI PRODOTTI
	        List<Prodotto> listaProdotti = new ArrayList<>();
	        listaProdotti.add( felpa );
	        listaProdotti.add( berretto );
	        listaProdotti.add( guanti );
	        listaProdotti.add( occhiali );
	        listaProdotti.add( felpa2 );
	        listaProdotti.add( berretto2 );
	        listaProdotti.add( guanti2 );
	        listaProdotti.add( occhiali2 );
	        listaProdotti.add( felpa3 );
	        listaProdotti.add( berretto3 );
	        listaProdotti.add( guanti3 );
	        listaProdotti.add( occhiali3 );
	        listaProdotti.add( felpa4 );
	        listaProdotti.add( berretto4 );
	        listaProdotti.add( guanti4 );
	        listaProdotti.add( occhiali4 );

	        // LISTA CLIENTI
	        List<Cliente> listaClienti = new ArrayList<Cliente>();

	        Cliente Piero = new Cliente( 12332223, "Piero", 1 );
	        Cliente Filippo = new Cliente( 123315423, "Filippo", 3 );
	        Cliente Mike = new Cliente( 123312323, "Mike", 2 );
	        Cliente Maria = new Cliente( 1212315423, "Maria", 1 );
	        Cliente Fabiola = new Cliente( 12331623, "Fabiola", 2 );

	        listaClienti.add( Piero );
	        listaClienti.add( Filippo );
	        listaClienti.add( Mike );
	        listaClienti.add( Maria );
	        listaClienti.add( Fabiola );

	        //LISTA DI ORDINI
	        Ordine ordineDiPiero = new Ordine( 12344556, new ArrayList<Prodotto>( Arrays.asList(
	                felpa,
	                berretto,
	                guanti,
	                occhiali,
	                felpa2,
	                berretto2,
	                guanti2,
	                occhiali2,
	                felpa3
	        ) ), Piero );

	        Ordine ordineDiMike = new Ordine( 52344556, new ArrayList<Prodotto>( Arrays.asList(
	                felpa,
	                occhiali2,
	                felpa3
	        ) ), Mike );

	        Ordine ordineDiFilippo = new Ordine( 22344556, new ArrayList<Prodotto>( Arrays.asList(
	                felpa,
	                guanti3,
	                felpa3
	        ) ), Filippo );

	        Ordine ordineDiMaria = new Ordine( 22344556, new ArrayList<Prodotto>( Arrays.asList(
	                felpa,
	                felpa3
	        ) ), Maria );

	        Ordine ordineDiFabiola = new Ordine( 22344556, new ArrayList<Prodotto>( Arrays.asList(
	                felpa,
	                felpa3,
	                guanti3,
	                occhiali
	        ) ), Fabiola );


	        List<Ordine> listaOrdini = new ArrayList<>();
	        listaOrdini.add( ordineDiMike );
	        listaOrdini.add( ordineDiPiero );
	        listaOrdini.add( ordineDiFilippo );
	        listaOrdini.add( ordineDiMaria );
	        listaOrdini.add( ordineDiFabiola );


	        MyStore store = new MyStore();

	        // RICERCA PRODOTTO PER PREZZO
	        List<Prodotto> filtro100 = store.filtraProdottoPerPrezzo( 100, listaProdotti );

	        //RICERCA PRODOTTO PER CATEGORIA
	        List<Prodotto> filtroBaby = store.filtraProdottoPerCategoria( Categoria.BABY, listaProdotti );

	        // SETTO UNA PROMOZIONE AD UNA LISTA DI PRODOTTI
	        List<Prodotto> inPromozione = store.promozione( 10, filtroBaby );

	        // SETTO UNA PROMOZIONE ALLA CATEGORIA BABY
	        List<Prodotto> BoysInPromozione = store.promozione( 10, store.filtraProdottoPerCategoria(
	                Categoria.BOY,
	                listaProdotti ) );

	        // RICERCO PRODOTTO DA UNA LISTA DI ORDINI DI CLIENTI LIVELLO 2
	        List<Prodotto> livelloClienteProdotti = store.filtraProdottoOrdinatoPerLivelloCliente( 2, listaOrdini );


	        System.out.println( "Prodotti a più di 100 euro - " + filtro100 );
	        System.out.println( "Prodotti categoria Baby - " + filtroBaby );
	        System.out.println( "Promozione applicata a Baby - " + inPromozione );
	        System.out.println( "Promozione applicata a Boys - " + BoysInPromozione );
	        System.out.println( "Lista livello prodotti ordinati: "+livelloClienteProdotti );

	    }
	}


	class MyStore {


	    public List<Prodotto> filtraProdottoPerPrezzo( double prezzo, List<Prodotto> catalogo ) {
	        List<Prodotto> catalogoFiltrato = new ArrayList<>();
	        catalogo.stream()
	                .filter( p -> p.getPrezzo() > prezzo )
	                .filter( p -> p.getCategoria() == Categoria.BOOKS )
	                .forEach( catalogoFiltrato::add );

	        return catalogoFiltrato;
	    }

	    public List<Prodotto> filtraProdottoPerCategoria( Categoria categoria, List<Prodotto> catalogo ) {
	        List<Prodotto> catalogoFiltrato = new ArrayList<>();

	        catalogo.stream()
	                .filter( p -> p.getCategoria() == categoria )
	                .forEach( catalogoFiltrato::add );

	        return catalogoFiltrato;
	    }

	    public List<Prodotto> filtraProdottoOrdinatoPerLivelloCliente( int livello, List<Ordine> ordini ) {
	        List<Ordine> ordiniFiltrati = new ArrayList<>();
	        List<Prodotto> prodottiFiltrati = new ArrayList<>();

	        ordini.stream()
	                .filter( ordine -> ordine.getCliente().getLivello() == livello )
	                .forEach( ordiniFiltrati::add );

	        ordiniFiltrati.stream()
	                .forEach( o -> {
	                    List<Prodotto> listaProdottiOrdini = o.getProdotti();
	                    prodottiFiltrati.addAll( listaProdottiOrdini );
	                } );
	        System.out.println( ordiniFiltrati );
	        return prodottiFiltrati;
	    }

	    public List<Prodotto> promozione( int sconto, List<Prodotto> catalogo ) {
	        List<Prodotto> catalogoFiltrato = new ArrayList<>();

	        catalogo.stream()
	                .forEach( prodotto -> {
	                    double scn = (prodotto.getPrezzo() * sconto) / 100;
	                    prodotto.setPrezzo( prodotto.getPrezzo() - scn );
	                    catalogoFiltrato.add( prodotto );
	                } );


	        return catalogoFiltrato;
	    }
	}
