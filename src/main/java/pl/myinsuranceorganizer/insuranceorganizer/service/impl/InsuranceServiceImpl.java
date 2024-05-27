package pl.myinsuranceorganizer.insuranceorganizer.service.impl;

import org.springframework.stereotype.Service;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;
import pl.myinsuranceorganizer.insuranceorganizer.repository.InsuranceRepository;
import pl.myinsuranceorganizer.insuranceorganizer.service.InsuranceService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        // super ();
        this.insuranceRepository = insuranceRepository;
    }


    @Override
    public List<Insurance> getAllInsurances(){
        return insuranceRepository.findAll();
    }
    @Override
    public Insurance saveInsurance( Insurance insurance){
        return insuranceRepository.save(insurance);


    }

    @Override
    public Insurance getInsuranceById(Long id) {
        return insuranceRepository.findById(id).get();
    }

    @Override
    public Insurance updateInsurance(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Override
    public void deleteInsuranceById(Long id) {
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(id);
        if (optionalInsurance.isPresent()) {
            Insurance insurance = optionalInsurance.get();
            if (insurance.getPremiumPaid()) {
                throw new IllegalStateException("Nie można usunąć ubezpieczenia, gdy składka została opłacona.");
            } else {
                insuranceRepository.deleteById(id);
            }
        } else {
            throw new NoSuchElementException("Nie znaleziono ubezpieczenia o podanym identyfikatorze: " + id);
        }
    }
    @Override
    public double getTotalEarnedPremium() {
        List<Insurance> insurances = insuranceRepository.findAll();
        return insurances.stream()
                .filter(Insurance::isPremiumPaid) // Upewnij się, że metoda isPremiumPaid istnieje
                .mapToDouble(Insurance::getPremium)
                .sum();
    }
}
