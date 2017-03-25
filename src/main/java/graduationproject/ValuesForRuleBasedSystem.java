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
public class ValuesForRuleBasedSystem {
    private Integer ATFD;
    private Float TCC;
    private Float HighWMC;
    private Float LowWMC;
    private Integer NAS;
    private Float PNAS;
    private Float AMW;
    private Integer NOM;
    
    private Integer HighCINT;
    private Float HighCDISP;
    private Integer MAXNESTING;
    private Integer LowCINT;
    private Float LowCDISP;

    public ValuesForRuleBasedSystem() {
        ATFD = 3;
        TCC = new Float(0.33);
        HighWMC = new Float(47.0);
        LowWMC = new Float(23.5);
        NAS = 7;
        PNAS = new Float(2/3);
        AMW = new Float(2.0);
        NOM = 10;
        
        HighCINT = 7;
        LowCINT = 3;
        HighCDISP = new Float(0.5);
        LowCDISP = new Float(0.25);
        MAXNESTING = 1;
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

    public Float getHighWMC() {
        return HighWMC;
    }

    public void setHighWMC(Float HighWMC) {
        this.HighWMC = HighWMC;
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

    public Integer getHighCINT() {
        return HighCINT;
    }

    public void setHighCINT(Integer HighCINT) {
        this.HighCINT = HighCINT;
    }

    public Float getHighCDISP() {
        return HighCDISP;
    }

    public void setHighCDISP(Float HighCDISP) {
        this.HighCDISP = HighCDISP;
    }

    public Integer getMAXNESTING() {
        return MAXNESTING;
    }

    public void setMAXNESTING(Integer MAXNESTING) {
        this.MAXNESTING = MAXNESTING;
    }

    public Float getLowWMC() {
        return LowWMC;
    }

    public void setLowWMC(Float LowWMC) {
        this.LowWMC = LowWMC;
    }

    public Integer getLowCINT() {
        return LowCINT;
    }

    public void setLowCINT(Integer LowCINT) {
        this.LowCINT = LowCINT;
    }

    public Float getLowCDISP() {
        return LowCDISP;
    }

    public void setLowCDISP(Float LowCDISP) {
        this.LowCDISP = LowCDISP;
    }
    
}
