create table board(
  idx numeric	primary key,
  writer varchar(30) not null,  
  pwd	 varchar(20) not null,
  subject varchar(200) not null,
  content varchar(2000),
  writedate	timestamp,
  readnum	 numeric,
  filename	varchar(200),
  filesize	 numeric,
  refer		 numeric,
  lev		 numeric,
  sunbun	 numeric
);

create sequence seq_board_idx
increment by 1
start with 1
nocache;

create table reply(
r_no numeric primary key,
writer varchar(30),
pwd varchar(20),
content varchar(1000),
writedate timestamp,
readnum numeric,
CONSTRAINT reply_idx_fk FOREIGN KEY(r_no) references board(idx)
);

CREATE sequence reply_no 
START WITH 1 
increment by 1
nocache;
