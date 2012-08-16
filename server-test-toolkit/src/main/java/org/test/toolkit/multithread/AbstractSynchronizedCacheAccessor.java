package org.test.toolkit.multithread;

import java.util.Map;

public abstract class AbstractSynchronizedCacheAccessor<K, V> {

	private volatile Map<K, V> map;

	protected AbstractSynchronizedCacheAccessor(Map<K, V> map) {
		super();
		this.map = map;
	}

	public Map<K, V> getMap() {
		return map;
	}

	public void setMap(Map<K, V> map) {
		this.map = map;
	}

	public V getValue(K key, Object synchronizedObject) {
		if (map.containsKey(key))
			return map.get(key);

		synchronized (synchronizedObject) {
			if (map.containsKey(key))
				return map.get(key);

			V value = createValue();
			map.put(key, value);

			return value;
		}
	}

	protected abstract V createValue();
}