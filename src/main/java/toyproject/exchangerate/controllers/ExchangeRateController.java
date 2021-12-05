package toyproject.exchangerate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import toyproject.exchangerate.dto.ExchangeRateDto;

@Controller
public class ExchangeRateController {
    @GetMapping(value = "/exchange-rate")
    public String getExchangeForm(Model model) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        model.addAttribute("exchangeRateDto", exchangeRateDto);
        return "/exchangeRateForm";
    }

    @ResponseBody
    @GetMapping(value = "/exchange-rate/{countryCode}")
    public ExchangeRateDto getExchangeRate(@PathVariable(value = "countryCode") String countryCode, Model model) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setExchangeRate(1000);
        exchangeRateDto.setReceptionAmount(0);
        System.out.println("test" + exchangeRateDto.getExchangeRate());
        return exchangeRateDto;
    }
}
