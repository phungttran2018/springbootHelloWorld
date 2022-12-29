package com.phung.helloWorld.configuration.multitenancy;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Optional;

public class TenantRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return Optional.ofNullable(TenantContext.getCurrentTenant())
                .orElse(TenantContext.DEFAULT_TENANT_ID);
    }

}
