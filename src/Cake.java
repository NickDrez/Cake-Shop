//Nick Drez
//892140140
//Lab4

public class Cake implements Comparable<Cake>{
	// Instance variables
	private int tiers;
	private String flavor;
	private double price;

	public Cake(int t, String f, double p){
		tiers = t;
		flavor = f;
		price = p;
	}

	// getter methods
	public int getTiers(){
		return tiers;
	}

	public String getFlavor() {
		return flavor;
	}

	public double getPrice() {
		return price;
	}

	// setter methods
	public void setPrice(double p){
		price = p;
	}

	public void printCard(){
		System.out.printf("A %d tier %10s cake %10s.%n", tiers, flavor, String.format("$%.2f", price));
	}

	@Override
	public int compareTo(Cake c) {
		if(flavor.compareTo(c.getFlavor())>0){
			return 1;
		}
		else if(flavor.compareTo(c.getFlavor())<0){
			return -1;
		}

		if(price > c.getPrice()){
			return 1;
		}
		else if(price < c.getPrice()){
			return -1;
		}

		return 0;
	}

}
