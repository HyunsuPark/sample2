DROP TABLE BOOKS;
CREATE TABLE BOOKS(ISBN VARCHAR2(30) PRIMARY KEY, 
TITLE VARCHAR2(50) NOT NULL, PRICE NUMBER(6), 
REMAINING NUMBER(10), AUTHOR VARCHAR2(30) NOT NULL, 
PUBLISHER VARCHAR2(30), CATEGORY VARCHAR2(40) NOT NULL, 
DESCRIPTION LONG );
insert into books values('ancd423bbcnf', 'Java Servlet Programming 정복', 27000, 1200, '양회석', '한빛 미디어', 'Web Development',
'이책은 짧은 시간에 객체 지향언어인 자바를 사용하여 서버측 프로그램에 익숙해 지도록 효과적인 예제로 상세한 설명으로 이루어 져있다.
기본적인 서블릿 API 부터 이러한 API를 활용하는 기법까지 쉬운 설명으로 명확한 예제를 통해 서블릿에 대한 이해부터 전반적인
자바 서버측 프로그래밍 기법을 다루고 있다.');
insert into books values('ancdwed1009f', 'Perfect Java Server Pages', 30000, 1500, '양회석', '한빛 미디어', 'Web Development',
'이책은 짧은 시간에 객체 지향언어인 자바를 사용하여 서버측 프로그램에 익숙해 지도록 효과적인 예제로 상세한 설명으로 이루어 져있다.
서블릿 API 2.2와 JSP 1.1을 기준으로 하고 있으며, 자바 서버 페이지 기본 문법부터 EJB를 통한 3-tier 이상 분산애플리케이션 아키텍쳐상에서
자바 서버 페이지 응용까지 친절한 설명과 상세한 예제를 통해 초보자라할지라도 무난히 따라할 수 있도록 구성되어있다.');
insert into books values('ancdyhsnp3nf', 'Java Programming 정복', 27000, 1200, '아무개', '한빛 미디어', 'Programming Language',
'이책은 짧은 시간에 객체 지향언어인 자바를 사용하여 자바 프로그래밍과 J2SDK 가 제공하는 API를 활용하여 자바 애플리케이션 개발을 할 수 있도록 
기본 문법부터 확장 API까지 자세한 설명과 삽화 위주의 구성으로 초보자가 기본적인 프로그래밍의 개념을 이해하고 객체지향적인 설계에 대한 
이해를 목적으로 하고 있다.');
insert into books values('abcdef1234cn2', 'Servlet Programming', 27000, 1200, '아무개', '한빛 미디어','Web Development',
'이책은 짧은 시간에 객체 지향언어인 자바를 사용하여 서버측 프로그램에 익숙해 지도록 효과적인 예제로 상세한 설명으로 이루어 져있다.
기본적인 서블릿 API 부터 이러한 API를 활용하는 기법까지 쉬운 설명으로 명확한 예제를 통해 서블릿에 대한 이해부터 전반적인
자바 서버측 프로그래밍 기법을 다루고 있다.');
insert into books values('abcdef1234cn5', 'MicroSoft Office 정복', 25000, 100, '양승진', '한빛 미디어','Computer Software',
'이책은 컴퓨터에 문외한이라할지라도 알기쉬운 삽화와 실행 화면을 통해 따라하기식 교수법으로 마이크로소프트 워드 프로세서
, 엑셀, 파워포인트등 오피스 제품군 전반에 걸쳐 쉬운 내용을 위주로 집안에 앉아서 커피한잔과 함께 따라 해볼만한
무겁지 않은 컴퓨터 서적이다.');

COMMIT;