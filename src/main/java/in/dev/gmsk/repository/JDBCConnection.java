package in.dev.gmsk.repository;

import in.dev.gmsk.model.JDBCModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection {

    private static final JDBCModel JDBC_MODEL;

    static {

        ResourceBundle res = ResourceBundle.getBundle( "application" );
        JDBC_MODEL = new JDBCModel();

        JDBC_MODEL.setDriverName( res.getString( "SqlDriver" ) );
        JDBC_MODEL.setProtocol( res.getString( "protocol" ) );
        JDBC_MODEL.setHost( res.getString( "host" ) );
        JDBC_MODEL.setPort( res.getString( "portNo" ) );
        JDBC_MODEL.setDbName( res.getString( "dbName" ) );
        JDBC_MODEL.setDbUserName( res.getString( "dbUserName" ) );
        JDBC_MODEL.setDbPassword( res.getString( "dbPassword" ) );

        JDBC_MODEL.setURI( JDBC_MODEL.getProtocol() + "://" + JDBC_MODEL.getHost() + ":" +
                JDBC_MODEL.getPort() + "/" + JDBC_MODEL.getDbName() );
    }

    public static JDBCModel getDataBaseSession() {
        return JDBC_MODEL;
    }

    public static Connection getConnection(JDBCModel model) throws SQLException {
        return DriverManager.getConnection( model.getURI(), model.getDbUserName(), model.getDbPassword() );
    }
}
