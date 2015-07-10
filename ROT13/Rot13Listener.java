import java.awt.event.*;
import javax.swing.JOptionPane;

public class Rot13Listener implements ActionListener {
	private Rot13GUI rot13GUI; 
	
	public Rot13Listener(Rot13GUI rot13GUI) {
		this.rot13GUI = rot13GUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ( command.equals(Rot13GUI.TEXT_FROM_FILE) ) {
			rot13GUI.importFromFile();
		} else if ( command.equals(Rot13GUI.QUIT) ) {
			System.exit(0);
		} else if ( command.equals(Rot13GUI.CIPHER) ) {
			rot13GUI.setText( Rot13.cipher( rot13GUI.getText() ) );
		} else if ( command.equals(Rot13GUI.ABOUT_ROT13) ) {
			JOptionPane.showMessageDialog(rot13GUI, 
										  Rot13GUI.ROT_13_INFO, 
										  Rot13GUI.ABOUT_ROT13, 
										  JOptionPane.INFORMATION_MESSAGE);
		} else if ( command.equals(Rot13GUI.ABOUT_AUTHOR) ) {
			JOptionPane.showMessageDialog(rot13GUI, 
					  					  Rot13GUI.AUTHOR_INFO, 
					  					  Rot13GUI.ABOUT_AUTHOR, 
					  					  JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
