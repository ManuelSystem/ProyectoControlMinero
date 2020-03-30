/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Database {

    private static Connection connection;
    private static String database = "controlmina";
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/" + database;
    private static JDBCMiddler jdbc;

    public static boolean connect() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            return true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }

    }

    public static boolean isConnected() {
        return connection != null;
    }

    public static void closeConnection() {

        if (isConnected()) {
            try {
                connection.close();
                connection = null;
                // System.out.println("Se ha finalizado la conexión con el servidor");
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean ejecutarActualizacionSQL(String comandoSQL) {
        {
            try {
                boolean ok;
                if (connect()) {

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    PreparedStatement sql = connection.prepareStatement(comandoSQL);
                    ok = sql.executeUpdate() != 0;
                    sql.close();
                    sql = null;
                    closeConnection();

                    return ok;
                } else {
                    return false;
                }

            } catch (Exception e) {
                System.err.println("SQL Error:" + e.getMessage());
                return (false);
            }
        }
    }

    /**
     *
     * @param comandoSQL
     * @return
     */
    public static ArrayList<String> getSQL(String a) {
        StringBuffer html = new StringBuffer();
        ArrayList<String> v = new ArrayList<String>();
        try {

            if (connect()) {
                Statement sql = connection.createStatement();
                //System.out.println(a);
                ResultSet rs = sql.executeQuery(a);
                ResultSetMetaData rsm = rs.getMetaData();

                while (rs.next()) {
                    String r = "";
                    for (int i = 1; i <= rsm.getColumnCount(); i++) {
                        r = r + rs.getString(i) + "/";
                    }
                    v.add(r);
                }
                closeConnection();

            }

        } catch (SQLException n) {
            System.err.println("SQL " + n.getMessage());
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
        }

        return v;

    }

    public static String[] getSQLArrayPersona(String SQL) {

        String[] datos = new String[9];
        try {
            if (connect()) {
                Statement sql = connection.createStatement();
                ResultSet rs = sql.executeQuery(SQL);
                ResultSetMetaData rsm = rs.getMetaData();

                while (rs.next()) {

                    datos[0] = rs.getString(1);
                    datos[1] = rs.getString(2);
                    datos[2] = rs.getString(3);
                    datos[3] = rs.getString(4);
                    datos[4] = rs.getString(5);
                    datos[5] = rs.getString(6);
                    datos[6] = rs.getString(7);
                    datos[7] = rs.getString(8);
                    datos[8] = rs.getString(9);

                }
                closeConnection();
            }
        } catch (SQLException n) {
            System.err.println("SQL " + n.getMessage());
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
        }

        return datos;
    }//Fin getHTML

}
