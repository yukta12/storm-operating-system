package BackEnd.ScreenMirroring;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientSide {
    /*private DatagramSocket clientSocket;
    private Robot robot;

    public ClientSide(final String ipAddress,
                      final int port) {
        try {
            this.clientSocket = new DatagramSocket(port, InetAddress.getByName(ipAddress));
        } catch(Exception uhe) {
            uhe.printStackTrace();
        }
        try {
            this.robot = new Robot();
        }
        catch(AWTException awtException) {
            awtException.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                sendData();
            }
        };
    }
    private void sendData() {
        while(true) {
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle((0,0,1920,1080)));
            byte[][] frames;
            try {
                frames = ImageUtils.splitImage(screenShot, 2048);

                String packetCount = frames.length + "";
                DatagramPacket packet = new DatagramPacket(packetCount.getBytes(), packetCount.length());
                clientSocket.send(packet);
                for(byte[] bytes : frames) {
                    DatagramPacket imagePacket = new DatagramPacket(bytes, bytes.length);
                    clientSocket.send(imagePacket);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }*/
}
