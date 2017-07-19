package br.com.denucieja.persistence;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.InitializingBean;
/**
 * Classe existe para instaciar um fuso horário padrão do servidor, evitando que capture o fuso horário da máquina.
 * @author Marconi Motta
 *
 */
public class UpInitializeContext implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}
	
    public void init() {
		try {
			
			TimeZone tzone = TimeZone.getTimeZone("America/Recife");
			
			
	        TimeZone.setDefault(tzone);
	        Locale local = new Locale("pt", "BR");
	        Locale.setDefault(local);
	        
		      // checking default time zone
	        System.out.println("Default time local:" +local);
			System.out.println("data " + new Date());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

}
