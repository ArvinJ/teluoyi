package org.teluoyi.client.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @ClassName: ClientSocket
 * @Description: TODO(socket客户端)
 * @author wenjin.zhu
 * @date 2018年4月14日
 *
 */
public class ClientSocket {

	private static final String HOST = "localhost";
	private static final int BUFFER_SIZE = 1024;
	private static final int PORT = 8282;

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket(HOST, PORT);
		InputStream in = client.getInputStream();
		OutputStream out = client.getOutputStream();
		byte[] recData = null;
		try {
			while (true) {
				Thread.sleep(3000);
				System.out.println("发送心跳数据包");
				out.write("ping".getBytes());
				recData = new byte[BUFFER_SIZE];
				int r = in.read(recData);
				if (r > -1) {
					String data = new String(recData);
					if (data.trim().equals("over")) {
						client.close();
					}
					System.out.println("client： GET server Data " + data);
					

				} else {
					System.out.println("数据读取完毕！");
					client.close();
					System.exit(0);
					// ss.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.close();
			client.close();
		}
	}

}
