
public class Main {

	public static void main(String[] args) {
		AccountGUI acctGUI = new AccountGUI();
		new AccountController(acctGUI, new Account());
		acctGUI.setVisible(true);
	}

}
