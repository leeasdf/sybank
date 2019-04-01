package xin.tianchuang.config;

import static com.google.common.collect.Lists.newArrayList;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
	}

	@Bean
	public Docket createRestApi() {
		List<ResponseMessage> responseMessageList = new ArrayList<>();
		responseMessageList.add(new ResponseMessageBuilder().code(500).message("系统繁忙").build());
		responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求成功").build());

		return new Docket(DocumentationType.SWAGGER_2) //
				.globalResponseMessage(RequestMethod.GET, responseMessageList) //
				.globalResponseMessage(RequestMethod.POST, responseMessageList) //
				.globalResponseMessage(RequestMethod.PUT, responseMessageList) //
				.globalResponseMessage(RequestMethod.DELETE, responseMessageList) //
				.apiInfo(apiInfo()) //
				.select() //
				// 加了ApiOperation注解的类，才生成接口文档
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //
				// 包下的类，才生成接口文档
				.apis(RequestHandlerSelectors.basePackage("xin.tianchuang.modules.api.controller")) //
				.paths(PathSelectors.any()) //
				.build() //
				.securitySchemes(security());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("泗阳农商行-企业信息管理系统") //
				.description("文档") //
				// .termsOfServiceUrl("-") //
				.version("1.0.0") //
				.build();
	}

	private List<ApiKey> security() {
		return newArrayList(new ApiKey("token", "token", "header"));
	}

}