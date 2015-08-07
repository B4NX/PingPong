package server;

import java.io.*;
import java.net.*;


public class Main {

	public static DatagramSocket socket;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Starting");
		
		socket = new DatagramSocket(666);
		
		//while(true){
			//Receive();
		//}
	}
	
	private static void Receive() throws IOException{
		DatagramPacket receivedPacket = new DatagramPacket(new byte[1024],1024);
		socket.receive(receivedPacket);
		
		String s = new String(receivedPacket.getData()).trim();
		System.out.println(s);
		
		//Reply
		String send = new String("Pong "+ new java.util.Date());
		
		DatagramPacket sendPacket = new DatagramPacket(s.getBytes(),s.getBytes().length,receivedPacket.getAddress(),receivedPacket.getPort());
		socket.send(sendPacket);
	}

}
