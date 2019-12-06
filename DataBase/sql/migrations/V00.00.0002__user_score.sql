-- Posts table.

CREATE TABLE user_score
(
    id               BIGSERIAL,
    user_id          BIGINT    NOT NULL,
    score            anyenum       NULL,
    count INT default 1 NOT NULL,
    CONSTRAINT pk_user_score PRIMARY KEY (id),
    CONSTRAINT fk_user_score FOREIGN KEY (user_id) REFERENCES users (id)
);
