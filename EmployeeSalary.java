import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.*;
public class EmployeeSalary extends Person{
    protected int Basic;
    static byte DA = 5;
    static byte HRA = 10;
    static byte PFA = 8;
    static byte IT = 7;
    protected float NetSalary;
    protected void read() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        super.read();
        System.out.print("Enter Basic Salary of the employee: ");
        this.Basic = Integer.parseInt(br.readLine());
    }
    protected void NetSalary(){
        float GrossSalary = this.Basic + (this.Basic * (100+DA)/100) + (this.Basic * (100+HRA)/100);
        float Deduction = GrossSalary - (this.Basic * (100-PFA)/100) - (this.Basic * (100-IT)/100);
        this.NetSalary = GrossSalary - Deduction;
    }
}
