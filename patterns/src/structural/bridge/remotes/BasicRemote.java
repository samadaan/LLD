package structural.bridge.remotes;

import structural.bridge.devices.Device;

public class BasicRemote implements Remote{

    protected Device device;

    public BasicRemote(Device device){
        this.device=device;
    }
    @Override
    public void power() {
        System.out.println("Remote: power Toggle");
        if(device.isEnabled()){
            device.disable();
        }else{
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume Down");
        device.setVolume(device.getVolume()-10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Volume Up");
        device.setVolume(device.getVolume()+10);
    }

    @Override
    public void channelDown() {
        System.out.println("Channel Down");
        device.setChannel(device.getChannel()-1);
    }

    @Override
    public void channelUp() {
        System.out.println("Channel Up");
        device.setChannel(device.getChannel()+1);
    }
}
