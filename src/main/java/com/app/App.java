package com.app;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main (String[] args) throws IOException {

        XlsRead r = new XlsRead();
        r.read();
        List<Command> commandList = r.getConf();
        PageTst test = new PageTst();
        for (Command command : commandList)
        {
            switch (command.getAct()) {

                case "openUrl":
                    test.openPage(command.getParam());
                    System.out.println(command.getDesc());
                    break;

                case "Click":
                    test.clickElem(command.getParam());
                    System.out.println(command.getDesc());
                    break;

                case "setValue":
                    String[] res = command.getParam().split("\\|");
                    test.setTxtVal(res[0], res[1]);
                    System.out.println(command.getDesc());
                    break;

                case "checkVis":
                    test.checkVis(command.getParam());
                    System.out.println(command.getDesc());
                    break;

                case "Screenshot":
                    test.prtScr();
                    System.out.println(command.getDesc());
                    break;
            }

        }
        test.closeUp();
    }
}
