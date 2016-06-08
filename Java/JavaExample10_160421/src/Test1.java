public class Test1 {
 
        public static void  main(String[] args) {
 
               // Chairman job = new Manager();
               // 추상 클래스는 생성자를 직접 사용 불가(X)
/*             Chairmanjob = new Employee();
               job.doWork();*/
               Director job2 = new Employee();
               job2.doWorkFromDirector();
              
               Manager job3 = new Employee();
               // job3.doWorkFromManager();
              
               job3 = new Employee2();
               job3.doWorkFromManager();
        }
 
}
 