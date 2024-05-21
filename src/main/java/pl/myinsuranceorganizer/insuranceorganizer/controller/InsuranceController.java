package pl.myinsuranceorganizer.insuranceorganizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;
import pl.myinsuranceorganizer.insuranceorganizer.service.InsuranceService;

@Controller
public class InsuranceController {

    private InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        super();
        this.insuranceService = insuranceService;
    }

    // handler method to handle list insurance and return mode and view
    @GetMapping("/insurances")
    public String listInsurances (Model model) {
        model.addAttribute("insurances", insuranceService.getAllInsurances());
        return "insurances";

    }
    @GetMapping("/insurances/new")
    public String createInsuranceForm(Model model) {
        Insurance insurance = new Insurance();
        model.addAttribute("insurance", insurance);
        return "create_insurance";
    }
    @PostMapping("insurances")
    public String saveInsurance(@ModelAttribute("insurance") Insurance insurance) {
        insuranceService.saveInsurance(insurance);
        return "redirect:/insurances";
    }
    @GetMapping("/insurances/edit/{id}")
    public String editInsurancesForm(@PathVariable Long id, Model model){
        model.addAttribute("insurance", insuranceService.getInsuranceById(id));
        return "edit_insurance";


    }
    @PostMapping("/insurances/{id}")
    public String updateInsurance(@PathVariable Long id,
                                  @ModelAttribute("insurance") Insurance insurance,
                                  Model model) {

        // get insurance from data base by id

        Insurance existingInsurance = insuranceService.getInsuranceById(id);
        existingInsurance.setId(id);
        existingInsurance.setClientName(insurance.getClientName());
        existingInsurance.setInsuranceName(insurance.getInsuranceName());
        existingInsurance.setSumInsurance(insurance.getSumInsurance());
        existingInsurance.setPremium(insurance.getPremium());
        existingInsurance.setPremiumPaid(insurance.getPremiumPaid());

        //save updated insurance object
        insuranceService.updateInsurance(existingInsurance);
        return "redirect:/insurances";

    }

    // handler method to handel delete insurance request
    @GetMapping("/insurances/{id}")
    public String deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsuranceById(id);
        return "redirect:/insurances";

    }


}
