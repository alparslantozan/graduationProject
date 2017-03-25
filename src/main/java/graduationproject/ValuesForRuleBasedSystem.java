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
