package sistema.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static UserDetailsService usuarioService = new UsuarioSistemaService();
	
	public SecurityConfig() {
		 
	}
	
   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(usuarioService);
	   auth.inMemoryAuthentication().withUser("adm").password("123456").roles("ADMIN");
        
        
    }

    //@Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	//Controle feito pelo JSF
    	http.csrf().disable();
    	    	
    	//Página de acesso negado
        http.exceptionHandling().accessDeniedPage("/pages/acessonegado.xhtml");
        
        //Libera todos os recursos do JSF
        http.authorizeRequests().antMatchers("/javax.faces.resource/**").permitAll();
       
        
        
        //Controla o acesso a página protegida  do adm        
        http.authorizeRequests().antMatchers("/pages/adm").hasRole("ADMIN");
     
		
        
   	
    	
    	//Login
    	http.formLogin().loginPage("/pages/login.xhtml").permitAll()
		.defaultSuccessUrl("/pages/paginaInicial.xhtml", true)
		.failureUrl("/pages/login.xhtml?error=true")
		.usernameParameter("username")
		.passwordParameter("password");
    	
    	
    	//Logout
        http.logout().logoutUrl("/logout")
                     .logoutSuccessUrl("/pages/login.xhtml");

        // Todas as requisições para partes internas da aplicação devem ser autenticadas
		/* http.authorizeRequests().anyRequest().authenticated();*/
		
    	
    	
        
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }
}