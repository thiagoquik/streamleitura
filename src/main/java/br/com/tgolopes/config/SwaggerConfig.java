package br.com.tgolopes.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import br.com.tgolopes.LeituraStreamApplication;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = LeituraStreamApplication.class)
public class SwaggerConfig {
    
    private static final String PACKAGE_BASE = "br.com.tgolopes.controller";
    
    @Bean
    public Docket swaggerInit() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(PACKAGE_BASE))
                .paths(PathSelectors.any()).build().apiInfo(this.apiInfo()).useDefaultResponseMessages(false);
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo("streamleitura", "Serviço Rest de imput de Stream", null, null,
                new Contact("Thiago Oloveira Lopes", null, "thiago.csgo@gmail.com"), null, null);
    }

}

