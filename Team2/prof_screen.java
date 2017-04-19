import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class prof_screen {

	static private JFrame frmProfessorScreen;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prof_screen window = new prof_screen();
					window.frmProfessorScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public prof_screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessorScreen = new JFrame();
		frmProfessorScreen.setTitle("Professor Screen");
		frmProfessorScreen.setBounds(100, 100, 553, 323);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("EECE 200");
		comboBox.addItem("EECE 210");
		comboBox.addItem("EECE 230");
		comboBox.addItem("EECE 290");
		comboBox.addItem("EECE 330");
		comboBox.addItem("EECE 431");
		comboBox.addItem("EECE 432");
		comboBox.addItem("EECE 437");
		
		JLabel lblCourse = new JLabel("Course: ");		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Monday");
		
		JRadioButton rdbtnTuesday = new JRadioButton("Tuesday");
		
		JRadioButton rdbtnWednesday = new JRadioButton("Wednesday");
		
		JRadioButton rdbtnThursday = new JRadioButton("Thursday");
		
		JRadioButton rdbtnFriday = new JRadioButton("Friday");
		
		JLabel lblTime = new JLabel("Timing:");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("8:00 AM - 8:50 AM");
		comboBox_1.addItem("9:00 AM - 9:50 AM");
		comboBox_1.addItem("10:00 AM - 10:50 AM");
		comboBox_1.addItem("11:00 AM - 11:50 AM");
		comboBox_1.addItem("12:00 PM - 12:50 PM");
		comboBox_1.addItem("1:00 PM - 1:50 PM");
		comboBox_1.addItem("2:00 PM - 2:50 PM");
		comboBox_1.addItem("3:00 PM - 3:50 PM");
		comboBox_1.addItem("4:00 PM - 4:50 PM");
		comboBox_1.addItem("5:00 PM - 5:50 PM");
		GroupLayout groupLayout = new GroupLayout(frmProfessorScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCourse)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(210)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnFriday)
						.addComponent(rdbtnThursday)
						.addComponent(rdbtnWednesday)
						.addComponent(rdbtnTuesday)
						.addComponent(rdbtnNewRadioButton))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnTuesday)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnWednesday)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnThursday)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnFriday))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCourse)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTime)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		frmProfessorScreen.getContentPane().setLayout(groupLayout);
	}
}
