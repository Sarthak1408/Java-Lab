class PatientInfo{
    int PatientId = 120;
}

class PatientInfo1 extends PatientInfo{
    int PatientId = 180;

}

class PatientInfo2 extends PatientInfo1{
    int PatientId = 280;
    void display(){
        System.out.println("Patient ID" + super.PatientId);
    }
}

public class SuperTest1 {
    public static void main(String args[]){
        PatientInfo2 obj1 = new PatientInfo2();
        obj1.display();
    }
}
