package com.sample.features;

import org.togglz.core.annotation.Label;
import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.context.FeatureContext;

public enum FeatureToggle implements Feature {

    @EnabledByDefault
    @Label("Real Service")
    REALSERVICE,
    @Label("Mock Service")
    MOCKSERVICE;


    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
