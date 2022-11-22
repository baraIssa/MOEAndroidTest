Database utility 
- This created in order to help QE to execute tests on database layer 
- DBConnection class method is responsible to connect on database 
- DB utility class contain method that help QE to execute queries (update , insert , delete , select), no need to creat an instance from the DBConeection Just import DButility and start writing your test 
- Each method in DbUtilities named with what will do 
- User should use close method in DbConnection class to close the opened connection from the DB 
- The supported database are "Mysql , Mssql , Mongodb"
- User should import DbUtilities in his test class in order to use methods 
- user able to retrieve data as Resultset using get result method 
- User able to retrieve data as ResultSetMetaData using get result method 
- User able to show all database record for the specific query 
- User able to retrieve a specific data for column name for the executed query using getResutlsByCoulmnName method 
- User able to retrieve a specific data for column index for the executed query using getResutlsByCoulmnindex method 
- User able to retrieve row count for specific query
- User able to retrieve column count for specific query  
- This method for any update statement like : update or insert into delete
- User should define props file in the db.props in the core ,url username , password , dbtype in case he want to user default  one 
- No worries if the user enter the props value incorrect , the console will show the problem to him 
- User should provide path of his props file in the path.props file to run his own one 
- In case user pass special parameter , he can pass these parameter in the url after ? as the default db.props file 
- Its Recommended  to use test priority in your test will do tests on database
- in case how are user Mssql data base and has an issue , the user should import sql jar file manually in his project from this link https://mvnrepository.com/artifact/com.microsoft.sqlserver/sqljdbc4/4.0 and here is the issue root cause for this issue https://stackoverflow.com/questions/19537396/missing-artifact-com-microsoft-sqlserversqljdbc4jar4-0
- The path database.properties file should be under resources , ex "src/main/resources/database.properties" and the file name should be database.properties
here is test sample 
  
    @Test
	    public void mawdoo3PageTest() {
		  try {
	        dbConnection.createConnection();
			ResultSet test = DBUtilities.getResultSet("SELECT * FROM aqlamy_db.articles where title_id = 2530 or title_id = 2085 or title_id = 2699;");
			test.next();
			System.out.println(test.getString("schedule_publish_date"));
			dbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	    }
	  
	  @Test
	    public void mawdoo3PageTest3() throws InterruptedException {
		  try {
	    dbConnection.createConnection();
	  
			DBUtilities.updateDataBase("UPDATE aqlamy_db.users set mobile_number=\"654444\" WHERE users.id =615;");
			dbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	    }
	  @Test
	    public void mawdoo3PageTest4() {
		  try {
			 dbConnection.createConnection();
			String test = DBUtilities.getResutlsByCoulmnName("SELECT * FROM aqlamy_db.users where mobile_number=\"5555\";", "mobile_number");
			System.out.println(test);
		} catch (SQLException e) {
			
			e.getMessage();
		}
	    }
	  
	  @Test
	    public void mawdoo3PageTest2() {
		  try {
			 dbConnection.createConnection();
			ResultSet test = DBUtilities.getResultSet("SELECT * FROM aqlamy_db.users where mobile_number=\"333\";");
			test.next();
			System.out.println(test.getString("mobile_number"));
		} catch (SQLException e) {
		
			e.getMessage();
		}
	    }
	  