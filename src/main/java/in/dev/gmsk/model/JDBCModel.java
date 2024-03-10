package in.dev.gmsk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class JDBCModel {

    private String driverName;
    private String protocol;
    private String host;
    private String port;
    private String dbName;
    private String dbUserName;
    private String dbPassword;
    private String URI;
}
