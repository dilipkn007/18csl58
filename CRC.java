import java.util.Scanner;

public class CRC {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String data,GP;
        System.out.print("Enter the Data stream : ");
        data=sc.next();
        System.out.print("Enter the generator polynomial : ");
        GP=sc.next();
        int dividend[]=new int[data.length()+GP.length()-1];
        for (int i = 0; i < data.length(); i++) 
            dividend[i]=Integer.parseInt((data).charAt(i)+"");
        int divisor[]=new int[GP.length()];
        for (int i = 0; i < GP.length(); i++) 
            divisor[i]=Integer.parseInt((GP).charAt(i)+"");
        for (int i = 0; i < data.length(); i++) {
            if(dividend[i]==1){
                for (int j = 0; j < GP.length(); j++) {
                    dividend[i+j]^=divisor[j];
                }
            }
        }
        //Print CRC
        System.out.print("CRC : ");
        for (int i = data.length(); i < dividend.length; i++)
            System.out.print(dividend[i]+" ");
        System.out.println();
        //Read codeword from reciver
        System.out.print("Enter datastream along with CRC : ");
        String codeword=sc.next();
        int newDividend[]=new int[codeword.length()];
        for (int i = 0; i < codeword.length(); i++) 
            newDividend[i]=Integer.parseInt((codeword).charAt(i)+"");
        for (int i = 0; i < data.length(); i++) {
            if(newDividend[i]==1){
                for (int j = 0; j < divisor.length; j++) {
                    newDividend[i+j]^=divisor[j];
                }
            }
        }
        Boolean valid=true;
        for (int i = 0; i < newDividend.length; i++) {
            if (newDividend[i]==1) {
                valid=false;
            }
        }
        if(valid==true)
            System.out.println("Data is valid");
        else
            System.out.println("Data is invalid");
        sc.close();
    }    
}