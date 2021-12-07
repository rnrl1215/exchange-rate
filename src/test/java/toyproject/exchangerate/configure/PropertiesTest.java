package toyproject.exchangerate.configure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PropertiesTest {

    @Autowired
    private ExchangeRateProperties exchangeRateProperties;

    @Test
    void getAccessKey() {
        String apiAccessKey = exchangeRateProperties.getApiAccessKey();
        log.info("api key log={}", apiAccessKey);
        org.assertj.core.api.Assertions.assertThat(apiAccessKey).isNotEmpty();
    }

    @Test
    void getUrl() {
        String apiUrl = exchangeRateProperties.getUrl();
        log.info("api url log={}", apiUrl);
        org.assertj.core.api.Assertions.assertThat(apiUrl).isNotEmpty();
    }

    @Test
    void getLive() {
        String live = exchangeRateProperties.getLive();
        log.info("api live log={}", live);
        org.assertj.core.api.Assertions.assertThat(live).isNotEmpty();
    }
}