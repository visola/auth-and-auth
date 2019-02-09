package org.visola.authandauth.data;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.visola.authandauth.data.uuid.UUIDArgumentFactory;

@Configuration
public class JDBIConfiguration {

  @Bean
  public Jdbi jdbi(DataSource dataSource) {
    Jdbi jdbi = Jdbi.create(dataSource);
    jdbi.installPlugin(new SqlObjectPlugin());
    jdbi.registerArgument(new UUIDArgumentFactory());
    return jdbi;
  }

  @Bean
  public UserDao userDAO(Jdbi jdbi) {
    return jdbi.onDemand(UserDao.class);
  }

}
