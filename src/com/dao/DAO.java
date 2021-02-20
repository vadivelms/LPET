package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import com.bean.QuestionBean;
import com.bean.TestBean;
import com.bean.UserBean;

public class DAO {
	Connection conn = null;
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Specify the deiver name to get registered  */
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "wipro", "wipro");
			/*Specify the database URL*/
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean addUser(UserBean uobj) throws SQLException {		
		String fname = uobj.getFname();
		String lname = uobj.getLname();
		String dob = uobj.getDob();
		String pass = uobj.getPassword();
		String email = uobj.getEmail();
		String aemail = uobj.getAemail();		
		DAO ob = new DAO();
		conn = ob.getConnection();
		try {			
			PreparedStatement pst = conn.prepareStatement("insert into wipro_user values(?,?,?,?,?,?)");
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, dob);
			pst.setString(4, email);
			pst.setString(5, aemail);
			pst.setString(6, pass);
			pst.executeUpdate();
			pst = conn.prepareStatement("commit work");
			pst.executeQuery();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean verifyUser(String username, String password) throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		try {			
			PreparedStatement pst = conn.prepareStatement(" select * from wipro_user where EMAIL=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			pst = conn.prepareStatement("commit work");
			pst.executeQuery();			
			if (rs.next()) {				
				return true;
			} else {				
				return false;
			}
		} catch (Exception e) {
			return false;
		}		
	}
	public ResultSet getUserDetails(String userName) throws SQLException
	{
		DAO ob = new DAO();		
		conn = ob.getConnection();
		String sql = "select * from WIPRO_USER where EMAIL=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		ps = conn.prepareStatement("commit work");
		ps.executeQuery();
		return rs;		
	}
	public boolean addquestions(QuestionBean qobj) throws SQLException {
		String title = qobj.getTitle();
		String domine = qobj.getDomine();
		String description = qobj.getDescription();
		String constraints = qobj.getConstraints();
		String sample_input1 = qobj.getInput_format();
		String sample_output1 = qobj.getOutput_format();
		String sample_input2 = qobj.getSample_input();
		String sample_output2 = qobj.getSample_output();
		int tc1p = qobj.getTc1p();
		String input1 = qobj.getInput1();
		String output1 = qobj.getOutput1();
		int tc2p = qobj.getTc2p();
		String input2 = qobj.getInput2();
		String output2 = qobj.getOutput2();
		int tc3p = qobj.getTc3p();
		String input3 = qobj.getInput3();
		String output3 = qobj.getOutput3();
		int tc4p = qobj.getTc4p();
		String input4 = qobj.getInput4();
		String output4 = qobj.getOutput4();
		String imports = qobj.getImports();
		String main = qobj.getMain();
		String method = qobj.getMethod();
		DAO ob = new DAO();
		conn = ob.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT Count(*) FROM questions");
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			String id = "q" + (++count);
			PreparedStatement pst = conn
					.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, id);
			pst.setString(2, title);
			pst.setString(3, description);
			pst.setString(4, constraints);
			pst.setString(5, sample_input1);
			pst.setString(6, sample_output1);
			pst.setString(7, sample_input2);
			pst.setString(8, sample_output2);
			pst.setString(9, domine);
			pst.setInt(10, tc1p);
			pst.setString(11, input1);
			pst.setString(12, output1);
			pst.setInt(13, tc2p);
			pst.setString(14, input2);
			pst.setString(15, output2);
			pst.setInt(16, tc3p);
			pst.setString(17, input3);
			pst.setString(18, output3);
			pst.setInt(19, tc4p);
			pst.setString(20, input4);
			pst.setString(21, output4);
			pst.setString(22, imports);
			pst.setString(23, main);
			pst.setString(24, method);			
			pst.executeUpdate();
			pst = conn.prepareStatement("commit work");
			pst.executeQuery();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String selectQuestionId(String testId) throws SQLException {
		Statement stmt = null;
		String allQuestions = null;
		Random r = new Random();
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "SELECT *  FROM test_details where TEST_ID=\'" + testId + "\'";
		stmt = conn.createStatement();		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			allQuestions = rs.getString("TEST_QUESTIONS");
		}
		String[] sary = allQuestions.split(" ");
		int q = r.nextInt((sary.length));
		String qId = sary[q];
		PreparedStatement pst = null;
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return qId;
	}
	public ResultSet getQuestion(String testId) throws SQLException {
		DAO ob = new DAO();
		String qId = ob.selectQuestionId(testId);		
		conn = ob.getConnection();
		String sql = "select * from Questions where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, qId);
		ResultSet rs = ps.executeQuery();
		ps = conn.prepareStatement("commit work");
		ps.executeQuery();
		return rs;
	}
	public ResultSet getAllQuestions() throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select * from Questions order by ID";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return rs;
	}
	public ResultSet getAllTests() throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select * from test_details order by TEST_ID";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return rs;
	}
	public void saveTest(TestBean tbobj) throws SQLException {
		String testName = tbobj.getTestName();
		int testDuration = tbobj.getTestDuration();
		String testQuestions = tbobj.getTestQuestionsId();
		String testDate=tbobj.getTestDate();
		DAO ob = new DAO();
		conn = ob.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT Count(*) FROM test_details");
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		String id = "test" + (++count);		
		PreparedStatement pst = conn.prepareStatement("insert into test_details values(?,?,?,?,?)");
		pst.setString(1, id);
		pst.setString(2, testName);
		pst.setInt(3, testDuration);
		pst.setString(4, testQuestions);
		pst.setString(5, testDate);		
		pst.executeUpdate();
		String sql = "create table " + id + "(username varchar(100),q1id varchar(50),mark1 decimal(5,2))";
		pst = conn.prepareStatement(sql);
		pst.executeQuery();
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
	}
	public String getTestName(String testId) throws SQLException {
		DAO ob = new DAO();
		String tId = testId;
		String testName = null;
		conn = ob.getConnection();
		String sql = "select TEST_NAME from test_details where TEST_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			testName = rs.getString(1);
		}
		ps = conn.prepareStatement("commit work");
		ps.executeQuery();
		return testName;
	}
	public String getSampleInput(String questionId) throws SQLException {
		DAO ob = new DAO();
		String ip = null;
		conn = ob.getConnection();
		String sql = "select SAMPLE_INPUT from questions where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, questionId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			ip = rs.getString(1);
		}		
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return ip;
	}
	public String getSampleOutput(String questionId) throws SQLException {
		DAO ob = new DAO();
		String op = null;
		conn = ob.getConnection();
		String sql = "select SAMPLE_OUTPUT from questions where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, questionId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			op = rs.getString(1);
		}	
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return op;
	}
	public ArrayList getInputs(String questionId) throws SQLException {
		ArrayList inputs = new ArrayList<>();
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select INPUT1,INPUT2,INPUT3,INPUT4 from questions where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, questionId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			inputs.add(rs.getString("INPUT1"));
			inputs.add(rs.getString("INPUT2"));
			inputs.add(rs.getString("INPUT3"));
			inputs.add(rs.getString("INPUT4"));
		}
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();		
		return inputs;
	}
	public ArrayList<Object> getOutputs(String questionId) throws SQLException {
		ArrayList<Object> outputs = new ArrayList<>();
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select OUTPUT1,OUTPUT2,OUTPUT3,OUTPUT4 from questions where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, questionId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			outputs.add(rs.getString("OUTPUT1"));
			outputs.add(rs.getString("OUTPUT2"));
			outputs.add(rs.getString("OUTPUT3"));
			outputs.add(rs.getString("OUTPUT4"));
		}
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return outputs;
	}

	public ArrayList getPoints(String questionId) throws SQLException {
		ArrayList<Integer> points = new ArrayList<Integer>();
		DAO ob = new DAO();

		conn = ob.getConnection();
		String sql = "select TC1P,TC2P,TC3P,TC4P from questions where ID=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, questionId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			points.add(rs.getInt("TC1P"));
			points.add(rs.getInt("TC2P"));
			points.add(rs.getInt("TC3P"));
			points.add(rs.getInt("TC4P"));
		}
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return points;
	}
	public boolean saveUserDetails(String testId, String username, String questionId) throws SQLException {
		DAO ob = new DAO();
		boolean flag = false;
		conn = ob.getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into " + testId + " (USERNAME,Q1ID) values (?,?)");
		pst.setString(1, username);
		pst.setString(2, questionId);
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			flag = true;
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return flag;
	}
	public boolean saveScore(String testId, String username, String questionId, float score) throws SQLException {
		DAO ob = new DAO();		
		boolean flag = false;
		conn = ob.getConnection();
		PreparedStatement pst = conn.prepareStatement("update " + testId + " set mark1=? where  username=? and Q1ID=?");
		pst.setFloat(1, score);
		pst.setString(2, username);		
		pst.setString(3, questionId);		
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			flag = true;
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return flag;
	}
	public boolean checkTestAttempt(String testId, String username) throws SQLException {	
		boolean flag = false;
		DAO ob = new DAO();
		conn = ob.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from " + testId + " where username=?");
		pst.setString(1, username);		
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			flag = true;
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return flag;
	}
	public float getStudentMarks(String testId, String username) throws SQLException {		
		DAO ob = new DAO();
		float marks = 0;
		conn = ob.getConnection();
		PreparedStatement pst = conn.prepareStatement("select MARK1 from " + testId + " where username=?");
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if (rs.next())
			marks = rs.getFloat("MARK1");

		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return marks;
	}
	public boolean checkUser(String email) throws SQLException {		
		boolean flag = false;
		DAO ob = new DAO();
		conn = ob.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from WIPRO_USER where EMAIL=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
			flag=true;		
		return flag;
	}
	public boolean addFeedback(String name, String mail, String comments) throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("insert into feedback values(?,?,?)");
			pst.setString(1, name);
			pst.setString(2, mail);
			pst.setString(3, comments);
			pst.executeUpdate();
			pst = conn.prepareStatement("commit work");
			pst.executeQuery();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public ResultSet getFeedback() throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select * from FEEDBACK";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return rs;
	}
	public ResultSet getTestReport(String testId) throws SQLException {
		DAO ob = new DAO();
		conn = ob.getConnection();
		String sql = "select * from "+testId;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		pst = conn.prepareStatement("commit work");
		pst.executeQuery();
		return rs;
	}
}
