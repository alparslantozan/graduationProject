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
public class MetricsForClassesDto {

    private Integer ATFD;
    private Float TCC;
    private Float WMC;
    private Integer NAS;
    private Float PNAS;
    private Float AMW;
    private Integer NOM;

    public MetricsForClassesDto() {
    }

    public MetricsForClassesDto(Integer ATFD, Float TCC, Float WMC) {
        this.ATFD = ATFD;
        this.TCC = TCC;
        this.WMC = WMC;
    }

    public Integer getATFD() {
        return ATFD;
    }

    public void setATFD(Integer ATFD) {
        this.ATFD = ATFD;
    }

    public Float getTCC() {
        return TCC;
    }

    public void setTCC(Float TCC) {
        this.TCC = TCC;
    }
    public Float getWMC() {
        return WMC;
    }

    public void setWMC(Float WMC) {
        this.WMC = WMC;
    }

    public Integer getNAS() {
        return NAS;
    }

    public void setNAS(Integer NAS) {
        this.NAS = NAS;
    }

    public Float getPNAS() {
        return PNAS;
    }

    public void setPNAS(Float PNAS) {
        this.PNAS = PNAS;
    }

    public Float getAMW() {
        return AMW;
    }

    public void setAMW(Float AMW) {
        this.AMW = AMW;
    }

    public Integer getNOM() {
        return NOM;
    }

    public void setNOM(Integer NOM) {
        this.NOM = NOM;
    }

    @Override
    public String toString() {
        return "MetricsForClassesDto{" + "ATFD=" + ATFD + ", TCC=" + TCC + ", WMC=" + 
                WMC + ", NAS=" + NAS + ", PNAS=" + PNAS + ", AMW=" + AMW + ", NOM=" + NOM + '}';
    }

}
