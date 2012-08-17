package org.test.toolkit.services.zookeeper.operations;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ExistOperation extends AbstractZookeeperOperationWithWatcher<Stat> {

	private final String path;

	public ExistOperation(ZooKeeper zookeeper, String path, Watcher watcher) {
		super(zookeeper, watcher);
		this.path = path;
	}

	public ExistOperation(ZooKeeper zookeeper, String path, boolean watch) {
		super(zookeeper, watch);
		this.path = path;
	}

	@Override
	public Stat execute() throws KeeperException, InterruptedException {
		if (hasExplicitWatcher)
			return zookeeper.exists(path, watcher);

		return zookeeper.exists(path, watch);
	}

	@Override
	public String operationName() {
		return "exist path: " + path;
	}
}