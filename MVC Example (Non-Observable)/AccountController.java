import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController implements ActionListener {
	private AccountGUI acctGUI;
	private Account acctModel;
	
	public AccountController(AccountGUI gui, Account model) {
		acctGUI = gui;
		acctGUI.addButtonListeners(this);
		
		acctModel = model;
		acctGUI.updateBalance(acctModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		float inputAmt = acctGUI.getInput();
		
		if ( !Float.isNaN(inputAmt) ) {
			switch ( e.getActionCommand() ) {
			case AccountGUI.SET:
				acctModel.setBalance(inputAmt);
				break;
			case AccountGUI.CREDIT:
				acctModel.credit(inputAmt);
				break;
			case AccountGUI.DEBIT:
				acctModel.debit(inputAmt);
				break;	
			}
		}
		
		acctGUI.updateBalance(acctModel);
	}	
}
