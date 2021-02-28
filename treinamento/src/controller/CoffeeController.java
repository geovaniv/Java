package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coffee;
import model.CoffeeDAO;

@WebServlet(urlPatterns = { "/CoffeeController", "/mainCoffee", "/checkCoffee", "/addCoffee", "/infoCoffee",
		"/listCoffee", "/editCoffee", "/deleteCoffee" })
public class CoffeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CoffeeDAO dao = new CoffeeDAO();
	Coffee coffee = new Coffee();

	public CoffeeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();

		if (action.equals("/mainCoffee")) {
			allCoffee(request, response);
		} else if (action.equals("/addCoffee")) {
			addCoffee(request, response);
		} else if (action.equals("/listCoffee")) {
			listCoffee(request, response);
		} else if (action.equals("/infoCoffee")) {
			infoCoffee(request, response);
		} else if (action.equals("/editCoffee")) {
			editCoffee(request, response);
		} else if (action.equals("/deleteCoffee")) {
			deleteCoffee(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// List of Coffee Spaces
	protected void allCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Coffee> list = dao.getAllCoffee();
		request.setAttribute("allCoffee", list);
		RequestDispatcher rd = request.getRequestDispatcher("mainCoffee.jsp");
		rd.forward(request, response);
	}

	// Add a new Coffee Space
	protected void addCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coffee.setCoffeeName(request.getParameter("coffeeName"));
		dao.addCoffee(coffee);
		response.sendRedirect("mainCoffee");
	}

	// List Coffee Spaces
	protected void listCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int coffeeId = Integer.parseInt(request.getParameter("coffeeId"));
		coffee.setCoffeeId(coffeeId);
		dao.getCoffeeById(coffee);
		request.setAttribute("coffee", coffee);
		RequestDispatcher rd = request.getRequestDispatcher("editCoffee.jsp");
		rd.forward(request, response);
	}

	// Coffee Space Info
	protected void infoCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int coffeeId = Integer.parseInt(request.getParameter("coffeeId"));
		coffee.setCoffeeId(coffeeId);
		dao.getCoffeeById(coffee);
		request.setAttribute("coffee", coffee);
		RequestDispatcher rd = request.getRequestDispatcher("infoCoffee.jsp");
		rd.forward(request, response);
	}

	// Edit Coffee Space
	protected void editCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int coffeeId = Integer.parseInt(request.getParameter("coffeeId"));
		String coffeeName = request.getParameter("coffeeName");
		coffee.setCoffeeId(coffeeId);
		coffee.setCoffeeName(coffeeName);
		dao.editCoffee(coffee);
		response.sendRedirect("mainCoffee");
	}

	// Delete Coffee Space
	protected void deleteCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int coffeeId = Integer.parseInt(request.getParameter("coffeeId"));
		coffee.setCoffeeId(coffeeId);
		dao.deleteCoffee(coffee);
		response.sendRedirect("mainCoffee");
	}
}
