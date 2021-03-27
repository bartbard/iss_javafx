package openNotifyConnection;


import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class OpenNotifyConnectionTest {
    public final static String ASTRONAUTS_IN_SPACE_URL = "http://api.open-notify.org/astros.json";
    public final static String CURRENT_LOCATION_URL = "http://api.open-notify.org/iss-now.json";
    private final static String OVERHEAD_PASS_PREDICTIONS_URL = "http://api.open-notify.org/iss-pass.json?lat=";
    private static String callForJSONResult;

    @BeforeAll
    public static void callForJSONRequest() throws IOException {
        Request request = new Request.Builder()
                .url(ASTRONAUTS_IN_SPACE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        callForJSONResult = response.body().string();

    }
    @Test
    public void requestForDataIsNotNull(){
        assertThat(callForJSONResult).isNotEmpty();
    }

    @Test
    public void requestForDataContainKeyWords(){
        assertThat(callForJSONResult).contains("message","people","number","success");
    }


}
