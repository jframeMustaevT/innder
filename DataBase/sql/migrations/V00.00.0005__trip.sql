-- Posts table.

CREATE TABLE trip
(
    id              BIGSERIAL,
    owner_id        BIGSERIAL constraint user_id,
    start_data_time timestamp NOT NULL,
    finsh_data_time timestamp NOT NULL,
    Status          anyenum NOT NULL ,
    type            anyenum NOT NULL,
    description     text NULL DEFAULT NULL,
    cost            INT NULL DEFAULT NULL,
    vehicle         anyenum NULL DEFAULT NULL,
    route_id        INTEGER constraint route (id),

    CONSTRAINT pk_users_links PRIMARY KEY (owner_id, route_id)
);
