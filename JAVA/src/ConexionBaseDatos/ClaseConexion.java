package ConexionBaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClaseConexion {

	
	public static void registrarUsuario(String usuario, String contraseña, String correo) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;	
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO usuarios(usuario,contraseña,correo) VALUES (?,?,?)");
			stm2.setString(1 , usuario);
			stm2.setString(2 , contraseña);
			stm2.setString(3 , correo);
			
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	public static void eliminarUsuario(String usuario) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM usuarios  WHERE Usuario = ?");
			stm2.setString(1 , usuario);
			
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	public static boolean comprobarInicio(String usuario, String contraseña) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		boolean inicioCorrecto = false;
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			pst = cn.prepareStatement("SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ?");
			pst.setString(1, usuario);
			pst.setString(2, contraseña);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				String usuario1 = rs.getString(2);
				String contraseña1 = rs.getString(3);
				
				if(usuario.equals(usuario1) && contraseña.equals(contraseña1)) {
					
					inicioCorrecto = true;
					break;
					
				}
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return inicioCorrecto;
		
			
		}
	
	
	
	
		public static boolean comprobarRegistro(String usuario) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		boolean registroCorrecto = false;
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			pst = cn.prepareStatement("SELECT * FROM usuarios WHERE Usuario = ? ");
			pst.setString(1, usuario);
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				
				String usuario1 = rs.getString(2);
			
				
				if(usuario.equals(usuario1)) {
					
					registroCorrecto = true;
					break;
					
				}
				
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return registroCorrecto;
		
		}
		
		public static void panelControl(JTable table ) {
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			
			
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			
			modelo.getDataVector().removeAllElements();
			
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				rs = stm.executeQuery("SELECT * FROM usuarios");
				
				while (rs.next()) {
					String usuario = rs.getString(1);
					String contraseña = rs.getString(2);
					String correo = rs.getString(3);
					
					String [] filas = {usuario, contraseña, correo};
					
					modelo.addRow(filas);
					
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					if (rs!= null) {
						rs.close();
					}
					
					if (stm != null) {
						stm.close();
					}
					
					if (cn != null) {
						cn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
		}
		
	   
}
	
	
