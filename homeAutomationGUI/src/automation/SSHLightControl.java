package automation;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.InputStream;
import java.util.Properties;

public class SSHLightControl {

    public void SSHLightControl(int input) {
        try {
        	String command = null;
        	
        	if(input == 1) {
        		command = "cd Desktop; ./lightOn.sh";
        	}
        	else if (input == 0) {
        		command = "cd Desktop; ./lightOff.sh";
        	}
        	
        	System.out.println(command);
        	
            JSch jsch = new JSch();

            Session session = jsch.getSession("pi", "169.254.107.255", 22);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.setPassword("pi");
            session.connect();


            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream is = channel.getInputStream();

            System.out.println("Connect to session...");
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (is.available() > 0) {
                    int i = is.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}