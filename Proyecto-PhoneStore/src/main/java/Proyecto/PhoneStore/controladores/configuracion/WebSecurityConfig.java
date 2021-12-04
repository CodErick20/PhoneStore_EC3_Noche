package Proyecto.PhoneStore.controladores.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/css/*", "/imagenes/", "/js/", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/*")
		.permitAll()
		.antMatchers("/categorias/listarTodo").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/categorias/nuevo").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/categorias/guardar").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/categorias/actualizar/**").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/categorias/eliminar/**").hasAnyRole("ADMIN")
		
		.antMatchers("/productos/listarTodo").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/productos/nuevo").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/productos/guardar").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/productos/actualizar/**").hasAnyRole("ADMIN","SOPORTE")
		.antMatchers("/productos/eliminar/**").hasAnyRole("ADMIN")
		
		
		
		
		
	
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout()
		.permitAll();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()				
		.withUser("henry").password(encoder.encode("henry")).roles("CLIENTE").and()
		.withUser("hernan").password(encoder.encode("hernan")).roles("SOPORTE").and();

	}

}