package org.test.toolkit.server.ftp.command.sftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public abstract class SftpCommandWithoutResult extends SftpCommand {

	public SftpCommandWithoutResult(Session session) {
		super(session);
	}

	@Override
	Object runCommandByChannelWithResult(ChannelSftp channelSftp) throws SftpException {
		runCommandByChannel(channelSftp);
		return null;
	}

	protected abstract void runCommandByChannel(ChannelSftp channelSftp) throws SftpException;
}
