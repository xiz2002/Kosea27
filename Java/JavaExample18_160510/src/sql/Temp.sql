create table TEMP (
	id varchar2(20) not null primary key,
	name varchar2(50) not null
);

insert into TEMP values ('java', 'name');
insert into TEMP values ('spring', 'name2');
insert into Temp values ('summer', 'name3');

delete from TEMP; -- 해당테이블의 데이터를 삭제, 공간은 반납 안됨. (truncate와 유사.)