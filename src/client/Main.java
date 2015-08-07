package client;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Main {
	
	public static DatagramSocket socket;
	private static SocketAddress address;
	
	static final String SERVER_IP = "52.26.255.34";
	static final int SERVER_PORT = 666;
	
	public static void main(String[] args) throws Exception {
		
		socket= new DatagramSocket(666);
		
		address = new InetSocketAddress(SERVER_IP, SERVER_PORT);
		
		while(true){
			Send();
		}
	}
	
	private static void Send() throws Exception{
		String message = new String("Ping "+new java.util.Date());
		DatagramPacket sendPacket = new DatagramPacket(message.getBytes(),message.getBytes().length,address);
		socket.send(sendPacket);
		System.out.println(message);
		
		//Receive
		DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
		socket.receive(receivePacket);
		
		System.out.println(new String(receivePacket.getData()).trim());
		
	}

}
