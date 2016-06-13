-- CREATE TABLE STEPLIST
CREATE TABLE STEPLIST_TB
(
syain_no integer,
tempo_no integer,
name varchar(20),
entrace_day date,
salary integer,
tel_num varchar(13),
PRIMARY KEY (syain_no)
);

-- INSERT 
INSERT INTO DEV.STEPLIST_TB values(1,1,'kimura takuya','2011-01-01','100000','080-3477-2013');
INSERT INTO DEV.STEPLIST_TB values(2,1,'kimura ichiro','2010-01-01',80000,'090-3477-2013');
INSERT INTO DEV.STEPLIST_TB values(3,2,'tanaka hanako','2010-03-01',300000,'090-2477-2000');
INSERT INTO DEV.STEPLIST_TB values(4,2,'yamasita tarou','2010-03-01',170000,'090-2477-2013');
INSERT INTO DEV.STEPLIST_TB values(5,2,'ayase ichio','2010-03-01',170000,'090-2477-2013');
INSERT INTO DEV.STEPLIST_TB values(6,4,'ayase haruka','2005-12-01',260000,'090-2477-2013');
INSERT INTO DEV.STEPLIST_TB values(7,4,'yang insik','2005-02-01',300000,'090-2477-2013');

-- TEST
SELECT * FROM STEPLIST_TB;

-- Mondai2
-- UPDATE	              表の既存の値を変更。
-- DELETE	              表から行を削除。
-- GROUP BY             データを取得し表示させた場合
-- HAVING              
-- GROUP B句で作成されたグループ表に対して検索条件を与えて行を絞り込むことである。
-- 関数 : MAX()、MIN()、SUBSTRING()

-- 門１．[店舗番号]「入社月」をグルップとして以下を出力せよ。(SUBSTING関数利用)
SELECT TEMPO_NO AS 店舗番呉, SUBSTR(ENTRACE_DAY,4,2)
FROM STEPLIST_TB
ORDER BY TEMPO_NO ASC;

-- 門２．店舗番号が「２」の給料を10%上げる（Update）
SELECT *
FROM STEPLIST_TB
WHERE TEMPO_NO = 2;

UPDATE STEPLIST_TB
SET SALARY = SALARY + SALARY * 0.10
WHERE TEMPO_NO = 2;

-- 門３．ボーナスは　給料の１２５％である。
-- adressが`亀有`の給料（salary）にボーナスをあげる。
-- 以下のように 給料、ボーナス、総計を表示。
-- ※where tempo_no＝２　←×（ではない）
SELECT a.salary, (a.salary * 1.25) as bonus, (a.salary + a.salary*1.25)as hap
FROM STEPLIST_TB a, TENPOLIST_TB b
WHERE a.TEMPO_NO = b.TEMPO_NO;
--AND b.address = '亀有';