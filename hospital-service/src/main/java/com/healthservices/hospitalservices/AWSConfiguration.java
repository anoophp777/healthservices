package com.healthservices.hospitalservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"cloud","local"})
@ImportResource("classpath:/aws-configuration.xml")
public class AWSConfiguration {

}
