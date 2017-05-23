package api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Mato on 23.5.17.
 */
public class VicinityLocator {

    String startURL = "http://nominatim.openstreetmap.org/reverse?format=json&lat=";
    String midURL = "&lon=";
    String endURL = "&zoom=18&addressdetails=1";
    String city;

    public String getCityNameByCoordinates(Double latitude, Double longitude) throws IOException {
        URL url = new URL(startURL+longitude+midURL+latitude+endURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        try {
            request.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
        JsonObject address = rootobj.get("address").getAsJsonObject();
        city = String.valueOf(address.get("city")); //just grab the zipcode
        return city;
    }


}
