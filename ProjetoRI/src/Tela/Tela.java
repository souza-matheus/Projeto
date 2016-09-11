package Tela;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import Indexador.Indexador;

import javax.swing.JLabel;
import java.awt.Font;


public class Tela extends JFrame {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String pasta = "C:";
		private JPanel contentPane;
		private JTextField LBLindexar;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					
					try {
						Tela frame = new Tela();
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
		public Tela() {
			setTitle("Indexador e Buscador - Matheus/Luiz");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 464, 235);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			LBLindexar = new JTextField();
			LBLindexar.setBounds(72, 59, 309, 20);
			LBLindexar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					JFileChooser chooserDiretorio = new JFileChooser();
					chooserDiretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
					chooserDiretorio.showOpenDialog(getParent());
					pasta = chooserDiretorio.getSelectedFile().getAbsolutePath();
					LBLindexar.setText(pasta);
					System.out.println(pasta);
				
				
				}
			});
			LBLindexar.setEditable(false);
			LBLindexar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			LBLindexar.setColumns(10);
			
			JButton BTNindexar = new JButton("Indexar normal");
			BTNindexar.setBounds(72, 90, 152, 23);
			BTNindexar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
				        Indexador.Indexar(pasta);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
			
			JButton BTNbuscar = new JButton("Buscar");
			BTNbuscar.setBounds(234, 90, 147, 23);
			BTNbuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			JLabel lblNewLabel = new JLabel("Indexador e Buscador");
			lblNewLabel.setBounds(100, 11, 236, 26);
			lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
			
			JButton BTNindexarbm = new JButton("Indexar BM25");
			BTNindexarbm.setBounds(72, 119, 152, 23);
			BTNindexarbm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			
			JButton BTNindexarro = new JButton("Indexar Rocchio");
			BTNindexarro.setBounds(72, 148, 152, 23);
			BTNindexarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			JButton BTNbuscarbm = new JButton("Buscar BM25");
			BTNbuscarbm.setBounds(234, 119, 147, 23);
			BTNbuscarbm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JButton BTNbuscarro = new JButton("Buscar Rocchio");
			BTNbuscarro.setBounds(234, 148, 147, 23);
			BTNbuscarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			contentPane.setLayout(null);
			contentPane.add(BTNindexarbm);
			contentPane.add(BTNindexar);
			contentPane.add(BTNindexarro);
			contentPane.add(BTNbuscar);
			contentPane.add(BTNbuscarro);
			contentPane.add(BTNbuscarbm);
			contentPane.add(lblNewLabel);
			contentPane.add(LBLindexar);
			}
		
		/*public static void STindexador(String text){
		    TXTPindexador.setText(text);
		}*/
		public void listf(String directoryName, ArrayList<File> files) {
		    File directory = new File(directoryName);

		    // get all the files from a directory
		    File[] fList = directory.listFiles();
		    for (File file : fList) {
		        if (file.isFile()) {
		            files.add(file);
		            
		            //System.out.println(file.getAbsolutePath());
		            
		        } else if (file.isDirectory()) {
		            listf(file.getAbsolutePath(), files);
		        }
		    }
		}
	}

