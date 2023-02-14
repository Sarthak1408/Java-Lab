public class category{

    protected String category_name, category_id, description, category_tag;
    category(){
        this.category_id = "";
        this.category_name = "";
        this.description = "";
        this.category_id = "";
    }
    category(String category_name,String category_id,String description){
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
    }

    protected void get_category(){
        switch (this.category_id) {
            case "C0001":
                this.category_name="Soft Drinks";
                this.description="Carbonated Drink";
                break;
            case "C0002":
                this.category_name="Biscuits";
                this.description="Cookies";
                break;
            case "C0003":
                this.category_name="Ready to Eat";
                this.description="Ready in 5 minutes";
                break;
        
            default:
                break;
        }
    }
    protected void display_details(){
        System.out.println("Category ID:                "+category_id);
        System.out.println("Category Type:              "+category_name);
        System.out.println("Category Description:       "+description);
    }
}