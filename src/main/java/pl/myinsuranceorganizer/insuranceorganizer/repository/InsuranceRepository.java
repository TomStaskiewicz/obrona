package pl.myinsuranceorganizer.insuranceorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
