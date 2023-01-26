package com.ticket.actor;

public class ActorService {
	
	public ActorDAO actorDao;
	
	public ActorService(ActorDAO actorDao) {
		this.actorDao = actorDao;
	}

}
