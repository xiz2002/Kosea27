package WordSearch;

public class Accident {
    
    private String year;
    private int accidentNum;
    private int srchIdx;
 
    @Override
    public String toString() {
        return String.format("%s년 교통사고 발생 건수 : %d건", year, accidentNum);
    }
 
    public String getYear() {
        return year;
    }
 
    public void setYear(String year) {
        this.year = year;
    }
 
    public int getAccidentNum() {
        return accidentNum;
    }
 
    public void setAccidentNum(int accidentNum) {
        this.accidentNum = accidentNum;
    }
 
    public int getSrchIdx() {
        return srchIdx;
    }
 
    public void setSrchIdx(int srchIdx) {
        this.srchIdx = srchIdx;
    }
}
