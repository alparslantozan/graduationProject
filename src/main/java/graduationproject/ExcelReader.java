/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2017, alparslantozan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package main.java.graduationproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alparslantozan
 */
public class ExcelReader {

    public ExcelReader() {
    }

    public List<MetricsOfClass> listOfAllClassMetrics(String excelFilePath) throws IOException {
        List<MetricsOfClass> projectClasses = new ArrayList<>();
        // Getting resource(File) from class loader  
        File configFile = new File(excelFilePath);

        try (FileInputStream inputStream = new FileInputStream(configFile); Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                String name = "";
                MetricsForClassesDto aMetricSet = new MetricsForClassesDto();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            name = getCellValue(nextCell).toString();
                            break;
                        case 1:
                            aMetricSet.setATFD((int) Math.round((double) getCellValue(nextCell)));
                            break;
                        case 2:
                            aMetricSet.setWMC(new Float((double) getCellValue(nextCell)));
                            break;
                        case 3:
                            aMetricSet.setTCC(new Float((double) getCellValue(nextCell)));
                            break;
                        case 4:
                            aMetricSet.setNAS((int) Math.round((double) getCellValue(nextCell)));
                            break;
                        case 5:
                            aMetricSet.setPNAS(new Float((double) getCellValue(nextCell)));
                            break;
                        case 6:
                            aMetricSet.setAMW(new Float((double) getCellValue(nextCell)));
                            break;
                        case 7:
                            aMetricSet.setNOM((int) Math.round((double) getCellValue(nextCell)));
                            break;
                    }
                }
                MetricsOfClass classMetric = new MetricsOfClass(name, aMetricSet);
                projectClasses.add(classMetric);
            }

        }

        return projectClasses;
    }

    public List<MetricsOfMethod> listAllMethods(String excelFilePath) throws IOException {
        List<MetricsOfMethod> projectMethods = new ArrayList<>();
        // Getting resource(File) from class loader  
        File configFile = new File(excelFilePath);

        try (FileInputStream inputStream = new FileInputStream(configFile); Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                String name = "";
                MetricsForMethodsDto aMetricSet = new MetricsForMethodsDto();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            name = getCellValue(nextCell).toString();
                            break;
                        case 1:
                            aMetricSet.setCINT((int) Math.round((double) getCellValue(nextCell)));
                            break;
                        case 2:
                            aMetricSet.setCDISP(new Float((double) getCellValue(nextCell)));
                            break;
                        case 3:
                            aMetricSet.setMAXNESTING((int) Math.round((double) getCellValue(nextCell)));
                            break;
                    }
                }
                MetricsOfMethod methodMetric = new MetricsOfMethod(name, aMetricSet);
                projectMethods.add(methodMetric);
            }

        }
        return projectMethods;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }
}
