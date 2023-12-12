package DAO;
import java.sql.*;
public class DBConn {
    private String status;
    private String url="jdbc:mysql://localhost:3306/student";
    private String user="root";
    private String pwd="";
    Connection con;
    public DBConn() {
        try {
            con=DriverManager.getConnection(url,user,pwd);
            status="Kết nối thành công";
        }
        catch (Exception e){
            status="Lỗi kết nối";
            e.printStackTrace();
        }
    }
    public Connection getCon() {
        return con;
    }

    public ResultSet queryDB(String query) throws Exception {
        Statement st=this.getCon().createStatement();
        return st.executeQuery(query);
    }

    public int updateDB(String query) throws Exception {
        Statement st=this.getCon().createStatement();
        return st.executeUpdate(query);
    }
}