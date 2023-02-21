package lab4;

import java.io.*;
import java.util.ArrayList;

public class store extends customer {

    static byte bill_count;

    static {
        product.unique_product_count=5;

        /*File reading will be performed here later */
        category.category_count = 3;

        category.unique_category.add("C0001");
        category.unique_category.add("C0002");
        category.unique_category.add("C0003");

        category.category_details.add("Soft Drinks");
        category.category_details.add("Biscuits");
        category.category_details.add("Ready to Eat");

        category.category_description.add("Carbonated Drink");
        category.category_description.add("Cookies");
        category.category_description.add("Ready in 5 minutes");

        product.unique_products.add("Coca Cola");
        product.unique_products.add("Parle-G");
        product.unique_products.add("Hide and Seek");
        product.unique_products.add("Thumbs Up");
        product.unique_products.add("Maggi");
        
        product.unique_product_pids.add("P0001");
        product.unique_product_pids.add("P0002");
        product.unique_product_pids.add("P0003");
        product.unique_product_pids.add("P0004");
        product.unique_product_pids.add("P0005");

        product.respective_category_ids.add("C0001");
        product.respective_category_ids.add("C0002");
        product.respective_category_ids.add("C0002");
        product.respective_category_ids.add("C0001");
        product.respective_category_ids.add("C0003");

        product.unique_price.add(10.0F);
        product.unique_price.add(20.0F);
        product.unique_price.add(30.0F);
        product.unique_price.add(40.0F);
        product.unique_price.add(50.0F);
        /*File reading will be performed here later */

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("HELLO and Welcome to All-in-One Store!!");
        bill_count = 0;
    }

    private static void display() {
        System.out.println("\n\nEnter 1 to enter new customer.");
        System.out.println("Enter 2 to view bill with respect to a customer.");
        System.out.println("Enter -1 to conclude for the day");
        System.out.print("Enter your choice: ");
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        byte choice;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<customer> customer_list = new ArrayList<>();
        do {
            display();
            choice = Byte.parseByte(br.readLine());
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            switch (choice) {
                case 1 -> {
                    customer obj = new customer();
                    bill_count += 1;
                    obj.bill_number = bill_count;
                    obj.accept_details();
                    obj.order_products();
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    if (obj.shoppingList.size() == 0) break;
                    obj.generate_bill();
                    customer_list.add(obj);
                    br.readLine();
                }
                case 2 -> {
                    String phonenumber;
                    System.out.print("\nEnter phone number to search in the list: ");
                    phonenumber = br.readLine();
                    for (customer customer : customer_list) {
                        if ((customer.phone_number).compareTo(phonenumber) == 0) {
                            customer.generate_bill();
                        }
                    }
                    br.readLine();
                }
                case -1 -> System.out.println("\n\nThat is the end of the day!!");
                default -> System.out.println("\nWrong Choice Entered!! Please try again.");
            }
        } while (choice != -1);
    }
}
