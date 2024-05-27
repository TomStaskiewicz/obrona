package pl.myinsuranceorganizer.insuranceorganizer.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MyErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(WebRequest webRequest, Model model) {
        // Pobierz szczegóły błędu
        model.addAttribute("error", errorAttributes.getError(webRequest));
        // Zwróć nazwę widoku dla strony błędu
        return "error";
    }


    public String getErrorPath() {
        return "/error"; // Zwróć ścieżkę do obsługi błędu
    }
}
