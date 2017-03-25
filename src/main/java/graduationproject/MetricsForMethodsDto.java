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
