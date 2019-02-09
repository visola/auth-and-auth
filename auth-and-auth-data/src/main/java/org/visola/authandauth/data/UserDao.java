package org.visola.authandauth.data;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.visola.authandauth.User;

public interface UserDao {

  @SqlUpdate(
      "INSERT INTO user (id, username, password)" +
          "VALUES (UUID_TO_BIN(:id), :username, :password)"
  )
  void create(@BindBean User user);

}
