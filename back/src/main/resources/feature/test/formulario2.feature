
#language: pt
#enconding: UTF-8

@MyStepdefs @End2End
Funcionalidade:

  Contexto:
    * mapeie "undefined" para "//body/*[@id='content']/div/app-root/main/*[@id='content-simulator']/app-vehicle/form/foundation-radio-button/div/label/span/*[text()='']"
    * mapeie "undefined" para "//body/*[@id='content']/div/app-root/main/*[@id='content-simulator']/app-vehicle/form/foundation-radio-button[3]/div/label/*[text()='']"
    * mapeie "text-cep" para "//*[@id='cep']"
    * mapeie "undefined" para "//body/*[@id='content']/div/app-root/main/*[@id='content-simulator']/app-vehicle/form/foundation-radio-button[7]/div/label/*[text()='']"
    * mapeie "vehicle-year" para "//*[@id='input_ano_veiculo']"
    * mapeie "vehicle-price" para "//*[@id='valor-veiculo']"
    * mapeie "undefined" para "//body/*[@id='content']/div/app-root/main/*[@id='content-simulator']/app-vehicle/form/foundation-radio-button[8]/div/label/span/*[text()='']"
    * mapeie "text-name" para "//*[@id='name']"
    * mapeie "text-cpf" para "//*[@id='cpf']"
    * mapeie "text-email" para "//*[@id='email']"
    * mapeie "text-phone" para "//*[@id='phone']"
    * mapeie "undefined" para "//div/div/*[text()='']"

  Esquema do Cenario:

    E clique em "undefined"
    E clique em "undefined"
    E digite em "text-cep" o valor "<valor_text-cep>"
    E clique em "undefined"
    E digite em "vehicle-year" o valor "<valor_vehicle-year>"
    E digite em "vehicle-price" o valor "<valor_vehicle-price>"
    E clique em "undefined"
    E digite em "text-name" o valor "<valor_text-name>"
    E digite em "text-cpf" o valor "<valor_text-cpf>"
    E digite em "text-email" o valor "<valor_text-email>"
    E digite em "text-phone" o valor "<valor_text-phone>"
    E clique em "undefined"

    Exemplos:
      |valor_text-cep|valor_vehicle-year|valor_vehicle-price|valor_text-name|valor_text-cpf|valor_text-email|valor_text-phone|
      |67140-180|2016|R$ 60.000,00|Mateus Lima Gomes|018.837.642-97|matdashell729105@gmail.com|(91) 98746-6472|
