package org.teluoyi.server.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
/**
 * 
 * 
 * @Title:  SocketOperate.java   
 * @Package com.ahhf.ljxbw.socket.server   
 * @Description:    TODO(多线程处理socket接收的数据 )   
 * @author: wenjin.zhu    
 * @date:   2018年4月13日 下午2:37:14   
 * @version V1.0
 */
public class SocketOperate extends Thread {
	private Socket socket;

	public SocketOperate(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("unused")
	public void run() {
		
		try {
			handleSocket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*try {

			InputStream in = socket.getInputStream();

			PrintWriter out = new PrintWriter(socket.getOutputStream());

			// BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				// 读取客户端发送的信息
				String strXML = "";
				byte[] temp = new byte[1024];
				int length = 0;
				while ((length = in.read(temp)) != -1) {
					strXML += new String(temp, 0, length);
				}
				if ("end".equals(strXML)) {
					System.out.println("准备关闭socket");
					break;
				}
				if ("".equals(strXML))
					continue;

				System.out.println("客户端发来：" + strXML.toString());

				// MethodHandler mh = new MethodHandler(ReadXML.readXML(strXML.toString()));
				// String resultXML = mh.getResultXML();
				// System.out.println("返回："+resultXML.toString());

				// if(!"".equals(resultXML)){
				// out.print(resultXML);
				out.flush();
				out.close();
				// }

			}
			socket.close();
			System.out.println("socket stop.....");

		} catch (IOException ex) {

		} finally {

		}*/
	}
	
	
	/**
	 * 跟客户端Socket进行通信
	 * 
	 * @throws Exception
	 */
	private void handleSocket() throws Exception {
		
		byte[] recData = null;
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		while (true) {
			recData = new byte[1024];
			int r = in.read(recData);
			if (r > -1) {
				String data = new String(recData);
				if (data.trim().equals("over")) {
					socket.close();
				}
				System.err.println("server： client send Data --" + data);
				
				String val[] = data.split(";");
				if(val!=null&&val.length==2) {
					String ip= val[0].toString().trim();
					String type = val[1].toString().trim();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("opt", type);
					map.put("ip", ip);
					String json = new Gson().toJson(map);
					// String json = "{\"key01\":\"" + value01 + "\",\"key02\":" + value02+ "}";
					//String jsonStr = "{\"opt\":\""   +type+      "\",\"ip\":\""+ip+"\"}";
					System.err.println("server send data--"+json);
					out.write(json.getBytes());
				}
			} else {
				System.out.println("数据读取完毕！");
				//socket.close();
				//System.exit(0);
				// ss.close();
			}
		
		}
		
	}
}