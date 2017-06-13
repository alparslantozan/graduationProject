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

import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.Remove;

import javax.swing.text.*;
import java.awt.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WekaDataReader {

    public WekaDataReader() {
    }

    public void neuralNetworkControl(String trainSet, String testSet, javax.swing.JTextPane learningBasedOutput) {
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
            trainSetData = filterDatasets(trainSetData);
            testSetData = filterDatasets(testSetData);

            if (trainSetData.classIndex() == -1)
                trainSetData.setClassIndex(trainSetData.numAttributes() - 1);
            if (testSetData.classIndex() == -1)
                testSetData.setClassIndex(testSetData.numAttributes() - 1);
            MultilayerPerceptron mlp = new MultilayerPerceptron();
            //Setting Parameters
            mlp.setLearningRate(0.1);
            mlp.setMomentum(0.2);
            mlp.setTrainingTime(2000);
            mlp.setHiddenLayers("3");
            mlp.buildClassifier(trainSetData);

            Evaluation evaluation = new Evaluation(trainSetData);
            //evaluation.evaluateModel(mlp, testSetData);
            evaluation.crossValidateModel(mlp, trainSetData, 10, new Random(10));
            doc.insertString(doc.getLength(), "\nNetwork\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);
            doc.insertString(doc.getLength(), mlp.toString(), attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
            doc.insertString(doc.getLength(), "\nResults\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.DARK_GRAY);
            doc.insertString(doc.getLength(), evaluation.toSummaryString(false), attributeSet);
            doc.insertString(doc.getLength(), evaluation.toMatrixString(), attributeSet);
            doc.insertString(doc.getLength(), "\nRecall = " + String.valueOf( evaluation.recall(0)),attributeSet);
            doc.insertString(doc.getLength(), "\n\nPrecision = " + String.valueOf(evaluation.precision(0)), attributeSet);
        } catch (Exception e) {
            Logger.getLogger(GraduationProject.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void randomForestControl(String trainSet, String testSet, javax.swing.JTextPane learningBasedOutput) {
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
            trainSetData = filterDatasets(trainSetData);
            testSetData = filterDatasets(testSetData);

            if (trainSetData.classIndex() == -1)
                trainSetData.setClassIndex(trainSetData.numAttributes() - 1);
            if (testSetData.classIndex() == -1)
                testSetData.setClassIndex(testSetData.numAttributes() - 1);
            RandomForest rf = new RandomForest();
            rf.buildClassifier(trainSetData);

            Evaluation evaluation = new Evaluation(trainSetData);
            //evaluation.evaluateModel(rf, testSetData);
            evaluation.crossValidateModel(rf, trainSetData, 10, new Random(10));
            doc.insertString(doc.getLength(), "\nForest\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);
            doc.insertString(doc.getLength(), rf.toString(), attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
            doc.insertString(doc.getLength(), "\nResults\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.DARK_GRAY);
            doc.insertString(doc.getLength(), evaluation.toSummaryString(false), attributeSet);
            doc.insertString(doc.getLength(), evaluation.toMatrixString(), attributeSet);
            doc.insertString(doc.getLength(), "\nRecall = " + String.valueOf( evaluation.recall(0)),attributeSet);
            doc.insertString(doc.getLength(), "\n\nPrecision = " + String.valueOf(evaluation.precision(0)), attributeSet);
        } catch (Exception e) {
            Logger.getLogger(GraduationProject.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //recall precission
    public void decisionTreeControl(String trainSet, String testSet, javax.swing.JTextPane learningBasedOutput) {
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
            trainSetData = filterDatasets(trainSetData);
            testSetData = filterDatasets(testSetData);

            if (trainSetData.classIndex() == -1)
                trainSetData.setClassIndex(trainSetData.numAttributes() - 1);
            if (testSetData.classIndex() == -1)
                testSetData.setClassIndex(testSetData.numAttributes() - 1);
            J48 tree = new J48();
            tree.setUnpruned(false);
            tree.buildClassifier(trainSetData);

            Evaluation evaluation = new Evaluation(trainSetData);
            //evaluation.evaluateModel(tree, testSetData);
            evaluation.crossValidateModel(tree, trainSetData, 10, new Random(10));
            doc.insertString(doc.getLength(), "\nTree\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLUE);
            doc.insertString(doc.getLength(), tree.toString(), attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
            doc.insertString(doc.getLength(), "\nResults\n======\n", attributeSet);
            attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.DARK_GRAY);
            doc.insertString(doc.getLength(), evaluation.toSummaryString(false), attributeSet);
            doc.insertString(doc.getLength(), evaluation.toMatrixString(), attributeSet);
            doc.insertString(doc.getLength(), "\nRecall = " + String.valueOf( evaluation.recall(0)),attributeSet);
            doc.insertString(doc.getLength(), "\n\nPrecision = " + String.valueOf(evaluation.precision(0)), attributeSet);
        } catch (Exception e) {
            Logger.getLogger(GraduationProject.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private Instances filterDatasets(Instances instances)throws Exception{
        Add filter = new Add();
        Integer a = instances.numAttributes() - 2;
        filter.setAttributeIndex(a.toString());
        filter.setAttributeName("BF/Rev");
        filter.setInputFormat(instances);
        instances = Filter.useFilter(instances,filter);
        for (int i = instances.numInstances() - 1; i >= 0; i--) {
            Instance inst = instances.get(i);
            if(inst.value(instances.attribute("REVISONS")) <= 5)
                instances.delete(i);
            else{
                double b =inst.value(instances.attribute("BUGFIXES"))/inst.value(instances.attribute("REVISONS"));
                instances.instance(i).setValue(a-1,b);
            }
        }
        for (int i = instances.numInstances() - 1; i >= 0; i--) {
            Instance inst = instances.get(i);
            if(inst.value(instances.attribute("BF/Rev")) > 0.60)
                instances.instance(i).setValue(instances.attribute("class"), "buggy");
            else
                instances.instance(i).setValue(instances.attribute("class"), "clean");
        }
        //3,25,111
        int[] options =new int[3];
        options[0] = 3;
        options[1] = 25;
        options[2] = 111;
        Remove remove = new Remove();
        remove.setAttributeIndicesArray(options);
        remove.setInputFormat(instances);
        instances = Filter.useFilter(instances, remove);
        return instances;
    }
}
