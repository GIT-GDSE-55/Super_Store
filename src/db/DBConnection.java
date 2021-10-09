/*
 *
 *  * -------------------------------------------------------------
 *  *  Copyright (c) GDSE- Gansters. All rights reserved
 *  *  Licensed under the SriLankan Information  License. See LICENSE.txt in the project root for License information
 *  * -------------------------------------------------------------
 *
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sachini Umayangana <sachi.umay@gmail.com>
 * @since 10/9/2021
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection=null;
    private DBConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/SuperStore",
                        "root","1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return (null==dbConnection)?
                (dbConnection= new DBConnection()):(dbConnection);
    }

    public Connection getConnection(){return connection;}
}
