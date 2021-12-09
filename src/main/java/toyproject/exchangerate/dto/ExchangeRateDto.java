package toyproject.exchangerate.dto;

import lombok.Getter;
import lombok.Setter;
import toyproject.exchangerate.data.CountryCode;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRateDto {
    private CountryCode countryCode;
    private double exchangeRate;
    private BigDecimal receptionAmount;
    private int remittanceAmount;
    boolean status = false;
}
