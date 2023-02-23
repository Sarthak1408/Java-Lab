package lab4;

import java.io.*;
import java.util.ArrayList;

public class store  {

    static byte bill_count;
    static BufferedReader prod_data;

    static {
        product.unique_product_count=0;
        try {
            prod_data = new BufferedReader(new FileReader("productlist.csv"));
            System.out.println("File reading successful");
            String row;
            boolean flag= false;
            while( (row= prod_data.readLine()) != null){
                if(!flag){
                    flag = true;
                    continue;
                }
                product.unique_product_count+=1;
                String[] data = row.split(",");
                product.unique_products.add(data[0]);
                product.unique_product_pids.add(data[1]);
                product.respective_category_ids.add(data[4]);
                product.unique_price.add(Float.parseFloat(data[2]));
                product.product_count.add(Byte.parseByte(data[3]));
                product.product_description.add(data[7]);

                if(!category.category_deets.containsKey(data[4]))
                    category.category_deets.put(data[4], data[5]);

            }
            System.out.println(category.category_deets);
        } catch (IOException e) {
            System.out.println("Files not found");
        }
            

        // System.out.print("\033[H\033[2J");
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
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    if (obj.order.shoppingList.size() == 0) break;
                    obj.generate_bill();
                    customer_list.add(obj);
                    br.readLine();
                }
                case 2 -> {
                    String phonenumber;
                    System.out.print("\nEnter phone number to search in the list: ");
                    phonenumber = br.readLine();
                    for (customer person : customer_list) {
                        if ((person.phone_number).compareTo(phonenumber) == 0) {
                            person.generate_bill();
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
