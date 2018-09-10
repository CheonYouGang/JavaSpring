create table tbl_board(
	bno int not null AUTO_INCREMENT,
	title varchar(200) not null,
	content TEXT null,
	writer VARCHAR(50) not null,
	regdate TIMESTAMP not null DEFAULT now(),
	viewcnt int DEFAULT 0,
	PRIMARY KEY (bno)
)DEFAULT CHARACTER SET utf8;

insert into tbl_board(title, content, writer)
VALUES ('안녕하세요', '반갑습니다', '가나다');

select *
FROM tbl_board;