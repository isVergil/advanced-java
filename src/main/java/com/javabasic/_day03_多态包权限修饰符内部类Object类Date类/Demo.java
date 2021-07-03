package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 15:39
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        USB xiaomi = new Mouse("小米");
        computer.installUSB(xiaomi);

        USB sfy = new KeyBoard("双飞燕");
        computer.installUSB(sfy);

    }
}

//电脑设备
class Computer {
    //提供一个安装USB设备的入口
    public void installUSB(USB device) {
        device.connect();
        if (device instanceof Mouse) {
            Mouse temp = (Mouse) device;
            temp.dbclick();
        }
        if (device instanceof KeyBoard) {
            KeyBoard temp = (KeyBoard) device;
            temp.keyDown();
        }
        device.unconnect();
    }
}

//鼠标设备
class Mouse implements USB {
    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    //双击
    public void dbclick() {
        System.out.println(name + "鼠标双击了");
    }

    @Override
    public void connect() {
        System.out.println(name + "成功接入了设备！");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "成功拔出了设备！");
    }
}

//键盘设备
class KeyBoard implements USB {
    private String name;

    public KeyBoard(String name) {
        this.name = name;
    }

    //键盘按键
    public void keyDown() {
        System.out.println(name + "键盘按键");
    }

    @Override
    public void connect() {
        System.out.println(name + "成功接入了设备！");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "成功拔出了设备！");
    }
}

//定义USB的规范  接入和拔出功能
interface USB {
    void connect();    //接入

    void unconnect();  //拔出
}
