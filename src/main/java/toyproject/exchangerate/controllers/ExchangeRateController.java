package toyproject.exchangerate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeRateController {

    @GetMapping(value = "/exchange-rate")
    public String getExchangeForm(@ModelAttribute String countryCode) {
        System.out.println("CODE: "+countryCode);
        return "exchangeRateForm";
    }


}
