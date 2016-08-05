DROP TABLE IF EXISTS tiny_url_map;
CREATE TABLE tiny_url_map(
  id  INTEGER PRIMARY KEY AUTO_INCREMENT,
  short_key VARCHAR(30),
  long_url TEXT
);