package WordSearch;

public class WordSearch {
    
    /*
     * 문) 아래와 같은 비정형 데이터에서 특정년도에 발생한 사건에서 
     *      각각 해당년도와 건수를 주어진 Accident 클래스로 추출하여
     *     화면에 아래와 같이 인쇄할 수 있도록 프로그래밍 코드를 완성하십시오.
     *     
     *     2009년 교통사고 발생 건수 : 437건
     *     2014년 교통사고 발생 건수 : 1,111건
     */
 
    public static void main(String[] args) {
 
        String str = "서울시는 연말까지 시범사업을 하며 보행행태 변화와 보행자 사고 건수, "
                   + "시민반응 등을 살핀다. 시는 그 결과에 따라 정식 교통안전시설물로 지정하는 "
                   + "방안을 경찰청과 검토할 계획이다."
                   + "이번 시범사업은 스마트폰으로 인한 보행자 교통사고가 급증한 데 따른 것이다. "
                   + "교통안전공단 조사에 따르면 2009년 437건에서 2014년 1111건으로 5년 만에 2.5배로 뛰었다."
                   + "서울시는 24일 연세로 유플렉스 앞 광장에서 보행 중 스마트폰 사용 자제를 유도하는 "
                   + "거리 캠페인을 한다.";
        
        Accident acc1 = getAccident(str, 0);
        System.out.println(acc1);
        
        Accident acc2 = getAccident(str, acc1.getSrchIdx());
        System.out.println(acc2);
        
    } // main
    
    private static Accident getAccident(String str, int srchIdx) {
        // 시작
    	Accident accident = new Accident();
        int iYear = str.indexOf("년",srchIdx);
        accident.setYear(str.substring(iYear-4, iYear));
        
        int iCnt = str.indexOf("건",iYear);
        accident.setAccidentNum(Integer.parseInt(str.substring(iYear+1,iCnt).trim()));
        
        accident.setSrchIdx(iCnt);
        
        return accident;
        // 끝
    } // 
 
}