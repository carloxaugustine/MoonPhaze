package MoonPhaze;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class MoonPhaseAPI {
    //This class will pull data from the API key inputted. At the moment world time doesn't fetch the data necessary.
    private static final String API_URL = "http://worldtimeapi.org/api/timezone/";

    public MoonPhaseData getMoonPhaseData(String timezone) {
        MoonPhaseData data = new MoonPhaseData();
        try {
            String requestURL = API_URL + timezone;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                System.out.println("Response: " + responseBody); // Print the entire response
                JSONObject jsonObject = new JSONObject(responseBody);

                // Extract the moon phase data from the JSON response
                String phaseName = jsonObject.getString("moon_phase"); // This assumes 'moon_phase' is the correct key
                data.setPhaseName(phaseName);
                data.setDate(jsonObject.getString("datetime")); // This assumes 'datetime' is the correct key
            } else {
                System.err.println("Error fetching data: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

