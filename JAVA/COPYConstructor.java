public class COPYConstructor {
   
   
   public static void main(String[] args) {
    
   
    student s1=new student ();
    s1.name="Anay Saha";
       s1.roll=8;
       student s2=new student(s1);
       System.out.println(s1.name+"   "+ s1.roll);
        System.out.println(s2.name+"   "+ s2.roll);
   }
}
class student{
    int roll;
    String name;
    student(student s1){
        
        this.name= s1.name;
        this.roll=s1.roll;

    }
     student(){
     }
}