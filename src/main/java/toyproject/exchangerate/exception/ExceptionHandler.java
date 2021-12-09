package toyproject.exchangerate.exception;

import com.sun.jdi.InternalException;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public String exchangeRateUserException(Exception e, Model model) {
        model.addAttribute("error",e.getMessage());
        return "/exchangeRateForm :: #resultDiv";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InternalException.class)
    public String exchangeRateInternalException(Exception e, Model model) {
        model.addAttribute("error",e.getMessage());
        return "/exchangeRateForm :: #resultDiv";
    }
}

