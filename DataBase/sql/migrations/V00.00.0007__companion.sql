-- Stories table.

CREATE TABLE companion
(
    id      BIGSERIAL,
    user_id BIGSERIAL NOT NULL,
    trip_id BIGSERIAL NULL default Null,
    CONSTRAINT companion_pk PRIMARY KEY (user_id, trip_id)
);
