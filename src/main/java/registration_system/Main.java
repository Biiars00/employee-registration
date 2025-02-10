package registration_system;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
		System.setProperty("DATABASE_USER", dotenv.get("DATABASE_USER"));
		System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));

		// // String databaseUrl = dotenv.get("DATABASE_URL", "default_url");
		// // String databaseUser = dotenv.get("DATABASE_USER", "default_user");
		// // String databasePassword = dotenv.get("DATABASE_PASSWORD",
		// // "default_password");

		// System.out.println("DATABASE_URL: ");
		// System.out.println("DATABASE_USER: ");
		// System.out.println("DATABASE_PASSWORD: ");

		SpringApplication.run(Main.class, args);
	}
}