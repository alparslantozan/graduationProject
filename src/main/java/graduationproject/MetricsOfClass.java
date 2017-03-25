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

/**
 *
 * @author alparslantozan
 */
public class MetricsOfClass {
    
    private String className;
    private MetricsForClassesDto metrics;

    public MetricsOfClass() {
    }

    public MetricsOfClass(String name, MetricsForClassesDto metrics) {
        this.className = name;
        this.metrics = metrics;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MetricsForClassesDto getMetrics() {
        return metrics;
    }

    public void setMetrics(MetricsForClassesDto metrics) {
        this.metrics = metrics;
    }

    @Override
    public String toString() {
        return "MetricsOfClass{" + "name=" + className + ", metrics=" + metrics.toString() + '}';
    }
    
}
