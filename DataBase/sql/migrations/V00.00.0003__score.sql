-- Posts table.

CREATE TABLE score
(
    id                  BIGSERIAL,
    from_user_id        BIGINT    NOT NULL,
    to_user_id          BIGINT    NOT NULL,
    score               INT      NOT NULL,
    CONSTRAINT pk_messages PRIMARY KEY (from_user_id),
    CONSTRAINT fk_messages_users_sender FOREIGN KEY (from_user_id) REFERENCES users (id),
    CONSTRAINT fk_messages_users_receiver FOREIGN KEY (to_user_id) REFERENCES users (id)
);
