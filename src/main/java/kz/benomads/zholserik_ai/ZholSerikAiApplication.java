package kz.benomads.zholserik_ai;

import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZholSerikAiApplication implements AppShellConfigurator {

	public static void main(String[] args) {
		SpringApplication.run(ZholSerikAiApplication.class, args);
	}

}
