package model;

public class People {
	private int peopleId;
	private String peopleFirstName;
	private String peopleLastName;
	private int idFirstRoom;
	private int idLastRoom;
	private int idFirstCoffee;
	private int idLastCoffee;

	public People() {
		super();
	}

	public People(int peopleId, String peopleFirstName, String peopleLastName, int idFirstRoom, int idLastRoom,
			int idFirstCoffee, int idLastCoffee) {
		super();
		this.peopleId = peopleId;
		this.peopleFirstName = peopleFirstName;
		this.peopleLastName = peopleLastName;
		this.idFirstRoom = idFirstRoom;
		this.idLastRoom = idLastRoom;
		this.idFirstCoffee = idFirstCoffee;
		this.idLastCoffee = idLastCoffee;
	}

	public int getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}

	public String getPeopleFirstName() {
		return peopleFirstName;
	}

	public void setPeopleFirstName(String peopleFirstName) {
		this.peopleFirstName = peopleFirstName;
	}

	public String getPeopleLastName() {
		return peopleLastName;
	}

	public void setPeopleLastName(String peopleLastName) {
		this.peopleLastName = peopleLastName;
	}

	public int getIdFirstRoom() {
		return idFirstRoom;
	}

	public void setIdFirstRoom(int idFirstRoom) {
		this.idFirstRoom = idFirstRoom;
	}

	public int getIdLastRoom() {
		return idLastRoom;
	}

	public void setIdLastRoom(int idLastRoom) {
		this.idLastRoom = idLastRoom;
	}

	public int getIdFirstCoffee() {
		return idFirstCoffee;
	}

	public void setIdFirstCoffee(int idFirstCoffee) {
		this.idFirstCoffee = idFirstCoffee;
	}

	public int getIdLastCoffee() {
		return idLastCoffee;
	}

	public void setIdLastCoffee(int idLastCoffee) {
		this.idLastCoffee = idLastCoffee;
	}
}
