package src.main.test.java;

import chaturbateteam.userid_rest_api.DataBase.DeleteData;
import org.junit.Test;

public class DeleteTest {

    @Test
    public void delteUserTest(){DeleteData.deleteUser(3);}

    @Test
    public void DeleteIDCardTest(){DeleteData.deleteIDCard(3);}

}
