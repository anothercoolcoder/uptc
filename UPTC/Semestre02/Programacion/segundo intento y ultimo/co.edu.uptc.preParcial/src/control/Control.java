package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String Tablet(String codigo, String marca, String precio, String screenSize, String sim, String stylus){
        return logic.tablet(codigo, marca, precio, Double.parseDouble(screenSize),Boolean.parseBoolean(sim),Boolean.parseBoolean(stylus));
    }
    public String Phone(String codigo, String marca, String precio, String number, String os, String cameras){
        return logic.phone(codigo, marca, precio, number, os, Integer.parseInt(cameras));
    }
    public String Computer(String codigo, String marca, String precio, String os, String ram, String gpu){
        return logic.computer(codigo, marca, precio, os, Integer.parseInt(ram), Boolean.parseBoolean(gpu));
    }
    public String showDevices(){
        return logic.showDevices();
    }
    public String deviceCode(String code) throws Exception {
        return logic.searchDevice(code);
    }
    public String deletedevice(String code){
        return logic.deleteDevice(code);
    }

}
