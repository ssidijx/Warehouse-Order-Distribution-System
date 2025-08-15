COPY stores(id, name, latitude, longitude)
FROM '/Users/rustam/Documents/programming/Warehouse-Order-Distribution-System/src/main/resources/data/stores.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ',');

COPY categories(id, name)
FROM '/Users/rustam/Documents/programming/Warehouse-Order-Distribution-System/src/main/resources/data/categories.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ',');

COPY products(id, name, category_id, weight, volume)
FROM '/Users/rustam/Documents/programming/Warehouse-Order-Distribution-System/src/main/resources/data/products.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ',');

COPY orders(id, store_id, order_date)
FROM '/Users/rustam/Documents/programming/Warehouse-Order-Distribution-System/src/main/resources/data/orders.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ',');

COPY order_items(id, order_id, product_id, quantity)
FROM '/Users/rustam/Documents/programming/Warehouse-Order-Distribution-System/src/main/resources/data/order_items.csv'
WITH (FORMAT csv, HEADER true, DELIMITER ',');

SELECT setval(pg_get_serial_sequence('stores', 'id'),       COALESCE((SELECT MAX(id) FROM stores), 1));
SELECT setval(pg_get_serial_sequence('categories', 'id'),  COALESCE((SELECT MAX(id) FROM categories), 1));
SELECT setval(pg_get_serial_sequence('products', 'id'),    COALESCE((SELECT MAX(id) FROM products), 1));
SELECT setval(pg_get_serial_sequence('orders', 'id'),      COALESCE((SELECT MAX(id) FROM orders), 1));
SELECT setval(pg_get_serial_sequence('order_items', 'id'), COALESCE((SELECT MAX(id) FROM order_items), 1));
