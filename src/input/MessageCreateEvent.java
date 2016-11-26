/* 
 * Copyright 2010 Aalto University, ComNet
 * Released under GPLv3. See LICENSE.txt for details. 
 */
package input;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

import core.DTNHost;
import core.Message;
import core.World;

/**
 * External event for creating a message.
 */
public class MessageCreateEvent extends MessageEvent {
	private int size;
	private int responseSize;
	public static List<Message> messagesCreated = new ArrayList<Message>();
	/**
	 * Creates a message creation event with a optional response request
	 * @param from The creator of the message
	 * @param to Where the message is destined to
	 * @param id ID of the message
	 * @param size Size of the message
	 * @param responseSize Size of the requested response message or 0 if
	 * no response is requested
	 * @param time Time, when the message is created
	 */
	public MessageCreateEvent(int from, int to, String id, int size,
			int responseSize, double time) {
		super(from,to, id, time);
		this.size = size;
		this.responseSize = responseSize;
	}


	/**
	 * Creates the message this event represents. 
	 */
	@Override
	public void processEvent(World world) {
		DTNHost to = world.getNodeByAddress(this.toAddr);
		DTNHost from = world.getNodeByAddress(this.fromAddr);
		Message m = new Message(from, to, this.id, this.size);
       // m.setVehicleNum(from.getVehicleNum());
		m.setResponseSize(this.responseSize);
		//System.out.println("from node"+ m.getVehicleNum());
		//System.out.println("to node "+ to);
		Message encryptedM = m;
		if(Message.isSecure)
		{
			encryptedM=m.encryptMessage();
			encryptedM.setSignature();
			encryptedM.setFlagAuth(true);
		}
		//m=encryptedM;
		//System.out.println("Finalllllyyyy u shud be the one");
		//System.out.println("DTN host speed "+ from.getSpeed()+"destination is "+ from.getDestination());

		//System.out.println("details of to host"+ to.getAddress()+" Name "+to.getName());
		//System.out.println("details of from host "+ from.getAddress()+"name "+from.getName());
		messagesCreated.add(encryptedM);
		System.out.println("\nEncrypted Message :  "+ encryptedM.getVehicleNum()+"id : "+ encryptedM.getId());	
		from.createNewMessage(encryptedM);
		System.out.println("**************************************************************");
		
	}
}
