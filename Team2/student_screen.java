import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class student_screen {

	private JFrame frmAdminstrativeScreen;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_screen window = new student_screen();
					window.frmAdminstrativeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public student_screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminstrativeScreen = new JFrame();
		frmAdminstrativeScreen.setTitle("Student Screen");
		frmAdminstrativeScreen.setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("Welcome Student!");
		
		JLabel label_1 = new JLabel("Choose which courses you are interested in taking:");
		GroupLayout groupLayout = new GroupLayout(frmAdminstrativeScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(138))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(label)
					.addGap(18)
					.addComponent(label_1)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		frmAdminstrativeScreen.getContentPane().setLayout(groupLayout);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
