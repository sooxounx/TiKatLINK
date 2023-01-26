package com.ticket.role;

public class RoleVO {
	private int roleSeq;      // 배역SEQ
	private String roleName;  // 배역명
	private String roleImage; // 배우이미지
	private int roleNum;      // 인원수
	private int rolePriority; // 배역우선순위
	private int roleProduct;  // 작품SEQ(FK)
	
	public RoleVO() {
		
	}

	public int getRoleSeq() {
		return roleSeq;
	}

	public void setRoleSeq(int roleSeq) {
		this.roleSeq = roleSeq;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleImage() {
		return roleImage;
	}

	public void setRoleImage(String roleImage) {
		this.roleImage = roleImage;
	}

	public int getRoleNum() {
		return roleNum;
	}

	public void setRoleNum(int roleNum) {
		this.roleNum = roleNum;
	}

	public int getRolePriority() {
		return rolePriority;
	}

	public void setRolePriority(int rolePriority) {
		this.rolePriority = rolePriority;
	}

	public int getRoleProduct() {
		return roleProduct;
	}

	public void setRoleProduct(int roleProduct) {
		this.roleProduct = roleProduct;
	}
	
	
}
