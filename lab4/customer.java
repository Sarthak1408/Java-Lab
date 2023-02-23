package lab4;

import java.io.*;

public class customer {
    String name;
    String phone_number;
    float grand_total;
    byte bill_number;
    orders order;

    customer() {
        name = phone_number = "";
        grand_total = 0.0f;
        bill_number = 0;
        order = new orders();
    }

    protected void accept_details() throws IOException {
        boolean flag;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n\nEnter Customer Name: ");
        this.name = br.readLine();
        do {
            System.out.print("Enter phone number: ");
            this.phone_number = br.readLine();
            if (this.phone_number.length() == 10) {
                flag = true;
                for (int i = 0; i < this.phone_number.length(); i++)
                    if (!Character.isDigit(this.phone_number.charAt(i))) {
                        System.out.println("\nInvalid Phone Number. Please try Again");
                        flag = false;
                        break;
                    }
            } else {
                System.out.println("\nInvalid Phone Number. Please try Again");
                flag = false;
            }
        } while (!flag);
        order.order_products();
    }

    protected void generate_bill() {
        System.out.println(
                "\n\n*********************************************Generated Bill*********************************************\n\n");
        System.out.println("Bill Number: " + this.bill_number + "\nName: " + this.name
                + "                      Phone Number: " + this.phone_number + "\n\n");
        order.view_productlist();
        System.out.println("\n\nGrand Total: " + this.order.grand_total);
        System.out.println(
                "\n\n********************************************************************************************************");
    }

}
