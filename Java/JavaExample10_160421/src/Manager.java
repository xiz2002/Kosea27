/*
 * 추상 클래스 = 인터페이스와 일반 클래스의 중간 역할
 * : 업무 부하 조절
 */
// public abstract class Manager
//                     implementsDirector, CEO {
// 다중 구현(multiple implementation(realization))
// public abstract class Manager implements Director {      
// public abstract class Manager, CoCEO
//                     implements Director { // (X)
// (일반/추상)클래스 다중 상속 불가 !
public abstract class Manager
                       implements Director, CIO { // 다중 구현
       
        public Manager(){
               System.out.println("과장 생성자 !");
        }
       
        abstract void doWorkFromManager();
       
        @Override
        public void doWorkFromDirector() {
 
               System.out.println("과장doWorkFromDirector !");
        }
 
        @Override
        public void doWork() {
 
               System.out.println("Manager doWork !");
        }
       
 
}