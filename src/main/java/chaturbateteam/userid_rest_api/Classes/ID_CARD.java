package chaturbateteam.userid_rest_api.Classes;



import chaturbateteam.userid_rest_api.Enums.Nationality;

import java.util.Date;

public class ID_CARD
{
    private int id;
    private final int CAN_number;
    private chaturbateteam.userid_rest_api.Classes.User user;
    private final String organ;
    private final String id_num;
    private final boolean finger_print;
    private final Date Expiry;
    private final Nationality nation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCAN_number() {
        return CAN_number;
    }

    public chaturbateteam.userid_rest_api.Classes.User getUser() {
        return user;
    }
    public void setUser(chaturbateteam.userid_rest_api.Classes.User user) {
        this.user = user;
    }

    public String getOrgan() {
        return organ;
    }

    public String getId_num() {
        return id_num;
    }

    public boolean isFinger_print() {
        return finger_print;
    }

    public Date getExpiry() {
        return Expiry;
    }


    public Nationality getNation() {
        return nation;
    }

    public ID_CARD(int CAN_number, chaturbateteam.userid_rest_api.Classes.User user, String organ, String id_num, boolean finger_print, Date from, Nationality nation) {
        this.CAN_number = CAN_number;
        this.user = user;
        this.organ = organ;
        this.id_num = id_num;
        this.finger_print = finger_print;
        this.Expiry = from;
        this.nation = nation;
    }

    public ID_CARD(int id, int CAN_number, chaturbateteam.userid_rest_api.Classes.User user, String organ, String id_num, boolean finger_print, Date from, Nationality nation) {
        this.id = id;
        this.CAN_number = CAN_number;
        this.user = user;
        this.organ = organ;
        this.id_num = id_num;
        this.finger_print = finger_print;
        this.Expiry = from;
        this.nation = nation;
    }
}
