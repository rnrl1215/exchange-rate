package toyproject.exchangerate.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
@Setter
public class ExchangeRateProperties {
    @Value("${property.exchange-rate-api-accesskey}")
    public String apiAccessKey;

    @Value("${property.exchange-rate-api-url}")
    public String url;

    @Value("${property.exchange-rate-api-live}")
    public String live;
}
