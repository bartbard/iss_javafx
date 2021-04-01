package openNotifyConnection;

import database.model.Astronaut;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static controllers.openNotify.OpenNotifyInformation.getPeopleInSpace;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenNotifyInformationTest {

    @Test
    public void getPeopleInSpaceReturnsList() throws IOException {
        assertThat(getPeopleInSpace()).isInstanceOf(List.class);
    }

    @Test
    public void getPeopleInSpaceReturnsListOfAstronauts() throws IOException {
        List<Astronaut> resultList = getPeopleInSpace();
        if(!resultList.isEmpty()){
            assertThat(resultList.get(0)).isInstanceOf(Astronaut.class);
        }
    }
}
