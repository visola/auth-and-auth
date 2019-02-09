package org.visola.authandauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.visola.authandauth.data.JDBIConfiguration;

@Configuration
@Import(JDBIConfiguration.class)
public class ApplicationConfiguration {

}
