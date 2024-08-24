package MakeBot;

import com.jcraft.jsch.*;

public class ServerManager {

    public static void deployBotToServer() {
        String user = "your-username"; // Replace with your SSH username
        String host = "your-server-ip"; // Replace with your server IP
        int port = 22; // Default SSH port
        String privateKey = "/path/to/your/private/key"; // Path to your SSH private key file

        try {
            // Create a new JSch instance
            JSch jsch = new JSch();
            jsch.addIdentity(privateKey); // Add your private key to the JSch session

            // Establish the SSH session
            Session session = jsch.getSession(user, host, port);
            session.setConfig("StrictHostKeyChecking", "no"); // Disable host key checking (optional)
            session.connect(); // Connect to the server

            // Command to deploy and start the bot on the server
            String command = "cd /path/to/bot && nohup java -jar your-bot.jar &";

            // Execute the command
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.connect();

            // Close the channel and session
            channelExec.disconnect();
            session.disconnect();

            System.out.println("Bot deployed and started successfully!");

        } catch (JSchException e) {
            e.printStackTrace(); // Print any errors that occur during the process
        }
    }
}
