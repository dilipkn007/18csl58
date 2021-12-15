import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        int bSize,np,oRate;  //bucket size,number of incomming packets, output rate
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the bucket size : ");
        bSize=sc.nextInt();
        System.out.print("Enter the number of incomming packets : ");
        np=sc.nextInt();
        int a[]=new int[np];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter the "+i +" packet size : ");            
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the Output rate : ");
        oRate=sc.nextInt();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Transmitting packet of size : "+a[i]);
            if(a[i]>bSize){
                System.out.println("Bucket overflow, packet cannot be transmitted ");
            }
            else if(a[i]<=oRate){
                System.out.println("Transmitted: "+a[i]+" bits");
            }
            else if(a[i]>oRate){
                while (a[i]!=0 && a[i]>oRate) {
                    System.out.println("Transmitted: "+oRate+" bits");
                    a[i]-=oRate;
                }
                System.out.println("Transmitted: "+a[i]+" bits");
            }
        }
        sc.close();
    }
}
