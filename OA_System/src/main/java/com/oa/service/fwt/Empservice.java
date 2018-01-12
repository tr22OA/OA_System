package com.oa.service.fwt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.jpa.IDeptdao;
import com.oa.dao.jpa.IEmpdao;
import com.oa.dao.jpa.IJobdao;
import com.oa.pojos.OaDept;
import com.oa.pojos.OaEmp;
import com.oa.pojos.OaJob;
import com.oa.vo.fwt.OaEmpvo;

@Service
@Transactional
public class Empservice {
	@Autowired
	IEmpdao empdao;
	
	@Autowired
	IDeptdao deptdao;
	
	@Autowired
	IJobdao jobdao;
	
	public List<OaJob> findJob(){
		return jobdao.queryJob();
	}
	
	/**
	 * 获取所有部门
	 * @return
	 */
	public List<OaDept> findDept(){
		List<OaDept> list = deptdao.queryDept();
		return list;
 	}
	
	
	/**
	 * 获取员工信息
	 * @param page
	 * @param limit
	 * @return
	 */
	public Map<String,Object> findEmppage(int page,int limit,String dept,String name,String type,String state,String begindate,String enddate){
		Pageable p = new PageRequest(page-1, limit);
		Specification<OaEmp> specification=new Specification<OaEmp>(){
			
			@Override
			public Predicate toPredicate(Root<OaEmp> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				List<Predicate> list = new ArrayList<Predicate>();
				if(dept != null && !dept.equals("")){
					Join<OaEmp,OaDept> join = root.join("oaDept", JoinType.INNER);
		            Path<String> exp4 = join.get("deptId");
		            list.add(cb.equal(exp4,dept));
				}
				if(name != null && !name.equals("")){
					list.add(cb.like(root.get("empName").as(String.class), "%"+name+"%"));
				}
				if(type != null && !type.equals("")){
					list.add(cb.equal(root.get("empType").as(String.class), type));
				}
				if(state != null && !state.equals("")){
					list.add(cb.equal(root.get("empWorkstate").as(String.class), state));
				}
				if(!("".equals(begindate)) && begindate != null){
					list.add(cb.greaterThan(root.get("empEntrydate"), toDate(begindate)));
				}
				if(!("".equals(enddate)) && enddate != null){
					list.add(cb.lessThan(root.get("empEntrydate"), toDate(enddate)));
				}
				
				
				return cb.and(list.toArray(new Predicate[list.size()]));
			}
			
		};
		Page<OaEmp> pa= empdao.findAll(specification, p);
		List<OaEmpvo> list = empToVolist(pa.getContent());
		Map<String, Object> dataMap=new HashMap<>();
		dataMap.put("code", 0);
		dataMap.put("count", empdao.queryEmpcount());
		dataMap.put("data", list);
		return dataMap;
	}

	private List<OaEmpvo> empToVolist(List<OaEmp> list2) {
		// TODO Auto-generated method stub
		List<OaEmpvo> list = new ArrayList<OaEmpvo>();
		for(OaEmp o:list2){
			list.add(toVo(o));
		}
		return list;
	}

	private OaEmpvo toVo(OaEmp o) {
		// TODO Auto-generated method stub
		OaEmpvo vo = new OaEmpvo();
		OaDept dept = o.getOaDept();
		vo.setDeptName(dept.getDeptName());
		vo.setEmpName(o.getEmpName());
		vo.setEmpId(o.getEmpId());
		vo.setEmpSex(o.getEmpSex() == 1?"男":"女");
		vo.setEmpBirth(o.getEmpBirth()+"");
		vo.setEmpType(o.getEmpType() == 0?"临时工":(o.getEmpType() == 1?"合同工":"正式工"));
		vo.setEmpWorkstate(o.getEmpWorkstate() == 0?"离职":"在职");
		OaJob job = o.getOaJob();
		vo.setJobName(job.getJobName());
		vo.setJobLevel(job.getJobLevel());
		vo.setEmpEntrydate(o.getEmpEntrydate()+"");
		return vo;
	}
	
	private Date toDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
