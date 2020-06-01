package com.company.form;

public class UserInformForResume {
    private Integer idInform;
    private String actionInform;

    public UserInformForResume() {
    }

    public UserInformForResume(Integer idInform, String actionInform) {
        this.idInform = idInform;
        this.actionInform = actionInform;
    }

    public Integer getIdInform() {
        return idInform;
    }

    public void setIdInform(Integer idInform) {
        this.idInform = idInform;
    }

    public String getActionInform() {
        return actionInform;
    }

    public void setActionInform(String actionInform) {
        this.actionInform = actionInform;
    }
}
