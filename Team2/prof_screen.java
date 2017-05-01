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
		
		
		
		

		
		JLabel lblNewLabel = new JLabel("Please Enter the course you would like to give this semester and your preferred time:");
		
		JLabel lblHelloProfessor = new JLabel("Hello Professor! ");
		
		JLabel lblDays = new JLabel("Days:");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("MWF");
		comboBox_2.addItem("TR");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Monday");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Wednesday");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Friday");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Tuesday");
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Thursday");
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Scheduling PROCCESS
				
				String x=comboBox.getSelectedItem().toString();
				String t=comboBox_1.getSelectedItem.toString();
				String d=comboBox_2.getSelectedItem.toString();
				
				//add course name, time and day to CurrentCourse
				CurrentCourse c= new CurrentCourse();
				c.setname(x);
				//c.settime(t); should make time slots in CurrentCourse instead of time to add time and day
				//need to take professor's name and add it too							 
			}
		});
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmProfessorScreen.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCourse)
								.addComponent(lblDays, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)))
					.addGap(14))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(226)
					.addComponent(lblHelloProfessor)
					.addContainerGap(223, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnNewRadioButton_2)
					.addPreferredGap(ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(181))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_4)
						.addComponent(rdbtnNewRadioButton_3))
					.addContainerGap(349, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblHelloProfessor)
					.addGap(3)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTime))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDays)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnNewRadioButton_2)
							.addGap(4))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())))
		);
		frmProfessorScreen.getContentPane().setLayout(groupLayout);
	}
}
