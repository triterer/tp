import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI {

	private JFrame frame;
	private JTextField textfield1;
	private JTextField textfield2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUI window = new SimpleGUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("some text");
		frame.setBounds(100, 100, 200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		Container container = frame.getContentPane();
		frame.setLayout(new GridLayout(3, 2, 2, 2));
		
		textfield1 = new JTextField(10);
		frame.getContentPane().add(textfield1);
		
		
		textfield2 = new JTextField(10);
		frame.getContentPane().add(textfield2);
		
		
		JButton button = new JButton("another text");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder msg = new StringBuilder("");
	            msg.append("text1: "+textfield1.getText()+" \ntext2"+textfield2.getText());
	            JOptionPane.showMessageDialog(null, msg, "text",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		
		frame.getContentPane().add(button);
		
		
	}
}