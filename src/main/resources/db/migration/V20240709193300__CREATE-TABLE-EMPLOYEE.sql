CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS employees (
  id TEXT NOT NULL DEFAULT uuid_generate_v4(),
  nik TEXT NOT NULL,
  full_name TEXT NOT NULL,
  number_phone TEXT NOT NULL,
  address TEXT,
  birth_place TEXT,
  birth_date DATE,
  join_date DATE,
  created_at timestamptz NOT NULL,
  updated_at timestamptz NULL,
  "version" int8 NOT NULL,
  is_active bool NOT NULL DEFAULT TRUE,
  CONSTRAINT employees_pk PRIMARY KEY (id)
 );
 
 CREATE UNIQUE INDEX IF NOT EXISTS employees_un
  ON employees(nik, number_phone);