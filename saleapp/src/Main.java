// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    Product[] products=new Product[3];
    public static void main(String[] args) {
       Product p=new Product();
        Main main=new Main();
        main.addProductsToArray();
        main.printthearray();
        main.searchforproducr(2);
    }

    void addProductsToArray(){
        System.out.println("In addProductsToArray() Method");
        Product p1=new Product(1,100);
        p1.increasepriceby(100);
        Product p2=new Product(2,200);
        Product p3=new Product(3,300);
        products[0]=p1;
        products[1]=p2;
        products[2]=p3;
        System.out.println("Added Products...");

//        for(int i=0;i<3;i++){
//            Scanner sc=new Scanner(System.in);
//            System.out.println("Enter produc Id");
//            long id=sc.nextLong();
//            double price=sc.nextDouble();
//            Product p=new Product(id,price);
//        }
//
    }
    void printthearray(){
        System.out.println("In printthearray() Method");
        for (int i=0;i<3;i++){
            System.out.println("Product-"+(i+1));
            System.out.println("Product Id:"+products[i].id);
            System.out.println("Product Price:"+products[i].price);
        }
    }
    void searchforproducr(long id){
        System.out.println("In searchforproducr() Method");
        boolean flag=false;
        for(Product pro:products){
            if (pro.id==id) {
                //                System.out.println("Product-"+i+1);
                System.out.println("ProducId:" + pro.id);
                System.out.println("Product Price:" + pro.price);
//                System.out.println(increasepriceby(345));
                flag = true;
            }
        }
        if(flag==false){
            System.out.println("pro not available:"+id);
        }
    }

    }