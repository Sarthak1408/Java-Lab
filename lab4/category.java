package lab4;

import java.util.*;

public class category {

    protected String category_name, category_id, description, category_tag;
    static int category_count;
    static ArrayList<String> unique_category = new ArrayList<>();
    static ArrayList<String> category_details = new ArrayList<>();
    static ArrayList<String> category_description = new ArrayList<>();

    category(){
        this.category_name = "";
        this.description = "";
        this.category_id = "";
    }

    category(String category_name, String category_id, String description) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
    }

    protected void get_category(){
        for( int i=0;i<category_count;i++ ){
            if(this.category_id.equalsIgnoreCase(unique_category.get(i)) == true){
                this.category_name = category_details.get(i);
                this.category_id = category_description.get(i);
                break;
            }
        }
    }

    protected void display_details() {
        System.out.println("Category ID:                " + category_id);
        System.out.println("Category Type:              " + category_name);
        System.out.println("Category Description:       " + description);
    }
}