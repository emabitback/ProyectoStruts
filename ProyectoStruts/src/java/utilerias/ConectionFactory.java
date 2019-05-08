package utilerias;

import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConectionFactory {
    
    private static final String jdni = "jdbc/Proyecto";
    
    public ConectionFactory(){
        
    }
    public static Connection getConnection() throws SQLException{
        Connection con = null;
    try{
        InitialContext ini= new InitialContext();
        DataSource ds =(DataSource) ini.lookup(jdni);
        con= ds.getConnection();
    }catch(Exception e){
        e.printStackTrace();
        throw new SQLException (e.getMessage());
    }
    
    return con;
    
    }
    
    public static void closeConnection(Connection con)
            throws SQLException{
        try{
            if(con!=null && !con.isClosed()){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    } 
}
