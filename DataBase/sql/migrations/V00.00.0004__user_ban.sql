-- Posts table.

CREATE TABLE user_ban
(
    id                      BIGSERIAL,
    banner_user_id          BIGINT    NOT NULL,
    banned_user_id          BIGINT    NOT NULL,
    CONSTRAINT pk_user_ban PRIMARY KEY (banner_user_id,banned_user_id)
    --CONSTRAINT ?? FOREIGN KEY (user_id) REFERENCES users (id),

);
