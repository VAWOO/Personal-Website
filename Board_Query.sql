use board;

CREATE TABLE board
(
	idx INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    view_cnt INT NOT NULL DEFAULT 0,
    notice_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    secret_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    insert_time DATETIME NOT NULL DEFAULT NOW(),
    update_time DATETIME NULL,
    delete_time DATETIME NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE comment
(
	idx INT NOT NULL AUTO_INCREMENT,
    board_idx INT NOT NULL,
    content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    insert_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT NULL,
    delete_time DATETIME DEFAULT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE member
(
	idx INT NOT NULL AUTO_INCREMENT,
	member_id VARCHAR(50),
	member_pw VARCHAR(100) NOT NULL,
	member_name VARCHAR(30) NOT NULL,
    member_gender ENUM('M', 'F') NOT NULL,
	member_mail VARCHAR(100) NOT NULL,
    member_birthday DATE NOT NULL,
    admin_ck INT NOT NULL DEFAULT 0,
    delete_yn ENUM('Y', 'N') NOT NULL DEFAULT 'N',
    insert_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT NULL,
    delete_time DATETIME DEFAULT NULL,
    PRIMARY KEY (idx)
);

CREATE TABLE contact
(
	idx INT NOT NULL AUTO_INCREMENT,
	contact_name VARCHAR(30) NOT NULL,
	contact_mail VARCHAR(100) NOT NULL,
    contact_phone VARCHAR(30) NOT NULL,
    contact_message VARCHAR(1500) NOT NULL,
    insert_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (idx)
);

alter table comment add constraint fk_comment_board_idx foreign key (board_idx) references board(idx);

SELECT *
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'board';

INSERT INTO board(title, content, writer)
SELECT title, content, writer FROM board WHERE delete_yn = 'N';

select * from board;
select * from comment;
select * from member;
select * from contact;