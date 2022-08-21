# Teste Senior
<hr>

## Como executar a aplicação:





<hr>

## Endpoints da aplicação:

### Postman
https://www.postman.com/galactic-flare-213161/workspace/teste-senior/collection/21160717-a283b61b-6ba5-4d13-8302-339e3492cf03?action=share&creator=21160717

### Arquivo JSON
https://www.getpostman.com/collections/0a29880b3bc84b0ed439

# 

### Items

#### Criar item:
		método: POST,
		url: {url base}/api/items,
		conteudo:
			{
				"description": string,
				"value": double,
				"type": char	       // Ex: "S" ou "P"
			}
		retorno: 
			{
				"id": "5d799a04-827c-4a1e-9f37-327bc1b5042a", // UUID gerado automaticamente
				"description": "Item 9",
				"value": 1000.0,
				"type": "S"
			}
			
#### Atualizar item:
		método: PUT,
		url: {url base}/api/items/{id},
		conteudo:
			{
				"description": string,
				"value": double,
				"type": char	       // Ex: "S" ou "P"
			}
		retorno: 
			{
				"id": "5d799a04-827c-4a1e-9f37-327bc1b5042a",
				"description": "Item 9",
				"value": 1000.0,
				"type": "S"
			}
	
#### Buscar item pelo id:
		método: GET,
		url: {url base}/api/items/{id},
		retorno: 
			{
				"id": "5d799a04-827c-4a1e-9f37-327bc1b5042a",
				"description": "Item 9",
				"value": 1000.0,
				"type": "S"
			}
			
	
#### Buscar todos os items:
		método: GET,
		url: {url base}/api/items/
		retorno: 
			[
			    {
				"id": "4fb337ae-a511-4abe-830e-47a56f8d4f47",
				"description": "Item 1",
				"value": 1000.0,
				"type": "P"
			    },
			    {
				"id": "075e7657-71e5-4d3c-8984-1b2db246a72f",
				"description": "Item 4",
				"value": 1000.0,
				"type": "S"
			    }
		    	]
		    	
#### Deletar Item:
    método: DELETE,
		url: {url base}/api/items/{id},
		retorno: Não possui retorno 
		
#
		
### Orders
#### Criar Order:
		método: POST,
		url: {url base}/api/orders,
		conteudo:
			{
				"number": integer, 
				"date": timestamp,		// Ex: "2000-07-16T22:54:01Z"
				"percentualDiscount": double
			}
		retorno: 
			{
				"id": "6eb43ebf-24ed-4708-8a97-32bdfa09669d",
				"number": 110,
				"date": "2000-07-16T22:54:01Z",
				"percentualDiscount": 5.0,
				"totalValue": 0.0
			}
			
#### Atualizar Order:
		método: PUT,
		url: {url base}/api/orders/{id},
		conteudo:
			{
				"number": integer, 
				"date": timestamp,		// Ex: "2000-07-16T22:54:01Z"
				"percentualDiscount": double
				"totalValue": double

			}
		retorno: 
			{
				 "id": "431e2e6d-810e-4452-a4b3-e7015aff4f16",
				 "number": 103,
				 "date": "2000-07-16T22:54:01Z",
				 "percentualDiscount": 5.5,
				 "totalValue": 0.0
			}
	
#### Buscar Order pelo id:
		método: GET,
		url: {url base}/api/orders/{id},
		retorno: 
			{
				  "id": "431e2e6d-810e-4452-a4b3-e7015aff4f16",
				  "number": 103,
				  "date": "2000-07-16T22:54:01Z",
				  "percentualDiscount": 5.5,
				  "totalValue": 0.0
			}
			
	
#### Buscar todas as Order:
		método: GET,
		url: {url base}/api/orders/,
		retorno: 
			[
			       {
					"id": "6eb43ebf-24ed-4708-8a97-32bdfa09669d",
					"number": 110,
					"date": "2000-07-16T22:54:01Z",
					"percentualDiscount": 5.0,
					"totalValue": 0.0
    			       },
			       {
					"id": "431e2e6d-810e-4452-a4b3-e7015aff4f16",
					"number": 103,
					"date": "2000-07-16T22:54:01Z",
					"percentualDiscount": 5.0,
					"totalValue": 0.0
			      }
		    	]
		    	
#### Deletar Order:
    método: DELETE,
		url: {url base}/api/orders/{id},
		retorno: Não possui retorno 
		
#### Fechar Order:
		método: POST,
		url: {url base}/api/orders/{id}/close,
		conteudo:
			{
				"percentualDiscount": double
			}
		retorno: 
			{
				
				"id": "bacd4b7e-b0b8-48d6-b93d-10a4fa7bf75f",
				"number": 100,
				"date": "2000-07-16T22:54:01Z",
				"percentualDiscount": 10.0,
				"totalValue": 3600.0,
				"items": [
				    {
					"id": "77e2e2f5-bc54-4479-8f5f-308497b1287e",
					"itemId": "4fb337ae-a511-4abe-830e-47a56f8d4f47",
					"quantity": 2.0,
					"totalValue": 2000.0
				    },
				    {
					"id": "689305c8-c143-4140-8f8d-b1102ca31985",
					"itemId": "e9fe88ce-9fcd-471f-bed0-8bd10d064045",
					"quantity": 2.0,
					"totalValue": 2000.0
				    }
				]
			}

# 

### Orders Items
#### Criar Orders Items:
		método: POST,
		url: {url base}/api/orders/{orderId}/items,
		conteudo:
			{
				"itemId": UUID,
				"quantity": double
			}
		retorno: 
			{
				"id": "5d799a04-827c-4a1e-9f37-327bc1b5042a", // UUID gerado automaticamente
				"itemId": "075e7657-71e5-4d3c-8984-1b2db246a72f",
				"quantity": 2.0,
				"totalValue": 2000.0
			}
			
#### Atualizar Orders Items:
		método: PUT,
		url: {url base}/api/orders/{orderId}/items/{orderItemId},
		conteudo:
			{
				"itemId": UUID,
				"quantity": double,
			}
		retorno: 
			{
				  "id": "77e2e2f5-bc54-4479-8f5f-308497b1287e",
			          "itemId": "075e7657-71e5-4d3c-8984-1b2db246a72f",
		        	  "quantity": 4.0,
				  "totalValue": 4000.0
			}
	
#### Buscar Orders Items pelo id:
		método: GET,
		url: {url base}/api/orders/{orderId}/items/{orderItemId},
		retorno: 
			{
				 "id": "77e2e2f5-bc54-4479-8f5f-308497b1287e",
    				 "itemId": "075e7657-71e5-4d3c-8984-1b2db246a72f",
    				 "quantity": 4.0,
    				 "totalValue": 4000.0
			}
			
	
#### Buscar todos os Orders Items:
		método: GET,
		url: {url base}/api/orders/{orderId}/items
		retorno: 
			[
		    		{
					"id": "689305c8-c143-4140-8f8d-b1102ca31985",
					"itemId": "e9fe88ce-9fcd-471f-bed0-8bd10d064045",
					"quantity": 2.0,
					"totalValue": 2000.0
			    	},
			    	{
					"id": "77e2e2f5-bc54-4479-8f5f-308497b1287e",
					"itemId": "075e7657-71e5-4d3c-8984-1b2db246a72f",
					"quantity": 4.0,
					"totalValue": 4000.0
				}
		  ]
          
#### Deletar Order Item:
    método: DELETE,
		url: {url base}/api/orders/{orderId}/items/{orderItemId},
		retorno: Não possui retorno 
   
   <hr>
