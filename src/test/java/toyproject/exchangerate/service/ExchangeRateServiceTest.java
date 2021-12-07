package toyproject.exchangerate.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import toyproject.exchangerate.data.CountryCode;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class ExchangeRateServiceTest {

    @Autowired
    ExchangeRateService exchangeRateService;

    @Test
    void getExchangeRateTest() {
        double exchangeRate = 0.0;
        exchangeRate = exchangeRateService.getExchangeRate(CountryCode.KRW);
        log.info("exchangeRate log={}",exchangeRate);
        Assertions.assertThat(exchangeRate).isNotEqualTo(0.0);
    }
}