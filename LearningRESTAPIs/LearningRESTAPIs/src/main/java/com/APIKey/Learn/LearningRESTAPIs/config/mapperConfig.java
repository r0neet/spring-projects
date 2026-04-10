package com.APIKey.Learn.LearningRESTAPIs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration                              // ANOTHER way of making a bean that can be configured
public class mapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
// used a model mapper for mapping between entity to DTO auto-matic
// also remember whats used in the entities should be same in DTO so it can easily map