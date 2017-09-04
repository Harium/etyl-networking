package com.harium.blakfisk.protocol;

import com.harium.blakfisk.model.Peer;
import com.harium.blakfisk.util.ByteMessageUtils;

public class NullProtocol implements Protocol {
	
	@Override
	public void receiveTCP(Peer peer, byte[] message) {
		System.out.println("Null Client Protocol - Recv TCP: "+new String(message));
	}

	@Override
	public void receiveUDP(Peer peer, byte[] message) {
		System.out.println("Null Client Protocol - Recv UDP: "+new String(message));
	}

	@Override
	public byte[] getPrefix() {
		return ByteMessageUtils.EMPTY_BYTES;
	}

	@Override
	public void addPeer(Peer peer) {
		System.out.println("Null Client Protocol - added peer "+peer.getID());
	}

	@Override
	public void removePeer(Peer peer) {
		System.out.println("Null Client Protocol - removed peer "+peer.getID());
	}

	@Override
	public void receive(byte messageProtocol, Peer peer, byte[] message) {
		// TODO Auto-generated method stub
		
	}

}
