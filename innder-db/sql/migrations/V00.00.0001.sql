CREATE TABLE "users" (
                        id                      int8                NOT NULL UNIQUE,
                        email                   TEXT                NOT NULL, --UNIQUE,
                        username                TEXT                NOT NULL UNIQUE,
                        password                TEXT                NOT NULL,
                        phone                   TEXT                NOT NULL,
                        telegram_name           TEXT                NOT NULL,
                        telegram_chat_id        TEXT                NOT NULL,
                        status                  TEXT                NOT NULL,
                        first_name              TEXT                NOT NULL,
                        last_name               TEXT,
                        enabled                 BOOLEAN             NOT NULL DEFAULT TRUE, -- включен ли аккаунт
                        account_non_expired     BOOLEAN             NOT NULL DEFAULT TRUE, -- время действия аккаунта не истекло
                        account_non_locked      BOOLEAN             NOT NULL DEFAULT TRUE, -- аккаунт не заблокирован
                        credentials_non_expired BOOLEAN             NOT NULL DEFAULT TRUE,  -- не истекло ли время действия пароля
                        CONSTRAINT user_pk PRIMARY KEY (id)
) WITH (
      OIDS=FALSE
    );

CREATE SEQUENCE "user_id_seq" START 1;

CREATE TABLE  "authority" (
                        id        int8,
                        user_id   int8  NOT NULL,
                        authority TEXT  NOT NULL,
                        CONSTRAINT authority_pk    PRIMARY KEY (id)
) WITH (
      OIDS=FALSE
    );

CREATE SEQUENCE "authority_id_seq" START 1;
ALTER TABLE "authority" ADD CONSTRAINT authority_fk_user FOREIGN KEY (user_id) REFERENCES "users"(id);

CREATE TABLE "trip" (
                        id                    int8 NOT NULL,
                        owner_id              int8 NOT NULL,
                        start_data_time       int8,
                        finish_data_time      int8,
                        status                TEXT NOT NULL,
                        type                  TEXT NOT NULL,
                        description           TEXT,
                        cost                  TEXT,
                        route_id              int8,
                        max_companions        int,
                        CONSTRAINT trip_pk    PRIMARY KEY (id)
) WITH (
      OIDS=FALSE
    );

CREATE SEQUENCE "trip_id_seq" START 1;
ALTER TABLE "trip" ADD CONSTRAINT trip_fk_owner FOREIGN KEY (owner_id) REFERENCES "users"(id);

CREATE TABLE "route" (
                        id                  int8 NOT NULL,
                        start_city          TEXT NOT NULL,
                        start_street        TEXT NULL,
                        start_street_number TEXT NULL,
                        end_city            TEXT NOT NULL,
                        end_street          TEXT NULL,
                        end_street_number   TEXT NULL,
                        CONSTRAINT rout_pk PRIMARY KEY (id)
) WITH (
      OIDS=FALSE
    );
CREATE SEQUENCE "route_id_seq" START 1;
ALTER TABLE "trip" ADD CONSTRAINT trip_fk_route FOREIGN KEY (route_id) REFERENCES "route"(id);


CREATE TABLE "companion" (
                             id              int8 NOT NULL,
                             trip_id         int8 NOT NULL,
                             user_id         int8 NOT NULL,
                             CONSTRAINT companion_pk PRIMARY KEY (id)
) WITH (
      OIDS=FALSE
    );

CREATE SEQUENCE "companion_id_seq" START 1;
ALTER TABLE "companion" ADD CONSTRAINT companion_fk_trip FOREIGN KEY (trip_id) REFERENCES "trip"(id);
ALTER TABLE "companion" ADD CONSTRAINT companion_fk_user FOREIGN KEY (user_id) REFERENCES "users"(id);


--
--
-- CREATE TABLE "user_score" (
--                               id          int8 NOT NULL,
--                               user_id     int8 NOT NULL,
--                               score       int,
--                               count       int DEFAULT '1',
--                               CONSTRAINT user_score_pk PRIMARY KEY (id)
-- ) WITH (
--       OIDS=FALSE
--     );
--
--
--
-- CREATE TABLE "user_ban" (
--                             id        int8 NOT NULL,
--                             banner_id int8 NOT NULL,
--                             banned_id int8 NOT NULL,
--                             CONSTRAINT user_ban_pk PRIMARY KEY (id)
-- ) WITH (
--       OIDS=FALSE
--     );

--
-- CREATE TABLE "score" (
--                          id int8 NOT NULL,
--                          from_user_id int8 NOT NULL,
--                          to_user_id int8 NOT NULL,
--                          CONSTRAINT score_pk PRIMARY KEY (id)
-- ) WITH (
--       OIDS=FALSE
--     );
--
-- ALTER TABLE user_score ADD CONSTRAINT user_score_fk0 FOREIGN KEY (user_id) REFERENCES "user"(id);
-- ALTER TABLE user_score ADD CONSTRAINT user_score_fk1 FOREIGN KEY (score) REFERENCES score(id);
--
-- ALTER TABLE user_ban ADD CONSTRAINT user_ban_fk0 FOREIGN KEY (banner_id) REFERENCES "user"(id);
-- ALTER TABLE user_ban ADD CONSTRAINT user_ban_fk1 FOREIGN KEY (banned_id) REFERENCES "user"(id);
--
-- ALTER TABLE score ADD CONSTRAINT score_fk0 FOREIGN KEY (from_user_id) REFERENCES "user"(id);
-- ALTER TABLE score ADD CONSTRAINT score_fk1 FOREIGN KEY (to_user_id) REFERENCES "user"(id);
--
--


