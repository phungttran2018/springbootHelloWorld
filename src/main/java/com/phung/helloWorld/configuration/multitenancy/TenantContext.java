package com.phung.helloWorld.configuration.multitenancy;


import org.springframework.util.StringUtils;

public abstract class TenantContext {
    public static final String DEFAULT_TENANT_ID = "inventorya";
    private static ThreadLocal<String> currentTenant = new ThreadLocal<String>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static void clear(){
        currentTenant.remove();
    }
}
