package ru.n1ppl3.amazon.items.checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import ru.n1ppl3.amazon.items.checker.service.DataBaseInitializer;

import java.io.IOException;

@SpringBootApplication
public class AmazonItemsCheckerApplication {

	static boolean shouldInitDataBase = false;

	/*
	 * http://localhost:8181/h2
	 */
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(AmazonItemsCheckerApplication.class, args);
		if (shouldInitDataBase) {
			Resource resource = new FileSystemResource("C:\\_CLOUD\\yadisk\\XLS\\AMAZON.xlsx");
			ctx.getBean(DataBaseInitializer.class).parseAndSave(resource);
		}
	}

}
