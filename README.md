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
- 02 Generar el siguiente POST http request:

[![Image](file:///C:/Users/marti/OneDrive/Pictures/AWS-capture/mutant-post-request.png "Mutant POST HTTP Request")]

- 03 Ejemplo cadena mutante:
  {
    "dna": [
        "AAAAGA", "AAGGGG", "TTCTGT", "AAACCG", "CTCCTA", "TAACTG"
    ]
  }
- 04 Ejemplo cadena no mutante:
  {
    "dna": [
        "AACAGA", "AAGGGG", "TTCTGT", "AGACCG", "CTCCTA", "TAACTG"
    ]
  }
  
  #### /Stats Method

- 01 Abrir Postman o copiar url en el navegador para consumir este servicio
- 02 Generar el siguiente GET http request:

[![Image](file:///C:/Users/marti/OneDrive/Pictures/AWS-capture/mutant-post-request.png "Stats GET HTTP Request")]
