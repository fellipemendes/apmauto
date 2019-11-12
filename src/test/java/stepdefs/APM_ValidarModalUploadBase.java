package stepdefs;

import configurations.Hooks;
import configurations.utils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pageobject.SerasaAPMPJ_PO;

public class APM_ValidarModalUploadBase {

    private SerasaAPMPJ_PO apmpjPO;
    private utils oUtils;

    public APM_ValidarModalUploadBase (Hooks driver, SerasaAPMPJ_PO apmpj_PO, utils o_Utils){
        this.apmpjPO = apmpj_PO;
        this.oUtils = o_Utils;
    }

    @Quando("selecionar uma base para upload")
    public void selecionar_uma_base_para_upload() throws Throwable {
        apmpjPO.clickBasesmenu();
        oUtils.waitElement(apmpjPO.txtCaminhoBase);
        apmpjPO.arquivoBaseUpload();
    }

    @Então("deverá abrir a modal de finalidade de base")
    public void deverá_abrir_a_modal_de_finalidade_de_base() throws Throwable {
        oUtils.waitElement(apmpjPO.btnCancelarUpload);
    }

    @E("deverá respeitar a regra de seleção do tipo de base para habilitar botão de Upload")
    public void deverá_respeitar_a_regra_de_seleção_do_tipo_de_base_para_habilitar_botão_de_Upload() {
        apmpjPO.validaCheckModalUploadBase();
    }

    @E("deverá respeitar apresentar os elementos para seleção de finalidade da base")
    public void deverá_respeitar_apresentar_os_elementos_para_seleção_de_finalidade_da_base() throws Throwable {
        apmpjPO.validaModalUploadBase();
    }
}
