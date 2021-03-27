package issCenter.openNotify;


import database.model.Astronaut;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenNotifyInformation {
    public static List<Astronaut> getPeopleInSpace() throws IOException {
        String jsonAsString = OpenNotifyConnection.requestForData(OpenNotifyConnection.ASTRONAUTS_IN_SPACE_URL);
        int howManyPeople = new JSONObject(jsonAsString).getInt("number");
        ArrayList<Astronaut> astronauts = new ArrayList<Astronaut>();
        for (int i = 0;i<howManyPeople;i++){
            Astronaut tempAstronaut = new Astronaut();
            JSONObject astronautObjectJSON = new JSONObject(jsonAsString).getJSONArray("people").getJSONObject(i);
            tempAstronaut.setCraftName(astronautObjectJSON.getString("craft"));
            tempAstronaut.setNameAndSurname(astronautObjectJSON.getString("name"));
            astronauts.add(tempAstronaut);
        }
        return astronauts;
    }

    public static void getCurrentSpeed() throws IOException {
        String jsonAsStringFirstResponse = OpenNotifyConnection.requestForData(OpenNotifyConnection.CURRENT_LOCATION_URL);
        String jsonAsStringSecondResponse = OpenNotifyConnection.requestForData(OpenNotifyConnection.CURRENT_LOCATION_URL);

       /* Timestamp ts = new Timestamp(System.currentTimeMillis());
        LocalDateTime date = ts.toLocalDateTime();
        System.out.println(date);*/
    }
}
