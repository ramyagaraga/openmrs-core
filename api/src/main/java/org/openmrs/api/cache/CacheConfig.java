/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class CacheConfig {

    @Bean(name = "apiCacheManagerFactoryBean")
    public EhCacheManagerFactoryBean apiCacheManagerFactoryBean(){
        OpenmrsCacheManagerFactoryBean cacheManagerFactoryBean = new OpenmrsCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache-api.xml"));
        cacheManagerFactoryBean.setShared(false);

        return cacheManagerFactoryBean;
    }

    @Bean(name = "apiCacheManager")
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(apiCacheManagerFactoryBean().getObject());
    }


}
