CREATE TABLE stores (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255)
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INTEGER NOT NULL REFERENCES categories(id),
    weight DECIMAL NOT NULL,
    volume DECIMAL NOT NULL
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    store_id INTEGER NOT NULL REFERENCES stores(id),
    order_date TIMESTAMP NOT NULL
);

CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL REFERENCES orders(id),
    product_id INTEGER NOT NULL REFERENCES products(id),
    quantity INTEGER NOT NULL
);

CREATE TABLE trucks (
    id SERIAL PRIMARY KEY,
    max_weight DECIMAL NOT NULL,
    max_volume DECIMAL NOT NULL,
    route VARCHAR(255)
);

CREATE TABLE truck_cargos (
    id SERIAL PRIMARY KEY,
    truck_id INTEGER NOT NULL REFERENCES trucks(id),
    order_item_id INTEGER NOT NULL REFERENCES order_items(id),
    loaded_weight DECIMAL NOT NULL,
    loaded_volume DECIMAL NOT NULL
);

