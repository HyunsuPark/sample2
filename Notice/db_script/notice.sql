-- 게시글 서비스용 테이블    
create table notice
(
       noticeno number,
       noticewriter varchar2(20) not null,
       noticedate date not null,
       noticetitle varchar2(50) not null,
       noticecontent varchar2(500),
       constraint pk_noticeno primary key (noticeno)
);   

insert into notice
values (1, 'admin', sysdate, '반갑습니다. 관리자입니다.', 
       '게시글 서비스에 많은 정보 올려주세요...'); 
       
commit;

select * from notice;       
