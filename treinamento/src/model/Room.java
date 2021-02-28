package model;

public class Room {
	private int roomId;
	private String roomName;
	private String roomCapacity;
	
	public Room() {
		super();
	}

	public Room(int roomId, String roomName, String roomCapacity) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(String roomCapacity) {
		this.roomCapacity = roomCapacity;
	}	
}
