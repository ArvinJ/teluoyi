package org.teluoyi.controller;

import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.teluoyi.common.base.BaseController;
import org.teluoyi.entity.UserEntity;
import org.teluoyi.server.socket.SocketThread;
import org.teluoyi.service.UserService;
import org.teluoyi.util.PageUtils;
import org.teluoyi.util.Query;
import org.teluoyi.util.R;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/optScreenShot")
	public void screenShot() {
		logger.info("/optScreenShot");
		logger.info("send----");
		String ipValue = "127.0.0.1";
		String optType = "5";
		try {
			List<Socket> tempList = SocketThread.socketList;
			System.out.println(SocketThread.socketList.toString());
			for (int i = 0; i < tempList.size(); i++) {
				Socket socket = tempList.get(i);
				String tempSocketAddress = socket.getInetAddress().toString();
				int length = tempSocketAddress.length();
				tempSocketAddress = tempSocketAddress.substring(1, length);
				if (tempSocketAddress.equals(ipValue)) {
					sendMsg(socket, optType, ipValue);

				}
				System.err.println("socket.getInetAddress()---" + socket.getInetAddress());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end-----");

	}

	private void sendMsg(Socket socket, String type, String ip) throws Exception {

		OutputStream out = socket.getOutputStream();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("opt", type.trim());
		map.put("ip", ip.trim());
		//String json = new Gson().toJson(map);
		String json =  JSONObject.fromObject(map).toString().trim()+"\n";
		System.err.println("gogo send haha");
		out.write(json.getBytes());
		out.flush();
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<UserEntity> userList = userService.queryList(query);
		int total = userService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id) {
		UserEntity user = userService.queryObject(id);

		return R.ok().put("user", user);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody UserEntity user) {
		userService.save(user);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody UserEntity user) {
		userService.update(user);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids) {
		userService.deleteBatch(ids);

		return R.ok();
	}

}
