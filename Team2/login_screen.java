import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.naming.ldap.Rdn;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class login_screen {

	private JFrame frmWelcomeScreen;
	private JPasswordField PassWordTextField;
	private JTextPane UserNameTextField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_screen window = new login_screen();
					window.frmWelcomeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JRadioButton StudentRadioButton = new JRadioButton("Student");
		JRadioButton ProfessorRadioButton = new JRadioButton("Professor");
		JRadioButton AdminstrationRadioButton = new JRadioButton("Adminstrative");
		frmWelcomeScreen = new JFrame();
		frmWelcomeScreen.setTitle("Log In Screen");
		frmWelcomeScreen.getContentPane().setForeground(new Color(95, 158, 160));
		frmWelcomeScreen.setBounds(100, 100, 303, 298);
		frmWelcomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton LogInButton = new JButton("Log In");
		LogInButton.setVerticalAlignment(SwingConstants.TOP);
		// Listener for the log in button that takes you to the convenient
		// screen
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (StudentRadioButton.isSelected()) {
					student_screen screen = new student_screen();
					UserNameTextField.setText("");
					PassWordTextField.setText("");
					screen.main();
				} else if (ProfessorRadioButton.isSelected()) {
					prof_screen screen = new prof_screen();
					UserNameTextField.setText("");
					PassWordTextField.setText("");
					screen.main();
				} else if (AdminstrationRadioButton.isSelected()) {
					adminstrative_screen screen = new adminstrative_screen();
					UserNameTextField.setText("");
					PassWordTextField.setText("");
					screen.main();
				} else
					JOptionPane.showMessageDialog(LogInButton, "Please select the type of user!", "Choose user type", 0,
							null);
			}
		});
		// end of listener code

		PassWordTextField = new JPasswordField();
		PassWordTextField.setBackground(new Color(204, 255, 255));

		UserNameTextField = new JTextPane();
		UserNameTextField.setBackground(new Color(204, 255, 255));
		UserNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));

		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.EAST, UserNameTextField, 0, SpringLayout.EAST, PassWordTextField);
		springLayout.putConstraint(SpringLayout.EAST, PassWordTextField, -10, SpringLayout.EAST,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, UserNameTextField, 0, SpringLayout.WEST, PassWordTextField);
		springLayout.putConstraint(SpringLayout.NORTH, AdminstrationRadioButton, 6, SpringLayout.SOUTH,
				ProfessorRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, AdminstrationRadioButton, 0, SpringLayout.WEST,
				StudentRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, StudentRadioButton, 10, SpringLayout.WEST,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, ProfessorRadioButton, 6, SpringLayout.SOUTH, StudentRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, ProfessorRadioButton, 0, SpringLayout.WEST, StudentRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, LogInButton, 10, SpringLayout.WEST,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, LogInButton, -10, SpringLayout.EAST,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, StudentRadioButton, 25, SpringLayout.NORTH,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, UserNameTextField, -6, SpringLayout.NORTH, PassWordTextField);
		springLayout.putConstraint(SpringLayout.NORTH, LogInButton, 226, SpringLayout.NORTH,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, PassWordTextField, 192, SpringLayout.NORTH,
				frmWelcomeScreen.getContentPane());
		frmWelcomeScreen.getContentPane().setLayout(springLayout);
		frmWelcomeScreen.getContentPane().add(StudentRadioButton);
		frmWelcomeScreen.getContentPane().add(ProfessorRadioButton);
		frmWelcomeScreen.getContentPane().add(AdminstrationRadioButton);
		frmWelcomeScreen.getContentPane().add(UserNameTextField);
		frmWelcomeScreen.getContentPane().add(PassWordTextField);
		frmWelcomeScreen.getContentPane().add(LogInButton);

		JLabel UserNameLabel = new JLabel("Username");
		springLayout.putConstraint(SpringLayout.NORTH, UserNameLabel, 60, SpringLayout.SOUTH, AdminstrationRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, UserNameLabel, 10, SpringLayout.WEST,
				frmWelcomeScreen.getContentPane());
		frmWelcomeScreen.getContentPane().add(UserNameLabel);

		JLabel PassWordLabel = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.SOUTH, UserNameLabel, -15, SpringLayout.NORTH, PassWordLabel);
		springLayout.putConstraint(SpringLayout.WEST, PassWordTextField, 18, SpringLayout.EAST, PassWordLabel);
		springLayout.putConstraint(SpringLayout.WEST, PassWordLabel, 10, SpringLayout.WEST,
				frmWelcomeScreen.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, PassWordLabel, 195, SpringLayout.NORTH,
				frmWelcomeScreen.getContentPane());
		frmWelcomeScreen.getContentPane().add(PassWordLabel);

		// listener for radio button selection to deselect other radio buttons
		StudentRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorRadioButton.setSelected(false);
				AdminstrationRadioButton.setSelected(false);
			}
		});

		// listener for radio button selection to deselect other radio buttons
		ProfessorRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentRadioButton.setSelected(false);
				AdminstrationRadioButton.setSelected(false);
			}
		});

		// listener for radio button selection to deselect other radio buttons
		AdminstrationRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorRadioButton.setSelected(false);
				StudentRadioButton.setSelected(false);
			}
		});
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}

	}
}
