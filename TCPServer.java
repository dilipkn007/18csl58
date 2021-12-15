import java.io.*;
import java.net.*;
import java.nio.file.*;
/**
 * TCPServer
 */
public class TCPServer {

    public static void main(String[] args) throws IOException{
        ServerSocket server;
        DataOutputStream out=null;
        DataInputStream in;
        try {
            server=new ServerSocket(5000,1);
            System.out.println("Server Waiting for client");
            Socket socket=server.accept();
            System.out.println("Client connect");
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());
            String fileName=in.readUTF();
            System.out.println("File requested is "+fileName);
            byte[] fileData=Files.readAllBytes(Paths.get(fileName));
            String fileContent=new String(fileData);
            out.writeUTF(fileContent.toString());
            System.out.println("FILE SENT SUCCESSFULLY");
        } catch (Exception e) {
            System.out.println("getMessage()");
            out.writeUTF("FILE DOESN'T EXIST");
        }
    }
}