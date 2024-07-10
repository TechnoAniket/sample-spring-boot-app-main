package com.sample.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.spring.proxy.FeatureProxyFactoryBean;

import com.sample.features.FeatureToggle;
import com.sample.service.ClientService;

@Configuration
public class ClientServiceConfiguration {

    @Qualifier("ClientService")
    @Autowired
    private ClientService realService;

    @Qualifier("MockClientService")
    @Autowired
    private ClientService mockService;

    @Bean("ClientServiceFeatureProxyFactoryBean")
    public FeatureProxyFactoryBean clientServiceFeatureProxyFactoryBean() {
        FeatureProxyFactoryBean featureProxyFactoryBean = new FeatureProxyFactoryBean();

        featureProxyFactoryBean.setProxyType(ClientService.class);
        featureProxyFactoryBean.setFeature(FeatureToggle.MOCKSERVICE.toString());
        featureProxyFactoryBean.setActive(mockService);
        featureProxyFactoryBean.setInactive(realService);

        return featureProxyFactoryBean;
    }
}