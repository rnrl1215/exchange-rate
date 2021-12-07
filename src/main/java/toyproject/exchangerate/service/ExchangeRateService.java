package toyproject.exchangerate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import toyproject.exchangerate.configure.ExchangeRateProperties;
import toyproject.exchangerate.data.CountryCode;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateService {

    private final ExchangeRateProperties exchangeRateProperties;


    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    public double getExchangeRate(CountryCode countryCode) {

        double exchangeRage = 0.0;

        try {
            String url = exchangeRateProperties.getUrl();
            log.info("url ={}", url);
            String live = exchangeRateProperties.getLive();
            String key = exchangeRateProperties.getApiAccessKey();

            String apiUrl = url + live + "?access_key="+key
                    + "& currencies=KRW,PHP,JPY"
                    + "& source = USD"
                    + "&format = 1";


            OkHttpClient client = new OkHttpClient();
            Request.Builder builder = new Request.Builder().url(apiUrl).get();
            builder.addHeader("Content-type", "application/json");
            Request request = builder.build();
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    String currentCountryCode = "USD"+countryCode;
                    JSONObject jsonObject = new JSONObject(body.string());
                    exchangeRage = jsonObject.getJSONObject("quotes").getDouble(currentCountryCode);
                    // TODO: exchageRate == 0 일때 익셉션 발생
                }
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return exchangeRage;
    }

    public double getReceptionAmount(CountryCode countryCode, double remittanceAmount) {
        double receptionAmount =  remittanceAmount * getExchangeRate(countryCode);
        return receptionAmount;
    }
}
