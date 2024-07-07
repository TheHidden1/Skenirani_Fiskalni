package mk.ukim.finki.skenirani_fiskalni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SkeniraniFiskalniApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SkeniraniFiskalniApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("file:src/main/resources/static/images/")
				.setCachePeriod(0);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
