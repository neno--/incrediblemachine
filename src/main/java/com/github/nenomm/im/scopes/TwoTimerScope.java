package com.github.nenomm.im.scopes;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TwoTimerScope implements Scope {
	static Logger logger = LoggerFactory.getLogger(TwoTimerScope.class);
	private static int REUSE_TIMES = 2;

	private class ScopedResource {
		private int count;
		private Object object;

		public ScopedResource(Object object) {
			this.object = object;
			count = 0;
		}

		public boolean isOverUsed() {
			return count >= (REUSE_TIMES - 1);
		}

		public void registerUsage() {
			count++;
		}

		public Object getObject() {
			return object;
		}
	}

	private Map<String, ScopedResource> scope = new HashMap<>();

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		ScopedResource resource = scope.remove(name);

		if (resource == null || (resource.isOverUsed())) {
			scope.put(name, new ScopedResource(objectFactory.getObject()));
		}
		else {
			resource.registerUsage();
			scope.put(name, resource);
		}

		return scope.get(name).getObject();
	}

	@Override
	public Object remove(String name) {
		return null;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		logger.warn("TwoTimerScope does not support destruction callbacks. " +
				"Consider using RequestScope in a web environment.");
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}
}
