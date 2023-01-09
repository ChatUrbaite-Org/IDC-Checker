package chaturbateteam.userid_rest_api.Mvc.Controllers;

import chaturbateteam.userid_rest_api.Mvc.DeleteService;
import chaturbateteam.userid_rest_api.DataBase.*;
import chaturbateteam.userid_rest_api.Mvc.DeleteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/delete")
public class DeleteController implements DeleteService
{
    @Path("/username")
    @Override
    @POST
    public Response deleteUser(@HeaderParam("userName") String userName,
                               @HeaderParam("token") String token)
    {
        try{
            DeleteData.deleteUser(GetId.getUserId(GetObject.getUserUserName(userName,token)));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @POST
    @Path("/user")
    @Override
    public Response deleteUser(@HeaderParam("Userid") String userid)
    {
        try{
            DeleteData.deleteUser(Integer.parseInt(userid));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/IDCard")
    @Override
    @POST
    public Response deleteIDCard(@HeaderParam("IDCardid") String IDCardid)
    {
        try{
            DeleteData.deleteIDCard(Integer.parseInt(IDCardid));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
