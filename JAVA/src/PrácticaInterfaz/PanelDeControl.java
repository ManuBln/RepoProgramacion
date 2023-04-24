package PrácticaInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBaseDatos.ClaseConexion;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelDeControl extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField cuadroEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDeControl frame = new PanelDeControl();
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
	public PanelDeControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CORREO");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(692, 112, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setBounds(391, 112, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setBounds(135, 112, 80, 14);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(135, 137, 756, 131);
		contentPane.add(table);
		
		
		
		
		JLabel titulo = new JLabel("Panel De Control");
		titulo.setBounds(315, 11, 345, 74);
		titulo.setFont(new Font("Tahoma", Font.ITALIC, 42));
		contentPane.add(titulo);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ClaseConexion.comprobarRegistro(cuadroEliminar.getText())) {
					 ClaseConexion.eliminarUsuario(cuadroEliminar.getText());
					 
					 
					 JOptionPane.showMessageDialog(botonEliminar,"Usuario Eliminado",
	                            "Informacion", JOptionPane.INFORMATION_MESSAGE);
					 
					 ClaseConexion.panelControl(table);
				}else {
					JOptionPane.showMessageDialog(botonEliminar,"Usuario no Registrado",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
		});
		botonEliminar.setBounds(416, 434, 130, 23);
		contentPane.add(botonEliminar);
		
		cuadroEliminar = new JTextField();
		cuadroEliminar.setBounds(416, 392, 130, 20);
		contentPane.add(cuadroEliminar);
		cuadroEliminar.setColumns(10);
		
		JLabel gif = new JLabel("New label");
		gif.setBounds(-55, 0, 1212, 609);
		gif.setIcon(new ImageIcon(PanelDeControl.class.getResource("/PrácticaTema15/panel.gif")));
		contentPane.add(gif);
		
		
		ClaseConexion.panelControl(table);
		
		
	}
}
