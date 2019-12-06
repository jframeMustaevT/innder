-- Users table.

CREATE TABLE users
(
    id              BIGSERIAL,
    email           TEXT NOT NULL,
    password_hash   TEXT NOT NULL,
    first_name      TEXT NOT NULL,
    last_name       TEXT NOT NULL,
    phone           INT NOT NULL,
    telegram_name   TEXT NOT NULL,
    status anyenum  NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uq_users_email UNIQUE (email)
)WITH (oids = false) ;
