package Homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Homework3/AddCustomer")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		request.getRequestDispatcher("/WEB-INF/Homework3/AddCustomer.jsp").forward(request, response);
	}

	public static boolean validateEmail(String email) {

		boolean status = true;
		String Email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(Email);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			status = false;
		} else {
			status = true;
		}
		return status;

	}

	public static boolean validatePhonenumber(String phone_number) {

		boolean status = true;
		String Phone_Number = "[0-9]+";
		Pattern pattern = Pattern.compile(Phone_Number);
		Matcher matcher = pattern.matcher(phone_number);
		if (matcher.matches()) {
			status = false;
		} else {
			status = true;
		}
		return status;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		String name = request.getParameter("name");
		String purchase_item = request.getParameter("purchase_item");
		String email_id = request.getParameter("email_id");
		String phone_number = request.getParameter("phone_number");

		
		
		boolean hasError = false;

		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "Please enter your name");
		}
		if (purchase_item == null || purchase_item.trim().length() == 0) {
			hasError = true;
			request.setAttribute("itemError", "Please enter a item details");
		}

		if (email_id == null || email_id.trim().length() == 0 || validateEmail(email_id)) {
			hasError = true;
			request.setAttribute("email_idError", "Please enter a valid Email Id");
		}

		if (phone_number == null || phone_number.trim().length() == 0 ||  validatePhonenumber(phone_number)) {
			hasError = true;
			request.setAttribute("phone_numberError", "Please enter a valid phone number");
		}

		if (!hasError) {
			@SuppressWarnings("unchecked")
			ArrayList<Customer> entries = (ArrayList<Customer>) getServletContext().getAttribute("entries");
			entries.add(new Customer(name, purchase_item, email_id, phone_number));
			response.sendRedirect("Main");
		}

		else {
			doGet(request, response);
		}
	}

}
