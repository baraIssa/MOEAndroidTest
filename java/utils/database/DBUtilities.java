

package utils.database;

import utils.error_handlers.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class DBUtilities {
	public static PreparedStatement preparedStatement;
	public static ResultSet results;
	public static ResultSetMetaData resultsMetaData;
	public static List<String> data = new ArrayList<String>();
	public static int columnNumber;

	/**
	 * retrieving ResultSet after execute query to allow the QE use the ResultSet's
	 * methods
	 * 
	 * @param query
	 * @return ResultSet
	 */
	public static ResultSet getResultSet(String query) {
		try {
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
		} catch (SQLException e) {
			Logger.info("The ResultSet not retrived succesfully , please check your query try again");
			e.printStackTrace();
		}
		return results;

	}

	/**
	 * ResultSetMetaData method in order to use ResultSetMetaData's methods and show
	 * all retrived records show all records from database method
	 */
	public static ResultSetMetaData getResultsMetaDataAndShowRecords(String query) {

		try {
			List<String> data = new ArrayList<String>();
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
			resultsMetaData = results.getMetaData();
			columnNumber = resultsMetaData.getColumnCount();
			while (results.next()) {
				for (int i = 1; i <= columnNumber; i++) {
					Logger.info(results.getString(i) + "\t");
					data.add(results.getString(i));
				}
			}
		} catch (SQLException e) {
			Logger.info(
					"The ResultsMetaData and records not retrived succesfully , please check your query and try again");
			e.printStackTrace();
		}
		return resultsMetaData;
	}

	/**
	 * retrieving results after execute query for the a particular column label
	 *
	 */
	public static List<String> getResultsByCoulmnName(String query, String column) {
		try {
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
			while (results.next()) {
				data.add(results.getString(column));
			}
		} catch (SQLException e) {
			Logger.info(
					"The ResultsByCoulmnName not retrived succesfully , please check your query and coulmn number then try again");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * retrieving results after execute query for the a particular column index
	 *
	 */
	public static List<String> getResutlsByCoulmnIndex(String query, int coulmnNum) {
		try {
			int coulmnindex = coulmnNum;
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
			while (results.next()) {
				data.add(results.getString(coulmnindex));
			}
		} catch (SQLException e) {
			Logger.info(
					"The ResultsByCoulmnName not retrived succesfully , please check your query and coulmn index then try again");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 *
	 * This method for any update statement like : update or insert into delete
	 *
	 *
	 * @param query
	 */
	public static void updateDataBase(String query) {
		try {
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			int rows = preparedStatement.executeUpdate(query);
			Logger.info(rows + " rows updated Successfully Into Database");

		} catch (SQLException e) {
			Logger.info("Nothing updated into the database, please check your query try again");
			e.printStackTrace();
		}
	}

	public static int getColumnCount(String query) {
		try {
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
			resultsMetaData = results.getMetaData();
			columnNumber = resultsMetaData.getColumnCount();
			while (results.next()) {
				for (int i = 1; i <= columnNumber; i++) {
					data.add(results.getString(i));
				}
			}
		} catch (SQLException e) {
			Logger.info("Somthing went wronge while retriving the data , please check your query try again");
			e.printStackTrace();
		}
		return columnNumber;
	}

	public static int getRowCount(String query) {
		int rows = 0;
		try {
			preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(query);
			results = preparedStatement.executeQuery(query);
			results.last();
			rows = results.getRow();
			results.beforeFirst(); // To back to first row in the table
			while (results.next())
				rows = results.getRow();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
}