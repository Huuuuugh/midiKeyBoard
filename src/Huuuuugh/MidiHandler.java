package Huuuuugh;
import javax.sound.midi.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.io.*;
public class MidiHandler
{
    static File[] files = new File[88];
    static AudioClip[] sound = new AudioClip[88];
    static AudioClip chosenClip;
    public static void main(String[] args) {
        for (int i = 0; i < files.length; i++) {
            files[i] = new File(System.getProperty("user.dir") + "/piano_music/1 ("+(i+1)+").wav");
            try {
                sound[i] = Applet.newAudioClip(files[i].toURL());
            } catch(OutOfMemoryError e1){
                e1.printStackTrace();
            } catch(Exception e1){
                e1.printStackTrace();
            }
        }

        int a = 65;
        char b = (char)a;
        System.out.println(b);
        int i = 1;
        switch (i){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("d");
        }
        new MidiHandler();
    }

    public MidiHandler()
    {
        MidiDevice device;
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < infos.length; i++) {
            try {
                device = MidiSystem.getMidiDevice(infos[i]);
                //does the device have any transmitters?
                //if it does, add it to the device list
                System.out.println(infos[i]);

                //get all transmitters
                List<Transmitter> transmitters = device.getTransmitters();
                //and for each transmitter

                for(int j = 0; j<transmitters.size();j++) {
                    //create a new receiver
                    transmitters.get(j).setReceiver(
                            //using my own MidiInputReceiver
                            new MidiInputReceiver(device.getDeviceInfo().toString())
                    );
                }

                Transmitter trans = device.getTransmitter();
                trans.setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString()));

                //open each device
                device.open();
                //if code gets this far without throwing an exception
                //print a success message
                System.out.println(device.getDeviceInfo()+" Was Opened");


            } catch (MidiUnavailableException e) {}
        }


    }
    //tried to write my own class. I thought the send method handles an MidiEvents sent to it
    public class MidiInputReceiver implements Receiver{
        public int a = 1;
        public String name;
        public void bindKey(byte b){
            System.out.println("case " + b + ":");
            System.out.println("    r.keyPress(" + "KeyEvent.VK_NUMPAD" + a + ");");
            System.out.println("    break;");
            a++;
        }
        public MidiInputReceiver(String name) {
            this.name = name;
        }//-112按下
        //-128松开
        public void send(MidiMessage msg, long timeStamp) {
            //System.out.println("msg " + msg.getMessage()[1]);
            for (byte a:msg.getMessage()){
                //System.out.println(a);
            }
            byte[] message = msg.getMessage();
            try {
                Robot r = new Robot();
                if(message[0] == -112){//按下
                    //System.out.println(message[1]);
                    Piano piano = new Piano(Integer.parseInt(message[1]+"")-9);
                    piano.start();
                    //r.keyPress(KeyEvent.VK_A);
                    bindKey(message[1]);
                    //System.out.println("press");
                    switch (message[1]){
                        case 83:
                            r.keyPress(0x6e);
                            break;
                        case 46:
                            r.keyPress(KeyEvent.VK_TAB);
                            break;
                        case 9:
                            r.keyPress(KeyEvent.VK_UP);
                            break;
                        case 93:
                            r.keyPress(KeyEvent.VK_DOWN);
                            break;
                        case 91:
                            r.keyPress(KeyEvent.VK_LEFT);
                            break;

                        case 95:
                            r.keyPress(KeyEvent.VK_RIGHT);
                            break;

                        case 39:
                            r.keyPress(KeyEvent.VK_CONTROL);
                            break;
                        case 42:
                            r.keyPress(KeyEvent.VK_SHIFT);
                            break;
                        case 44:
                            r.keyPress(KeyEvent.VK_ALT);
                            break;
                        case 49:
                            r.keyPress(KeyEvent.VK_1);
                            break;
                        case 51:
                            r.keyPress(KeyEvent.VK_2);
                            break;
                        case 54:
                            r.keyPress(KeyEvent.VK_3);
                            break;
                        case 56:
                            r.keyPress(KeyEvent.VK_4);
                            break;
                        case 58:
                            r.keyPress(KeyEvent.VK_5);
                            break;
                        case 61:
                            r.keyPress(KeyEvent.VK_6);
                            break;
                        case 63:
                            r.keyPress(KeyEvent.VK_7);
                            break;
                        case 66:
                            r.keyPress(KeyEvent.VK_8);
                            break;
                        case 68:
                            r.keyPress(KeyEvent.VK_9);
                            break;
                        case 70:
                            r.keyPress(KeyEvent.VK_0);
                            break;

                        case 36:
                            r.keyPress(KeyEvent.VK_A);
                            break;
                        case 38:
                            r.keyPress(KeyEvent.VK_B);
                            break;
                        case 40:
                            r.keyPress(KeyEvent.VK_C);
                            break;
                        case 41:
                            r.keyPress(KeyEvent.VK_D);
                            break;
                        case 43:
                            r.keyPress(KeyEvent.VK_E);
                            break;
                        case 45:
                            r.keyPress(KeyEvent.VK_F);
                            break;
                        case 47:
                            r.keyPress(KeyEvent.VK_G);
                            break;
                        case 48:
                            r.keyPress(KeyEvent.VK_H);
                            break;
                        case 50:
                            r.keyPress(KeyEvent.VK_I);
                            break;
                        case 52:
                            r.keyPress(KeyEvent.VK_J);
                            break;
                        case 53:
                            r.keyPress(KeyEvent.VK_K);
                            break;
                        case 55:
                            r.keyPress(KeyEvent.VK_L);
                            break;
                        case 57:
                            r.keyPress(KeyEvent.VK_M);
                            break;
                        case 59:
                            r.keyPress(KeyEvent.VK_N);
                            break;
                        case 60:
                            r.keyPress(KeyEvent.VK_O);
                            break;
                        case 62:
                            r.keyPress(KeyEvent.VK_P);
                            break;
                        case 64:
                            r.keyPress(KeyEvent.VK_Q);
                            break;
                        case 65:
                            r.keyPress(KeyEvent.VK_R);
                            break;
                        case 67:
                            r.keyPress(KeyEvent.VK_S);
                            break;
                        case 69:
                            r.keyPress(KeyEvent.VK_T);
                            break;
                        case 71:
                            r.keyPress(KeyEvent.VK_U);
                            break;
                        case 72:
                            r.keyPress(KeyEvent.VK_V);
                            break;
                        case 74:
                            r.keyPress(KeyEvent.VK_W);
                            break;
                        case 76:
                            r.keyPress(KeyEvent.VK_X);
                            break;
                        case 77:
                            r.keyPress(KeyEvent.VK_Y);
                            break;
                        case 79:
                            r.keyPress(KeyEvent.VK_Z);
                            break;

                        case 84:
                            r.keyPress(KeyEvent.VK_SPACE);
                            break;
                        case 88:
                            r.keyPress(KeyEvent.VK_BACK_SPACE);
                            break;
                        case 86:
                            r.keyPress(KeyEvent.VK_WINDOWS);
                            break;
                        case 96:
                            r.keyPress(KeyEvent.VK_ESCAPE);
                            break;
                        case 90:
                            r.keyPress(KeyEvent.VK_ENTER);
                            break;
                        case 37:
                            r.keyPress(0x6F);
                            break;
                    }
                }
                if(message[0] == -128){//松开
                    //System.out.println("release");
                    switch (message[1]){
                        case 83:
                            r.keyRelease(0x6e);
                            break;
                        case 46:
                            r.keyRelease(KeyEvent.VK_TAB);
                            break;
                        case 94:
                            r.keyRelease(KeyEvent.VK_UP);
                            break;
                        case 93:
                            r.keyRelease(KeyEvent.VK_DOWN);
                            break;
                        case 91:
                            r.keyRelease(KeyEvent.VK_LEFT);
                            break;

                        case 95:
                            r.keyRelease(KeyEvent.VK_RIGHT);
                            break;
                        case 39:
                            r.keyRelease(KeyEvent.VK_CONTROL);
                            break;
                        case 42:
                            r.keyRelease(KeyEvent.VK_SHIFT);
                            break;
                        case 44:
                            r.keyRelease(KeyEvent.VK_ALT);
                            break;
                        case 49:
                            r.keyRelease(KeyEvent.VK_1);
                            break;
                        case 51:
                            r.keyRelease(KeyEvent.VK_2);
                            break;
                        case 54:
                            r.keyRelease(KeyEvent.VK_3);
                            break;
                        case 56:
                            r.keyRelease(KeyEvent.VK_4);
                            break;
                        case 58:
                            r.keyRelease(KeyEvent.VK_5);
                            break;
                        case 61:
                            r.keyRelease(KeyEvent.VK_6);
                            break;
                        case 63:
                            r.keyRelease(KeyEvent.VK_7);
                            break;
                        case 66:
                            r.keyRelease(KeyEvent.VK_8);
                            break;
                        case 68:
                            r.keyRelease(KeyEvent.VK_9);
                            break;
                        case 70:
                            r.keyRelease(KeyEvent.VK_0);
                            break;

                        case 36:
                            r.keyRelease(KeyEvent.VK_A);
                            break;
                        case 38:
                            r.keyRelease(KeyEvent.VK_B);
                            break;
                        case 40:
                            r.keyRelease(KeyEvent.VK_C);
                            break;
                        case 41:
                            r.keyRelease(KeyEvent.VK_D);
                            break;
                        case 43:
                            r.keyRelease(KeyEvent.VK_E);
                            break;
                        case 45:
                            r.keyRelease(KeyEvent.VK_F);
                            break;
                        case 47:
                            r.keyRelease(KeyEvent.VK_G);
                            break;
                        case 48:
                            r.keyRelease(KeyEvent.VK_H);
                            break;
                        case 50:
                            r.keyRelease(KeyEvent.VK_I);
                            break;
                        case 52:
                            r.keyRelease(KeyEvent.VK_J);
                            break;
                        case 53:
                            r.keyRelease(KeyEvent.VK_K);
                            break;
                        case 55:
                            r.keyRelease(KeyEvent.VK_L);
                            break;
                        case 57:
                            r.keyRelease(KeyEvent.VK_M);
                            break;
                        case 59:
                            r.keyRelease(KeyEvent.VK_N);
                            break;
                        case 60:
                            r.keyRelease(KeyEvent.VK_O);
                            break;
                        case 62:
                            r.keyRelease(KeyEvent.VK_P);
                            break;
                        case 64:
                            r.keyRelease(KeyEvent.VK_Q);
                            break;
                        case 65:
                            r.keyRelease(KeyEvent.VK_R);
                            break;
                        case 67:
                            r.keyRelease(KeyEvent.VK_S);
                            break;
                        case 69:
                            r.keyRelease(KeyEvent.VK_T);
                            break;
                        case 71:
                            r.keyRelease(KeyEvent.VK_U);
                            break;
                        case 72:
                            r.keyRelease(KeyEvent.VK_V);
                            break;
                        case 74:
                            r.keyRelease(KeyEvent.VK_W);
                            break;
                        case 76:
                            r.keyRelease(KeyEvent.VK_X);
                            break;
                        case 77:
                            r.keyRelease(KeyEvent.VK_Y);
                            break;
                        case 79:
                            r.keyRelease(KeyEvent.VK_Z);
                            break;
                        case 84:
                            r.keyRelease(KeyEvent.VK_SPACE);
                            break;
                        case 96:
                            r.keyRelease(KeyEvent.VK_ESCAPE);
                            break;
                        case 88:
                            r.keyRelease(KeyEvent.VK_BACK_SPACE);
                            break;
                        case 90:
                            r.keyRelease(KeyEvent.VK_ENTER);
                            break;
                        case 86:
                            r.keyRelease(KeyEvent.VK_WINDOWS);
                            break;
                        case 37:
                            r.keyRelease(0x6F);
                            break;
                    }
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }

        }
        public void close() {}


    }
}
class Piano extends Thread{
    int aaa;
    Piano(int qwq){
        aaa = qwq;
    }
    @Override
    public void run(){
        play(aaa);

    }
    public void play(int i){
        stop(i);
        MidiHandler.chosenClip = MidiHandler.sound[i];
        MidiHandler.chosenClip.play();
    }
    public void stop(int i){
        MidiHandler.chosenClip = MidiHandler.sound[i];
        MidiHandler.chosenClip.stop();
    }
}