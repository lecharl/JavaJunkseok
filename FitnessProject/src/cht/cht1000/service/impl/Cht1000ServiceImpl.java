package cht.cht1000.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cht.cht1000.service.Cht1000Service;
import lck.lck1000.dao.Lck1000Dao;
import lck.lck1000.dao.impl.Lck1000DaoImpl;
import lck.lck1000.service.Lck1000Service;
import lck.lck1000.service.impl.Lck1000ServiceImpl;
import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.dao.impl.Usr1000DaoImpl;
import usr.usr1000.vo.Usr1000Vo;
/**
 * @Class Name : Cht1000ServiceImpl.java
 * @Description : Cht1000ServiceImpl Service class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cht1000ServiceImpl implements Cht1000Service{

	private Usr1000Dao usr1000Dao = Usr1000DaoImpl.getInstance();
	private Lck1000Dao lck1000Dao = Lck1000DaoImpl.getInstance();
	private Lck1000Service lck1000Service = new Lck1000ServiceImpl();
	
	//회원 수
	@Override
	public int countCht1000() {
		return usr1000Dao.countCht1000();
	}	
	
	//임박, 만료 회원 수
	@Override
	public int countCht1000Stt(String status) {
		return usr1000Dao.countCht1000Stt(status);
	}
	
	//회원 목록
	@Override
	public List<Map<String, String>> selectCht1001List()  {
		//dao에서 받아온 걸 각 요소(vo)를 꺼내서 new linkedmap에 저장
		List<Usr1000Vo> usrList = usr1000Dao.selectCht1001List();
		LinkedHashMap<String, String> map;
		
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		
		for (Usr1000Vo usrVo : usrList) {
			Field[] fieldArr = usrVo.getClass().getDeclaredFields();
			map = new LinkedHashMap<String, String>();
			for (Field field : fieldArr) {
				field.setAccessible(true);
				String key = field.getName();
				String val = "";
				try {
					val = (String) field.get(usrVo);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.println("usr-조회-필드");
					e.printStackTrace();
				}
				map.put(key, val);
			}
			try {
				Map<String, String> tmpMap = lck1000Service.selectLck1000ById(usrVo.getUsrId());
				map.put("lckNo", tmpMap.get("lckNo"));
			} catch (Exception e) {
//				e.printStackTrace();
			}
			mapList.add(map);
		}
		return mapList;
	}




}
