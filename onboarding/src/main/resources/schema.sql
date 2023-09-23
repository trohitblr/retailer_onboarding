CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS  fos (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    fos_id VARCHAR PRIMARY KEY,
    name VARCHAR,
    password VARCHAR,
    created_at TIMESTAMP(6) WITH TIME ZONE,
    updated_at TIMESTAMP(6) WITH TIME ZONE
);


CREATE TABLE  IF NOT EXISTS  retailer (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    retailer_id VARCHAR PRIMARY KEY,
    owner_name VARCHAR,
    store_name VARCHAR,
    retailer_mob INTEGER,
    mob_verified BOOLEAN,
    retiler_verified BOOLEAN,
    is_parent BOOLEAN,
    parent VARCHAR,
    fos_id VARCHAR,
    created_at TIMESTAMP(6) WITH TIME ZONE,
    updated_at TIMESTAMP(6) WITH TIME ZONE
    -- FOREIGN KEY (fos_id) REFERENCES fos(id)
);

CREATE TABLE  IF NOT EXISTS retailer_address (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    retailer_id VARCHAR PRIMARY KEY,
    street VARCHAR,
    road VARCHAR,
    area VARCHAR,
    locality VARCHAR,
    pincode VARCHAR,
    state VARCHAR
   -- FOREIGN KEY (retailer_id) REFERENCES retailer(id) ON DELETE CASCADE
);

CREATE TABLE  IF NOT EXISTS retailer_meta (
    id UUID DEFAULT uuid_generate_v4() NOT NULL,
    retailer_id VARCHAR PRIMARY KEY,
    gst_number VARCHAR,
    store_category INTEGER,
    store_sub_Category INTEGER,
    lat FLOAT,
    long FLOAT,
    store_start_date TIMESTAMP(6) WITH TIME ZONE,
    store_opening_start_hours TIMESTAMP(6) WITH TIME ZONE,
    store_opening_closing_hours TIMESTAMP(6) WITH TIME ZONE,
    store_description VARCHAR
   -- FOREIGN KEY (retailer_id) REFERENCES retailer(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS retailer_media (
    id SERIAL PRIMARY KEY,
    retailer_id INTEGER,
    retailer_media_id INTEGER,
    retaler_image_url VARCHAR,
    retaler_vdo_url INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
   -- FOREIGN KEY (retailer_id) REFERENCES retailer(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS category (
    id SERIAL PRIMARY KEY,
    category_id INTEGER,
    name VARCHAR,
    description INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS sub_category (
    id SERIAL PRIMARY KEY,
    category_id INTEGER,
    sub_category_id VARCHAR,
    description INTEGER,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
 --   FOREIGN KEY (category_id) REFERENCES category(category_id)
);

