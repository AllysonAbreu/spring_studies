-- 1. Criação da tabela de Conferências
CREATE TABLE IF NOT EXISTS tbl_conference (
                                              id_conference INT NOT NULL AUTO_INCREMENT,
                                              name VARCHAR(100) NOT NULL,
    address VARCHAR(255),

    PRIMARY KEY (id_conference)
    );

-- 2. Criação da tabela de Usuários
CREATE TABLE IF NOT EXISTS tbl_user (
                                        user_id INT NOT NULL AUTO_INCREMENT,
                                        user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,

    PRIMARY KEY (user_id)
    );

-- 3. Criação da tabela de Sessões (Depende de tbl_conference)
CREATE TABLE IF NOT EXISTS tbl_session (
                                           session_id INT NOT NULL AUTO_INCREMENT,
                                           title VARCHAR(255) NOT NULL,
    start_date DATE,
    start_time TIME,
    tbl_conference_id_conference INT NOT NULL,

    PRIMARY KEY (session_id),
    CONSTRAINT fk_session_conference
    FOREIGN KEY (tbl_conference_id_conference)
    REFERENCES tbl_conference (id_conference)
    ON DELETE CASCADE
    );

-- 4. Criação da tabela de Inscrições (Tabela associativa entre User e Session)
CREATE TABLE IF NOT EXISTS tbl_subscription (
                                                subscribed_user_id INT NOT NULL,
                                                session_id INT NOT NULL, -- Na imagem, event_id referencia session_id
                                                created_at timestamp NULL DEFAULT NULL,
                                                level int DEFAULT NULL,
                                                unique_id varchar(45) NOT NULL,

    PRIMARY KEY (subscribed_user_id, session_id),
    CONSTRAINT fk_subscription_user
    FOREIGN KEY (subscribed_user_id)
    REFERENCES tbl_user (user_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_subscription_session
    FOREIGN KEY (session_id)
    REFERENCES tbl_session (session_id)
    ON DELETE CASCADE,
    CONSTRAINT uk_subscription_unique_id UNIQUE (unique_id)
    );