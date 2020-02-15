import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            String user = "test_user";
            String pass = "test";
            Properties config = new Properties();
            config.put("StrictHostKeyChecking","no");
            String host = "127.0.0.1";

            JSch jSch = new JSch();
            Session session = jSch.getSession(user,host);
            session.setPassword(pass);
            session.setConfig(config);
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            Vector fileList = channelSftp.ls("inbound/");
            for (int i = 0; i < fileList.size(); i++) {
                ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry) fileList.get(i);
                System.out.println(lsEntry.getFilename());
            }

//channelSftp.rename("inbound/newFile.txt","inbound/newFile2.txt");
//            //            channelSftp.put("D:\\Personal\\Github\\Youtube-Tutorial\\JavaSFTPConnection\\newFile.txt","inbound/newFile.txt");

            channelSftp.get("inbound/newFile2.txt","newFile2.txt");
            System.out.println("Session connected: "+session.isConnected());
            channelSftp.disconnect();
            session.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

