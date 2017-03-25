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
public class MetricsForMethodsDto {
    
    private Integer CINT;
    private Float CDISP;
    private Integer MAXNESTING;

    public MetricsForMethodsDto() {
    }

    public MetricsForMethodsDto(Integer CINT, Float CDISP, Integer MAXNESTING) {
        this.CINT = CINT;
        this.CDISP = CDISP;
        this.MAXNESTING = MAXNESTING;
    }

    public Integer getCINT() {
        return CINT;
    }

    public void setCINT(Integer CINT) {
        this.CINT = CINT;
    }

    public Float getCDISP() {
        return CDISP;
    }

    public void setCDISP(Float CDISP) {
        this.CDISP = CDISP;
    }

    public Integer getMAXNESTING() {
        return MAXNESTING;
    }

    public void setMAXNESTING(Integer MAXNESTING) {
        this.MAXNESTING = MAXNESTING;
    }

    @Override
    public String toString() {
        return "MetricsForMethodsDto{" + "CINT=" + CINT + ", CDISP=" + CDISP + ", MAXNESTING=" + MAXNESTING + '}';
    }
    
}
