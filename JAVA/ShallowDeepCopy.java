public class ShallowDeepCopy {
 public static void main(String[] args) {
student1 s1= new student1();
 s1.marks[0]=100;
 s1.marks[1]=90;
 s1.marks[2]=97;
 s1.name ="Anay";
 student1 s2= new student1(s1);//coping
 s1.marks[0]=99;//changing 
 System.out.println(s2.marks[0]);
 /*changing the marks of the student1 1 this will effect the marks[0] of student1 2 .
 since array is a refference type data structure....
 i.e shallow copy which effects the data of another object(copied).
 but in Deep constructor the elements are copied in a new array.
*/

} 
}
class student1
{
   int marks[]=new int[3];
   String name;
   student1(){}
    /* shallow copy constructor
    
    student1(student1 s)
   {
    this.marks=s.marks;
    }
    */
    student1(student1 s)//shallow copy constructor
   { for(int i=0;i<3;i++)
    this.marks[i]=s.marks[i];
    }
}