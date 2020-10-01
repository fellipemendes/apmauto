package pageobject;

import configurations.Hooks;
import configurations.PropertiesUtil;
import configurations.contants;
import configurations.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class pages extends LoadableComponent<pages> {

    private utils oUtils;
    private contants oConstants;
    private static final String fileName = "file.csv";
    private String URL = null;

    public static String getFileName() {
        return fileName;
    }

    private JavascriptExecutor executorJS = (JavascriptExecutor) Hooks.driver;

    public pages(utils o_Utils, contants o_Constants){
        this.oUtils = o_Utils;
        this.oConstants = o_Constants;
        String env_test = PropertiesUtil.getProperty("env.test").toUpperCase();
        switch (env_test){
            case "DEXTRA":
                URL = PropertiesUtil.getProperty("url.apm.dextra");
        }
        Hooks.driver.get(URL);
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(name="username")
    public WebElement usernameTextBox;

    @FindBy(name="password")
    private WebElement passwordTextBox;

    @FindBy(id="okta-signin-submit")
    private WebElement loginButton;

    @FindBy(xpath="//span")
    public WebElement linkMenuAPMPJ;

    @FindBy(xpath="//span[contains(text(),'Bases')]")
    private WebElement linkMenuBases;

    @FindBy(id="input")
    public WebElement txtCaminhoBase;

    @FindBy(xpath="//form[@class='base-uploader__upload ng-untouched ng-pristine ng-valid']")
    private WebElement formUploadBase;

    @FindBy(xpath="//span[@class='file__name']")
    private WebElement txtFileName;

    @FindBy(xpath="//span[contains(text(),'Portfolio Management')]")
    private WebElement txtPortfolioManagement;

    @FindBy(xpath="//h4[contains(text(),'Pessoa Física')]")
    private WebElement txtPF;

    @FindBy(xpath="//h4[contains(text(),'Pessoa Jurídica')]")
    private WebElement txtPJ;

    @FindBy(id=fileName + "-PF")
    private WebElement checkFilePF;

    @FindBy(id=fileName + "-PJ")
    private WebElement checkFilePJ;

    @FindBy(xpath = "//span")
    private WebElement txtAnalyticalSandboxPF;

    @FindBy(xpath="//h4[contains(text(),'Modelagem')]")
    private WebElement txtModelagem;

    @FindBy(xpath="//h4[contains(text(),'Estudos')]")
    private WebElement txtEstudos;

    @FindBy(id=fileName + "-modelagem")
    private WebElement checkFileModelagem;

    @FindBy(id=fileName + "-estudo")
    private WebElement checkFileEstudo;

    @FindBy(xpath="//button[@class='file-type-selector__button']")
    public WebElement btnProsseguirUpload;

    @FindBy(xpath="//button[@class='file-type-selector__button file-type-selector__button--secondary']")
    public WebElement btnCancelarUpload;

    @FindBy(xpath = "//h3[@class='message__title']")
    public WebElement msgTitleUploadBase;

    @FindBy(xpath = "//h3[@class='message__subtitle']")
    public WebElement msgSubtitleUploadBase;

    public void performLogin(String Usuario, String Senha){
        usernameTextBox.sendKeys(Usuario);
        passwordTextBox.sendKeys(Senha);
        loginButton.click();
    }

    public void setCheckFilePJ(){
        executorJS.executeScript("arguments[0].click();", checkFilePJ);
    }

    public void setCheckFileModelagem(){
        executorJS.executeScript("arguments[0].click();", checkFileModelagem);
    }

    public void setCheckFileEstudo(){
        executorJS.executeScript("arguments[0].click();", checkFileEstudo);
    }

    public void clickBasesmenu() throws InterruptedException {
        Thread.sleep(3000);
        linkMenuBases.click();
    }

    public void clickAPMPJmenu(){
        linkMenuAPMPJ.click();
    }

    public void clickProsseguirUploadBase(){
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        btnProsseguirUpload.click();
    }

    public void arquivoBaseUpload() throws IOException, InterruptedException {
        txtCaminhoBase.sendKeys(System.getProperty("user.dir")+"/src/test/data/" + fileName);
    }

    //Valida texto e presença dos elementos de seleção da base
    public void validaModalUploadBase() throws Throwable {
        oUtils.waitElement(btnProsseguirUpload);
        assertThat(txtFileName.getText()).isNotEmpty();
        assertThat(txtFileName.getText()).isEqualTo(fileName);
        assertThat(txtPF.getText()).isEqualTo(oConstants.pfTitle);
        assertThat(txtPJ.getText()).isEqualTo(oConstants.pjTitle);
        assertThat(txtAnalyticalSandboxPF.getText()).isEqualTo(oConstants.analyticalPFTitle);
        assertThat(txtModelagem.getText()).isEqualTo(oConstants.modelagemTitle);
        assertThat(txtEstudos.getText()).isEqualTo(oConstants.estudosTitle);
        assertThat(checkFileModelagem.isEnabled()).isTrue();
        assertThat(checkFileEstudo.isEnabled()).isTrue();
    }

    private void validaCheckModalUpload_PF(){
        oUtils.waitPresenceOfElementLocated("ID", fileName + "-PF");
        executorJS.executeScript("arguments[0].click();", checkFilePF);
        assertThat(checkFilePF.isSelected()).isTrue();
        assertThat(checkFileEstudo.isEnabled()).isTrue();
        assertThat(checkFileModelagem.isEnabled()).isTrue();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();
        executorJS.executeScript("arguments[0].click();", checkFilePF);
    }

    private void validaCheckModalUpload_PJ() {
        executorJS.executeScript("arguments[0].click();", checkFilePJ);
        assertThat(checkFilePJ.isSelected()).isTrue();
        assertThat(checkFileEstudo.isEnabled()).isFalse();
        assertThat(checkFileModelagem.isEnabled()).isFalse();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();
        executorJS.executeScript("arguments[0].click();", checkFilePJ);
    }

    private void validaCheckModalUpload_Estudo_Modelagem() {
        executorJS.executeScript("arguments[0].click();", checkFileEstudo);
        assertThat(checkFileEstudo.isSelected()).isTrue();
        assertThat(checkFileModelagem.isEnabled()).isTrue();
        assertThat(checkFilePJ.isEnabled()).isTrue();
        assertThat(checkFilePF.isEnabled()).isTrue();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();

        executorJS.executeScript("arguments[0].click();", checkFileModelagem);
        assertThat(checkFileEstudo.isSelected()).isTrue();
        assertThat(checkFileModelagem.isSelected()).isTrue();
        assertThat(checkFilePJ.isEnabled()).isTrue();
        assertThat(checkFilePF.isEnabled()).isTrue();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();

        executorJS.executeScript("arguments[0].click();", checkFilePF);
        assertThat(checkFilePF.isSelected()).isTrue();
        assertThat(checkFileEstudo.isSelected()).isTrue();
        assertThat(checkFileModelagem.isSelected()).isTrue();
        assertThat(checkFilePJ.isEnabled()).isFalse();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();

        executorJS.executeScript("arguments[0].click();", checkFilePF);
        assertThat(checkFilePF.isSelected()).isFalse();
        assertThat(checkFilePJ.isSelected()).isFalse();
        assertThat(checkFilePJ.isEnabled()).isTrue();
        assertThat(checkFilePF.isEnabled()).isTrue();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();
        executorJS.executeScript("arguments[0].click();", checkFilePJ);
        assertThat(checkFilePJ.isSelected()).isTrue();
        assertThat(checkFileEstudo.isEnabled()).isFalse();
        assertThat(checkFileModelagem.isEnabled()).isFalse();
        assertThat(btnProsseguirUpload.isEnabled()).isTrue();
        assertThat(btnCancelarUpload.isEnabled()).isTrue();
    }

    //Valida a seleção dos checkbox de seleção de base
    public void validaCheckModalUploadBase(){
        validaCheckModalUpload_PF();
        validaCheckModalUpload_PJ();
        validaCheckModalUpload_Estudo_Modelagem();
    }

    public String returnTextElement(String locator, String element){
        String textElement = "";
        if (locator.toUpperCase().equals("XPATH")){
            WebElement object = Hooks.driver.findElement(By.xpath(element));
            textElement = object.getText().trim();
        }
        return textElement;
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}

