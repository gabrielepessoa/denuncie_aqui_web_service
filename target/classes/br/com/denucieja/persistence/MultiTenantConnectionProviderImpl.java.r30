
package br.com.denucieja.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	/**
	 * configurações do dataSource de acesso ao servidor de banco de dados
	 * Obs: Não existe configuração do schema nesta classe.
	 */
	private static final long serialVersionUID = 4866736042040236152L;

	private Map<String, DataSource> map;

	private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
	private static final String USER_BASE = "root";
	private static final String PASSWORD_BASE = "4056";

	 
		 
	public MultiTenantConnectionProviderImpl() {

		map = new HashMap<String, DataSource>();

		try {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername(USER_BASE);
			dataSource.setPassword(PASSWORD_BASE);
			dataSource.setMinIdle(0);
			dataSource.setMaxTotal(50);
			dataSource.setMaxIdle(5);
			dataSource.setMaxWaitMillis(1800);
//			dataSource.setMaxConnLifetimeMillis(60000);
			dataSource.setMaxConnLifetimeMillis(7200000);
			dataSource.setSoftMinEvictableIdleTimeMillis(1800);
//			dataSource.setRemoveAbandonedOnBorrow(true);
//			dataSource.setRemoveAbandonedOnMaintenance(true);
			dataSource.setRemoveAbandonedTimeout(120);
			dataSource.setUrl(URL_BASE + "denucieja");
			map.put("denucieja", dataSource);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao inicializar conexões com bancos.");
		}
	}

	protected DataSource selectAnyDataSource() {
		return map.get("denucieja");
	}

	protected DataSource selectDataSource(String tenantIdentifier) {
		try {
			if (map.get(tenantIdentifier) == null) {
				BasicDataSource dataSource = new BasicDataSource();
				dataSource.setDriverClassName("com.mysql.jdbc.Driver");
				dataSource.setUsername(USER_BASE);
				dataSource.setPassword(PASSWORD_BASE);
				dataSource.setMinIdle(0);
				dataSource.setMaxTotal(50);
				dataSource.setMaxIdle(5);
				dataSource.setMaxWaitMillis(1800);
//				dataSource.setMaxConnLifetimeMillis(60000);
				dataSource.setMaxConnLifetimeMillis(7200000);
				dataSource.setSoftMinEvictableIdleTimeMillis(1800);
//				dataSource.setRemoveAbandonedOnBorrow(true);
//				dataSource.setRemoveAbandonedOnMaintenance(true);
				dataSource.setRemoveAbandonedTimeout(120);
				dataSource.setUrl(URL_BASE + tenantIdentifier);
				map.put(tenantIdentifier, dataSource);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.get(tenantIdentifier);
	}

	public Map<String, DataSource> getMap() {
		return map;
	}

	public void setMap(Map<String, DataSource> map) {
		this.map = map;
	}

}