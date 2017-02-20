/*
 * Copyright (c) 2017, alparslantozan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package main.java.graduationproject;

import java.util.List;

/**
 *
 * @author alparslantozan
 */
public class MetricInterpreter {
    
    public MetricInterpreter() {
    }
    
    /**
     *
     * @param classList
     */
    public void classMetricInterpreter(List<MetricsOfClass> classList){
        classList.forEach((metricsOfClass) -> {
            printResult(metricsOfClass);
            if (determineGodClass(metricsOfClass) && determineTraditionBreaker(metricsOfClass)) {
                System.out.println("This class is both god class and tradition breaker");
            }
            else if(determineGodClass(metricsOfClass))
                System.out.println("This class is only god class");
            else if(determineTraditionBreaker(metricsOfClass))
                System.out.println("This class is only tradition breaker");
            else
                System.out.println("This class seems good");
            System.out.println();
            System.out.println();
        });
    }
    
    /**
     *
     * @param methodList
     */
    public void methodMetricInterpreter(List<MetricsOfMethod> methodList) {
        methodList.forEach((metricsOfMethod) -> {
            printResult(metricsOfMethod);
            if(determineIntensiveCoupling(metricsOfMethod))
                System.out.println("This method has intensive coupling");
            System.out.println();
            System.out.println();
        });
    }
    
    private void printResult(MetricsOfClass classMetric){
        System.out.println(classMetric.toString());
    }
    
    private void printResult(MetricsOfMethod methodMetric){
        System.out.println(methodMetric.toString());
    }
    
    private boolean determineGodClass(MetricsOfClass classMetric){
        return classMetric.getMetrics().getWMC() >= 47 && classMetric.getMetrics().getATFD() > 3 && classMetric.getMetrics().getTCC() < 0.33;
    }
    
    private boolean determineIntensiveCoupling(MetricsOfMethod methodMetric) {
        boolean firstControl = methodMetric.getMetrics().getCDISP()<0.5 && methodMetric.getMetrics().getCINT()>7;
        boolean secondControl = methodMetric.getMetrics().getCDISP()<0.25 && methodMetric.getMetrics().getCINT()>3;
        return methodMetric.getMetrics().getMAXNESTING()>1 && (firstControl || secondControl);
    }
    
    private boolean determineTraditionBreaker(MetricsOfClass classMetric){
        boolean excessiveIncrease = classMetric.getMetrics().getNAS() >= 7 
                && classMetric.getMetrics().getPNAS() >= 2/3;
        boolean childClassSubsential = (classMetric.getMetrics().getAMW() > 2 || classMetric.getMetrics().getWMC() >= 47) 
                && classMetric.getMetrics().getNOM() >= 10;
        boolean parentNotSmallOrDumb = classMetric.getMetrics().getAMW() > 2.0
                && classMetric.getMetrics().getNOM() > 5 && classMetric.getMetrics().getWMC() >= 23.5;
        return excessiveIncrease && childClassSubsential && parentNotSmallOrDumb;
    }
    
}
