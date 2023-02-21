package lab3;

public class product extends category{
    protected String pid,product_name;
    protected float price;
    protected byte quantity;
    protected short availablequantity;
    protected float total_price;
    product(){
        super();
        this.pid = "";
        this.product_name = "";
        this.price = 0;
        this.availablequantity = 0;
        this.quantity = 0;
    }
    
    product(String pid, String product_name,float price, byte quantity, String category_name,String category_id,String description){
        super(category_name,category_id,description);
        this.pid = pid;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }
    
    private void get_details(){
        switch (this.pid) {
            case "P0001":
                this.product_name="Coca Cola";
                this.category_id="C0001";
                break;
            case "P0002":
                this.product_name="Parle-G";
                this.category_id="C0002";
                break;
            case "P0003":
                this.product_name="Hide and Seek";
                this.category_id="C0002";
                break;
            case "P0004":
                this.product_name="Thumbs Up";
                this.category_id="C0001";
                break;
            case "P0005":
                this.product_name="Maggi";
                this.category_id="C0003";
                break;
        
            default:
                break;
        }
        
    }

    private void getprice(){
        if(this.pid.equals("P0001")) this.price = 10.0F;
        else if(this.pid.equals("P0002")) this.price = 20.0F;
        else if(this.pid.equals("P0003")) this.price = 30.0F;
        else if(this.pid.equals("P0004")) this.price = 40.0F;
        else if(this.pid.equals("P0005")) this.price = 50.0F;
        System.out.println(this.price);
    }

    private void calculate_price(){
        this.getprice();
        this.total_price = this.price * this.quantity;
    }

    protected void display_details(){
        this.get_details();
        this.get_category();
        this.calculate_price();
        System.out.println("Product Name:               "+product_name);
        super.display_details();
        System.out.println("Quantity:                   "+quantity);
        System.out.println("Price per item(in ruppees): "+price);
        System.out.println("Total price:                "+total_price);
    }

}
