

package utils.database;

import utils.database.enums.Databases;
import utils.error_handlers.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * setup connection class
 * 
 *
 */
public class DbConnection {

	private static DbConnection dbConnection;
	private Connection con;

	public static DbConnection getInstance() {
		if (dbConnection == null) {
			dbConnection = new DbConnection();
		}
		return dbConnection;
	}

	private DbConnection() {
		init();
	}
	/**
	 * 
	 * Initiate connection based on value retrieved from the props file 
	 */

	private void init() {
		Databases dbName = Databases.fromString(PropertiesUtils.getProperty(PropertiesUtils.PROP_NAME_DB_VENDOR));
		String url = PropertiesUtils.getProperty(PropertiesUtils.PROP_NAME_DB_URL);
		String username = PropertiesUtils.getProperty(PropertiesUtils.PROP_NAME_DB_USER_NAME);
		String password = PropertiesUtils.getProperty(PropertiesUtils.PROP_NAME_DB_PASSWORD);
		try {
			Class.forName(dbName.getDbDriverClassName());
			Logger.info("Connecting to the " + url);
			con = DriverManager.getConnection(dbName.getUrlPrefix().concat(url), username, password);
			Logger.info(con + " Connection created");
		} catch (Exception e) {
			Logger.info("Error occurs while creating connection to mysql database using the following parameters "
					+ "username ".concat(username) + " password ".concat(password));
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}

	public void closeConnection() {
		try {
			if (con != null && !con.isClosed())
				con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
