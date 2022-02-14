package app.core;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPort;
	private JLabel lblIpAddress;
	private JLabel lblPort;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(69, 50, 145, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblForName = new JLabel("Name:");
		lblForName.setBounds(121, 30, 42, 14);
		contentPane.add(lblForName);

		txtAddress = new JTextField();
		txtAddress.setBounds(69, 115, 145, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);

		lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(107, 95, 69, 14);
		contentPane.add(lblIpAddress);

		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(69, 180, 145, 20);
		contentPane.add(txtPort);

		lblPort = new JLabel("Port:");
		lblPort.setBounds(121, 160, 42, 14);
		contentPane.add(lblPort);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}
		});
		btnLogin.setBounds(90, 250, 90, 45);
		contentPane.add(btnLogin);
	}

	/**
	 * Handle login
	 */
	private void login(String name, String address, int port) {
		dispose();
		new ClientWindow(name, address, port);
	}
}
