import java.io.*;
public class buyproducts {

    static boolean check_availability(String id){
        return id.equals("P0001") || id.equals("P0002") || id.equals("P0003") || id.equals("P0004") || id.equals("P0005");
    }
    public static void main(String[] args) throws IOException {
        float sum=0;
        byte n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of products you want to order: ");
        n=Byte.parseByte(br.readLine());
        product[] obj = new product[n];

        for (int i = 0; i < n; i++) {
            obj[i] = new product();
            System.out.print("\nEnter the product id for product "+(i+1)+": ");
            obj[i].pid = br.readLine();
            if(!check_availability(obj[i].pid)){
                System.out.println("\nProduct not Available. Please try again");
                i -= 1;
                continue;
            }
            System.out.print("Enter the quantity of product: ");
            obj[i].quantity = Byte.parseByte(br.readLine());
        }
        System.out.println("\n\n**********Order Summary**********\n\n");
        for(int i=0;i<n;i++)
        {
            System.out.println("\nProduct "+(i+1)+": \n");
            obj[i].display_details();
        }
        for(int i=0;i<n;i++){
            sum += obj[i].total_price;
        }
        System.out.println("Grand total: Rs. "+sum);
        System.out.println("\n\n*********************************\n\n");
    }
}
