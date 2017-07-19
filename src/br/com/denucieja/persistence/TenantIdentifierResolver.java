package br.com.denucieja.persistence;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;


public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

	@Override
	public String resolveCurrentTenantIdentifier() {
		return ThreadLocalContextUtil.getTenantId();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}

