package com.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class XlsRead {

    private List<Command> commandList = new ArrayList<Command>();

    public void read() throws IOException {

        FileInputStream inputStream = new FileInputStream(new File("C:/BinaryConverter/Conf.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();



        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() > 0) {
                commandList.add(new Command(sheet.getRow(row.getRowNum()).getCell(0).getStringCellValue(), sheet.getRow(row.getRowNum()).getCell(1).getStringCellValue(), sheet.getRow(row.getRowNum()).getCell(2).getStringCellValue()));
            }

        }
      /*  for (Command command : commandList)
        {
            System.out.println(command.getAct());
            System.out.println(command.getParam());
            System.out.println(command.getDesc());
        }*/
    }

    public List<Command> getConf()
    {
        return commandList;
    }
}

