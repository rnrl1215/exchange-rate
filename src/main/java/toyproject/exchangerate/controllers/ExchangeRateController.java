package toyproject.exchangerate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.exchangerate.dto.ExchangeRateDto;
import toyproject.exchangerate.service.ExchangeRateService;

@Controller
@RequiredArgsConstructor
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
    public ExchangeRateDto getExchangeRate(@PathVariable(value = "countryCode") String countryCode, Model model) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setExchangeRate(1000);
        return exchangeRateDto;
    }

    @PostMapping(value = "/exchange-rate")
    public String getReceptionAmount(@ModelAttribute ExchangeRateDto exchangeRateDto, Model model) {
        System.out.println("POST: "+exchangeRateDto.getExchangeRate());
        System.out.println("POST: "+exchangeRateDto.getCountryCode().getDescription());
        System.out.println("POST: "+exchangeRateDto.getReceptionAmount());
        exchangeRateDto.setStatus(true);

        exchangeRateService.getExchangeRate(exchangeRateDto.getCountryCode());

        model.addAttribute("exchangeRateDto",exchangeRateDto);
        return "/exchangeRateForm";
    }
}
