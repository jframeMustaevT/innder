-- Stories table.

CREATE TABLE route
(
    id          BIGSERIAL,
    start       text NOT NULL,
    finish      text NULL default Null,
    CONSTRAINT  route PRIMARY KEY (id)
);
