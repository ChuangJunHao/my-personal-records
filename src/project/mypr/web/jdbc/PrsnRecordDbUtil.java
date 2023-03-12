package project.mypr.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class PrsnRecordDbUtil {

	private DataSource dataSource;
	
	// constructor
	public PrsnRecordDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private String selectAllQuery = "select * from record order by training_date desc";
	private String selectByIdQuery = "select * from record where id = ?";
	private String insertQuery = "insert into record(exercise_name, weights, sets, reps, volume, training_date) value(?, ?, ?, ?, ?, ?)";
	private String updateQuery = "update record set exercise_name = ?, weights = ?, sets = ?, reps = ?, volume = ?, training_date = ? where id = ? ";
	
	
	
	// retrieve all data
	public List<PrsnRecord> getAllPrsnRecords() throws Exception{
		List<PrsnRecord> allPrsnRecords = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// get result set from db
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectAllQuery);
			
			// store them into list
			while(rs.next()) {
				
				//retrieve pieces of info and create a new PrsnRec object
				int id = rs.getInt("id");
				String exerciseName = rs.getString("exercise_name");
				int weights = rs.getInt("weights");
				int sets = rs.getInt("sets");
				int reps = rs.getInt("reps");
				Date date = rs.getDate("training_date");
				
				PrsnRecord tempPrsnRecord = new PrsnRecord(id, exerciseName, weights, sets, reps, date);
				allPrsnRecords.add(tempPrsnRecord);
			}
			
			return allPrsnRecords;
			
		} finally {
			close(conn, stmt, rs);
		}
	}
	


	// retrieve data by keyword
	public List<PrsnRecord> getPrsnRecordsByKeyword(String keyword){
		return null;
	}
	
	// retrieve data by id
	public PrsnRecord getPrsnRecord(int id) throws Exception{
		PrsnRecord prsnRecord;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(selectByIdQuery);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String exerciseName = rs.getString("exercise_name");
				int weights = rs.getInt("weights");
				int sets = rs.getInt("sets");
				int reps = rs.getInt("reps");
				Date date = rs.getDate("training_date");
				
				prsnRecord = new PrsnRecord(id, exerciseName, weights, sets, reps, date);
				return prsnRecord;	
			}else {
				throw new Exception("could not find record id");
			}
		} finally {
			close(conn, stmt, rs);
		}
	}
	
	// create new data
	public void savePrsnRecord(PrsnRecord prsnRecord) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null; 
		
		// get pieces of info
		String exerciseName = prsnRecord.getExerciseName();
		int weights = prsnRecord.getWeights();
		int sets = prsnRecord.getSets();
		int reps = prsnRecord.getReps();
		int volume = prsnRecord.getVolume();
		String strDate = new SimpleDateFormat("yyyy-MM-dd").format(prsnRecord.getDate());
	
		
		// insert into db
		try {
			conn = dataSource.getConnection();
			
			// set query
			stmt = conn.prepareStatement(insertQuery);
			stmt.setString(1, exerciseName);
			stmt.setInt(2, weights);
			stmt.setInt(3, sets);
			stmt.setInt(4, reps);
			stmt.setInt(5, volume);
			stmt.setString(6, strDate);
			
			// execute query
			stmt.execute();
			
			
		} finally {
			close(conn, stmt, null);
		}
	}
	
	// update existing data
	public void updatePrsnRecord(PrsnRecord prsnRecord) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(updateQuery);
			
			stmt.setString(1, prsnRecord.getExerciseName());
			stmt.setInt(2, prsnRecord.getWeights());
			stmt.setInt(3, prsnRecord.getSets());
			stmt.setInt(4, prsnRecord.getReps());
			stmt.setInt(5, prsnRecord.getVolume());
			stmt.setString(6,  new SimpleDateFormat("yyyy-MM-dd").format(prsnRecord.getDate()));
			stmt.setInt(7, prsnRecord.getId());
			stmt.execute();
			
		}finally {
			close(conn ,stmt, null);
		}
		
	}
	
	// delete data
	public void deletePrsnRecord(int id) {
		
	}
	
	
	private void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
