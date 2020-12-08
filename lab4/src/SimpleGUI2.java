import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI2 {

	private JFrame frame;
	private JTextField textfield1;
	private JCheckBox check = new JCheckBox("text?", false);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUI2 window = new SimpleGUI2();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleGUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("some text");
		frame.setBounds(100, 100, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 2, 2, 10));
		
		JLabel label = new JLabel("still text"); 
		frame.getContentPane().add(label);
		
		textfield1 = new JTextField(10);
		frame.getContentPane().add(textfield1);
		
		JButton button = new JButton("another text");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder msg = new StringBuilder("");
				
				if(check.isSelected()) 
					msg.append("checked: "+ textfield1.getText());				
		        
				else 
					msg.append("unchecked: "+ textfield1.getText());
				
		        JOptionPane.showMessageDialog(null, msg, "text",JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		frame.getContentPane().add(button);
		
//		JCheckBox check = new JCheckBox("text?", false);
		frame.getContentPane().add(check);
		
	}
}