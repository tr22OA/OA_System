package com.oa.controller.hq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oa.vo.hq.FindJxVo;
import com.oa.vo.hq.KhScoreVo;
import com.oa.vo.hq.MyJxVo;

@Controller
public class MyJxController {
	/**
	 * 返回到'我的绩效'界面
	 * @return
	 */
	@RequestMapping("/to_myJx")
	public String toMyJx(){
		return "myJx";
	}
	
	/**
	 * 获取'我的绩效'数据
	 * @return
	 */
	@RequestMapping("/myJx_list")
	public @ResponseBody Map<String, Object> myJxList(){
		Map<String, Object> map=new HashMap<>();
		List<MyJxVo> list = new ArrayList<>();
		list.add(new MyJxVo(1,"优秀",90,90,90,"总体表现很不错"));
		list.add(new MyJxVo(1,"良好",85,84,86,"工作认真"));
		list.add(new MyJxVo(2,"合格",72,74,72,"还应继续努力"));
		list.add(new MyJxVo(3,"优秀",93,92,95,"很棒"));
		list.add(new MyJxVo(4,"不合格",55,60,50,"要加油吖"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'绩效查询'界面
	 * @return
	 */
	@RequestMapping("/to_find_jx")
	public String toFindJx(){
		return "findJx";
	}
	
	/**
	 * 获取'绩效查询'数据
	 * @return
	 */
	@RequestMapping("/find_jx_list")
	public @ResponseBody Map<String, Object> findJxList(){
		Map<String, Object> map=new HashMap<>();
		List<FindJxVo> list = new ArrayList<>();
		list.add(new FindJxVo("竹笛",1,"优秀",90,90,"总体表现很不错"));
		list.add(new FindJxVo("紫雪儿",1,"良好",84,86,"工作认真"));
		list.add(new FindJxVo("莉莉",2,"合格",74,72,"还应继续努力"));
		list.add(new FindJxVo("敏儿",3,"优秀",92,95,"很棒"));
		list.add(new FindJxVo("晓晓",4,"不合格",60,50,"要加油吖"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'考核评分'界面
	 * @return
	 */
	@RequestMapping("/to_kh_score")
	public String toKhScore(){
		return "khScore";
	}
	
	/**
	 * 获取'考核评分'数据
	 * @return
	 */
	@RequestMapping("/find_kh_score_list")
	public @ResponseBody Map<String, Object> findKhScoreList(){
		Map<String, Object> map=new HashMap<>();
		List<KhScoreVo> list = new ArrayList<>();
		list.add(new KhScoreVo("员工绩效","自评","晓晓","2018-01-01","2018-01-02"));
		list.add(new KhScoreVo("考核1","自评","竹笛","2018-01-2","2018-01-03"));
		list.add(new KhScoreVo("考核1","经理评","莉莉","2018-01-6","2018-01-07"));
		list.add(new KhScoreVo("考核2","自评","雪儿","2018-01-9","2018-01-10"));
		list.add(new KhScoreVo("考核3","自评","水麒麟","2018-01-12","2018-01-13"));
		map.put("data", list);
		map.put("count", list.size());
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 返回到'考核任务'界面
	 * @return
	 */
	@RequestMapping("/to_Kh_examtask")
	public String toKhExamtask(){
		return "khExamtask";
	}
	
	/**
	 * 返回到'考核模板'界面
	 * @return
	 */
	@RequestMapping("/to_kh_pertemp")
	public String toKhPertemp(){
		return "khPertemp";
	}
	
}
