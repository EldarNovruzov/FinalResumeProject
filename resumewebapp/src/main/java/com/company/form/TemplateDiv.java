package com.company.form;

public class TemplateDiv {
    private String div;
    private String pdfFileName;

    public String getPdfFileName() {
        return pdfFileName;
    }

    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }

    public TemplateDiv(String div, String pdfFileName) {
        this.div = div;
        this.pdfFileName = pdfFileName;
    }

    public TemplateDiv(String div) {
        this.div = div;
    }

    public TemplateDiv() {
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }
}
