
public class Main {
	public static void main(String[] args) {
		AccountView acctGUI = new AccountView();
		new AccountController(acctGUI, new Account());
		acctGUI.setVisible(true);
	}
}
