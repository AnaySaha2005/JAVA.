public class Inheritance {
    public static void main(String[] args) {
         homosapien ob =new homosapien();
         tuna ob1 =new tuna();
         shark ob2 = new shark();
         peacock ob3 =new peacock();
    }
   
}
class animal{
  animal() {
    System.out.print("I am animal class--> ");
  }
}
class mammal extends animal{
    mammal() {
    System.out.print("I am mammal class--> ");
  }
}
class fish extends animal{
    fish(){
    System.out.print("I am fish class--> ");
  }
}
class bird extends animal{
    bird() {
    System.out.print("I am bird class--> ");
  }
}
class human extends mammal{
    human() {
    System.out.print("I am human class--> ");
  }}
class shark extends fish{
    shark() {
    System.out.println("I am shark class ");
  }}
class tuna extends fish{
    tuna() {
    System.out.println("I am tuna class ");
  }}
class homosapien extends human{
    homosapien()
    {
    System.out.println("I am homosapien class ");
  }}
  class peacock extends bird{
    peacock(){
        System.out.println("I am peacock class ");
    }
  }
