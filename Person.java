import java.io.*;
public class Person{

    protected String name;
    protected byte age;
    protected String address;
    Person(){
        name="";
        age=0;
        address="";
    }
    protected void read() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Name of the employee: ");
        this.name=br.readLine();
        System.out.print("Age of the employee: ");
        this.age=Byte.parseByte(br.readLine());
        System.out.print("Address of the employee: ");
        this.address=br.readLine();
    }
    protected void show(){
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Home Address: "+this.address);
    }
}