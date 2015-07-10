import java.text.DecimalFormat;

public class Account {
	private float balance;
	private static DecimalFormat formatter = new DecimalFormat("0.00");
	
	public Account() {
		this(0);
	}
	
	public Account(float amt) {
		balance = amt;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float amt) {
		balance = amt;
	}
	
	public void debit(float amt) {
		balance -= amt;
	}
	
	public void credit(float amt) {
		balance += amt;
	}
	
	public String toString() {
		return formatter.format(balance);
	}
}
