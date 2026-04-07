
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
	private ArrayList<Cake> cakes;

	public Inventory(){
		cakes = new ArrayList<>();
	}

	public void addCake(Cake c){
		cakes.add(c);
	}

	public void listInventory(){
		Collections.sort(cakes);
		for(Cake cake : cakes){
			cake.printCard();
		}
	}


	// TODO - implement functions below
	public void priceChange(double percent){
		// TODO - change the price of every cake in cakes
		// using percent as a percent change
		// In other words: price = price * percent
		for(Cake cake : cakes) {
			double newPrice = cake.getPrice()* percent;
			cake.setPrice(newPrice);
		}
	}

	public void saveInventory() throws FileNotFoundException{
		// TODO - save the current Inventory to a csv file called 'inventory.csv'
		// This should have the same structure as 'cakes.csv',
		// so the first row of the csv should be 'Tiers,Flavor,Price'
		// NOTE - this file should be compatible with the 'populate' function in the runner class
		PrintWriter out = new PrintWriter(new File("inventory.csv"));
		out.println("Tiers,Flavor,Price");
		
		for(Cake cake: cakes) {
			out.println(cake.getTiers()+ "," +cake.getFlavor()+","+cake.getPrice());
		}
		out.close();
		}
	}

