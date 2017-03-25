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
