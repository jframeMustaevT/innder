-- Test data.

INSERT INTO user (email, password, phone, telegram_name, status, firs_name, last_name, enabled, account_non_expired, account_non_locked, credentials_non_expired)
VALUES ('user1@mail.ru', 'password_hash_1', 89033140100,'@pumbatum','on', 'pumba','tumbauma',true,true,true,true),
 ('userq@mail.ru', 'password_hash_q', 89033140101,'@pumbatum','on', 'pumbaone','tumbaturumba',true,true,true,true),
 ('user2@mail.ru', 'password_hash_2', 89033140102,'@pumbatum','on', 'pumbatwo','tumbastul',true,true,true,true),
 ('push@mail.ru', 'password_hash_1', 89033140100,'@push','on', 'push','pushpush',true,true,true,true),
 ('user3@mail.ru', 'password_hash_3', 89033140103,'@pumbatum','on', 'pumbatree','tumbamuba',true,true,true,true),
 ('user4@mail.ru', 'password_hash_4', 89033140104,'@pumbatum','on', 'pumbafoo','tumbahu',true,true,true,true),
 ('user5@mail.ru', 'password_hash_5', 89033140105,'@pumbatum','on', 'pumbafive',null,true,true,true,true),
 ('user6@mail.ru', 'password_hash_6', 89033140106,'@pumbatum','on', 'pumbasex','tumbanotnul',true,true,true,true),
 ('user7@mail.ru', 'password_hash_7', 89033140107,'@pumbatum','on', 'pumbaseven','tumbanol',true,true,true,true),
 ('exception@mail.ru', 'password_hash_8', 89033140108,'@pumbatum','ban', 'pumba1111','tumbanull',true,true,true,true);

INSERT INTO user_score ( user_id, score, count)
VALUES (1, 2,4),
       (2, 3,3),
       (3, 4,3),
       (4, 5,3),
       (5, 1,2),
       (6, 3,3),
       (7, 4,5),
       (8, 5,4),
       (9, 3,4),
       (10, 4,5);

INSERT INTO  trip (owner_id, start_data_time, finish_data_time, status, type, description, cost, vehicle, rout)
VALUES (1,current_timestamp, current_timestamp, true,1, 'description',1000,'bus',1),
 (1,current_timestamp, current_timestamp, true,1, 'description',2000,'bus',1),
 (2,current_timestamp, current_timestamp, true,1, 'description',3000,'bus',1),
 (3,current_timestamp, current_timestamp, true,1, 'description',3000,'bus',1),
 (4,current_timestamp, current_timestamp, true,1, 'description',4000,'bus',1),
 (5,current_timestamp, current_timestamp, true,1, 'description',5000,'bus',1),
 (6,current_timestamp, current_timestamp, true,1, 'description',6000,'bus',1),
 (7,current_timestamp, current_timestamp, true,1, 'NULL_o_O',7000,'bus',1);

INSERT INTO rout (id, start_city, start_street,start_build,end_city, end_street,end_build)
 VALUES (1,'казань',null,null,'иннополис');
 VALUES (2,'иннополис',null,null,'казань');
 VALUES (3,'москва',null,null,'иннополис');
 VALUES (4,'казань',null,null,'москва');
 VALUES (5,'казань','чистопольская',null,'иннополис');
 VALUES (6,'казань','чистопольская','спортиваная','иннополис');
 VALUES (7,'казань',null,null,'иннополис');
 VALUES (8,'казань',null,'спортивная','иннополис');


