package toyproject.exchangerate.service;

import com.sun.jdi.InternalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import toyproject.exchangerate.configure.ExchangeRateProperties;
import toyproject.exchangerate.data.CountryCode;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateService {

    private final ExchangeRateProperties exchangeRateProperties;

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
                } else {
                    throw new InternalException("환율 정보를 가져오지 못했습니다.");
                }
            } else {
                throw new InternalException("환율 정보를 가져오지 못했습니다.");
            }
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }

        return exchangeRage;
    }

    public double getReceptionAmount(double exchangeRate, double remittanceAmount) throws IllegalArgumentException {

        if (exchangeRate == 0.0) {
            throw new IllegalArgumentException("환율값이 잘못 되었습니다.");
        } else if (remittanceAmount == 0.0 || remittanceAmount > 10000 ) {
            throw new IllegalArgumentException("송금액이 바르지 않습니다.");
        }

        double receptionAmount =  remittanceAmount * exchangeRate;
        return receptionAmount;
    }
}
