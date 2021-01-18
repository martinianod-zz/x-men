# x-men

## Como consumir X-Mens Microservices

## Getting Started

#### Required URLs

- /Mutant URL - POST Method -  http://ec2-3-135-188-103.us-east-2.compute.amazonaws.com/v1/api/mutant/

- /Stats URL - GET Method -    http://ec2-3-135-188-103.us-east-2.compute.amazonaws.com/v1/api/stats/

#### Postman o cualquier otro API Client

#### /Mutant Method

- 01 Abrir Postman 
- 02 Copiar la url
- 03 Generar un POST http request y pegar la url: http://ec2-3-135-188-103.us-east-2.compute.amazonaws.com/v1/api/mutant/

- 04 Agregar la cadena de dna en formato json al body del request:
  {
    "dna": [
        "AAAAGA", "AAGGGG", "TTCTGT", "AAACCG", "CTCCTA", "TAACTG"
    ]
  }
- 05 Ejemplo cadena no mutante:
  {
    "dna": [
        "AACAGA", "AAGGGG", "TTCTGT", "AGACCG", "CTCCTA", "TAACTG"
    ]
  }
  
 #### /Stats Method

- 01 Abrir Postman o copiar url en el navegador para consumir este servicio
- 02 En caso de consumir el servicio con algun api client: Generar un GET http request y pegar la url: http://ec2-3-135-188-103.us-east-2.compute.amazonaws.com/v1/api/stats/

