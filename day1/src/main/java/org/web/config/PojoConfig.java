package org.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("file:src/main/**/*-context.xml") // xml bean설정을 import
public class PojoConfig {

}
