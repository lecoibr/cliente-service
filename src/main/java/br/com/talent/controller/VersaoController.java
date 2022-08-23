package br.com.talent.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * http://localhost/swagger-ui.html
 * http://localhost/v2/api-docs/
 */

@RestController
@RequestMapping("${domain}/versao")
@Api(tags = { "Versão da API" })
@Validated
@PropertySource("classpath:versao.properties")
public class VersaoController implements EnvironmentAware {

	private static Environment environment;

	@ApiOperation(value = "Versão da API")
	@GetMapping(value = "/api")
	public String getApi() throws FileNotFoundException, IOException, XmlPullParserException, ParseException {
		return getProp("versao");
	}

	public static String getProp(String key) {
		return environment.getProperty(key);
	}

	@Override
	public void setEnvironment(Environment environment) {
		VersaoController.environment = environment;
	}

}
