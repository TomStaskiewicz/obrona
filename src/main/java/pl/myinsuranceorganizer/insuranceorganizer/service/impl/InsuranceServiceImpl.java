package pl.myinsuranceorganizer.insuranceorganizer.service.impl;

import org.springframework.stereotype.Service;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;
import pl.myinsuranceorganizer.insuranceorganizer.repository.InsuranceRepository;
import pl.myinsuranceorganizer.insuranceorganizer.service.InsuranceService;

import java.util.List;

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
        insuranceRepository.deleteById(id);

    }
}
