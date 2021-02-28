package model;

import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDAO {
	
	public ArrayList<Room> getAllRoom() {
		ArrayList<Room> allRoom = new ArrayList<>();
		String read = "select * from room";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int roomId = rs.getInt(1);
				String roomName = rs.getString(2);
				String roomCapacity = rs.getString(3);
				allRoom.add(new Room(roomId, roomName, roomCapacity));
			}
			connection.close();
			return allRoom;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Room getRoomById(Room room) {
		String list = "select * from room where roomId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(list);
			pst.setInt(1, room.getRoomId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				room.setRoomId(rs.getInt("roomId"));
				room.setRoomName(rs.getString("roomName"));
				room.setRoomCapacity(rs.getString("roomCapacity"));
			}
			connection.close();
			return room;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void addRoom(Room room) {
		String create = "insert into room (roomName, roomCapacity) values (?,?)";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(create);
			pst.setString(1, room.getRoomName());
			pst.setString(2, room.getRoomCapacity());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void editRoom(Room room) {
		String read = "update room set roomName=?, roomCapacity=? where roomId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(read);
			pst.setString(1, room.getRoomName());
			pst.setString(2, room.getRoomCapacity());
			pst.setInt(3, room.getRoomId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteRoom(Room room) {
		String delete = "delete from room where roomId=?";
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(delete);
			pst.setInt(1, room.getRoomId());
			pst.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
