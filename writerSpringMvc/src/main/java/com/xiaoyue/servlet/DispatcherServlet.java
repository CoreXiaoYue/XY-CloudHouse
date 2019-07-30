package com.xiaoyue.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoyue.Service.UserService;
import com.xiaoyue.ServiceImpl.UserServiceImpl;
import com.xiaoyue.anotation.OwnAutoAware;
import com.xiaoyue.anotation.OwnController;
import com.xiaoyue.anotation.OwnRepository;
import com.xiaoyue.anotation.OwnRequestMapping;
import com.xiaoyue.anotation.OwnService;
import com.xiaoyue.controller.UserController;
import com.xiaoyue.repositoryImpl.UserRepositoryImpl;

/**
 * @author 小岳
 * 			手写SpringMVC
 */
public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> classNames = new ArrayList<String>();// 存放解析出路径下的class文件名
	Map<String, Object> beanMap = new HashMap<String, Object>();// 存放创建的实例对象
	Map<String, Object> reqMapping = new HashMap<String, Object>();//存放解析后的请求映射路径

	public DispatcherServlet() {
		doInit();
	}

	private void doInit() {
		doScan("com.xiaoyue");// 包扫描
		System.out.println("扫描到：" + classNames.size() + "class文件");
		
		doInitBean();// 初始化bean
		System.out.println("创建的组件数：" + beanMap.size() + "个");
		
		doIoc();// 依赖注入组件
		
		doHandler();// 处理映射请求
		System.out.println("请求映射：" + reqMapping.size() + "条");

	}

	/**
	 * 	拼接请求的映射路径
	 * 	修饰在类上的OwnRequestMapping的value值+修饰在方法上的OwnRequestMapping的value值作为key放入map集合中
	 */
	private void doHandler() {
		if (beanMap.size() <= 0) {
			System.out.println("容器中没有组件");
		} else {
			String RequestMappingVal = null;
			for (Map.Entry<String, Object> entry : beanMap.entrySet()) {// 遍历map中的对象
				Class<? extends Object> clazz = entry.getValue().getClass();
				if (clazz.isAnnotationPresent(OwnRequestMapping.class)) {// 判断该类是否有OwnAutoAware注释修饰
					OwnRequestMapping ownRequestMapping = clazz.getDeclaredAnnotation(OwnRequestMapping.class);//
					// 获取注解的value属性值
					RequestMappingVal = ownRequestMapping.value();
				}
				Method[] methods = clazz.getMethods();// 获取class对象所有方法对象
				for (Method method : methods) {// 遍历方法对象
					if (method.isAnnotationPresent(OwnRequestMapping.class)) {// 判断该类是否有OwnRequestMapping注释修饰
						// 被OwnRequestMapping修饰的方法注解对象
						OwnRequestMapping ownRequestMapping = method.getAnnotation(OwnRequestMapping.class);
						// 获取注解的value属性值
						String ownRequestMappingVal = ownRequestMapping.value();
						// 拼接请求映射路径
						RequestMappingVal += ownRequestMappingVal;
						// 将请求路径添加到map中，key=请求路径，value=当前method方法对象
						reqMapping.put(RequestMappingVal, method);
					}
					continue;
				}
				continue;
			}

		}
	}

	/**
	 * 依赖注入组件
	 */
	private void doIoc() {
		if (beanMap.size() <= 0) {
			System.out.println("容器中没有组件");
		} else {
			// 遍历Map中的组件。
			for (Map.Entry<String, Object> entry : beanMap.entrySet()) {

				Object instance = entry.getValue();

				Class<? extends Object> clazz = instance.getClass();// 获取实例对象的calss对象。
				//判断是否是OwnController修饰的组件
				if (clazz.isAnnotationPresent(OwnController.class)) {
				
					Field[] fields = clazz.getDeclaredFields();// 获取clazz对象的所有成员变量。
					System.out.println(fields.length);
					for (Field field : fields) {// 遍历成员变量
						if (field.isAnnotationPresent(OwnAutoAware.class)) {// 判断该成员变量是否有OwnAutoAware注释修饰
							String fieldName = field.getName();//获取成员变量的属性名
							Object service = beanMap.get(fieldName);//通过变量名做key获取beanMap中的repository组件
							try {
								field.setAccessible(true);
								field.set(instance, service);// 对成员变量设值操作
							}  catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}
						continue;
					}
				
				}
				
				//判断是否是被OwnService注解修饰的组件
				if(clazz.isAnnotationPresent(OwnService.class)) {
					Field[] fields = clazz.getDeclaredFields();
					
					for (Field field : fields) {
						if(field.isAnnotationPresent(OwnAutoAware.class)) {
							String fieldName = field.getName();//获取成员变量的属性名
							field.setAccessible(true);//获取私有属性操作权。
							Object repository = beanMap.get(fieldName);//通过变量名做key获取beanMap中的repository组件
							
							try {
								field.set(instance, repository);//对该成员变量进行set这只操作。为service组件注入repository组件，
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
						}
						continue;
					}
				}
				continue;
			}

		}
	}

	/**
	 * 		初始化bean
	 */
	private void doInitBean() {
		if (classNames.size() <= 0) {
			System.out.println("包扫描失败。");
		} else {
			for (String className : classNames) {// 遍历class文件名
				// 创建calss字节码对象
				try {
					Class<?> clazz = Class.forName(className);
					if (clazz.isAnnotationPresent(OwnController.class)) {// 判断该类是否有OwnController注解修饰
						IsAnnotationPresent(clazz);
					} 
					if (clazz.isAnnotationPresent(OwnService.class)) {// 判断该类有OwnService注解修饰
						IsAnnotationPresent(clazz);
					}
					if(clazz.isAnnotationPresent(OwnRepository.class)) {// 判断该类有OwnRepository注解修饰
						IsAnnotationPresent(clazz);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				continue;
			}
		}

	}

	/**
	 * @param clazz 组件的class字节码对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * 			创建实例，解析类名，放入map集合
	 * 		
	 */
	private void IsAnnotationPresent(Class<?> clazz)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object usercontroller = clazz.getConstructor().newInstance();// 创建对象
		String key = clazz.getSimpleName();// UserController获取类名
		String initialStr = key.substring(0, 1);// 获取首字母
		String lowerCase = initialStr.toLowerCase();// 将首字母转成小写
		key = key.replace(initialStr, lowerCase);// 将类名首字母替换成小写字母
		beanMap.put(key, usercontroller);// 添加到map中
	}

	/**
	 * @param sourcePath 要扫描的包路径
	 */
	private void doScan(String sourcePath) {
		String urlpath = sourcePath.replace(".", "/");// 解析路径。
		URL urlRoot = this.getClass().getClassLoader().getResource(urlpath);// 获取项目根路径对象。
		String urlfile = urlRoot.getFile();// 获取项目根路径名。

		File filePath = new File(urlfile);

		String[] listFile = filePath.list();// 目录下的所有文件名

		for (String fileNameList : listFile) {
			File fileName = new File(urlfile + "/" + fileNameList);// 根路径+文件名

			if (fileName.isDirectory()) {// 如果是文件夹
				doScan(urlpath + "/" + fileNameList);// 递归调用
			} else {
				fileNameList = fileNameList.replace(".class", "");
				classNames.add(sourcePath.replace("/", ".") + "." + fileNameList);// 将获取到的类名解析添加到list集合
			}
			continue;// 跳出循环
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String contextPath = req.getContextPath();//  /ImpSpringMvc
		String requestURI = req.getRequestURI();//   /ImpSpringMvc/user/add
		System.out.println(requestURI);
		String methodMapping = requestURI.replace(contextPath, "");//  /user/add?xxxxxxx
//		System.out.println("有请求参数："+methodMapping);
//		int indexOf = methodMapping.indexOf("?");	//获取请求参数的问好索引。
//		methodMapping = methodMapping.substring(0, indexOf-1);//从0开始到问号处截取
		System.out.println(methodMapping);
		UserController userController = (UserController) beanMap.get("userController");
		Method method = (Method) reqMapping.get(methodMapping);
		String name = req.getParameter("name");
		System.out.println("参数name："+name);
		if (method != null) {
			try {
				String result = (String) method.invoke(userController, name);
				if(result!=null) {
					writer.write(result);
				}else {
					System.out.println("没有获取到返回值");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("没有获取到映射的方法");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
