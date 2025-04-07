package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import devices.Connections;
import models.User;

public class DBManagerClient {
	
	public static boolean loginUser(User u) {
		boolean loggued = false;
		
		String username = u.getName();
		String pass = u.getPass();
		
		String sql = "SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pass);
			
			loggued = ps.executeQuery().next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return loggued;
	}
	
	public static boolean registerUser(User u) {
		boolean registered = false;
		
		String email = u.getMail();
		String name = u.getName();
		String password = u.getPass();
		String phone = u.getPhone();
		
		if(userExists(name)) {
			registered = false;
		}else {
			String sql = "INSERT INTO usuario (correo, nombre, contraseña, telefono, saldo) VALUES(?, ?, ?, ?, 0.00)";
			
			try {
				Connection conn = Connections.obtener();
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, email);
				ps.setString(2, name);
				ps.setString(3, password);
				ps.setString(4, phone);
				
				ps.executeUpdate();
				registered = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return registered;
	}
	
	public static boolean userExists(String name) {
		boolean exists = false;
		String sql = "SELECT * FROM usuario WHERE nombre = ?";

		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			exists = rs.next(); // Si hay al menos un resultado, el usuario existe

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return exists;
	}
	
	public static String getEmail(String name) {
		String email = "";
		
		String sql = "SELECT correo FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				email = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return email;
	}
	
	public static String getPhoneNumber(String name) {
		String phone = "";
		
		String sql = "SELECT telefono FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				phone = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return phone;
	}
	
	public static double getBalance(String name) {
		double balance = 0.00;
		
		String sql = "SELECT saldo FROM usuario WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				balance = rs.getDouble(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return balance;
	}
	
	public static void setNewBalance(String name, double amount) {
		String sql = "UPDATE usuario SET saldo = saldo + ? WHERE nombre = ?";
		
		try {
			Connection conn = Connections.obtener();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, name);
			
			int rows = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
