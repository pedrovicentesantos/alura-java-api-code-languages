package com.pedro.api.languages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ApiLanguagesApplication {
		public static void main(String[] args) {
			Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
			String mongodbPassword = dotenv.get("MONGODB_PASSWORD");
			String mongodbUser = dotenv.get("MONGODB_USER");
			String mongodbUDatabase = dotenv.get("MONGODB_DATABASE");

			String mongodbUri = String.format("mongodb+srv://%s:%s@cluster0.b01ut.mongodb.net/%s?retryWrites=true&w=majority", mongodbUser, mongodbPassword, mongodbUDatabase);
			System.setProperty("spring.data.mongodb.uri", mongodbUri);

			SpringApplication.run(ApiLanguagesApplication.class, args);
	}

}
