#language: pt
Funcionalidade: Validar Modal de Upload de Base

  @ModalUploadBase1
  Esquema do Cenario: Validar Seleção do Checkbox de base
    Dado que acessei o APM
    E realizei login com usuário <Login> e senha <Senha>
    Então deverá apresentar a tela inicial do APM
    Quando selecionar uma base para upload
    Então deverá abrir a modal de finalidade de base
    E deverá respeitar a regra de seleção do tipo de base para habilitar botão de Upload


    Exemplos:
      | Login                                    | Senha                                    |
      | "user.dextra-serasa-analytics-pmpf-pmpj" | "pass.dextra-serasa-analytics-pmpf-pmpj" |

  @ModalUploadBase1
  Esquema do Cenario: Validar presença dos elementos na Modal de Upload de Base
    Dado que acessei o APM
    E realizei login com usuário <Login> e senha <Senha>
    Então deverá apresentar a tela inicial do APM
    Quando selecionar uma base para upload
    Então deverá abrir a modal de finalidade de base
    E deverá respeitar apresentar os elementos para seleção de finalidade da base

    Exemplos:
      | Login                                    | Senha                                    |
      | "user.dextra-serasa-analytics-pmpf-pmpj" | "pass.dextra-serasa-analytics-pmpf-pmpj" |