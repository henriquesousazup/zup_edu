# Conta

## Criação de Conta 

```shell
curl --request POST \
  --url http://localhost:8080/contas \
  --header 'Content-Type: application/json' \
  --data '{
	"documentoTitular":35385638807,
	"nomeTitular":"Rafaela da Costa",
	"agencia":1000,
	"numero":123,
	"saldo":250
}'
```

## Consulta de conta

## Deletar conta



