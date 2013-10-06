/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Tata
 */
public class ConnectionUtil {

    private static Connection m_conn;
//    static Logger logger = Logger.getLogger(ConnectionUtil.class.getName());
    private static ConnectionUtil connectionUtil = null;

    public static ConnectionUtil getInstance() {
        if (connectionUtil == null) {
            connectionUtil = new ConnectionUtil();
            try {
                System.out.println("aaaaa");
//	      m_connectmgr = new ConnectionManager("sampurna");
//	      m_connectmgr = new ConnectionManager("sampurna");
                Class.forName("com.mysql.jdbc.Driver");
                m_conn = DriverManager.getConnection("jdbc:mysql://localhost/tisas_db", "root", "");
                System.out.println("bbbbb");
//	      m_conn = m_connectmgr.getConnection();  
                System.out.println("ccccc");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return connectionUtil;
    }

    public ConnectionUtil() {
    }

    public Connection getConn() {
        return m_conn;
    }
}
