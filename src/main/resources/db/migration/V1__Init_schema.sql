--
-- Table structure for table employee
--

CREATE TABLE IF NOT EXISTS employees (
  id serial NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);
