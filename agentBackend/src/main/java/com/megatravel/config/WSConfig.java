package com.megatravel.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WSConfig extends WsConfigurerAdapter{

	
	 @Bean
	    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
	        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	        servlet.setApplicationContext(context);
	        servlet.setTransformWsdlLocations(true);
	        return new ServletRegistrationBean(servlet, "/soap/*");
	    }
	 
	 @Bean(name = "accommodation")
		public DefaultWsdl11Definition AccommodationsWsdl(XsdSchema accommodationSchema) {
		    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		    wsdl11Definition.setPortTypeName("AccomodaitonsPort");
		    wsdl11Definition.setLocationUri("/soap");
		    wsdl11Definition.setTargetNamespace("http://www.megatravel.com/accommodation");
		    wsdl11Definition.setSchema(accommodationSchema);
		    return wsdl11Definition;
		}
}
