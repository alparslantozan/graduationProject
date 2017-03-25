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

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alparslantozan
 */
public class GraduationProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraduationProjectGUI gui = new GraduationProjectGUI();
        gui.setVisible(true);
//        try {
//            ExcelReader excelReader = new ExcelReader();
//            MetricInterpreter metricInterpreter = new MetricInterpreter();
//            List<MetricsOfClass> classMetrics = excelReader.listOfAllClassMetrics("resources/metrics.xlsx");
//            metricInterpreter.classMetricInterpreter(classMetrics);
//            List<MetricsOfMethod> methodMetrics = excelReader.listAllMethods("resources/methods.xlsx");
//            metricInterpreter.methodMetricInterpreter(methodMetrics);
//        } catch (IOException ex) {
//            Logger.getLogger(GraduationProject.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
