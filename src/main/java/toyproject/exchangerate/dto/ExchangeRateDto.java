package toyproject.exchangerate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateDto {
    private String countryCode;
    private int exchangeRate;
    private int receptionAmount;
    boolean status = false;
}
