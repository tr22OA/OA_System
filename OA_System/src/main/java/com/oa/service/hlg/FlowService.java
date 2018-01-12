package com.oa.service.hlg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.LeaveDao;
import com.oa.dao.jpa.OaflowDao;
import com.oa.pojos.OaFlow;

@Service
@Transactional
public class FlowService {
	@Autowired
	private LeaveDao leaveDao;
	@Autowired
	private OaflowDao oaflowDao;
	
	/**
	 * 查询待办流程
	 */
	public List<OaFlow> queryFlowAll(int state,int step){
		List<OaFlow> list=new ArrayList<>();
		if(state==1&&step==1){
			list = oaflowDao.queryFlowAll(state, step);
		}
		return list;
	}
}
