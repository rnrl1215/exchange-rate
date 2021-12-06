package toyproject.exchangerate.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.springframework.stereotype.Service;
import toyproject.exchangerate.data.CountryCode;

@Service
public class ExchangeRateService {
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    public void getExchangeRate(CountryCode countryCode) {

        try {
            String url = BASE_URL + ENDPOINT + "?access_key="+"6408fc6fc21b031866843c7c0faac12e"
                    + "& currencies=KRW,PHP,JPY"
                    + "& source = USD"
                    + "&format = 1";

            OkHttpClient client = new OkHttpClient();
            Request.Builder builder = new Request.Builder().url(url).get();
            builder.addHeader("Content-type", "application/json");
            Request request = builder.build();
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {

                    System.out.println("Respose: " + body.string());
                }
            } else {
                System.out.println("Error");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
