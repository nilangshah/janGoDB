import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

class TCPClient
{
	
	
 public static void main(String argv[]) throws Exception
 {
  String sentence;
  String modifiedSentence;
  BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost", 11211);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

  boolean flag=true; 
   
   	sentence = "set alpha 123";
  	outToServer.writeBytes(sentence + '\n');
  	modifiedSentence = inFromServer.readLine();
	System.out.println("SEND SERVER:" + sentence);
  	System.out.println("FROM SERVER: " + modifiedSentence );
  	sentence = "get alpha";
	System.out.println("SEND SERVER:" + sentence);
    	outToServer.writeBytes(sentence + '\n');
  	modifiedSentence = inFromServer.readLine();
  	System.out.println("FROM SERVER: " + modifiedSentence);
  		 
	clientSocket.close();
	 
}
}
