package ba.unsa.etf.rpr;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	String url="jdbc:sqlite:knjige.db";
        try {
            Connection conn= DriverManager.getConnection(url);
           /* Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM knjiga");*/
           PreparedStatement ps=conn.prepareStatement("SELECT *FROM knjiga WHERE id=3");
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt(1);
                String naslov = rs.getString(2);
                System.out.println("ID:" + id + " Naslov: " + naslov);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
