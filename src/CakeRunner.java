

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CakeRunner {
	public static void main(String[] args) throws FileNotFoundException {
		Inventory cakes = populate();

		char option = 'a';
		Scanner in = new Scanner(System.in);
		while (option != 'q') {
			menuList();

			option = in.next().charAt(0);
			switch (option) {
			case '1':
				promptAddCake(cakes, in);
				break;
			case '2':
				cakes.listInventory();
				break;
			case '3':
				promptChangePrice(cakes, in);
				break;
			}
		}

		cakes.saveInventory();
		in.close();
	}

	public static void menuList() {
		System.out.println("Please select one of the following:");
		System.out.println("\t1- Make a new cake");
		System.out.println("\t2- List Inventory");
		System.out.println("\t3- Change Price");
		System.out.println("\tq- Exit");
	}

	public static Inventory populate() throws FileNotFoundException {
		Inventory cakes = new Inventory();
		File inFile;
		Scanner in = null;

		try {
			inFile = new File("inventory.csv");
			if (inFile.exists()) {
				in = new Scanner(inFile);
			} else {
				in = new Scanner(new File("cakes.csv"));
			}
		} catch (FileNotFoundException e) {
			System.out.println("No files found. ");
			return cakes;
		}

		if (in.hasNextLine()) {
			in.nextLine(); 
		}

		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] values = line.split(",");
			cakes.addCake(new Cake(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2])));
		}

		in.close();
		return cakes;
	}

	public static void promptAddCake(Inventory i, Scanner sc) {
			System.out.println("How many tiers is this cake?");
			int t = sc.nextInt();
			sc.nextLine(); 
			System.out.println("What is the flavor of your cake?");
			String f = sc.nextLine();
			System.out.println("How much is this cake?");
			double p = sc.nextDouble();

			i.addCake(new Cake(t, f, p));
		}
	

	public static void promptChangePrice(Inventory i, Scanner sc) {
			System.out.println("Enter percent price change: ");
			double percent = sc.nextDouble();
			i.priceChange(percent);
		}
	}

