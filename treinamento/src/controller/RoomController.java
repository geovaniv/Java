package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.People;
import model.PeopleDAO;
import model.Room;
import model.RoomDAO;

@WebServlet(urlPatterns = { "/roomController", "/mainRoom", "/checkRoom", "/addRoom", "/infoRoom",
		"/listRoom", "/editRoom", "/deleteRoom" })
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoomDAO dao = new RoomDAO();
	Room room = new Room();
	PeopleDAO peopleDao = new PeopleDAO();
	People people = new People();

	public RoomController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		if (action.equals("/mainRoom")) {
			allRoom(request, response);
		} else if (action.equals("/addRoom")) {
			addRoom(request, response);
		} else if (action.equals("/listRoom")) {
			listRoom(request, response);
		} else if (action.equals("/infoRoom")) {
			infoRoom(request, response);
		} else if (action.equals("/editRoom")) {
			editRoom(request, response);
		} else if (action.equals("/deleteRoom")) {
			deleteRoom(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// List of Rooms
	protected void allRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Room> list = dao.getAllRoom();
		request.setAttribute("allRoom", list);
		RequestDispatcher rd = request.getRequestDispatcher("mainRoom.jsp");
		rd.forward(request, response);
	}

	// Add a new Room
	protected void addRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		room.setRoomName(request.getParameter("roomName"));
		room.setRoomCapacity(request.getParameter("roomCapacity"));
		dao.addRoom(room);
		response.sendRedirect("mainRoom");
	}

	// List Room
	protected void listRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		room.setRoomId(roomId);
		dao.getRoomById(room);
		request.setAttribute("room", room);
		RequestDispatcher rd = request.getRequestDispatcher("editRoom.jsp");
		rd.forward(request, response);
	}

	// Room Info
	protected void infoRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		room.setRoomId(roomId);
		dao.getRoomById(room);
		ArrayList<People> list = peopleDao.getAllPeople();
		ArrayList<People> filtred = new ArrayList<People>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdFirstRoom() == room.getRoomId()) {
				filtred.add(new People(list.get(i).getPeopleId(), list.get(i).getPeopleFirstName(), list.get(i).getPeopleLastName(), list.get(i).getIdFirstRoom(), list.get(i).getIdLastRoom(), list.get(i).getIdFirstCoffee(), list.get(i).getIdLastCoffee()));
			}
		}
		request.setAttribute("room", room);
		request.setAttribute("allPeople", filtred);
		RequestDispatcher rd = request.getRequestDispatcher("infoRoom.jsp");
		rd.forward(request, response);
	}

	// Edit Room
	protected void editRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		String roomName = request.getParameter("roomName");
		String roomCapacity = request.getParameter("roomCapacity");
		room.setRoomId(roomId);
		room.setRoomName(roomName);
		room.setRoomCapacity(roomCapacity);
		dao.editRoom(room);
		response.sendRedirect("mainRoom");
	}

	// Delete Room
	protected void deleteRoom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		room.setRoomId(roomId);
		dao.deleteRoom(room);
		response.sendRedirect("mainRoom");
	}
}