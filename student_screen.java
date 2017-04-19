import java.awt.EventQueue;

import javax.swing.JFrame;

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
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
