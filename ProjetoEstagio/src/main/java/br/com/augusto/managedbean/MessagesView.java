package br.com.augusto.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesView {
    public void sucessoDeletar() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Deletado com Sucesso!."));
    }
    public void erroDeletar() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "N�o foi possivel Deletar!."));
    }

}
