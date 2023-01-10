package chaturbateteam.userid_rest_api.Mvc.Controllers;

import chaturbateteam.userid_rest_api.Classes.ID_CARD;
import chaturbateteam.userid_rest_api.Classes.User;
import chaturbateteam.userid_rest_api.DataBase.Insert_Into_DataBase;
import chaturbateteam.userid_rest_api.Enums.Nationality;
import chaturbateteam.userid_rest_api.Mvc.NewService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.*;

import java.util.Arrays;
import java.util.Objects;

import static chaturbateteam.userid_rest_api.DataBase.GetObject.getUserById;
import static java.sql.Date.valueOf;


@Path("/new")
public class NewController implements NewService
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();
    @Path("/user")
    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(@HeaderParam("uname") String name,
                                  @HeaderParam("userName") String username,
                                  @HeaderParam("email") String email,
                                  @HeaderParam("token") String token,
                                  @HeaderParam("birthPlace") String birthPlace,
                                  @HeaderParam("birthDate") String birthDate,
                                  @HeaderParam("sex") String sex,
                                  @HeaderParam("isMom") String isMom,
                                  @HeaderParam("girlName") String girlName,
                                  @HeaderParam("nationality") String nationality)
    {
        boolean mom = false;
        if(Objects.equals(isMom, "true")) mom = true;
        try
        {
            insert.insertIntoUserTable(new User(name,username,token,email, valueOf(birthDate),birthPlace,sex,true,mom,girlName,nationality));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            JSONObject object = new JSONObject();
            try {
                object.put("Name",name);
                object.put("UserName",username);
                object.put("Email",email);
                object.put("Token",token);
                object.put("BirthPlace",birthPlace);
                object.put("BirthDate",birthDate);
                object.put("Sex",sex);
                object.put("Mom",isMom);
                object.put("GirlName",girlName);
                object.put("Nationality",nationality);
                object.put("Message",ex.getMessage());
                object.put("StackTraceToString", Arrays.toString(ex.getStackTrace()));
                object.put("StackTrace",ex.getStackTrace());
                object.put("Cause",ex.getCause());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            return Response.ok(object).type(MediaType.APPLICATION_JSON).build();
        }

    }

    @Path("/IDCard")
    @Override
    @POST
    public Response createNewIDCard(@HeaderParam("Can_number") String can_number,
                                    @HeaderParam("Userid") String userid,
                                    @HeaderParam("OrganName") String orgname,
                                    @HeaderParam("IdNum") String idNum,
                                    @HeaderParam("FingerPrint") String fingerPrint,
                                    @HeaderParam("Expiry") String Expiry,
                                    @HeaderParam("Nationality") String nation)
    {
        try
        {
            insert.insertIntoIDCardTable(new ID_CARD(Integer.parseInt(can_number), getUserById(Integer.parseInt(userid)), orgname,idNum,Boolean.parseBoolean(fingerPrint),valueOf(Expiry), Nationality.valueOf(nation)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }

    }
}
