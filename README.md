# drone-feeder

## Sumário

- [Descrição](#Descrição)
- [Pré-requisitos](#Pre-requisitos)
  - [Instalação](#Instalação)
  - [Instruções para iniciar o projeto](#Intruções-para-iniciar-o-projeto)
- [Documentação](#Documentação)
  - [Lista todos os drones](#Lista-todos-os-drones)
  - [Lista o drone pelo id](#Lista-o-drone-pelo-id) 
  - [Cria um novo drone](#Cria-um-novo-drone)
  - [Atualiza um drone pelo id](#Atualiza-um-drone-pelo-id)
  - [Atualiza um usuario pelo id](#Atualiza-um-usuario-pelo-id)
  - [Deleta um drone pelo id](#Deleta-um-drone-pelo-id)
  - [Lista todos os videos](#Lista-todos-os-videos)
  - [Lista o video pelo id](#Lista-o-video-pelo-id)
  - [Cria um novo Video](#Cria-um-novo-Video)
  - [Lista todos os Deliverys](#Lista-todos-os-Deliverys)
  - [Lista o Delivery pelo id](#Lista-o-Delivery-pelo-id)
  - [Cria um novo Delivery](#Cria-um-novo-Delivery)
  - [Atualiza um delivery pelo id](#Atualiza-um-delivery-pelo-id)
  - [Finaliza um delivery pelo id](#Finaliza-um-delivery-pelo-id)
  - [Deleta um Delivery pelo id](#Deleta-um-Delivery-pelo-id)

<br>

## Descrição

**Objetivo**:  Drone Feeder e uma aplicação REST que fornece a um sistema Front-end informações dos drones, tais como latitude e longitude, data e horário da entrega ou retirada do pacote.

O drone ainda vai informar se a entrega foi efetuada junto a data, horário e vídeo gravado do momento da entrega. Essas informações serão armazenadas em um banco de dados MySQL.

- Arquitetura REST;
- Banco de Dados MySQL;
- Java;
- SpringBoot;
- Hibernate;
- Testes Automatizados com JUnit;
- Docker;
- Docker compose;


## Pré-requisitos

- `Apache Maven 3.6.3`
- `Java 11.0.15`
- `docker version 20.10.13`
- `docker-compose version 1.29.2`

## Instalação

- Clone o repositório
  ```sh
    git clone git@github.com:esdrasoliveira5/DroneFeeder.git

- Vá para a pasta da aplicação
  ```sh
    cd ./droneFeeder

- Instale as dependencias
  ```sh
    mvn install 
    
- Configure secrets.properties conforme o exemplo:
  ```sh
  
    MYSQL_ROOT_HOST=dbapp
    MYSQL_ROOT_USER=root
    MYSQL_ROOT_PASSWORD=secretroot
    MYSQL_DATABASE=MY_DBASE

    APP_PORT=8082 


## Instruções para iniciar o projeto

<br>

- Vá para a pasta Docker
  ```sh
    cd ./Docker
   
- Comando para iniciar com docker

  ```sh
  sudo docker-compose up

- Acesse pelo navegador 
  ```sh
    http://localhost:8082/

- Comando para iniciar pelo mvn

  ```sh
  mvn spring-boot:run -e -X

- Acesse pelo navegador 
  ```sh
    http://localhost:8082/

<br/>

## Instruções para acessar a API pelo deploy

<br>

- Acesse pelo endpoint
  ```sh
  https://dronefeederacc.herokuapp.com
   
<br/>


## Instruções para testar o projeto

<br>

- Testes unitarios

  ```sh
  mvn test
  
## Documentação

<br/>

### **Lista todos os drones** 
##### `GET` /dronefeeder/drone

  <br/>

  Esse endpoint retorna status ``200`` e o todos os Drones cadastrados.

  - Exemplo `response body`
    ```json
        [
            {
                "id": 1,
                "marca": "marca1",
                "modelo": "modelo2"
            },
            {
                "id": 2,
                "marca": "marca2",
                "modelo": "modelo2"
            },
            {
                "id": 3,
                "marca": "marca3",
                "modelo": "modelo3"
            }
        ]
    ```
  <br/>


### **Lista o drone pelo id** 
##### `GET` /dronefeeder/drone/:id

  <br/>

  Esse endpoint retorna status ``200`` e o Drone cadastrado.

  - Exemplo `response body`
    ```json
        {
            "id": 1,
            "marca": "marca1",
            "modelo": "modelo2"
        }
    ```
  <br/>


### **Cria um novo drone** 
##### `POST` /dronefeeder/drone

  <br/>

  Esse endpoint retorna status ``200`` e o Drone cadastrado.

  - Exemplo `request body` 
    ``` json
        {
            "marca": "marca",
            "modelo": "modelo"
        }
    ```

  - Exemplo `response body`
    ```json
        {
            "id": 1,
            "marca": "marca",
            "modelo": "modelo"
        }
    ```
  <br/>


### **Atualiza um drone pelo id** 
##### `PUT` /dronefeeder/drone/:id

  <br/>

  Esse endpoint retorna status ``200`` e atualiza o Drone cadastrado.

  - Exemplo `request body` 
    ``` json
        {
            "marca": "marca",
            "modelo": "modelo"
        }
    ```

  - Exemplo `response body`
    ```json
        {
            "id": 1,
            "marca": "marca1",
            "modelo": "modelo2"
        }
    ```
  <br/>


### **Deleta um drone pelo id** 
##### `DELETE` /dronefeeder/drone/:id

  <br/>

  Esse endpoint retorna status ``200``

  <br/>


### **Lista todos os videos** 
##### `GET` /dronefeeder/video

  <br/>

  Esse endpoint retorna status ``200`` e o todos os Videos cadastrados.

  - Exemplo `response body`
    ```json
        [
            {
                "id": 1,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 1,
                    "marca": "modelo1",
                    "modelo": "marca1"
                }
            },
            {
                "id": 2,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 2,
                    "marca": "modelo2",
                    "modelo": "marca2"
                }
            },
            {
                "id": 3,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 3,
                    "marca": "modelo3",
                    "modelo": "marca3"
                }
            }
        ]
    ```
  <br/>


### **Lista o video pelo id** 
##### `GET` /dronefeeder/video/:id

  <br/>

  Esse endpoint retorna status ``200`` e o Video cadastrado.

  - Exemplo `response body`
    ```json
        {
            "id": 3,
            "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
            "drone": {
                "id": 3,
                "marca": "modelo3",
                "modelo": "marca3"
            }
        }
    ```
  <br/>


### **Cria um novo Video** 
##### `POST` /dronefeeder/video

  <br/>

  Esse endpoint retorna status ``200`` e o Video cadastrado.

  - Exemplo `request body` 
    ``` json
            {
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": 3
            }
    ```

  - Exemplo `response body`
    ```json
        {
            "id": 3,
            "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
            "drone": {
                "id": 3,
                "marca": "modelo3",
                "modelo": "marca3"
            }
        }
    ```
  <br/>


### **Lista todos os Deliverys** 
##### `GET` /dronefeeder/delivery

  <br/>

  Esse endpoint retorna status ``200`` e o todos os Deliverys cadastrados.

  - Exemplo `response body`
    ```json
            [
                {
                    "id": 2,
                    "latitude": "15.7975° S",
                    "longitude": "47.8919° W",
                    "dateAndTime": "2022-08-04T18:09:16.946+00:00",
                    "deliveryStatus": true,
                    "deliveryDateAndTime": "2022-08-04T18:53:44.599+00:00",
                    "drone": {
                        "id": 22,
                        "marca": "Marca22",
                        "modelo": "Modelo22"
                    },
                    "video": {
                        "id": 25,
                        "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                        "drone": {
                            "id": 22,
                            "marca": "Marca22",
                            "modelo": "Modelo22"
                        }
                    }
                },
                {
                    "id": 28,
                    "latitude": "15.7975° S",
                    "longitude": "47.8919° W",
                    "dateAndTime": "2022-08-04T18:54:15.250+00:00",
                    "deliveryStatus": false,
                    "deliveryDateAndTime": null,
                    "drone": {
                        "id": 23,
                        "marca": "Marca22",
                        "modelo": "Modelo22"
                    },
                    "video": {
                        "id": 27,
                        "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                        "drone": {
                            "id": 23,
                            "marca": "Marca22",
                            "modelo": "Modelo22"
                        }
                    }
                }
            ]
    ```
  <br/>


### **Lista o Delivery pelo id** 
##### `GET` /dronefeeder/delivery/:id

  <br/>

  Esse endpoint retorna status ``200`` e o Delivery cadastrado.

  - Exemplo `response body`
    ```json
            {
                "id": 2,
                "latitude": "15.7975° S",
                "longitude": "47.8919° W",
                "dateAndTime": "2022-08-04T18:09:16.946+00:00",
                "deliveryStatus": true,
                "deliveryDateAndTime": "2022-08-04T18:53:44.599+00:00",
                "drone": {
                    "id": 22,
                    "marca": "Marca22",
                    "modelo": "Modelo22"
                },
                "video": {
                    "id": 25,
                    "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                    "drone": {
                        "id": 22,
                        "marca": "Marca22",
                        "modelo": "Modelo22"
                    }
                }
            }
    ```
  <br/>


### **Cria um novo Delivery** 
##### `POST` /dronefeeder/delivery

  <br/>

  Esse endpoint retorna status ``200`` e o Delivery cadastrado.

  - Exemplo `request body` 
    ``` json
        {
                "latitude": "15.7975° S",
                "longitude": "47.8919° W",
                "drone": "1"
        }
    ```

  - Exemplo `response body`
    ```json
        {
            "id": 2,
            "latitude": "15.7975° S",
            "longitude": "47.8919° W",
            "dateAndTime": "2022-08-04T18:09:16.946+00:00",
            "deliveryStatus": true,
            "deliveryDateAndTime": "2022-08-04T18:53:44.599+00:00",
            "drone": {
                "id": 22,
                "marca": "Marca22",
                "modelo": "Modelo22"
            },
            "video": {
                "id": 25,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 22,
                    "marca": "Marca22",
                    "modelo": "Modelo22"
                }
            }
        }
    ```
  <br/>


### **Atualiza um delivery pelo id** 
##### `PUT` /dronefeeder/delivery/:id

  <br/>

  Esse endpoint retorna status ``200`` e atualiza o Delivery cadastrado.

  - Exemplo `request body` 
    ``` json
        {
                "latitude": "15.7975° S",
                "longitude": "47.8919° W",
                "drone": "1"
        }
    ```

  - Exemplo `response body`
    ```json
        {
            "id": 2,
            "latitude": "15.7975° S",
            "longitude": "47.8919° W",
            "dateAndTime": "2022-08-04T18:09:16.946+00:00",
            "deliveryStatus": true,
            "deliveryDateAndTime": "2022-08-04T18:53:44.599+00:00",
            "drone": {
                "id": 22,
                "marca": "Marca22",
                "modelo": "Modelo22"
            },
            "video": {
                "id": 25,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 22,
                    "marca": "Marca22",
                    "modelo": "Modelo22"
                }
            }
        }
    ```
  <br/>


### **Finaliza um delivery pelo id** 
##### `PATCH` /dronefeeder/delivery/:id/finish

  <br/>

  Esse endpoint retorna status ``200`` e finaliza o Delivery cadastrado.

  - Exemplo `response body`
    ```json
        {
            "id": 2,
            "latitude": "15.7975° S",
            "longitude": "47.8919° W",
            "dateAndTime": "2022-08-04T18:09:16.946+00:00",
            "deliveryStatus": true,
            "deliveryDateAndTime": "2022-08-04T18:53:44.599+00:00",
            "drone": {
                "id": 22,
                "marca": "Marca22",
                "modelo": "Modelo22"
            },
            "video": {
                "id": 25,
                "url": "https://www.youtube.com/watch?v=qcsszdkjlXg",
                "drone": {
                    "id": 22,
                    "marca": "Marca22",
                    "modelo": "Modelo22"
                }
            }
        }
    ```
  <br/>


### **Deleta um Delivery pelo id** 
##### `DELETE` /dronefeeder/delivery/:id

  <br/>

  Esse endpoint retorna status ``200``

  <br/>
