package steps;

import io.cucumber.java.pt.E;
import page.AutoPage;
import recursive.RecursiveFeature;

import java.util.HashMap;
import java.util.Map;

import static mapper.PathMapper.insertOnCSV;

public class MyStepdefs {

    //TODO: 1 - TELINHA FLUTUANTE - 2 - MULTIPLOS TESTES NO FRONT - 3 - VALIDACOES EXEMPLIFICADAS - 4 - MAPPER SALVO EM ARQUIVO LOCAL
    
    public static final Map<String, String> xPath = new HashMap<>();
    private static final AutoPage autoPage = new AutoPage();
    private static final RecursiveFeature recursiveFeature = new RecursiveFeature();

    @E("mapeie {string} para {string}")
    public void mapeiePara(String name, String xPath) {
        MyStepdefs.xPath.put(name, xPath);
        insertOnCSV(name, MyStepdefs.xPath.get(name));
    }

    @E("digite em {string} o valor {string}")
    public void digiteEmOValor(String name, String value) {
        autoPage.fillInputWithValue(xPath.get(name), value);
    }

    @E("selecione no select {string} o valor {string}")
    public void selecioneNoSelectOValor(String name, String value) {
        autoPage.selectElement(xPath.get(name), value);
    }

    @E("clique em {string}")
    public void cliqueEm(String name) {
        autoPage.clickByPath(xPath.get(name));
    }

    @E("valide positivamente o elemento {string}")
    public void validePositivamenteOElemento(String text) {
        autoPage.validateIfElementIsPresent(xPath.get(text), text);
    }

    @E("valide negativamente o elemento {string}")
    public void valideNegativamenteOElemento(String text) {
        autoPage.validateIfElementNotIsPresent(xPath.get(text), text);
    }

    @E("execute a feture {string}")
    public void executeAFeture(String name) {
        recursiveFeature.fromFeatureName(name);
    }

    @E("acesse a url {string}")
    public void acesseAUrl(String url) {
        autoPage.acessUrl(url);
    }

    @E("aguarde {string} segundos")
    public void aguardeSegundos(String time) {
        autoPage.await(time);
    }
}
