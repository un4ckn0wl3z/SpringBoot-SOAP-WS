package com.anuwk.soap.webservice.coursemanagement;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet messageDispatherServlet = new MessageDispatcherServlet();
		
		messageDispatherServlet.setApplicationContext(context);
		messageDispatherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDispatherServlet,"/ws/*");
	}
	
	@Bean(name="un4ckn0wl3z")
	public DefaultWsdl11Definition defaultWsdl11Definition(
			XsdSchema xyzUn4ckn0wl3zSchema
			) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		
		definition.setPortTypeName("Un4ckn0wl3zPort");
		definition.setTargetNamespace("http://www.un4ckn0wl3z.xyz");
		definition.setLocationUri("/ws");
		definition.setSchema(xyzUn4ckn0wl3zSchema);
		return definition;
	}
	
	
	@Bean
	public XsdSchema xyzUn4ckn0wl3zSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
	
}
