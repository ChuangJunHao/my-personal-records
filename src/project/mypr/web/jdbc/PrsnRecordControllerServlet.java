package project.mypr.web.jdbc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PrsnRecordControllerServlet
 */
@WebServlet("/PrsnRecordControllerServlet")
public class PrsnRecordControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private PrsnRecordDbUtil prsnRecDbUtil;

	@Resource(name ="jdbc/my_personal_record")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// create our prsnRec db util...and pass in the conn pool / datasource
		try {
			prsnRecDbUtil = new PrsnRecordDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if(command == null) command = "LIST";
			
			switch(command) {
				case "ADD": addRecord(request, response); break;
				case "LIST": listPrsnRecord(request, response); break;
				default: listPrsnRecord(request, response); break;
			}
			
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
	}



	private void addRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// get pieces of info from request
		String exerciseName = request.getParameter("exerciseName");
		int weights = Integer.valueOf(request.getParameter("weights"));
		int sets = Integer.valueOf(request.getParameter("sets"));
		int reps = Integer.valueOf(request.getParameter("reps"));
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
				
		// create new PrsnRec object using the info
		PrsnRecord prsnRecord = new PrsnRecord(exerciseName, weights, sets, reps, date);
		
		// pass it to db
		prsnRecDbUtil.savePrsnRecord(prsnRecord);
		
		// send back to list page
		listPrsnRecord(request, response);
		
	}



	private void listPrsnRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<PrsnRecord> records = prsnRecDbUtil.getAllPrsnRecords();
		request.setAttribute("ALL_RECORDS", records);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-all-records.jsp");
		dispatcher.forward(request, response);
	}

}
