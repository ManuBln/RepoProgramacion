package PrácticaInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBaseDatos.ClaseConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField contenedorUsuario;
	private JPasswordField contenedorContraseña;
	
	
	static Bienvenido bienvenido;
	static IniciarSesion principal;
	static Registrarse secundaria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal = new IniciarSesion();
					principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuarioImg = new JLabel("");
		usuarioImg.setIcon(new ImageIcon(IniciarSesion.class.getResource("/PrácticaTema15/usuario.png")));
		usuarioImg.setBounds(196, 92, 48, 20);
		usuarioImg.setForeground(new Color(255, 255, 255));
		contentPane.add(usuarioImg);
		
		JLabel contraseñaImg = new JLabel("");
		contraseñaImg.setIcon(new ImageIcon(IniciarSesion.class.getResource("/PrácticaTema15/contraseña (1).png")));
		contraseñaImg.setForeground(Color.WHITE);
		contraseñaImg.setBounds(196, 142, 68, 20);
		contentPane.add(contraseñaImg);
		
		JButton botonIniciarSesion = new JButton("Iniciar sesión");
		botonIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!contenedorUsuario.getText().isEmpty() && !contenedorContraseña.getText().isEmpty()   && contenedorContraseña.getText().length()  >= 8) {
					
					if((contenedorUsuario.getText().equals("ADMIN") && contenedorContraseña.getText().equals("ADMINADMIN"))) {
						PanelDeControl panel = new PanelDeControl();
						panel.setVisible(true);
						
						dispose();
					}else {
					
					if(!ClaseConexion.comprobarInicio(contenedorUsuario.getText(),contenedorContraseña.getText())){
						
						 
						 
						JOptionPane.showMessageDialog(botonIniciarSesion,"Iniciaste sesión correctamente",
								"Informacion", JOptionPane.INFORMATION_MESSAGE);
						Bienvenido bienvenido = new Bienvenido();	
						bienvenido.setVisible(true);
						dispose();//elimina la ventana
						
					
					}else if(ClaseConexion.comprobarInicio(contenedorUsuario.getText(),contenedorContraseña.getText())) {
						JOptionPane.showMessageDialog(botonIniciarSesion,"El usuario no esta registrado",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}}else {
					if(contenedorUsuario.getText().isEmpty() && contenedorContraseña.getText().isEmpty()) {
						JOptionPane.showMessageDialog(botonIniciarSesion,"Introduce un Usuario y Contraseña",
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}else if(contenedorUsuario.getText().isEmpty()){
						JOptionPane.showMessageDialog(botonIniciarSesion,"Introduce un Usuario",
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
						
					}else if(contenedorContraseña.getText().isEmpty()) {
						JOptionPane.showMessageDialog(botonIniciarSesion,"Introduce una Contraseña",
	                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					else if( contenedorContraseña.getText().length() < 8) {
					JOptionPane.showMessageDialog(botonIniciarSesion,"Contraseña con un minimo de 8 caracteres",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}	
				
			}
		});
		
		contenedorUsuario = new JTextField();
		contenedorUsuario.setBounds(274, 92, 142, 20);
		contentPane.add(contenedorUsuario);
		contenedorUsuario.setColumns(10);
		botonIniciarSesion.setBackground(new Color(128, 255, 255));
		botonIniciarSesion.setBounds(182, 209, 113, 23);
		contentPane.add(botonIniciarSesion);
		
		JButton botonRegistrarse = new JButton("Registrate Aqui!");
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrarse secundaria=new Registrarse();	
				secundaria.setVisible(true);	
				dispose();//elimina la ventana
				
			}
		});
		botonRegistrarse.setBackground(new Color(128, 255, 255));
		botonRegistrarse.setBounds(327, 209, 133, 23);
		contentPane.add(botonRegistrarse);
		
		contenedorContraseña = new JPasswordField();
		contenedorContraseña.setBounds(274, 142, 142, 20);
		contentPane.add(contenedorContraseña);
		
		JCheckBox mostrarContraseña = new JCheckBox("Mostrar contraseña");
		mostrarContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				   if (mostrarContraseña.isSelected()==true) {
					   contenedorContraseña.setEchoChar((char)0);
                   }else {
                	   contenedorContraseña.setEchoChar('●');
                   }
			}
		});
		mostrarContraseña.setBounds(422, 141, 142, 23);
		contentPane.add(mostrarContraseña);
		
		JLabel Fondo = new JLabel("");
		
			
		Fondo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/PrácticaTema15/Fondo.gif")));
		Fondo.setBounds(0, 0, 614, 341);
		contentPane.add(Fondo);
		
	
	}
}
