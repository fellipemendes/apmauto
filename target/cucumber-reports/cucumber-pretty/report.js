$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("APM_UploadBasePj.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    }
  ],
  "line": 2,
  "name": "Upload de Base PJ",
  "description": "",
  "id": "upload-de-base-pj",
  "keyword": "Funcionalidade"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Realizar upload de base cliente PJ",
  "description": "",
  "id": "upload-de-base-pj;realizar-upload-de-base-cliente-pj",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 4,
      "name": "@uploadBaseClientePJModelagem"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "que acessei o APM",
  "keyword": "Dado "
});
formatter.step({
  "line": 7,
  "name": "realizei login com usuário \u003cLogin\u003e e senha \u003cSenha\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 8,
  "name": "deverá apresentar a tela inicial do APM",
  "keyword": "Então "
});
formatter.step({
  "line": 9,
  "name": "realizar o upload de uma base cliente PJ",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "deverá apresentar sucesso no envio da base",
  "keyword": "Então "
});
formatter.step({
  "line": 11,
  "name": "base deverá aparecer na lista de bases",
  "keyword": "E "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "upload-de-base-pj;realizar-upload-de-base-cliente-pj;",
  "rows": [
    {
      "cells": [
        "Login",
        "Senha"
      ],
      "line": 14,
      "id": "upload-de-base-pj;realizar-upload-de-base-cliente-pj;;1"
    },
    {
      "cells": [
        "\"user.dextra-serasa-pmpj\"",
        "\"pass.dextra.serasa.pmpj\""
      ],
      "line": 15,
      "id": "upload-de-base-pj;realizar-upload-de-base-cliente-pj;;2"
    }
  ],
  "keyword": "Exemplos"
});
formatter.before({
  "duration": 1486902360,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Realizar upload de base cliente PJ",
  "description": "",
  "id": "upload-de-base-pj;realizar-upload-de-base-cliente-pj;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 4,
      "name": "@uploadBaseClientePJModelagem"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "que acessei o APM",
  "keyword": "Dado "
});
formatter.step({
  "line": 7,
  "name": "realizei login com usuário \"user.dextra-serasa-pmpj\" e senha \"pass.dextra.serasa.pmpj\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "E "
});
formatter.step({
  "line": 8,
  "name": "deverá apresentar a tela inicial do APM",
  "keyword": "Então "
});
formatter.step({
  "line": 9,
  "name": "realizar o upload de uma base cliente PJ",
  "keyword": "Quando "
});
formatter.step({
  "line": 10,
  "name": "deverá apresentar sucesso no envio da base",
  "keyword": "Então "
});
formatter.step({
  "line": 11,
  "name": "base deverá aparecer na lista de bases",
  "keyword": "E "
});
formatter.match({
  "location": "APM_UploadBasePj.que_acessei_o_APM()"
});
formatter.result({
  "duration": 16501655134,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "user.dextra-serasa-pmpj",
      "offset": 28
    },
    {
      "val": "pass.dextra.serasa.pmpj",
      "offset": 62
    }
  ],
  "location": "APM_UploadBasePj.realizei_login_com_usuário_e_senha(String,String)"
});
formatter.result({
  "duration": 12452022479,
  "status": "passed"
});
formatter.match({
  "location": "APM_UploadBasePj.deverá_apresentar_a_tela_inicial_do_APM()"
});
