package src.main.test.java;

import chaturbateteam.userid_rest_api.DataBase.LoadMySQL;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoadMySQLTest {
    public void LoadMYSQLTest(){LoadMySQL load = new LoadMySQL();}
    @Test
    public void DriverTest(){assertEquals("com.mysql.cj.jdbc.Driver",LoadMySQL.getDriverName());}
    @Test
    public void AddressTest(){assertEquals("jdbc:mysql://localhost:3306/",LoadMySQL.getAddress());}
    @Test
    public void UserPassTest(){assertEquals("?user=root&password=",LoadMySQL.getUserPass());}
    @Test
    public void DBNameTest(){assertEquals("projekt",LoadMySQL.getDBName());}
    @Test
    public void UserNameTest(){assertEquals("root",LoadMySQL.getUserName());}
    @Test
    public void PasswordTest(){assertEquals("",LoadMySQL.getPassword());}
}
