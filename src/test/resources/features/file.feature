#language: pt
Funcionalidade: Upload de Base PJ

  @uploadBaseClientePJModelagem
  Esquema do Cenario: Realizar upload de base cliente PJ
    Dado que acessei o APM
    E realizei login com usuário <Login> e senha <Senha>
    Então deverá apresentar a tela inicial do APM
    Quando realizar o upload de uma base cliente PJ
    Então deverá apresentar sucesso no envio da base
    E base deverá aparecer na lista de bases

    Exemplos:
      | Login                      | Senha                    |
      | "user.dextra-serasa-pmpj" | "pass.dextra.serasa.pmpj" |

#
#  @uploadBaseClientePJEstudo
#  Esquema do Cenario: Realizar upload de base cliente PJ tipo Estudo
#    Dado que acessei o APM
#    E realizei login com usuário <Login> e senha <Senha>
#    Então deverá apresentar a tela inicial do APM
#    Quando realizar o upload de uma base cliente PJ tipo Estudo
#    Então deverá apresentar sucesso no envio da base
#    E base deverá aparecer na lista de bases
#
#    Exemplos:
#      | Login                          | Senha      |
#     | "user.dextra-serasa-pmpj" | "pass.dextra.serasa.pmpj" ||