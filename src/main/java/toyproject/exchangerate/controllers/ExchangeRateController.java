package toyproject.exchangerate.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.exchangerate.data.CountryCode;
import toyproject.exchangerate.dto.ExchangeRateDto;
import toyproject.exchangerate.service.ExchangeRateService;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping(value = "/exchange-rate")
    public String getExchangeForm(Model model) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        model.addAttribute("exchangeRateDto", exchangeRateDto);
        return "/exchangeRateForm";
    }

    @ResponseBody
    @GetMapping(value = "/exchange-rate/{countryCode}")
    public ExchangeRateDto getExchangeRate(@PathVariable(value = "countryCode") CountryCode countryCode, Model model) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        double exchangeRate = exchangeRateService.getExchangeRate(countryCode);
        exchangeRateDto.setExchangeRate(exchangeRate);
        return exchangeRateDto;
    }

    @PostMapping(value = "/exchange-rate")
    public String getReceptionAmount(@RequestBody ExchangeRateDto exchangeRateDto
                                                 ,Model model) {

        double exchangeRate = exchangeRateDto.getExchangeRate();
        double remittanceAmount = exchangeRateDto.getRemittanceAmount();

        BigDecimal receptionAmount = exchangeRateService.getReceptionAmount(exchangeRate, remittanceAmount);
        exchangeRateDto.setReceptionAmount(receptionAmount);
        exchangeRateDto.setStatus(true);

        model.addAttribute("exchangeRateDto",exchangeRateDto);
        return "/exchangeRateForm :: #resultDiv";
    }
}
