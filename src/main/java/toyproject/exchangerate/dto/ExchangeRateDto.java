package toyproject.exchangerate.dto;

import lombok.Getter;
import lombok.Setter;
import toyproject.exchangerate.data.CountryCode;

@Getter
@Setter
public class ExchangeRateDto {
    private CountryCode countryCode;
    private double exchangeRate;
    private double receptionAmount;
    private int remittanceAmount;
    boolean status = false;
}
