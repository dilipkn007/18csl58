import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException,InterruptedException{
        DataOutputStream out;
        DataInputStream in;
        Scanner sc=new Scanner(System.in);
        Socket socket=new Socket("127.0.0.1",5000);
        System.out.println("Client connected to server");
        System.out.println("\nEnter file name to request\n");
        String fileName=sc.nextLine();
        in=new DataInputStream(socket.getInputStream());
        out=new DataOutputStream(socket.getOutputStream());
        out.writeUTF(fileName);
        String fileContent=in.readUTF();
        if(fileContent.length()>0){
            System.out.println(fileContent);
        }
        else{
            System.out.println("FILE IS EMPTYS");
        }
        sc.close();
        socket.close();
    }
}
