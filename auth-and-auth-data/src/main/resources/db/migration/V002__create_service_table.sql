CREATE TABLE service (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX service_name_idx ON service (name);
