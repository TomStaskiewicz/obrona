package pl.myinsuranceorganizer.insuranceorganizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.myinsuranceorganizer.insuranceorganizer.entity.Insurance;
import pl.myinsuranceorganizer.insuranceorganizer.repository.InsuranceRepository;

@SpringBootApplication
public class InsuranceorganizerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceorganizerApplication.class, args);
	}

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public void run(String... args) throws Exception {
		Insurance insurance1 = new Insurance("ABC Trans", "OC Zawodowe", 250000, 1200.50, true);
		insuranceRepository.save(insurance1);

		Insurance insurance2 = new Insurance("OOL Trans", "OC Przewoźnika Drogowego", 50000, 1800.25, false);
		insuranceRepository.save(insurance2);

		Insurance insurance3 = new Insurance("Siema Trans", "OC Spedytora", 900000, 3000.25, false);
		insuranceRepository.save(insurance3);


	}
}
