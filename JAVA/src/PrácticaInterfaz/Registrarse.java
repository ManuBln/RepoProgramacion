package PrácticaInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBaseDatos.ClaseConexion;
import ConexionBaseDatos.Conexion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField cuadroCorreo;
	private JTextField cuadroUsuario;
	private JTextField cuadroApellidos;
	private JTextField cuadroNombre;
	private JPasswordField cuadroContConfirmacion;
	private JPasswordField cuadroContraseña;
	
	
	
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
					secundaria = new Registrarse();
					secundaria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registrarse() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreImg = new JLabel("");
		nombreImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/nombre (1).png")));
		nombreImg.setBounds(145, 79, 52, 20);
		nombreImg.setForeground(new Color(255, 255, 255));
		nombreImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nombreImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nombreImg);
		
		JLabel apellidosImg = new JLabel("");
		apellidosImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/apellidos (1).png")));
		apellidosImg.setBounds(145, 110, 54, 20);
		apellidosImg.setForeground(new Color(255, 255, 255));
		apellidosImg.setHorizontalAlignment(SwingConstants.CENTER);
		apellidosImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(apellidosImg);
		
		JLabel usuarioImg = new JLabel("\r\n");
		usuarioImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/usuario.png")));
		usuarioImg.setBounds(145, 141, 60, 20);
		usuarioImg.setForeground(new Color(255, 255, 255));
		usuarioImg.setBackground(new Color(0, 0, 0));
		usuarioImg.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(usuarioImg);
		
		JLabel correoImg = new JLabel("");
		correoImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/correo electrónico (1).png")));
		correoImg.setBounds(145, 172, 116, 20);
		correoImg.setForeground(new Color(255, 255, 255));
		correoImg.setHorizontalAlignment(SwingConstants.CENTER);
		correoImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(correoImg);
		
		JLabel contraseñaImg = new JLabel("");
		contraseñaImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/contraseña (1).png")));
		contraseñaImg.setBounds(145, 203, 78, 20);
		contraseñaImg.setForeground(new Color(255, 255, 255));
		contraseñaImg.setHorizontalAlignment(SwingConstants.CENTER);
		contraseñaImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(contraseñaImg);
		
		JLabel confirmacionContImg = new JLabel("");
		confirmacionContImg.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/confirmar contraseña (1).png")));
		confirmacionContImg.setBounds(145, 234, 134, 20);
		confirmacionContImg.setForeground(new Color(255, 255, 255));
		confirmacionContImg.setHorizontalAlignment(SwingConstants.CENTER);
		confirmacionContImg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(confirmacionContImg);
		
		cuadroCorreo = new JTextField();
		cuadroCorreo.setBounds(293, 172, 169, 20);
		contentPane.add(cuadroCorreo);
		cuadroCorreo.setColumns(10);
		
		cuadroUsuario = new JTextField();
		cuadroUsuario.setBounds(293, 141, 169, 20);
		cuadroUsuario.setColumns(10);
		contentPane.add(cuadroUsuario);
		
		cuadroApellidos = new JTextField();
		cuadroApellidos.setBounds(293, 110, 169, 20);
		cuadroApellidos.setColumns(10);
		contentPane.add(cuadroApellidos);
		
		cuadroNombre = new JTextField();
		cuadroNombre.setBounds(293, 79, 169, 20);
		cuadroNombre.setColumns(10);
		contentPane.add(cuadroNombre);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(cuadroContraseña.getText().equals(cuadroContConfirmacion.getText()) && cuadroCorreo.getText().contains("@") && cuadroCorreo.getText().contains(".") && cuadroContraseña.getText().length() >= 8 ){	
				
				
				
				if(!ClaseConexion.comprobarRegistro(cuadroUsuario.getText())) {
					ClaseConexion.registrarUsuario(cuadroUsuario.getText(),cuadroContraseña.getText(), cuadroCorreo.getText());
					JOptionPane.showMessageDialog(botonRegistrarse,"Se registró correctamente",
							"Informacion", JOptionPane.INFORMATION_MESSAGE);
					IniciarSesion principal=new IniciarSesion();
					principal.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(botonRegistrarse,"El usuario esta en uso",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					
				}
				
				}else {
						if(cuadroNombre.getText().isEmpty() && cuadroApellidos.getText().isEmpty() && cuadroUsuario.getText().isEmpty() && cuadroCorreo.getText().isEmpty() && cuadroContraseña.getText().isEmpty() && cuadroContConfirmacion.getText().isEmpty()){
							JOptionPane.showMessageDialog(botonRegistrarse,"Rellene todos los campos",
						            "ERROR", JOptionPane.ERROR_MESSAGE);
						}else if(!cuadroContraseña.getText().equals(cuadroContConfirmacion.getText())) {
						    JOptionPane.showMessageDialog(botonRegistrarse,"Revisa que las contraseñas sean iguales",
						            "ERROR", JOptionPane.ERROR_MESSAGE);
						}else if(cuadroContraseña.getText().length() < 8) {
							JOptionPane.showMessageDialog(botonRegistrarse,"Revisa que la contraseña contenga minimo 8 caracteres",
						            "ERROR", JOptionPane.ERROR_MESSAGE);
							
						}else if(!cuadroCorreo.getText().contains("@") && !cuadroCorreo.getText().contains(".")){
							JOptionPane.showMessageDialog(botonRegistrarse,"Revisa que el correo este bien formado",
						            "ERROR", JOptionPane.ERROR_MESSAGE);
							
						}
						
						
					}
				
			}
		});
		botonRegistrarse.setBounds(145, 265, 101, 23);
		botonRegistrarse.setBackground(new Color(0, 255, 255));
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(botonRegistrarse);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(406, 265, 89, 23);
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);	
			}
		});
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCancelar.setBackground(new Color(255, 0, 0));
		contentPane.add(botonCancelar);
		
		JButton botonIniciarSesion = new JButton("Inicia Sesión Aqui!");
		botonIniciarSesion.setBounds(256, 265, 140, 23);
		botonIniciarSesion.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				IniciarSesion principal=new IniciarSesion();
				principal.setVisible(true);
				dispose();
		 	
		   }
		});
		botonIniciarSesion.setBackground(new Color(0, 255, 255));
		contentPane.add(botonIniciarSesion);
		
		cuadroContConfirmacion = new JPasswordField();
		cuadroContConfirmacion.setBounds(293, 234, 169, 20);
		contentPane.add(cuadroContConfirmacion);
		
		cuadroContraseña = new JPasswordField();
		cuadroContraseña.setBounds(293, 203, 169, 20);
		contentPane.add(cuadroContraseña);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registrarse.class.getResource("/PrácticaTema15/Fondo.gif")));
		lblNewLabel.setBounds(0, -32, 687, 426);
		contentPane.add(lblNewLabel);
	}
}