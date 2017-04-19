import java.awt.EventQueue;

import javax.swing.JFrame;

public class adminstrative_screen {

	private JFrame frmAdminstrativeScreen;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminstrative_screen window = new adminstrative_screen();
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
	public adminstrative_screen() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminstrativeScreen = new JFrame();
		frmAdminstrativeScreen.setTitle("Adminstrative Screen");
		frmAdminstrativeScreen.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
