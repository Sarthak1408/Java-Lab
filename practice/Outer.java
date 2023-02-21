// public class Outer {
//     int outer_x=100;
//     void test(){
//         Inner inner=new Inner();
//         inner.display();
//     }
//         class Inner{
//             void display(){
//                 System.out.println("outer_x= "+outer_x);
//             }
//         }
// }
class InnerClassDemo
{
    public static void main(String[] args) {
        Outer outer=new Outer();
        outer.test();
    }
}

public class Outer{
    int outer_x=100;
    void test(){
        Inner inner = new Inner();
        inner.display();
        inner.showy();
    }
        class Inner{
            int y=10;
            void display(){
                System.out.println("outeR_x= "+outer_x);
            }
            void showy(){
                System.out.println("inneR_x= "+y);
            }
        }
}
