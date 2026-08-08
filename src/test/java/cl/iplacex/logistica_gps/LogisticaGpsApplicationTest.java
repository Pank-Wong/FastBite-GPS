package cl.iplacex.logistica_gps;

import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;

class LogisticaGpsApplicationTest {

	@Test
	void mainStartsSpringApplication() {
		try (MockedStatic<SpringApplication> springApplication = mockStatic(SpringApplication.class)) {
			springApplication.when(() -> SpringApplication.run(LogisticaGpsApplication.class, new String[0]))
				.thenReturn(null);

			LogisticaGpsApplication.main(new String[0]);

			springApplication.verify(() -> SpringApplication.run(LogisticaGpsApplication.class, new String[0]));
		}
	}
}
