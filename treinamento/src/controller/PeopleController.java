package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import model.Coffee;
import model.CoffeeDAO;

@WebServlet(urlPatterns = { "/PeopleController", "/mainPeople", "/checkPeople", "/addPeople", "/infoPeople",
		"/listPeople", "/editPeople", "/deletePeople" })
public class PeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PeopleDAO dao = new PeopleDAO();
	RoomDAO roomDao = new RoomDAO();
	CoffeeDAO coffeeDao = new CoffeeDAO();
	People people = new People();
	Room room = new Room();

	public PeopleController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		if (action.equals("/mainPeople")) {
			allPeople(request, response);
		} else if (action.equals("/addPeople")) {
			addPeople(request, response);
		} else if (action.equals("/listPeople")) {
			listPeople(request, response);
		} else if (action.equals("/infoPeople")) {
			infoPeople(request, response);
		} else if (action.equals("/editPeople")) {
			editPeople(request, response);
		} else if (action.equals("/deletePeople")) {
			deletePeople(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// List of People
	protected void allPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<People> list = dao.getAllPeople();
		request.setAttribute("allPeople", list);
		RequestDispatcher rd = request.getRequestDispatcher("mainPeople.jsp");
		rd.forward(request, response);
	}

	// Add a new Person
	protected void addPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		people.setPeopleFirstName(request.getParameter("peopleFirstName"));
		people.setPeopleLastName(request.getParameter("peopleLastName"));
		
				
		List<Integer> roomCods = new ArrayList<Integer>();
		List<Integer> roomCount = new ArrayList<Integer>();
		List<People> peopleList = dao.getAllPeople();
		List<Room> roomList = roomDao.getAllRoom();
		int fewerPeople;
		int codFewerPeople;
		int count = 0;
		
		if (roomList.size() > 0) {
			if (peopleList.size() > 0) {
				for (int a = 0; a < roomList.size(); a++) {
					
					for (int b = 0; b < peopleList.size(); b++) {
						if (peopleList.get(b).getIdFirstRoom() == roomList.get(a).getRoomId()) {
							count++;
						}
					}
					if (count < Integer.parseInt(roomList.get(a).getRoomCapacity())) {
						roomCods.add(roomList.get(a).getRoomId());
						roomCount.add(count);
					}
					count = 0;
				}
				
				fewerPeople = roomCount.get(0);
				codFewerPeople = roomCods.get(0);
				
				for(int a = 0; a < roomCount.size(); a++) {
					if (roomCount.get(a)<fewerPeople) {
						fewerPeople = roomCount.get(a);
						codFewerPeople = roomCods.get(a);
					}
				}
				
				people.setIdFirstRoom(codFewerPeople);
				dao.addPeople(people);
				response.sendRedirect("mainPeople");
			} else {
				people.setIdFirstRoom(roomList.get(0).getRoomId());
			}
		} else {
			//"É necessário que estejam cadastradas pelo menos uma Sala de Evento e um Espaço de Café!";
		}
	}

	// List People
	protected void listPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int peopleId = Integer.parseInt(request.getParameter("peopleId"));
		people.setPeopleId(peopleId);
		dao.getPeopleById(people);
		request.setAttribute("people", people);
		RequestDispatcher rd = request.getRequestDispatcher("editPeople.jsp");
		rd.forward(request, response);
	}

	// People Info
	protected void infoPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int peopleId = Integer.parseInt(request.getParameter("peopleId"));
		people.setPeopleId(peopleId);
		dao.getPeopleById(people);
		room.setRoomId(people.getIdFirstRoom());
		roomDao.getRoomById(room);
		request.setAttribute("people", people);
		request.setAttribute("room", room);
		RequestDispatcher rd = request.getRequestDispatcher("infoPeople.jsp");
		rd.forward(request, response);
	}

	// Edit People
	protected void editPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int peopleId = Integer.parseInt(request.getParameter("peopleId"));
		String peopleFirstName = request.getParameter("peopleFirstName");
		String peopleLastName = request.getParameter("peopleLastName");
		people.setPeopleId(peopleId);
		people.setPeopleFirstName(peopleFirstName);
		people.setPeopleLastName(peopleLastName);
		dao.editPeople(people);
		response.sendRedirect("mainPeople");
	}

	// Delete People
	protected void deletePeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int peopleId = Integer.parseInt(request.getParameter("peopleId"));
		people.setPeopleId(peopleId);
		dao.deletePeople(people);
		response.sendRedirect("mainPeople");
	}
}
