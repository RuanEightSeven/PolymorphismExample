import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List <Product> products= new ArrayList<>();

        System.out.print("Enter the number of products:");
        int numberOfProducts = sc.nextInt();

        for(int i=1; i<=numberOfProducts; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char answer = sc.next().charAt(0);
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Price:");
            Double price = sc.nextDouble();

            if (answer == 'c'){
                products.add(new Product(name, price));
            } else if (answer == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }else if(answer == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, manufactureDate));
            }


            }
        System.out.println("PRICE TAGS:");
        for (Product p : products){
            System.out.println(p.priceTag());
        }
    }
}