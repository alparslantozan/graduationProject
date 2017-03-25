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

import javax.swing.text.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author alparslantozan
 */
public class MetricInterpreter {

    ValuesForRuleBasedSystem ruleValues;

    public MetricInterpreter() {
    }

    public MetricInterpreter(ValuesForRuleBasedSystem ruleValues) {
        this.ruleValues = ruleValues;
    }

    /**
     *
     * @param classList
     */
    public void classMetricInterpreter(List<MetricsOfClass> classList, javax.swing.JTextPane ruleBasedOutput){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        StyledDocument doc = ruleBasedOutput.getStyledDocument();
        AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Lucida Console");
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        try {
            doc.insertString(doc.getLength(),"Class Results\n",attributeSet);
            doc.insertString(doc.getLength(),"====================\n",attributeSet);
            classList.forEach((metricsOfClass) -> {
                try {
                    if (determineGodClass(metricsOfClass) && determineTraditionBreaker(metricsOfClass)) {
                        AttributeSet attributeSet2 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
                        attributeSet2 = sc.addAttribute(attributeSet2, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet2 = sc.addAttribute(attributeSet2, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Class " + metricsOfClass.getClassName()
                                +" is both god class and tradition breaker\n",attributeSet2);
                    }
                    else if(determineGodClass(metricsOfClass)) {
                        AttributeSet attributeSet3 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.ORANGE);
                        attributeSet3 = sc.addAttribute(attributeSet3, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet3 = sc.addAttribute(attributeSet3, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Class " + metricsOfClass.getClassName() + " is god class\n",attributeSet3);
                    } else if(determineTraditionBreaker(metricsOfClass)) {
                        AttributeSet attributeSet4 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.PINK);
                        attributeSet4 = sc.addAttribute(attributeSet4, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet4 = sc.addAttribute(attributeSet4, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Class " + metricsOfClass.getClassName() + " is only tradition breaker\n",attributeSet4);
                    } else {
                        AttributeSet attributeSet5 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.GREEN);
                        attributeSet5 = sc.addAttribute(attributeSet5, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet5 = sc.addAttribute(attributeSet5, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Class " + metricsOfClass.getClassName() + " seems good\n",attributeSet5);
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            });
            doc.insertString(doc.getLength(),"====================\n",attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param methodList
     */
    public void methodMetricInterpreter(List<MetricsOfMethod> methodList, javax.swing.JTextPane ruleBasedOutput) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        StyledDocument doc = ruleBasedOutput.getStyledDocument();
        AttributeSet attributeSet = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.FontFamily, "Lucida Console");
        attributeSet = sc.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        try {
            doc.insertString(doc.getLength(),"Method Results\n",attributeSet);
            doc.insertString(doc.getLength(),"====================\n",attributeSet);
            methodList.forEach((metricsOfMethod) -> {
                try {
                    if(determineIntensiveCoupling(metricsOfMethod)) {
                        AttributeSet attributeSet2 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
                        attributeSet2 = sc.addAttribute(attributeSet2, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet2 = sc.addAttribute(attributeSet2, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Method " + metricsOfMethod.getClassName() + " has intensive coupling\n",attributeSet2);
                    } else {
                        AttributeSet attributeSet3 = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.GREEN);
                        attributeSet3 = sc.addAttribute(attributeSet3, StyleConstants.FontFamily, "Lucida Console");
                        attributeSet3 = sc.addAttribute(attributeSet3, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
                        doc.insertString(doc.getLength(),"Method " + metricsOfMethod.getClassName() + " seems good\n",attributeSet3);
                    }
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            });

            doc.insertString(doc.getLength(),"====================\n",attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private boolean determineGodClass(MetricsOfClass classMetric){
        return classMetric.getMetrics().getWMC() >= ruleValues.getHighWMC() &&
                classMetric.getMetrics().getATFD() > ruleValues.getATFD() &&
                classMetric.getMetrics().getTCC() < ruleValues.getTCC();
    }

    private boolean determineIntensiveCoupling(MetricsOfMethod methodMetric) {
        boolean firstControl = methodMetric.getMetrics().getCDISP()< ruleValues.getHighCDISP() && methodMetric.getMetrics().getCINT()> ruleValues.getHighCINT();
        boolean secondControl = methodMetric.getMetrics().getCDISP()<ruleValues.getLowCDISP()&& methodMetric.getMetrics().getCINT()>ruleValues.getLowCINT();
        return methodMetric.getMetrics().getMAXNESTING()>ruleValues.getMAXNESTING() && (firstControl || secondControl);
    }

    private boolean determineTraditionBreaker(MetricsOfClass classMetric){
        boolean excessiveIncrease = classMetric.getMetrics().getNAS() >= ruleValues.getNAS()
                && classMetric.getMetrics().getPNAS() >= ruleValues.getPNAS();
        boolean childClassSubsential = (classMetric.getMetrics().getAMW() > ruleValues.getAMW() || classMetric.getMetrics().getWMC() >= ruleValues.getHighWMC())
                && classMetric.getMetrics().getNOM() >= ruleValues.getNOM();
        boolean parentNotSmallOrDumb = classMetric.getMetrics().getAMW() > ruleValues.getAMW()
                && classMetric.getMetrics().getNOM() > 5 && classMetric.getMetrics().getWMC() >= ruleValues.getLowWMC();
        return excessiveIncrease && childClassSubsential && parentNotSmallOrDumb;
    }

}
