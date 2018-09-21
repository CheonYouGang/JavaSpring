create table tbl_reply(
	rno int not null AUTO_INCREMENT,
	bno int not null default 0,
	replytext VARCHAR(1000),
	reply VARCHAR(100) not null,
	regdate TIMESTAMP not null DEFAULT now(),
	updatedate TIMESTAMP,
	PRIMARY KEY (rno)
)DEFAULT CHARACTER SET utf8;

alter table tbl_reply add CONSTRAINT fk_board
FOREIGN KEY (bno) REFERENCES tbl_board(bno);