package com.ticket.actor;

public class ActorVO {
	private int actorSeq;      // 배우SEQ
	private String actorName;  // 배우명
	private int actorPriority; // 배우우선순위
	private int actorRole;     // 배역SEQ
	private int actorRound;     // 회차정보SEQ
	
	public ActorVO() {
		
	}
	
	public int getActorRound() {
		return actorRound;
	}
	public void setActorRound(int actorRound) {
		this.actorRound = actorRound;
	}
	public int getActorSeq() {
		return actorSeq;
	}
	public void setActorSeq(int actorSeq) {
		this.actorSeq = actorSeq;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getActorPriority() {
		return actorPriority;
	}
	public void setActorPriority(int actorPriority) {
		this.actorPriority = actorPriority;
	}
	public int getActorRole() {
		return actorRole;
	}
	public void setActorRole(int actorRole) {
		this.actorRole = actorRole;
	}
	
	

}
