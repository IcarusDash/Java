import java.text.DecimalFormat;
import java.util.Observable;

public class Account extends Observable {
	private float balance;
	private static DecimalFormat formatter = new DecimalFormat("0.00");
	
	public Account() {
		this(0);
	}
	
	public Account(float amt) {
		balance = amt;
	}
	
	public float getAmount() {
		return balance;
	}
	
	public void set(float amt) {
		balance = amt;
		setChanged();
		notifyObservers();
	}
	
	public void debit(float amt) {
		balance -= amt;
		setChanged();
		notifyObservers();
	}
	
	public void credit(float amt) {
		balance += amt;
		setChanged();
		notifyObservers();
	}
	
	public String toString() {
		return formatter.format(balance);
	}
}
