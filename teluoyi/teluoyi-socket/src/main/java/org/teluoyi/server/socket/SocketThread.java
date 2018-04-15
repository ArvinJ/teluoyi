package org.teluoyi.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 
 * @Title: SocketThread.java
 * @Package com.ahhf.ljxbw.socket.server
 * @Description: TODO(socket 线程类 )
 * @author: wenjin.zhu
 * @date: 2018年4月13日 下午2:35:44
 * @version V1.0
 */
public class SocketThread extends Thread {
	private ServerSocket serverSocket = null;
	public static List<Socket> socketList = new ArrayList<Socket>();
	public static HashMap<String, Socket> socketLists = new HashMap<>();
	public SocketThread(ServerSocket serverScoket) {
		try {
			if (null == serverSocket) {
				this.serverSocket = new ServerSocket(8282);
				System.out.println("socket start");
			}
		} catch (Exception e) {
			System.out.println("SocketThread创建socket服务出错");
			e.printStackTrace();
		}

	}
	public SocketThread() {
		
	}

	public void run() {
		while (!this.isInterrupted()) {
			try {
				ExecutorService threadPool = Executors.newFixedThreadPool(100);
					Socket socket = serverSocket.accept();
					socketList.add(socket);
					System.err.println("socketlist列表中的--"+socketList.toString());
					System.err.println("当前最新建立好连接的 socket-----"+socket);
					/*if (null != socket && !socket.isClosed()) {
						// 处理接受的数据
						new SocketOperate(socket).start();
					}*/
					new SocketOperate(socket).start();
					//socket.setSoTimeout(30000);
					threadPool.submit(new SocketOperate(socket));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeSocketServer() {
		try {
			if (null != serverSocket && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
