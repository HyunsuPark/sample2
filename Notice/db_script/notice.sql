-- �Խñ� ���񽺿� ���̺�    
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
values (1, 'admin', sysdate, '�ݰ����ϴ�. �������Դϴ�.', 
       '�Խñ� ���񽺿� ���� ���� �÷��ּ���...'); 
       
commit;

select * from notice;       
