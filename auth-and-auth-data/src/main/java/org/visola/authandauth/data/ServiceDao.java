package org.visola.authandauth.data;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.visola.authandauth.Service;

public interface ServiceDao {

  @SqlQuery("SELECT COUNT(1) FROM service WHERE name = :name")
  int count(@Bind("name") String name);

  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO service (name) VALUES (:name)")
  long create(@BindBean Service service);

}
