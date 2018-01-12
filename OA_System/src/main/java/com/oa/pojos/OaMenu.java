package com.oa.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the oa_menu database table.
 * 
 */
@Entity
@Table(name="oa_menu")
@NamedQuery(name="OaMenu.findAll", query="SELECT o FROM OaMenu o")
public class OaMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id")
	private int menuId;

	@Column(name="menu_father")
	private int menuFather;

	@Column(name="menu_img")
	private String menuImg;

	@Column(name="menu_isvisible")
	private int menuIsvisible;

	@Column(name="menu_link")
	private String menuLink;

	@Column(name="meu_name")
	private String meuName;

	@ManyToMany
	@JoinTable(
		name="dept_power"
		, joinColumns={
			@JoinColumn(name="menu_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="dept_id")
			}
		)
	private List<OaDept> oaDepts;

	@ManyToMany(mappedBy="oaMenus")
	private List<OaRole> oaRoles;


	public OaMenu() {
	}

	public OaMenu(String menuId, String meuName, String menuLink, String menuFather, String menuIsvisible) {
		if(menuId!=null&&!"".equals(menuId))this.menuId=Integer.parseInt(menuId);
		this.meuName=meuName;
		this.menuLink=menuLink;
		if(menuFather!=null&&!"".equals(menuFather))this.menuFather=Integer.parseInt(menuFather);
		if(menuIsvisible!=null&&!"".equals(menuIsvisible))this.menuIsvisible=Integer.parseInt(menuIsvisible);
		
	}


	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuFather() {
		return this.menuFather;
	}

	public void setMenuFather(int menuFather) {
		this.menuFather = menuFather;
	}

	public String getMenuImg() {
		return this.menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public int getMenuIsvisible() {
		return this.menuIsvisible;
	}

	public void setMenuIsvisible(int menuIsvisible) {
		this.menuIsvisible = menuIsvisible;
	}

	public String getMenuLink() {
		return this.menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	public String getMeuName() {
		return this.meuName;
	}

	public void setMeuName(String meuName) {
		this.meuName = meuName;
	}

	@Override
	public String toString() {
		return "OaMenu [menuId=" + menuId + ", menuFather=" + menuFather + ", menuImg=" + menuImg + ", menuIsvisible="
				+ menuIsvisible + ", menuLink=" + menuLink + ", meuName=" + meuName + "]";
	}


	public void setOaDepts(List<OaDept> oaDepts) {
		this.oaDepts = oaDepts;
	}

	public List<OaRole> getOaRoles() {
		return this.oaRoles;
	}

	public void setOaRoles(List<OaRole> oaRoles) {
		this.oaRoles = oaRoles;
	}

}