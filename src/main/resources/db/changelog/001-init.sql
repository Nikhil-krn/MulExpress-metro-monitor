--liquibase formatted sql
--changeset nikhil:001

CREATE SEQUENCE schedule_id_seq START WITH 501 INCREMENT BY 10;

CREATE TABLE mxpress_trains(
    train_id    integer PRIMARY KEY,
    train_name  text NOT NULL,
    origin      text,
    destination text,
    inventory   text,
    timing      time
);

CREATE TABLE mxpress_schedules(
    schedule_id    integer PRIMARY KEY,
    train_id       integer NOT NULL
                   REFERENCES mxpress_trains(train_id) ON DELETE CASCADE,
    board_point    text,
    off_point      text,
    departure_time timestamp,
    arrival_time   timestamp,
    fare_level     text,
    is_happening   boolean NOT NULL DEFAULT false
);

CREATE INDEX idx_schedules_train_id ON mxpress_schedules(train_id);
--rollback DROP TABLE mxpress_schedules; DROP TABLE mxpress_trains; DROP SEQUENCE schedule_id_seq;