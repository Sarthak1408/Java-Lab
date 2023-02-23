package lab4;

import java.util.ArrayList;

public class product extends category{
    static byte unique_product_count;
    static ArrayList<String> unique_products = new ArrayList<>();
    static ArrayList<String> unique_product_pids = new ArrayList<>();
    static ArrayList<Float> unique_price = new ArrayList<>();
    static ArrayList<String> respective_category_ids = new ArrayList<>();
    static ArrayList<Byte> product_count = new ArrayList<>();
    static ArrayList<String> product_description = new ArrayList<>();
    protected String pid,product_name;
    protected float price;
    protected byte quantity;
    protected short availablequantity;
    protected String product_desc;

    product(){
        super();
        this.pid = "";
        this.product_name = "";
        this.price = 0;
        this.availablequantity = 0;
    }


    static boolean check_product_availability(String product_name){
        for( int i=0;i<unique_product_count;i++ ){
            if(product_name.equalsIgnoreCase(unique_products.get(i)))
                return true;
        }
        return false;
    }

    static boolean display_all_products(){
        int j=1;
        for( int i=0;i<unique_products.size();i++ ) 
            System.out.println((j++) + ") "+unique_products.get(i)+"|||||||||||| product id: "+unique_product_pids.get(i));
        return false;
    }

    private void get_details1(){
        for( int i=0;i<unique_product_count;i++ ){
            if(this.product_name.equalsIgnoreCase(unique_products.get(i))){
                this.pid = unique_product_pids.get(i);
                this.category_id = respective_category_ids.get(i);
                this.product_desc = product_description.get(i);
                this.category_name = category_deets.get(this.category_id);
                break;
            }
        }
    }


    private void get_price1(){
        for( int i=0;i<unique_product_count;i++ ){
            if(this.product_name.equalsIgnoreCase(unique_products.get(i))){
                this.price = unique_price.get(i);
                break;
            }
        }
    }


    protected void assign_details(){
        this.get_details1();
        this.get_price1();
    }

    protected void display_details(){
        System.out.print("Product Name: "+product_name);
        //super.display_details();
        System.out.print("| Quantity: "+quantity);
        System.out.println("| Price per item(in rupees): "+price+"| ");
        System.out.println("Product Description: "+product_desc);
    }

}
