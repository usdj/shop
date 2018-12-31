/**
 * 
 */
package com.usdj.shop.user.adminaction;

import com.usdj.shop.user.service.UserService;
import com.usdj.shop.user.vo.User;
import com.usdj.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author gerrydeng
 *
 */
public class UserAdminAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5135243593052076417L;
	// 模型驱动使用的类
	private User user = new User();

	public User getModel() {
		return user;
	}

	// 注入用户的Service
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接受page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 后台查询所有用户的方法带分页:
	public String findAll() {
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 后台用户的删除
	public String delete() {
		User existUser = userService.findByUid(user.getUid());
		userService.delete(existUser);
		return "deleteSuccess";
	}

	// 后台用户的编辑
	public String edit() {
		user = userService.findByUid(user.getUid());
		return "editSuccess";
	}

	// 后台用户的修改:
	public String update() {
		userService.update(user);
		return "updateSuccess";
	}
}
