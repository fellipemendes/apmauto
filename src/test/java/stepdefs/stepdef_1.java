package stepdefs;

import configurations.Hooks;
import configurations.PropertiesUtil;
import configurations.utils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageobject.SerasaAPMPJ_PO;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class APM_UploadBasePj {

    public static WebDriver driver;
    private SerasaAPMPJ_PO apmpjPO;
    private utils oUtils;

    //private JavascriptExecutor executorJS = (JavascriptExecutor)driver;

    public APM_UploadBasePj (SerasaAPMPJ_PO apmpj_PO, utils o_Utils){
        this.apmpjPO = apmpj_PO;
        this.oUtils = o_Utils;
        driver = Hooks.driver;
    }

    private static String emailLogin ="";

    @Dado("que acessei o APM")
    public void que_acessei_o_APM() { apmpjPO.get(); }

    @Dado("^realizei login com usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
    public void realizei_login_com_usuário_e_senha(String Usuario, String Senha) throws Throwable {
        oUtils.waitElement(apmpjPO.usernameTextBox);
        apmpjPO.performLogin(
                PropertiesUtil.getProperty(Usuario),
                PropertiesUtil.getProperty(Senha));
        emailLogin = PropertiesUtil.getProperty(Usuario);
    }

    @Então("deverá apresentar a tela inicial do APM")
    public void deverá_apresentar_a_tela_inicial_do_APM() throws Throwable {
        oUtils.waitElement(apmpjPO.linkMenuAPMPJ);
    }

    @Quando("realizar o upload de uma base cliente PJ")
    public void realizar_o_upload_de_uma_base_cliente_PJ() throws Throwable {
        oUtils.waitElement(apmpjPO.txtCaminhoBase);
        apmpjPO.arquivoBaseUpload();
        oUtils.waitElement(apmpjPO.btnProsseguirUpload);
        apmpjPO.setCheckFilePJ();
        //apmpjPO.setCheckFileModelagem();
        apmpjPO.clickProsseguirUploadBase();
    }

    @Quando("realizar o upload de uma base cliente PJ tipo Estudo")
    public void realizar_o_upload_de_uma_base_cliente_PJ_tipo_Estudo() throws Throwable {
        apmpjPO.clickBasesmenu();
        oUtils.waitElement(apmpjPO.txtCaminhoBase);
        apmpjPO.arquivoBaseUpload();
        oUtils.waitElement(apmpjPO.btnProsseguirUpload);
        apmpjPO.setCheckFilePJ();
        apmpjPO.setCheckFileEstudo();
        apmpjPO.clickProsseguirUploadBase();
    }

    @Então("deverá apresentar sucesso no envio da base")
    public void deverá_apresentar_sucesso_no_envio_da_base() throws Throwable {
        oUtils.waitElement(apmpjPO.msgTitleUploadBase);
        assertThat(apmpjPO.returnTextElement("XPATH", "//h3[@class='message__title']"))
                .isEqualTo("Upload concluído com sucesso");
        oUtils.waitElement(apmpjPO.msgSubtitleUploadBase);
        assertThat(apmpjPO.returnTextElement("XPATH", "//h3[@class='message__subtitle']"))
                .isEqualTo("O upload do arquivo " + SerasaAPMPJ_PO.getFileName() + " foi concluído com sucesso");
    }

    @E("base deverá aparecer na lista de bases")
    public void base_deverá_aparecer_na_lista_de_bases() {
        oUtils.waitVisibilityOfElementLocated("XPATH", "/html[1]/body[1]/app-root[1]/div[1]/main[1]/div[1]/app-base[1]/section[2]/app-base-item[1]/article[1]/div[1]/div[1]/div[2]/h3[1]");
        assertThat(apmpjPO.returnTextElement("XPATH", "/html[1]/body[1]/app-root[1]/div[1]/main[1]/div[1]/app-base[1]/section[2]/app-base-item[1]/article[1]/div[1]/div[1]/div[2]/h3[1]"))
                .isEqualTo(SerasaAPMPJ_PO.getFileName());

        assertThat(apmpjPO.returnTextElement("XPATH", "/html[1]/body[1]/app-root[1]/div[1]/main[1]/div[1]/app-base[1]/section[2]/app-base-item[1]/article[1]/div[1]/div[1]/div[2]/h4[1]"))
                .startsWith(emailLogin);
    }

}
