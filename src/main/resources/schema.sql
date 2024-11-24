CREATE EXTENSION "uuid-ossp";

CREATE TABLE IF NOT EXISTS event
(
    id             VARCHAR(50) NOT NULL,
    name           VARCHAR(250),
    description    VARCHAR(500),
    start_date     TIMESTAMP,
    end_date       TIMESTAMP,
    location       VARCHAR(250),
    guest_capacity INTEGER,
    category       VARCHAR(250),
    created_at     TIMESTAMP,
    updated_at     TIMESTAMP,
    CONSTRAINT event_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS data_master
(
    id          VARCHAR(50) NOT NULL,
    master      VARCHAR(100),
    data_master VARCHAR(100),
    code        VARCHAR(50),
    description VARCHAR(250),
    state       VARCHAR(2),
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    CONSTRAINT data_master_pkey PRIMARY KEY (id)
);

COMMENT ON COLUMN data_master.state IS 'A: Activo, I: Inactivo';
