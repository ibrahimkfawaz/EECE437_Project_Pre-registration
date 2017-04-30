import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

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
		
		JLabel lblWelcomeAdminstrator = new JLabel("Welcome Adminstrator!");
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to do?");
		
		JButton btnAddANew = new JButton("Edit Catalog");
		
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					student_screen.main();
			}
		});
		
		JButton btnEditRoom = new JButton("Edit Room");
		
		GroupLayout groupLayout = new GroupLayout(frmAdminstrativeScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(219, Short.MAX_VALUE)
					.addComponent(lblWelcomeAdminstrator)
					.addGap(84))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblWhatWouldYou)
					.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddANew)
					.addContainerGap(183, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEditRoom)
					.addContainerGap(327, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblWelcomeAdminstrator)
					.addGap(18)
					.addComponent(lblWhatWouldYou)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddANew)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEditRoom)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		frmAdminstrativeScreen.getContentPane().setLayout(groupLayout);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
