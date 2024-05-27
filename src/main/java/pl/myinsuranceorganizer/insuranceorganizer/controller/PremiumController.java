package pl.myinsuranceorganizer.insuranceorganizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;
import pl.myinsuranceorganizer.insuranceorganizer.service.InsuranceService;

import java.util.List;

@Controller
public class PremiumController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/earned-premium")
    public String showEarnedPremium(Model model) {
        double totalPremium = insuranceService.getTotalEarnedPremium();
        model.addAttribute("totalPremium", totalPremium);
        return "earned-premium";
    }
}
