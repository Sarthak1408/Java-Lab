package lab4;

import java.io.*;
import java.util.ArrayList;
public class buyproducts extends product{

    float product_total;
    ArrayList<buyproducts> shoppingList;
    public buyproducts(){
        this.product_total = 0.0f;
        shoppingList = new ArrayList<>();
    }



    protected void order_products()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            buyproducts obj = new buyproducts();
            System.out.print("\n\nEnter the name of the product : ");
            obj.product_name = br.readLine();
            if(obj.product_name.compareTo(" ") == 0) break;
            if(!check_product_availability(obj.product_name)){
                System.out.println("\nProduct not Available. Please try again");
                continue;
            }
            System.out.print("Enter the quantity of products: ");
            obj.quantity = Byte.parseByte(br.readLine());
            obj.assign_details();
            shoppingList.add(obj);
        }while(true);

        for (buyproducts buyproducts : shoppingList) {
            buyproducts.product_total = buyproducts.price * buyproducts.quantity;
        }
    }


    protected void view_productlist(){
        for(int i=0;i<shoppingList.size();i++)
        {
            System.out.print((i+1)+")");
            shoppingList.get(i).display_details();
            shoppingList.get(i).product_total = shoppingList.get(i).price * shoppingList.get(i).quantity;
            System.out.println("Total price: "+shoppingList.get(i).product_total);
        }
    }

}
