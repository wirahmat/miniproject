CREATE TABLE IF NOT EXISTS categories (
  id TEXT NOT NULL DEFAULT uuid_generate_v4(),
  code NOT NULL,
  name TEXT NOT NULL,
  description TEXT,
  created_at timestamptz NOT NULL,
  updated_at timestamptz NULL,
  "version" int8 NOT NULL,
  is_active bool NOT NULL DEFAULT TRUE,
  deleted_at timestamptz NULL,
  CONSTRAINT categories_pk PRIMARY KEY (id)
 );
 
 CREATE UNIQUE INDEX IF NOT EXISTS categories_un
  ON categories(code);

CREATE TABLE IF NOT EXISTS inventories (
  id TEXT NOT NULL DEFAULT uuid_generate_v4(),
  item_code NOT NULL,
  item_name TEXT NOT NULL,
  last_maintenance DATE,
  is_reminded_maintenance BOOLEAN NOT NULL DEFAULT FALSE,
  month INT,
  registered_date DATE NOT NULL,
  item_category_id TEXT NOT NULL,
  created_at timestamptz NOT NULL,
  updated_at timestamptz NULL,
  "version" int8 NOT NULL,
  is_active bool NOT NULL DEFAULT TRUE,
  deleted_at timestamptz NULL,
  CONSTRAINT inventories_pk PRIMARY KEY (id),
  CONSTRAINT inventories_fk_category FOREIGN KEY(item_category_id) REFERENCES categories(id) 
 );
 
 CREATE UNIQUE INDEX IF NOT EXISTS inventories_un
  ON inventories(item_code);