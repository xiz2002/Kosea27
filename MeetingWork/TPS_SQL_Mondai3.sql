 -- 1.[店舗別]給料が一番高い人の「名前」と「給料」を出力せよ
-- SUCCESS
SELECT A.NAME, B.NAME, B.SALARY 
FROM TENPOLIST_TB A, STEPLIST_TB B
WHERE A.TEMPO_NO = B.TEMPO_NO
AND B.SALARY IN (SELECT SALARY 
                 FROM (SELECT TEMPO_NO, MAX(SALARY) AS SALARY 
                       FROM STEPLIST_TB 
                       GROUP BY TEMPO_NO
                       )
                 );

 -- 2.[店舗別]給料が一番高い人の「給料」を「-10%削減」せよ
UPDATE STEPLIST_TB
SET SALARY = SALARY+(SALARY*-0.1)
WHERE SYAIN_NO IN (
                  SELECT SYAIN_NO 
                  FROM STEPLIST_TB
                  WHERE SALARY IN (SELECT SALARY 
                                  FROM (SELECT TEMPO_NO, MAX(SALARY) AS SALARY 
                                       FROM STEPLIST_TB 
                                       GROUP BY TEMPO_NO
                                      )
                                  )
                  );
SELECT * FROM STEPLIST_TB;