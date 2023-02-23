package lab4;

import java.io.*;
import java.util.ArrayList;
public class orders{

    float grand_total;
    ArrayList<product> shoppingList;
    ArrayList<Float> total_item_price;
    public orders(){
        this.grand_total = 0.0f;
        shoppingList = new ArrayList<>();
        total_item_price = new ArrayList<>();
    }



    protected void order_products()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        product.display_all_products();
        do {
            product obj = new product();
            System.out.print("\n\nEnter the name of the product : ");
            obj.product_name = br.readLine();
            if(obj.product_name.compareTo(" ") == 0) break;
            if(! product.check_product_availability(obj.product_name)){
                System.out.println("\nProduct not Available. Please try again");
                continue;
            }
            System.out.print("Enter the quantity of products: ");
            obj.quantity = Byte.parseByte(br.readLine());
            obj.assign_details();
            shoppingList.add(obj);
        }while(true);

        for (product item : shoppingList) 
            total_item_price.add(item.price * item.quantity);

        for (float price: total_item_price)
            this.grand_total += price;
    }


    protected void view_productlist(){
        for(product item: this.shoppingList)
        {
            System.out.print(shoppingList.indexOf(item)+1+")");
            item.display_details();
            System.out.println("Total price: "+this.total_item_price.get(shoppingList.indexOf(item)));
        }
    }

}
