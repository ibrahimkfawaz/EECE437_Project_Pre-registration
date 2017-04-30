import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class EditRoom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditRoom window = new EditRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditRoom() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAddANew = new JLabel("Room ID");
		
		textField = new JTextField(); //room ID
		textField.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		
		JLabel lblBuilding = new JLabel("Building");
		
		JLabel lblCapacity = new JLabel("Capacity");
		
		textField_1 = new JTextField(); //room number
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();  //building
		comboBox.addItem("Bechtel");
		comboBox.addItem("Irani Oxi");
		comboBox.addItem("SRB");
		
		JComboBox comboBox_1 = new JComboBox(); //capacity
		comboBox_1.addItem("20");
		comboBox_1.addItem("30");
		comboBox_1.addItem("40");
		comboBox_1.addItem("50");
		comboBox_1.addItem("100");
		
		//to do enable text field entry only when checkbox is checked
		
		
		JComboBox comboBox_2 = new JComboBox(); //existing room name to remove
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ADD A NEW ROOM:");
		
		
		JCheckBox chckbxRemoveExistingRoom = new JCheckBox("REMOVE EXISTING ROOM:");
		
		if (chckbxNewCheckBox.isSelected()) {
			
			int roomID= Integer.parseInt(textField.getText());
			int roomnumber=Integer.parseInt(textField_1.getText());
			String building=comboBox.getSelectedItem().toString();
			int capacity=(Integer) comboBox_1.getSelectedItem();
			
			Room r = new Room();
			r.setBldg(building);
			r.setId(roomID);
			r.setNumber(roomnumber);
			r.setCapacity(capacity);
			
		}
		
		if (chckbxRemoveExistingRoom.isSelected()) {
			
			
			String room=comboBox_2.getSelectedItem().toString();
			//to do:
			//remove room selected from room database which don't have yet
			
		}
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRoomNumber, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBuilding, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAddANew)
										.addComponent(lblCapacity))
									.addGap(75)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_1)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
											.addGap(64))
										.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
								.addComponent(chckbxNewCheckBox)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_2, 0, 297, Short.MAX_VALUE)
								.addComponent(chckbxRemoveExistingRoom))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddANew)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoomNumber)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBuilding)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacity)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxRemoveExistingRoom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
