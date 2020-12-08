import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI3 {

	private JFrame frame;
	private JTextField textfield1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleGUI3 window = new SimpleGUI3();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleGUI3() {
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
		
		JLabel label = new JLabel("it's text"); 
		frame.getContentPane().add(label);
		
		textfield1 = new JTextField(10);
		textfield1.setBackground(Color.RED);
		frame.getContentPane().add(textfield1);
		
		JButton button = new JButton("hide text");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textfield1.isVisible()) {
					textfield1.setVisible(false);
					button.setText("show text");
				}
				else {
					textfield1.setVisible(true);
					button.setText("hide text");
				}
			}
		});
		
		frame.getContentPane().add(button);
	}
}