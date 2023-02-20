package it.epicode.be.godfather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import it.epicode.be.godfather.model.Drink;
import it.epicode.be.godfather.model.DrinkLemonade;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.MenuItem;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.Pizza;
import it.epicode.be.godfather.model.PizzaHawaiian;
import it.epicode.be.godfather.model.PizzaMargherita;
import it.epicode.be.godfather.model.PizzaSalami;
import it.epicode.be.godfather.model.Tavolo;
import it.epicode.be.godfather.model.ToppingCheese;
import it.epicode.be.godfather.model.ToppingHam;
import it.epicode.be.godfather.repository.DrinkRepository;
import it.epicode.be.godfather.repository.FranchiseRepository;
import it.epicode.be.godfather.repository.MenuRepository;
import it.epicode.be.godfather.repository.OrdineRepository;
import it.epicode.be.godfather.repository.PizzaRepository;
import it.epicode.be.godfather.repository.PizzaToppingRepository;
import it.epicode.be.godfather.repository.TavoloRepository;

@Component
public class MenuRunner implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(MenuRunner.class);

	@Autowired
	private Menu menu;
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@Autowired
	private DrinkRepository drinkRepo;
	@Autowired
	private FranchiseRepository franRepo;
	@Autowired
	private MenuRepository menuRepo;
	@Autowired
	private OrdineRepository ordineRepo;
	@Autowired
	private PizzaToppingRepository toppingRepo;
	@Autowired
	private TavoloRepository tavoloRepo;
	
	@Value("${godfatherpizza.costocoperto}")
	private Double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
		

		
		Tavolo tavolo = new Tavolo(1,5,true);
		
		
		Ordine ordine = creaOrdine(tavolo,3, costoCoperto);
		
		valorizzaOrdine(ordine);
		
		stampaOrdine(ordine);
		
	}

	private void valorizzaOrdine(Ordine ordine) {

		for (int i = 0;i<3;i++) {
			Pizza pizza = new PizzaMargherita();
			ordine.addMenuItem(pizza);
		}
		
		Pizza pizzaTopping1 = new ToppingCheese(new PizzaHawaiian());
		pizzaTopping1 = new ToppingHam(pizzaTopping1);
		ordine.addMenuItem(pizzaTopping1);
		
		pizzaTopping1 = new ToppingCheese(new PizzaHawaiian());
		pizzaTopping1 = new ToppingHam(pizzaTopping1);
		ordine.addMenuItem(pizzaTopping1);
		
		Pizza pizzaTopping2 = new ToppingCheese(new PizzaSalami());
		ordine.addMenuItem(pizzaTopping2);
		
		Pizza pizzaTopping3 = new ToppingCheese(new PizzaSalami());
		pizzaTopping3 = new ToppingHam(pizzaTopping3);
		ordine.addMenuItem(pizzaTopping3);
		
		Drink drink = new DrinkLemonade();
		ordine.addMenuItem(drink);
		
	}

	public Ordine creaOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto2) {

		Ordine ordine = new Ordine();
		ordine.setTavolo(tavolo);
		ordine.setNumeroCoperti(numeroCoperti);
		ordine.setNumeroOrdine(1);
		ordine.setCostoCoperto(costoCoperto2);

		return ordine;
	}

	public void stampaOrdine(Ordine ordine) {




	}
}
