CREATE TABLE subject
(
    id   bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name varchar(256) NOT NULL
);

CREATE TABLE team
(
    id   bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name varchar(256) NOT NULL
);
CREATE TABLE users
(
    login    varchar(256) PRIMARY KEY UNIQUE,
    name     varchar(256) NOT NULL,
    team_id  bigint,
    mail     varchar(256) NOT NULL,
    password varchar(80)  NOT NULL,
    role     varchar(16)  NOT NULL
);

CREATE TABLE fly
(
    id                bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    name              varchar(256) NOT NULL,
    subject_id        bigint       NOT NULL,
    questions_per_try bigint       NOT NULL,
    time              bigint       NOT NULL,
    start_date        timestamp    NOT NULL,
    end_date          timestamp    NOT NULL
);

CREATE TABLE question
(
    id        bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    content   varchar(2048) NOT NULL,
    fly_id    bigint        NOT NULL,
    answer_id bigint
);

CREATE TABLE answer
(
    id          bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    content     varchar(2048) NOT NULL,
    question_id bigint        NOT NULL
);

CREATE TABLE fly_result
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY UNIQUE,
    student_id varchar(256)  NOT NULL,
    fly_id     bigint        NOT NULL,
    score      decimal(4, 1) NOT NULL,
    time       bigint        NOT NULL,
    lost_focus boolean NOT NULL
);

ALTER TABLE fly
    ADD CONSTRAINT fk_subject_id FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE;
ALTER TABLE users
    ADD CONSTRAINT fk_team_id FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE CASCADE;
ALTER TABLE question
    ADD CONSTRAINT fk_answer_id FOREIGN KEY (answer_id) REFERENCES answer (id) ON DELETE CASCADE;
ALTER TABLE question
    ADD CONSTRAINT fk_fly_id FOREIGN KEY (fly_id) REFERENCES fly (id) ON DELETE CASCADE;
ALTER TABLE answer
    ADD CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question (id) ON DELETE CASCADE;
ALTER TABLE fly_result
    ADD CONSTRAINT fk_fly_id FOREIGN KEY (fly_id) REFERENCES fly (id) ON DELETE CASCADE;
ALTER TABLE fly_result
    ADD CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES users (login) ON DELETE CASCADE;

