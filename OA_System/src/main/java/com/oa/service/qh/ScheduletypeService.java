package com.oa.service.qh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.IScheduletypeDAO;
import com.oa.pojos.OaScheduletype;
import com.oa.vo.qh.ScheduletypeVo;

/**
 * 排班类型业务类
 * @author qh
 *
 */
@Service
@Transactional
public class ScheduletypeService {
	@Autowired
	private IScheduletypeDAO iScheduletypeDAO;
	
	public Map<String, Object> queryAllScheduletype(int page ,int limit) {
		Pageable pageable= new PageRequest(page-1, limit);
		//获取当前页的记录
		List<OaScheduletype> list=iScheduletypeDAO.queryAllByPage(pageable);
		//获取总的记录条数
		long total = iScheduletypeDAO.count();
		Map<String, Object> map = new HashMap<>();
		map.put("count", total);
		map.put("data", MapToList(list));
		map.put("code", 0);
		return map;
	}
	/**
	 * 将map集合转换为map集合
	 * @param list
	 * @return
	 */
	private List<ScheduletypeVo> MapToList(List<OaScheduletype>list){
		if(list==null)return null;
		List<ScheduletypeVo> list2=new ArrayList<>();
		for (OaScheduletype oasheduletype : list) {
			ScheduletypeVo vo= typePojoToVo(oasheduletype);
			list2.add(vo);
		}
		return list2;
	}
	/**
	 * 将排班类型的pojo转换为vo
	 * @param oaScheduletype
	 * @return
	 */
	private ScheduletypeVo typePojoToVo(OaScheduletype oaScheduletype) {
		String week="";
		ScheduletypeVo sVo=new ScheduletypeVo();
		sVo.setShtId(oaScheduletype.getShtId());
		sVo.setShtName(oaScheduletype.getShtName());
		week+=(oaScheduletype.getShtW1()==1?"星期一,":"");
		week+=(oaScheduletype.getShtW2()==1?"星期二,":"");
		week+=(oaScheduletype.getShtW3()==1?"星期三,":"");
		week+=(oaScheduletype.getShtW4()==1?"星期四,":"");
		week+=(oaScheduletype.getShtW5()==1?"星期五,":"");
		week+=(oaScheduletype.getShtW6()==1?"星期六,":"");
		week+=(oaScheduletype.getShtW7()==1?"星期天,":"");
		sVo.setShtWeek(week.substring(0,week.length()-1));
		sVo.setShtRemark(oaScheduletype.getShtRemark());
		sVo.setShtStatus(oaScheduletype.getShtStatus()==1?"启用":"禁用");
		return sVo;
	}
}
