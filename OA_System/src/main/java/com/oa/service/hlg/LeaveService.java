package com.oa.service.hlg;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 请假服务层
 * @author Administrator
 *
 */

import com.oa.dao.jpa.LeaveDao;
import com.oa.dao.jpa.OaflowDao;
import com.oa.pojos.OaFlow;
import com.oa.pojos.OaLeave;
@Service
@Transactional
public class LeaveService {
	
	
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private OaflowDao oaflowDao;
	
	/**
	 * 新建一个请假申请
	 */
	public void addLeave(OaLeave oaLeave,String type){
		//在请假申请表中添加一条记录
		 leaveDao.save(oaLeave);
		 //请假成功之后，在流程有中添加一条记录，并记录流程状态
		 OaFlow oaFlow=new OaFlow();
		 oaFlow.setEmpName(oaLeave.getLeaName());
		 if(type.equals("1")){
			 oaFlow.setFlowName("请假申请");
			 oaFlow.setFlowTitle("请假申请_"+oaLeave.getLeaName()+"_"+oaLeave.getDept());
			 oaFlow.setFlowType(1);
		 }
		 oaFlow.setFlowState(1);
		 oaFlow.setFlowStep(1);
		 oaFlow.setFlowDate(new Date());
		 oaflowDao.save(oaFlow);
		 
	}
	
}
