package br.com.augusto;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class ProjetoEstagioApplication extends SpringBootServletInitializer implements ServletContextInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEstagioApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjetoEstagioApplication.class);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;

	}

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return sc -> {
			sc.setInitParameter("APP_NAME", "ProjetoEstagio");
			sc.setInitParameter("com.sun.faces.expressionFactory",
					"org.springframework.web.jsf.el.SpringBeanFacesElResolver");
//	            sc.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());
			sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
			sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
			sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
			sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
			sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
			sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
			sc.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
			sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
			sc.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());

			sc.addListener(new ContextLoaderListener());
			sc.addListener(new RequestContextListener());

			sc.addFilter("openSessionInView", new OpenEntityManagerInViewFilter()).addMappingForUrlPatterns(null, false,
					"/*");
		};
	}
}
