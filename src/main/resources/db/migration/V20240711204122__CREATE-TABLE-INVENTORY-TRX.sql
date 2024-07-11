CREATE TABLE IF NOT EXISTS inventory_transaction (
  id TEXT NOT NULL DEFAULT uuid_generate_v4(),
  trx_date DATE NOT NULL,
  trx_number TEXT NOT NULL,
  inventory_id TEXT NOT NULL,
  vendor TEXT,
  reason TEXT NOT NULL,
  amount NUMERIC NOT NULL,
  description TEXT,
  status TEXT NOT NULL,
  created_at timestamptz NOT NULL,
  updated_at timestamptz NULL,
  "version" int8 NOT NULL,
  deleted_at timestamptz NULL,
  CONSTRAINT inventory_transaction_pk PRIMARY KEY (id),
  CONSTRAINT inventory_transaction_fk_inventory FOREIGN KEY(inventory_id) REFERENCES inventories(id) 
 );
 
 CREATE UNIQUE INDEX IF NOT EXISTS inventory_transaction_un
  ON inventory_transaction(trx_date, trx_number, inventory_id);