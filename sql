-- TASK 테이블 생성 sql(MySql 기준)

CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    title VARCHAR(255),
    description VARCHAR(255),
    is_urgent TINYINT(1),       -- boolean 필드: MySQL에서는 TINYINT(1)로 매핑
    is_important TINYINT(1),    -- boolean 필드: MySQL에서는 TINYINT(1)로 매핑
    due_date DATETIME,
    completed TINYINT(1),       -- boolean 필드: MySQL에서는 TINYINT(1)로 매핑
    created_at DATETIME,
    updated_at DATETIME
);

