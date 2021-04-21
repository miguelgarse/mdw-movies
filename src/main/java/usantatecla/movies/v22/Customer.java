package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	private double totalCharge;

	private int totalFrequentRenterPoints;

	
	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = this.rentals.iterator();
		String result = "Rental Record for " + this.getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		
		getTotal();
		
		result += "Amount owed is " + String.valueOf(this.totalCharge) + "\n";
		result += "You earned " + String.valueOf(this.totalFrequentRenterPoints) + " frequent renter points";
		return result;
	}

	private void getTotal() {
		Iterator<Rental> rentals = this.rentals.iterator();
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			this.totalCharge += each.getCharge();
			this.totalFrequentRenterPoints += each.getFrequentRenterPoints();
		}
	}

}
