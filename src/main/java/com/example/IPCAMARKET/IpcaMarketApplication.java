package com.example.IPCAMARKET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IpcaMarketApplication {
        @Bean
   public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)  
    	  .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
   }

	public static void main(String[] args) {
		SpringApplication.run(IpcaMarketApplication.class, args);
        }
   
	@Bean
	public CorsFilter corsfilter() {
		final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedOrigin("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PUT");
		source.registerCorsConfiguration("/**", config);
		return  new CorsFilter(source);
	
	}

}
