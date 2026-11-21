--liquibase formatted sql
--changeset nikhil:002

ALTER SEQUENCE schedule_id_seq INCREMENT BY 10;

--rollback ALTER SEQUENCE schedule_id_seq INCREMENT BY 50;