import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI4 {

	private JFrame frame;
	private JTextField textfield1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUI4 window = new SimpleGUI4();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleGUI4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("WHY NOT");
		frame.setBounds(100, 100, 300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		Container container = frame.getContentPane();
		frame.setLayout(new GridLayout(1, 2, 2, 2));
		
		textfield1 = new JTextField(10);
		frame.getContentPane().add(textfield1);
		
		
		
		
		JButton button = new JButton("loren ipsum?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder msg = new StringBuilder("");
				if(!textfield1.getText().equals("")) {
		            msg.append("text1: "+textfield1.getText());
		            JOptionPane.showMessageDialog(null, msg, "text",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		});
		
		frame.getContentPane().add(button);
		
		
	}
}