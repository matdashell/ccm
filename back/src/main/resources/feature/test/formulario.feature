#language: pt
#enconding: UTF-8

@MyStepdefs @End2End
Funcionalidade: sdasdas

  Contexto:
    * mapeie "Formulario" para "//*[@id='form']"
    * mapeie "nome" para "//body/*[@id='root']/div/form/div/label/input"
    * mapeie "produto" para "//select"
    * mapeie "quantidade" para "//div[3]/label/input"
    * mapeie "cep" para "//div[4]/label/input"
    * mapeie "Realizar compra" para "//*[text()='Realizar compra']"
    * mapeie "Dinheiro: R$: 485" para "//body/*[@id='root']/div/div[2]/*"

  Esquema do Cenario: 1
    E acesse a url "http://localhost:3000"
    E clique em "Formulario"
    E digite em "nome" o valor "<valor_nome>"
    E selecione no select "produto" o valor "<valor_produto>"
    E digite em "quantidade" o valor "<valor_quantidade>"
    E digite em "cep" o valor "<valor_cep>"
    E clique em "Realizar compra"
    E valide positivamente o elemento "Dinheiro: R$: 485"

    Exemplos:
      | valor_nome | valor_produto | valor_quantidade | valor_cep |
      | Mateus     | shampoo       | 1                | 67140180  |

  Esquema do Cenario: 2
    E acesse a url "http://localhost:3000"
    E clique em "Formulario"
    E digite em "nome" o valor "<valor_nome>"
    E selecione no select "produto" o valor "<valor_produto>"
    E digite em "quantidade" o valor "<valor_quantidade>"
    E digite em "cep" o valor "<valor_cep>"
    E clique em "Realizar compra"
    E valide positivamente o elemento "Dinheiro: R$: 485"

    Exemplos:
      | valor_nome | valor_produto | valor_quantidade | valor_cep |
      | Mateus     | shampoo       | 1                | 67140180  |

