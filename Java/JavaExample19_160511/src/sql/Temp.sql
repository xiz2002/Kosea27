create table member (
	id varchar2(20) not null primary key,
	pw varchar2(20) not null,
	name varchar2(50) not null,
	address varchar2(300),
	phone char(13)
	);
	 --char : 고정 문자열
	
	insert into MEMBER values('hoo u yu', '1234','TEST!','서울','02-123-4567');
	
	insert into Member (id, pw, name) values ('nattsu','1234','TEST@')
	
	insert into Member (name, pw, id) values ('TEST#','1234','haru')
	
	insert into Member (id, pw, name, address) values ('aKi','1111','TEST%','Seoul')
	
	update member set 
			name='GG', 
			pw='AAC', 
			address='LL', 
			phone='000-000-0000'
		where id = 'haru';
	-- StringBuffer로 갈경우 구문 끝에 ;이 빠져야한다.
	
select * from member;