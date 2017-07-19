package br.com.denucieja.persistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Marconi Motta
 *
 */
public class TenantSecurityContextFilter implements Filter {
	

	private Map<String, String> map; 

	@Override
	public void destroy() {

	}
/**
 * Realiza o filtro por url. Como no momento possuimos um unico tipo de acesso, que é pelo aplicativo, deixamos padrão. Porém caso venha torna-se
 * web e multiplataforma, poderemos captura de onde ver a chamada e acessar o banco designado.
 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String url = httpRequest.getHeader("tenant");
			
			if ( url != null ){
				System.out.println("meu tenant = " +url);
			}
				
			if (map.get(httpRequest.getServerName()) == null) {
				ThreadLocalContextUtil.setTenantId("denucieja");
			} else {
				ThreadLocalContextUtil.setTenantId("denucieja");
			}
			
			ThreadLocalContextUtil.createSession();
			chain.doFilter(request, response);
			ThreadLocalContextUtil.finishSession();
		} catch (Throwable e) {
			try {
				if(ThreadLocalContextUtil.getSession().getTransaction().isActive()){
					ThreadLocalContextUtil.rollbackSession();
					ThreadLocalContextUtil.clearTenant();
				}
			} catch (Exception e2) {
				ThreadLocalContextUtil.finishSession();
				throw new RuntimeException("Erro ao realizar rollback da operação");
			}
		}
	} 

	/**
	 * Mapeamento de possiveis chamadas de url, com sua respectiva base de banco de dados.
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		if ( map == null){
			map = new HashMap<String, String>();
			map.put("localhost", "denucieja");
		}
	}
}