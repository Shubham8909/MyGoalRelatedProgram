package com.mq.ibm;
// ==================================================================

//
// Program Name
//  MQRead
//
// Last date of modification
//  1 Oct 2000
//
// Description
//  This java class will read a queue an output the message
//  content to the console.  This class will loop until all
//  messages have been read.
//
// Sample Command Line Parameters
//  -h 127.0.0.1 -p 1414 -c CLIENT.CHANNEL -m MQA1 -q TEST.QUEUE
//
// Copyright(C), Roger Lacroix, Capitalware
//
// ------------------------------------------------------------------

import com.ibm.mq.*;
import java.io.IOException;
import java.util.Hashtable;
import java.io.*;

public class MQRead {
	private MQQueueManager _queueManager = null;
	private Hashtable params = null;
	public int port = 7194;
	public String hostname = "10.94.135.147";
	public String channel = "QMRECGWS.ONE97.SVRCN";
	public String qManager = "QMRECCGWS";
	public String inputQName = "EVENTS.ONE97.ACTIVATION.RPO.01";

	public MQRead() {
		super();
	}

	private boolean allParamsPresent() {
		boolean b = params.containsKey("-h") && params.containsKey("-p") && params.containsKey("-c")
				&& params.containsKey("-m") && params.containsKey("-q");
		if (b) {
			try {
				port = Integer.parseInt((String) params.get("-p"));
			} catch (NumberFormatException e) {
				b = false;
			}
			// Set up MQ environment
			hostname = (String) params.get("-h");
			channel = (String) params.get("-c");
			qManager = (String) params.get("-m");
			inputQName = (String) params.get("-q");

		}
		return b;
	}

	private void init(String[] args) throws IllegalArgumentException {
		params = new Hashtable(5);
		if (args.length > 0 && (args.length % 2) == 0) {
			for (int i = 0; i < args.length; i += 2) {
				params.put(args[i], args[i + 1]);
			}
		} else {
			throw new IllegalArgumentException();
		}
		if (allParamsPresent()) {
			// Set up MQ environment
			MQEnvironment.hostname = hostname;
			MQEnvironment.channel = channel;
			MQEnvironment.port = port;
			MQEnvironment.sslCipherSuite = "TLS_RSA_WITH_AES_128_CBC_SHA256";

		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {

		MQRead readQ = new MQRead();

		try {
			readQ.init(args);
			readQ.selectQMgr();
			readQ.read();
		} catch (IllegalArgumentException e) {
			System.out.println(
					"Usage: java MQRead <-h host> <-p port> <-c channel> <-m QueueManagerName> <-q QueueName>");
			System.exit(1);
		} catch (MQException e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	private void read() throws MQException {
		int openOptions = MQC.MQOO_INQUIRE + MQC.MQOO_FAIL_IF_QUIESCING + MQC.MQOO_INPUT_SHARED;

		MQQueue queue = _queueManager.accessQueue(inputQName, openOptions, null, // default q manager
				null, // no dynamic q name
				null); // no alternate user id

		System.out.println("MQRead v1.0 connected.\n");

		int depth = queue.getCurrentDepth();
		System.out.println("Current depth: " + depth + "\n");
		if (depth == 0) {
			return;
		}

		MQGetMessageOptions getOptions = new MQGetMessageOptions();
		getOptions.options = MQC.MQGMO_NO_WAIT + MQC.MQGMO_FAIL_IF_QUIESCING + MQC.MQGMO_CONVERT;
		while (true) {
			MQMessage message = new MQMessage();
			try {
				queue.get(message, getOptions);
				byte[] b = new byte[message.getMessageLength()];
				message.readFully(b);
				System.out.println(new String(b));
				message.clearMessage();
			} catch (IOException e) {
				System.out.println("IOException during GET: " + e.getMessage());
				break;
			} catch (MQException e) {
				if (e.completionCode == 2 && e.reasonCode == MQException.MQRC_NO_MSG_AVAILABLE) {
					if (depth > 0) {
						System.out.println("All messages read.");
					}
				} else {
					System.out.println("GET Exception: " + e);
				}
				break;
			}
		}
		queue.close();
		_queueManager.disconnect();
	}

	private void selectQMgr() throws MQException {
		_queueManager = new MQQueueManager(qManager);
		
	}
}