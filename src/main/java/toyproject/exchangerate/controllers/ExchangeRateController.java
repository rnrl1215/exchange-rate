package toyproject.exchangerate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import toyproject.exchangerate.dto.ExchangeRateDto;

@Controller
public class ExchangeRateController {

    @GetMapping(value = "/exchange-rate")
    public String getExchangeForm(@ModelAttribute ExchangeRateDto exchangeRateDto) {
        if (exchangeRateDto != null) {
            System.out.println("TEST1111: "+exchangeRateDto.getCountryCode());
        }
        System.out.println("TEST");
        return "exchangeRateForm";
    }

    @GetMapping(value = "/exchange-rate/{code}")
    public String getExchangeForm(@PathVariable(value = "code") String code) {
        System.out.println("TEST"+code);
        return "exchangeRateForm";
    }

}
