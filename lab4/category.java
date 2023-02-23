package lab4;

import java.util.*;

public class category {

    protected String category_name;
    protected String category_id;
    protected String description;
    static HashMap<String,String> category_deets = new HashMap<>();


    category() {
        this.category_name = "";
        this.description = "";
        this.category_id = "";
    }

    category(String category_name, String category_id, String description) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
    }

}