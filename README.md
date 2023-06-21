# s22 Kotlin 課題

必ずこのリポジトリをフォークしてから取り掛かってください。

## 事前準備
1. Docker のコンテナで使うボリュームを事前に作成してください。
   1. mb_pg_data
   2. mb_redis_data
2. docker-compose.yml を使用して起動する前に、
BookManager で使用したコンテナ一式は停止させてください。
3. データベースの情報は以下の通りで作成してください

   データベース名
   :  message_board

   接続ユーザ名
   :  kotlin

   ユーザパスワード
   :  spring

4. テーブルの作成は以下のSQL文を参照してください。
   ```postgresql
   CREATE TABLE users (
       id SERIAL PRIMARY KEY ,
       username VARCHAR(64) NOT NULL UNIQUE ,
       password VARCHAR(128) NOT NULL
   );
   
   CREATE TABLE threads (
       id BIGSERIAL PRIMARY KEY ,
       user_id BIGINT NOT NULL ,
       title VARCHAR(256) NOT NULL ,
       created_at TIMESTAMP NOT NULL,
       updated_at TIMESTAMP
   );
   
   CREATE TABLE messages (
       id BIGSERIAL PRIMARY KEY ,
       thread_id BIGINT NOT NULL ,
       user_id BIGINT NOT NULL ,
       message TEXT ,
       created_at TIMESTAMP NOT NULL,
       updated_at TIMESTAMP
   )
   ```