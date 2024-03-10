package in.dev.gmsk.repository;

import in.dev.gmsk.model.JDBCModel;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JDBCConnectionTest {

    @Test
    void getConnection() throws SQLException {
        JDBCModel dataBaseSession = JDBCConnection.getDataBaseSession();

        assertNotNull( dataBaseSession );

        Connection connection = JDBCConnection.getConnection( dataBaseSession );

        assertTrue( connection.isValid( 0 ) );

        connection.close();
    }
}