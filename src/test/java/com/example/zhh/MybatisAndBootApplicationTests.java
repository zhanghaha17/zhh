package com.example.zhh;


import com.example.zhh.controller.TimerThread;
import com.example.zhh.dao.TRoleMapper;
import com.example.zhh.dao.TTaishiMapper;
import com.example.zhh.dao.UserMapper;
import com.example.zhh.pojo.SysLog;
import com.example.zhh.pojo.User;
import com.example.zhh.service.SysLogDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisAndBootApplicationTests {


	public MybatisAndBootApplicationTests() {
	}

	@Resource
	private UserMapper userMapper;
	@Resource
	private TRoleMapper tRoleMapper;
	@Resource
	private SysLogDao sysLogDao;
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private TTaishiMapper tTaishiMapper;
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	@Before//在所有测试方法执行前执行
	public void setupMockMvc(){
		mockMvc  = MockMvcBuilders.webAppContextSetup(wac).build();
		MockHttpSession session = new MockHttpSession();
		User user =new User();
		user.setUsername("Dopa");
		user.setPassword("ac3af72d9f95161a502fd326865c2f15");
		session.setAttribute("user", user);
	}
	@Test
	public void contextLoads() {
//		User mrbird = userMapper.findByUserName("mrbird");
//		System.out.println(mrbird.toString());
//
//		List<TRole> polePer = tRoleMapper.getPolePer("2");
//		System.out.println("xixi"+polePer.size());

/*		List<TRole> rolePer2 = tRoleMapper.getRolePer2("1");
		System.out.println("xixi"+rolePer2.toString());*/
		SysLog sysLog = new SysLog();
		sysLog.setCreateTime(new Date(System.currentTimeMillis()));
		sysLog.setIp("127.0.0.1");
		sysLog.setMethod("put");
		sysLog.setOperation("update");
		sysLog.setParams("object");
		sysLog.setTime(0);
		sysLog.setUsername("lfqlfq");
		sysLogDao.saveSysLog(sysLog);
//新增1000条da_case
//


	}

	@Test
	public void taishi(){
//		TTaishi tTaishi = new TTaishi();
//		tTaishi.setId(UUID.randomUUID().toString());
//		tTaishi.setTime(new Date());
//		Random random = new Random();
//		tTaishi.setValue(String.valueOf(random.nextInt(1)));
//		tTaishiMapper.insert(tTaishi);
		//new TimerThread().start();
		String str = "线aaa线";
		String aa = str.replace("线", "");
		System.out.println(aa);

		try{
			int i = 1/0;
		}catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("xixihaha");

	}

	@Test
	public void test1() {
		Byte[] bytes = new Byte[]{120,122,12,28,16,24,52};

		Random rand = new Random();
		int MAX = 22, MIN = 11;
		for (int i = 0; i < 10; i++) {
			System.out.print(rand.nextInt(MAX - MIN + 1) + MIN + " ");
		}
	}
//62 100 76 96 80 66 67 10 55 16
	//遍历工作簿中的所有数据
	ArrayList<User> userss = new ArrayList<>();
	@Test
	public void ReadExcel(){
		try {
			//创建工作簿对象
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\user\\Desktop\\777888.xlsx"));
			//获取工作簿下sheet的个数
			int sheetNum = xssfWorkbook.getNumberOfSheets();
			System.out.println("该excel文件中总共有："+sheetNum+"个sheet");

			for(int i = 0;i<sheetNum;i++) {
				//读取第i个工作表
				System.out.println("读取第"+(i+1)+"个sheet");
				XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
				//获取最后一行的num，即总行数。此处从0开始
				int maxRow = sheet.getLastRowNum();
				for (int row = 0; row <= maxRow; row++) {
					//获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
					int maxRol = sheet.getRow(row).getLastCellNum();
					System.out.println("--------第" + row + "行的数据如下--------");
					for (int rol = 0; rol < maxRol; rol++){
						XSSFCell cell = sheet.getRow(row).getCell(rol);
						if(cell!=null){
							// 判断是否是时间格式
							if (cell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(cell))
							{
								SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
								Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
								String value = sdf.format(date);
								if(!"".equals(value)&&value.contains(":")){
									String[] split = value.split(":");
									if("00".equals(split[1])||"30".equals(split[1])){
										User user = new User();
										user.setStatus(value);
										user.setUsername(sheet.getRow(row).getCell(2)+"");
										userss.add(user);
									}
								}
								System.out.println("时间是"+value);
							}
						}

						System.out.print(sheet.getRow(row).getCell(rol) + "  ");
					}
					System.out.println();
				}
				writeExcel();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	
	@Test
	public void writeExcel(){
		//第一步，创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//第二部，在workbook中创建一个sheet对应excel中的sheet
		HSSFSheet sheet = workbook.createSheet("用户表一");
		//第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		HSSFRow row = sheet.createRow(0);
		//第四步，创建单元格，设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("用户名");
		cell = row.createCell(1);
		cell.setCellValue("密码");

		//第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
		List<User> users = getUsers();
		for (int i = 0; i < users.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 1);
			User user = users.get(i);
			//创建单元格设值
			row1.createCell(0).setCellValue(user.getUsername());
			row1.createCell(1).setCellValue(user.getStatus());
		}

		File file = new File("D:/user22.xls");
		if (file.exists()) {
			file.delete();
		}
		//将文件保存到指定的位置
		try {
			file.createNewFile();
			workbook.write(file);
			System.out.println("写入成功");
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<User> getUsers() {
		if (userss==null|| userss.isEmpty()){
			User user1 = new User("admin", "123456");
			User user2 = new User("staff1", "141242");
			User user3 = new User("staff2", "386002");
			userss.add(user1);
			userss.add(user2);
			userss.add(user3);
			return userss;
		}else {
			return userss;
		}

	}


	@Test
	public void testCache(){
		PageHelper.startPage(2,1);
		List<User> users = userMapper.queryUserList();
		PageInfo<User> userPageInfo = new PageInfo<>(users);
		List<User> list = userPageInfo.getList();
		for (User user:list) {
			System.out.println(user.toString());
		}
//		userMapper.queryUserList();
//		userMapper.queryUserList();
//		System.out.println("success");
	}

	@Test
	@Transactional
	public void testController(){
		try {
//			controller层单元测试
			mockMvc.perform(MockMvcRequestBuilders.get("/user/queryAllUser")).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJs(){
//		java中调用js的方法
		String str = "3*8";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		Double result = null;

		try {
			result = Double.valueOf(se.eval(str).toString());
			if (result == null) {
				result = new Double(0);
			}
			System.out.println(result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
}
