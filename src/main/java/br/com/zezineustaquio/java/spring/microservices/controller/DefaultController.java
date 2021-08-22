package br.com.zezineustaquio.java.spring.microservices.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/")
public class DefaultController {

	@Value("${mocroservice.home:}")
	private String homePage;

	@GetMapping
	public void redirectToHome(HttpServletResponse response) throws IOException {
		response.sendRedirect(homePage);
	}

}
