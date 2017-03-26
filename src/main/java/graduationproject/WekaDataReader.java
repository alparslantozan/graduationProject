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

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;

import javax.swing.text.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WekaDataReader {

    public WekaDataReader() {
    }

    public void readArff(String trainSet, String testSet, javax.swing.JTextPane learningBasedOutput) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        StyledDocument doc = learningBasedOutput.getStyledDocument();
        AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Lucida Console");
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        try {
            DataSource trainDataSource = new DataSource(trainSet);
            DataSource testDataSource = new DataSource(testSet);
            Instances trainSetData = trainDataSource.getDataSet();
            Instances testSetData = testDataSource.getDataSet();
            if (trainSetData.classIndex() == -1)
                trainSetData.setClassIndex(trainSetData.numAttributes() - 1);
            if (testSetData.classIndex() == -1)
                testSetData.setClassIndex(testSetData.numAttributes() - 1);
            Classifier tree = new J48();
            tree.buildClassifier(trainSetData);

            Evaluation evaluation = new Evaluation(trainSetData);
            evaluation.evaluateModel(tree, testSetData);
            doc.insertString(doc.getLength(), "\nTree\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);
            doc.insertString(doc.getLength(), tree.toString(), attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
            doc.insertString(doc.getLength(), "\nResults\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.DARK_GRAY);
            doc.insertString(doc.getLength(), evaluation.toSummaryString(false), attributeSet);
        } catch (Exception e) {
            Logger.getLogger(GraduationProject.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
