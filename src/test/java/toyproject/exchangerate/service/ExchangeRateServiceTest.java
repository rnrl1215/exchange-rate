package toyproject.exchangerate.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import toyproject.exchangerate.data.CountryCode;

import java.math.BigDecimal;

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

    @Test
    void getReceptionAmount() {
        double exchangeRate = 2.0;
        int remittanceAmount = 100;

        BigDecimal exchangeRateBig = new BigDecimal(String.valueOf(exchangeRate));
        BigDecimal remittanceAmountBig = new BigDecimal(String.valueOf(remittanceAmount));

        BigDecimal result = exchangeRateBig.multiply(remittanceAmountBig);

        BigDecimal receptionAmount = exchangeRateService.getReceptionAmount(exchangeRate, remittanceAmount);
        Assertions.assertThat(receptionAmount).isEqualTo(result);
    }
}