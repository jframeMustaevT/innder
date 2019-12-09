CREATE TABLE "user" (
                        "id" serial NOT NULL UNIQUE,
                        "email" TEXT NOT NULL UNIQUE,
                        "password" TEXT NOT NULL,
                        "phone" integer  NOT NULL,
                        "telegram_name" TEXT NOT NULL,
                        "status" TEXT NOT NULL,
                        "firs_name" TEXT NOT NULL,
                        "last_name" TEXT,
                        CONSTRAINT "user_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "user_score" (
                              "id" serial NOT NULL,
                              "user_id" bigint NOT NULL,
                              "score" int,
                              "count" int DEFAULT '1',
                              CONSTRAINT "user_score_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "user_ban" (
                            "id" serial NOT NULL,
                            "banner_id" bigint NOT NULL,
                            "banned_id" bigint NOT NULL,
                            CONSTRAINT "user_ban_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "trip" (
                        "id" serial NOT NULL,
                        "owner_id" bigint NOT NULL,
                        "start_data_time" TIMESTAMP,
                        "finish_data_time" TIMESTAMP,
                        "status" bigint NOT NULL,
                        "type" bigint,
                        "description" TEXT,
                        "cost" TEXT,
                        "vehicle" TEXT,
                        "rout" bigserial,
                        CONSTRAINT "trip_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "trip_status" (
                               "id" serial NOT NULL,
                               "trip_status_1" TEXT,
                               "trip_status_2" TEXT,
                               "trip_status_3" TEXT,
                               CONSTRAINT "trip_status_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "trip_type" (
                             "id" serial NOT NULL,
                             "trip_type" TEXT,
                             "trip_type_2" TEXT,
                             "trip_type_3" TEXT,
                             "trip_type_4" TEXT,
                             CONSTRAINT "trip_type_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "score" (
                         "id" serial NOT NULL,
                         "from_user_id" serial NOT NULL,
                         "to_user_id" serial NOT NULL,
                         CONSTRAINT "score_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "rout" (
                        "id" serial NOT NULL,
                        "start_longitude" bigint NOT NULL,
                        "start_latude" bigint NOT NULL,
                        "end_longitude" bigint,
                        "end_latude" bigint,
                        CONSTRAINT "rout_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "companion" (
                             "id" serial NOT NULL,
                             "trip_id" serial NOT NULL,
                             "user_id" serial NOT NULL,
                             CONSTRAINT "companion_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );




ALTER TABLE "user_score" ADD CONSTRAINT "user_score_fk0" FOREIGN KEY ("user_id") REFERENCES "user"("id");
ALTER TABLE "user_score" ADD CONSTRAINT "user_score_fk1" FOREIGN KEY ("score") REFERENCES "score"("id");

ALTER TABLE "user_ban" ADD CONSTRAINT "user_ban_fk0" FOREIGN KEY ("banner_id") REFERENCES "user"("id");
ALTER TABLE "user_ban" ADD CONSTRAINT "user_ban_fk1" FOREIGN KEY ("banned_id") REFERENCES "user"("id");

ALTER TABLE "trip" ADD CONSTRAINT "trip_fk0" FOREIGN KEY ("owner_id") REFERENCES "user"("id");
ALTER TABLE "trip" ADD CONSTRAINT "trip_fk1" FOREIGN KEY ("status") REFERENCES "trip_status"("id");
ALTER TABLE "trip" ADD CONSTRAINT "trip_fk2" FOREIGN KEY ("type") REFERENCES "trip_type"("id");
ALTER TABLE "trip" ADD CONSTRAINT "trip_fk3" FOREIGN KEY ("rout") REFERENCES "rout"("id");



ALTER TABLE "score" ADD CONSTRAINT "score_fk0" FOREIGN KEY ("from_user_id") REFERENCES "user"("id");
ALTER TABLE "score" ADD CONSTRAINT "score_fk1" FOREIGN KEY ("to_user_id") REFERENCES "user"("id");


ALTER TABLE "companion" ADD CONSTRAINT "companion_fk0" FOREIGN KEY ("trip_id") REFERENCES "trip"("id");
ALTER TABLE "companion" ADD CONSTRAINT "companion_fk1" FOREIGN KEY ("user_id") REFERENCES "user"("id");

