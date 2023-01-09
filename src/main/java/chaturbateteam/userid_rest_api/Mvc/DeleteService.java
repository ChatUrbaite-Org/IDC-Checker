package chaturbateteam.userid_rest_api.Mvc;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

//Path("/delete") @POST
public interface DeleteService
{
    //Path("/username")
    Response deleteUser(@HeaderParam("userName") String userName,
                        @HeaderParam("token") String token);
    //Path("/user")
    Response deleteUser(@HeaderParam("Userid") String userid);

    //Path("/IDCard")
    Response deleteIDCard(@HeaderParam("IDCardid") String IDCardid);

}
