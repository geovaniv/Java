package model;

import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PeopleDAO {
	
	public ArrayList<People> getAllPeople() {
		ArrayList<People> allPeople = new ArrayList<>();
		String read = "select * from people";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int peopleId = rs.getInt(1);
				String peopleFirstName = rs.getString(2);
				String peopleLastName = rs.getString(3);
				int idFirstRoom = rs.getInt(4);
				int idLastRoom = rs.getInt(5);
				int idFirstCoffee = rs.getInt(6);
				int idLastCoffee = rs.getInt(7);
				allPeople.add(new People(peopleId, peopleFirstName, peopleLastName, idFirstRoom, idLastRoom, idFirstCoffee, idLastCoffee));
			}
			connection.close();
			return allPeople;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public People getPeopleById(People people) {
		String list = "select * from people where peopleId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(list);
			pst.setInt(1, people.getPeopleId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				people.setPeopleId(rs.getInt("peopleId"));
				people.setPeopleFirstName(rs.getString("peopleFirstName"));
				people.setPeopleLastName(rs.getString("peopleLastName"));
				people.setIdFirstRoom(rs.getInt("idFirstRoom"));
				people.setIdLastRoom(rs.getInt("idLastRoom"));
				people.setIdFirstCoffee(rs.getInt("idFirstCoffee"));
				people.setIdLastCoffee(rs.getInt("idLastCoffee"));
			}
			connection.close();
			return people;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void addPeople(People people) {
		String create = "insert into people (peopleFirstName, peopleLastName, idFirstRoom) values (?,?,?)";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(create);
			pst.setString(1, people.getPeopleFirstName());
			pst.setString(2, people.getPeopleLastName());
			pst.setInt(3, people.getIdFirstRoom());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editPeople(People people) {
		String read = "update people set peopleFirstName=?, peopleLastName=? where peopleId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			pst.setString(1, people.getPeopleFirstName());
			pst.setString(2, people.getPeopleLastName());
			pst.setInt(3, people.getPeopleId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletePeople(People people) {
		String delete = "delete from people where peopleId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(delete);
			pst.setInt(1, people.getPeopleId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
