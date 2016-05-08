package projet;

import java.sql.*;

public class Connect {
    public static void main(String[] args) {      
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locationdb", "root","");
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM login");
            ResultSetMetaData resultMeta = result.getMetaData();
            System.out.println("\n**********************************");
            for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            System.out.println("\n**********************************");
            while(result.next()){         
                for(int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");                
            System.out.println("\n---------------------------------");
            }
        } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
        }
    }
}
    
