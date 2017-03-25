/*
 *   Copyright (C) 2017, alparslantozan
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
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
