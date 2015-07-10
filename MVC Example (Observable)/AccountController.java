import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController implements ActionListener {
	private AccountView acctGUI;
	private Account acctModel;
	
	public AccountController(AccountView gui, Account model) {
		acctGUI = gui;
		acctGUI.addButtonListeners(this);
		
		acctModel = model;
		acctModel.addObserver(acctGUI);
		
		acctGUI.updateBalance(acctModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		float inputAmt = acctGUI.getInput();
		
		if ( !Float.isNaN(inputAmt) ) {
			switch ( e.getActionCommand() ) {
			case AccountView.SET:
				acctModel.set(inputAmt);
				break;
			case AccountView.CREDIT:
				acctModel.credit(inputAmt);	
				break;
			case AccountView.DEBIT:
				acctModel.debit(inputAmt);
				break;
			}
		}
	}	
}
