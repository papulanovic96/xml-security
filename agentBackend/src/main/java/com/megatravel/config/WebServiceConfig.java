package com.megatravel.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    //return new ServletRegistrationBean(servlet, "/booking/*");
	    return new ServletRegistrationBean(servlet, "/soap/*");
	}
	
	@Bean(name = "accommodations")
	public DefaultWsdl11Definition AccommodationsWsdl(XsdSchema accommodationSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("AccomodaitonsPort");
	    wsdl11Definition.setLocationUri("/booking");
	    wsdl11Definition.setTargetNamespace("http://www.megatravel.com/accommodation");
	    wsdl11Definition.setSchema(accommodationSchema);
	    return wsdl11Definition;
	}
	
	@Bean(name = "reservations")
	public DefaultWsdl11Definition ReservationsWsdl(XsdSchema reservationSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("ReservationsPort");
	    wsdl11Definition.setLocationUri("/booking");
	    wsdl11Definition.setTargetNamespace("http://www.megatravel.com/reservation");
	    wsdl11Definition.setSchema(reservationSchema);
	    return wsdl11Definition;
	}
	
	@Bean(name = "messages")
	public DefaultWsdl11Definition MessagesWsdl(XsdSchema messageSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("MessagesPort");
	    //wsdl11Definition.setLocationUri("/booking");
	    wsdl11Definition.setLocationUri("/soap");
	    wsdl11Definition.setTargetNamespace("http://www.megatravel.com/message");
	    wsdl11Definition.setSchema(messageSchema);
	    return wsdl11Definition;
	}
	 
}
