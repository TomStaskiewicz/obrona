package pl.myinsuranceorganizer.insuranceorganizer.service;

import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    List<Insurance> getAllInsurances();

    Insurance saveInsurance (Insurance insurance);

    Insurance getInsuranceById(Long id);

    Insurance updateInsurance(Insurance insurance);

    void deleteInsuranceById(Long id);
}
