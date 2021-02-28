package model;

import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CoffeeDAO {
	
	public ArrayList<Coffee> getAllCoffee() {
		ArrayList<Coffee> allCoffee = new ArrayList<>();
		String read = "select * from coffee";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int coffeeId = rs.getInt(1);
				String coffeeName = rs.getString(2);
				allCoffee.add(new Coffee(coffeeId, coffeeName));
			}
			connection.close();
			return allCoffee;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Coffee getCoffeeById(Coffee coffee) {
		String list = "select * from coffee where coffeeId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(list);
			pst.setInt(1, coffee.getCoffeeId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				coffee.setCoffeeId(rs.getInt("coffeeId"));
				coffee.setCoffeeName(rs.getString("coffeeName"));
			}
			connection.close();
			return coffee;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void addCoffee(Coffee coffee) {
		String create = "insert into coffee (coffeeName) values (?)";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(create);
			pst.setString(1, coffee.getCoffeeName());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editCoffee(Coffee coffee) {
		String read = "update coffee set coffeeName=? where coffeeId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			pst.setString(1, coffee.getCoffeeName());
			pst.setInt(2, coffee.getCoffeeId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCoffee(Coffee coffee) {
		String delete = "delete from coffee where coffeeId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(delete);
			pst.setInt(1, coffee.getCoffeeId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
