package iuh.da1.controler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class GUI extends JFrame {
	private JTextField host,port,databaseName;
	private JButton btStart;
	public GUI()throws ParserConfigurationException, SAXException, IOException{
		setSize(400, 200);
		setTitle("ConvertXMLtoNoSQL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		
		host=new JTextField(15);
		port=new JTextField(15);
		databaseName=new JTextField(15);
		btStart=new JButton("Start");
		host.setText("localhost");
		port.setText("27017");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		JLabel l1=new JLabel("Host: ");
		JLabel l2=new JLabel("Port: ");
		JLabel l3=new JLabel("DBName: ");
		
		l1.setPreferredSize(l3.getPreferredSize());
		l2.setPreferredSize(l3.getPreferredSize());
		
		p1.add(l1); p1.add(host);
		p2.add(l2); p2.add(port);
		p3.add(l3); p3.add(databaseName);
		
		Box b=Box.createVerticalBox();
		b.add(p1);
		b.add(Box.createVerticalStrut(10));
		b.add(p2);
		b.add(Box.createVerticalStrut(10));
		b.add(p3);
		b.add(Box.createVerticalStrut(10));
		btStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.setProperty("entityExpansionLimit","100000000" );
				try {
					new Main(host.getText().toString(),Integer.parseInt(port.getText().toString()),databaseName.getText().toString());
				} catch (ParserConfigurationException | SAXException
						| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.add(b);
		this.add(btStart,BorderLayout.SOUTH);
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		new GUI().setVisible(true);
	}
}
