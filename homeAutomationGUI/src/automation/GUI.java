package automation;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.event.PopupMenuListener;

import javafx.application.Platform;
import javafx.stage.Stage;

import javax.swing.event.PopupMenuEvent;
import javax.swing.JTextArea;

public class GUI extends JFrame {
	protected static String user;
	
	int temp = 70;
	int bathTemp = 75, garageTemp = 70, kitchenTemp = 76, livTemp = 70, bedTemp = 75;
	int holder, inputTemp, kitColor, livColor, garColor, bathColor, backColor, bedColor = 0;
	java.net.URL url1 = getClass().getResource("imgres.png");
	java.net.URL bathroom = getClass().getResource("../images/bathroom.png");
	java.net.URL bedroom = getClass().getResource("../images/bedroom.png");
	java.net.URL kitchen = getClass().getResource("../images/kitchen.png");
	java.net.URL livingroom = getClass().getResource("../images/livingroom.png");
	
	private JPanel contentPane;
	private final Panel panel = new Panel();
	protected Stage primaryStage;

	public static void main(String[] args) {
		
		Login login = new Login();
		login.main(args);
		
		//Make this run. Don't use main like above.
		//login.start(primaryStage);
		
		if (user == "admin"){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI frame = new GUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(user == "user"){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI frame = new GUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	//Creates the frame
	public GUI() {
		setTitle("HAm");
		JEditorPane LivingRoom = new JEditorPane();
		LivingRoom.setContentType("text/html");
		LivingRoom.setText("<html><body>Living Room: " + livTemp + "&#8457;<br /><img src='" + bedroom + "'></body></html>");
		LivingRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LivingRoom.setBackground(Color.orange);

			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] appliances = { "A/C", "Television", "Microwave", "Toaster", "Appliances" };
		JComboBox Appliances = new JComboBox(appliances);
		
		//Instantiating all appliances here
		MicroWaveInterface microwave = new MicroWaveInterface();
		Television television = new Television();
		Toast toaster = new Toast();
		
		
		Appliances.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String selectedAppliance = (String) Appliances.getSelectedItem();
				
				//Temperature
				if(selectedAppliance == "A/C"){
					tempControl changingTemp = new tempControl();
					try {
						changingTemp.start(primaryStage);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//temp = tempControl.returnTemp();
					livTemp = temp;
					
				}
				//Lights Scheduling Options
				if(selectedAppliance == "Television"){
					television.main(appliances);
				}
				
				//Entertainment Scheduling Options
				if(selectedAppliance == "Microwave"){
					microwave.initate();
				}
				
				//Toaster
				if(selectedAppliance == "Toaster"){
					toaster.main(appliances); 
				}
				
				//Appliances Options
				if(selectedAppliance == "Toaster"){
					//This will open menu (maybe JavaFX) with different appliances, e.g., toaster, dishwasher, 
				}
			}
		});
		
		//Living Room
		LivingRoom.setEditable(false);
		LivingRoom.setBackground(Color.LIGHT_GRAY);		
		LivingRoom.setText("<html><body>Living Room " + livTemp + "&#8457;<br /><img src='" + livingroom + "'></body></html>");
		SSHLightControl lightControl = new SSHLightControl();
		LivingRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(livColor == 1){
					lightControl.SSHLightControl(0);
					LivingRoom.setBackground(Color.LIGHT_GRAY);
					livColor = 0;
				}
				else if(livColor == 0){
					lightControl.SSHLightControl(1);
					LivingRoom.setBackground(Color.ORANGE);
					livColor = 1;
				}
			}
		});
		
		//Bathroom
		JEditorPane Bathroom = new JEditorPane();
		Bathroom.setContentType("text/html");
		Bathroom.setText("<html><body>Bathroom " + bathTemp + "&#8457;<br /><img src='" + bathroom + "'></body></html>");
		
		Bathroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bathColor == 1){
					Bathroom.setBackground(Color.LIGHT_GRAY);
					bathColor = 0;
				}
				else if(bathColor == 0){
					Bathroom.setBackground(Color.ORANGE);
					bathColor = 1;
				}
			}
		});
		Bathroom.setEditable(false);
		Bathroom.setBackground(Color.LIGHT_GRAY);
		
		//Bedroom
		JEditorPane Bedroom = new JEditorPane();
		Bedroom.setContentType("text/html");
		Bedroom.setText("<html><body>Bedroom " + bedTemp + "&#8457;<br /><img src='" + bedroom + "'></body></html>");
		Bedroom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bedColor == 1){
					Bedroom.setBackground(Color.LIGHT_GRAY);
					Bedroom.setText("<html><body>Bedroom " + bedTemp + "&#8457;<br /><img src='" + bedroom + "'></body></html>");
					bedColor = 0;
				}
				else if(bedColor == 0){
					Bedroom.setBackground(Color.ORANGE);
					Bedroom.setText("<html><body>Bedroom " + bedTemp + "&#8457;<br /><img src='" + bedroom + "'></body></html>");
					bedColor = 1;
				}
			}
		});
		Bedroom.setEditable(false);
		Bedroom.setBackground(Color.LIGHT_GRAY);
		
		
		//Garage
		JEditorPane Garage = new JEditorPane();
		Garage.setContentType("text/html");
		Garage.setText("<html><body>Garage " + garageTemp + "&#8457;<br /><img src='" + url1 + "'></body></html>");
		Garage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(garColor == 1){
					Garage.setBackground(Color.LIGHT_GRAY);
					garColor = 0;
				}
				else if(garColor == 0){
					Garage.setBackground(Color.ORANGE);
					garColor = 1;
				}
			}
		});
		Garage.setEditable(false);
		Garage.setBackground(Color.LIGHT_GRAY);
		Garage.setText("Garage");
		
		
		
		//Kitchen
		JEditorPane Kitchen = new JEditorPane();
		Kitchen.setContentType("text/html");
		Kitchen.setText("<html><body>Kitchen " + kitchenTemp + "&#8457;<br /><img src='" + kitchen + "'></body></html>");
		Kitchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(kitColor == 1){
					Kitchen.setBackground(Color.LIGHT_GRAY);
					kitColor = 0;
				}
				else if(kitColor == 0){
					Kitchen.setBackground(Color.ORANGE);
					kitColor = 1;
				}
			}
		});
		Kitchen.setEditable(false);
		Kitchen.setBackground(Color.LIGHT_GRAY);
		
		
		
		//Front Yard
		JEditorPane FrontYard = new JEditorPane();
		FrontYard.setContentType("text/html");
		
		FrontYard.setText("<html><body>Front Yard<br /></body></html>");
		FrontYard.setEditable(false);
		FrontYard.setBackground(Color.LIGHT_GRAY);
		
		
		//Backyard
		JEditorPane Backyard = new JEditorPane();
		Backyard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(backColor == 1){
					Backyard.setBackground(Color.LIGHT_GRAY);
					backColor = 0;
				}
				else if(backColor == 0){
					Backyard.setBackground(Color.ORANGE);
					backColor = 1;
				}
			}
		});
		Backyard.setContentType("text/html");
		Backyard.setText("<html><body>Backyard<br /></body></html>");
		Backyard.setEditable(false);
		Backyard.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		
		JTextArea textArea = new JTextArea(
				"What you type in here appears in the JTextArea"
				);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JButton btnScheduler = new JButton("Scheduler");
		btnScheduler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Code in here is executed when the button is clicked
				
			}
		});
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Verification add = new Verification();
				add.main(appliances);
				
				
			}
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Appliances, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnScheduler, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addGap(50)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Bathroom, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Bedroom, 0, 0, Short.MAX_VALUE))
								.addComponent(LivingRoom, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Backyard, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(Garage, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(Kitchen, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)))
						.addComponent(FrontYard, 0, 0, Short.MAX_VALUE))
					.addContainerGap(66, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(FrontYard, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Garage, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Kitchen, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
								.addComponent(LivingRoom, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnScheduler, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Appliances, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Bathroom, GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE)
								.addComponent(Bedroom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(Backyard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(69))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
		return null;
		}
	}
}