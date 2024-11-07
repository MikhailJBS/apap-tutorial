package apap.tutorial.manpromanpro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import apap.tutorial.manpromanpro.model.Developer;
import apap.tutorial.manpromanpro.model.Pekerja;
import apap.tutorial.manpromanpro.model.Proyek;
import apap.tutorial.manpromanpro.service.DeveloperService;
import apap.tutorial.manpromanpro.service.PekerjaService;
import apap.tutorial.manpromanpro.service.ProyekService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class ManpromanproApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManpromanproApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(ProyekService proyekService, DeveloperService developerService, PekerjaService pekerjaService) {
		return args -> {
			var faker = new Faker(new Locale("in-ID"));

			for (int i = 0; i < 2; i++) {
				var proyek = new Proyek();
				var date = faker.date();

				proyek.setNama(faker.app().name());
				proyek.setDeskripsi(faker.company().catchPhrase());
				proyek.setTanggalMulai(date.past(2, TimeUnit.DAYS));
				proyek.setTanggalSelesai(date.future(2, TimeUnit.DAYS));
				String[] statusList = { "STARTED", "ONGOING", "FINISHED" };
				proyek.setStatus(statusList[faker.random().nextInt(statusList.length)]);

				var developer = new Developer();
				var devName = faker.name();
				var devAddress = faker.address();

				developer.setNama(devName.fullName());
				developer.setAlamat(devAddress.fullAddress());
				developer.setTanggalBerdiri(date.birthday());
				developer.setEmail(faker.internet().emailAddress());

				var newDeveloper = developerService.addDeveloper(developer);
				proyek.setDeveloper(newDeveloper);

				var pekerja = new Pekerja();
				String namaPekerja = faker.name().fullName();
				if (namaPekerja.length() > 50) {
					namaPekerja = namaPekerja.substring(0, 50);
				}
				pekerja.setNama(namaPekerja);
				pekerja.setUsia(faker.number().numberBetween(20, 60));
				String pekerjaan = faker.job().title();
				if (pekerjaan.length() > 30) {
					pekerjaan = pekerjaan.substring(0, 30);
				}
				pekerja.setPekerjaan(pekerjaan);
				pekerja.setBiografi(faker.lorem().paragraph());

				var newPekerja = pekerjaService.addPekerja(pekerja);

				List<Pekerja> listPekerja = new ArrayList<>();
				listPekerja.add(newPekerja);
				proyek.setListPekerja(listPekerja);

				proyekService.addProyek(proyek);
			}
		};
	}
}