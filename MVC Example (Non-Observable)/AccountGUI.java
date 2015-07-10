import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AccountGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String 	SET = "Set",
								CREDIT = "Credit",
								DEBIT = "Debit";
	private JLabel displayArea;
	private JTextField inputField;
	private JButton setButton, creditButton, debitButton;
	
	public AccountGUI() {
		super("Account MVC Demonstration (Non-Observable)");
		initialize();
	}
	
	private void initialize() {
		setLocation(100, 100);
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout() );
		setResizable(false);
		
		displayArea = new JLabel("Your Account Balance: $");
		displayArea.setFont( new Font(Font.SANS_SERIF, Font.BOLD, 16) );
		add(displayArea, BorderLayout.NORTH);
		
		inputField = new JTextField();
		add(inputField, BorderLayout.CENTER);
		
		setButton = new JButton(SET);
		creditButton = new JButton(CREDIT);
		debitButton = new JButton(DEBIT);
		JPanel southPanel = new JPanel( new GridLayout(1, 3) );
		southPanel.add(setButton);
		southPanel.add(creditButton);
		southPanel.add(debitButton);
		add(southPanel, BorderLayout.SOUTH);
	}

	public float getInput() {
		try {
			return Float.parseFloat( inputField.getText() );
		} catch (NumberFormatException nfe) {
			return Float.NaN;
		}
	}
	
	public void addButtonListeners(ActionListener listener) {
		setButton.addActionListener(listener);
		creditButton.addActionListener(listener);
		debitButton.addActionListener(listener);
	}
	
	public void updateBalance(Account acct) {
		displayArea.setText("Your Account Balance: $" + acct);
		inputField.setText(null);
	}
}
