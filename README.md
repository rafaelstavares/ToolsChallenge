# ToolsChallenge

Api processamento de pagamentos de cartao

## Tecnologias Utilizadas

O projeto foi criado com Spring Boot na linguagem de programação Java, Spring Data JPA, DataBAse h2 e realizado testes unitários com Mockito.


## Como testar

 endpoint de Criação:
1. **``POST /pagamentos``**: Cria um Pagamento:
```json
{
    "cartao": "55553322228888",
    "id": "202231221256",
    "descricao":{
        "valor": 1000.26,
        "dataHora": "21-05-2023 12:55:26",
        "estabelecimento": "novo teste do ceu"
    },
    "formaPagamento": {
        "tipo": "PARCELADO_LOJA",
        "parcelas": 3
    }
}
```

*Exemplo do corpo da resposta do pagamento:*
```json
{
    "transacao": {
        "id": 202231221256,
        "cartao": "55553322228888",
        "descricao": {
            "valor": 1000.26,
            "dataHora": "21-05-2023 12:55:26",
            "estabelecimento": "novo teste do ceu",
            "nsu": 100848112,
            "codigoAutorizacao": 136268673,
            "status": "AUTORIZADO"
        },
        "formaPagamento": {
            "tipo": "PARCELADO LOJA",
            "parcelas": 3
        }
    }
}
```


2. **``get pagamento/?id=``**: *Pesquisar pelo id*
   *Resposta:*
```json
{
    "transacao": {
        "id": 20230511210,
        "cartao": "22223002228888",
        "descricao": {
            "valor": 1000.26,
            "dataHora": "21-05-2023 12:55:26",
            "estabelecimento": "novo teste do ceu",
            "nsu": 120240192,
            "codigoAutorizacao": 136331491,
            "status": "AUTORIZADO"
        },
        "formaPagamento": {
            "tipo": "PARCELADO LOJA",
            "parcelas": 3
        }
    }
}
```


3. **``post pagamento/estorno?id=``**: *Estornar pelo id*
   *Resposta:*
```json
{
    "transacao": {
        "id": 202305111239,
        "cartao": "22223002228888",
        "descricao": {
            "valor": 1000.26,
            "dataHora": "21-05-2023 12:55:26",
            "estabelecimento": "novo teste do ceu",
            "nsu": 158183470,
            "codigoAutorizacao": 101478140,
            "status": "CANCELADO"
        },
        "formaPagamento": {
            "tipo": "PARCELADO LOJA",
            "parcelas": 3
        }
    }
}
```

4. **``get pagamento/todos``**: *Retorna todas as transações*
   *Resposta:*
```json
[
    {
        "transacao": {
            "id": 20230511210,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 173397933,
                "codigoAutorizacao": 123441616,
                "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 20230511,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 169860424,
                "codigoAutorizacao": 170047637,
                "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111234,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 119539680,
                "codigoAutorizacao": 132924733,
                "status": "CANCELADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111235,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 164763467,
                "codigoAutorizacao": 139436351,
                "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111236,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 198546906,
                "codigoAutorizacao": 128336050,
                "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111237,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 176533542,
                "codigoAutorizacao": 111991795,
                "status": "CANCELADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111238,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 113674036,
                "codigoAutorizacao": 184528632,
                "status": "AUTORIZADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    },
    {
        "transacao": {
            "id": 202305111239,
            "cartao": "22223002228888",
            "descricao": {
                "valor": 1000.26,
                "dataHora": "21-05-2023 12:55:26",
                "estabelecimento": "novo teste do ceu",
                "nsu": 158183470,
                "codigoAutorizacao": 101478140,
                "status": "CANCELADO"
            },
            "formaPagamento": {
                "tipo": "PARCELADO LOJA",
                "parcelas": 3
            }
        }
    }
]
```
