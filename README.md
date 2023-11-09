## Resumo do projeto
- O sistema-parquimetro é um serviço back-end para gerenciamento de estacionamentos. Disponibilizamos endpoints para que seja possível realizar o cadastro de Condutores, cadastro de veículos, estacionar veículos e realizar pagamentos.

## 🛠️ Exemplo Json/Rotas de cada API

###  API Condutor

- `(POST) API de cadastro de condutor`:
- `API de cadastro de condutor`: localhost:9080/condutor

exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/2ac208f4-dcb8-43c5-b25d-3801d99cd930)


- `(PUT) API de atualizar condutor`:
- `API de atualizar condutor`: localhost:9080/condutor/974feaa6-ca9b-49f5-af30-53068c6c558b

exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/731a888b-b630-4124-8997-1394fd65ac33)


- `(GET) API de buscar condutor`:
- `API de buscar condutor`: localhost:9080/condutor/974feaa6-ca9b-49f5-af30-53068c6c558b
  
exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/d1f63c53-d868-492c-a514-228fc8506498)
   <br>
   <br>
- `(DELETE) API de deletar condutor`:
- `API de deletar condutor`: localhost:9080/condutor/974feaa6-ca9b-49f5-af30-53068c6c558b
  
exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/c0fe5205-401a-4134-9037-928f03df7b46)



### API Veiculo
- `(POST) API de cadastrar veiculo`:
- `Rota POST - veiculo`: localhost:9080/veiculo

exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/078bf7ae-6b6d-46f4-9303-21209a09b693)


- `(PUT) API de atualizar veiculo`:
- `Rota PUT - veiculo`: localhost:9080/veiculo/d016480b-597b-4c94-b761-7ff746328afe

exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/3ebe51a2-1c24-4a85-93ba-99f22b386fdd)


- `(GET) API de buscar veiculo`:
- `Rota GET - veiculo`: localhost:9080/veiculo/d016480b-597b-4c94-b761-7ff746328afe

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/92755877-81db-4388-84e8-0310fc90176f)
  <br>
  <br>
- `(DELETE) API de deletar veiculo`:
- `Rota DELETE - veiculo`: localhost:9080/veiculo/d016480b-597b-4c94-b761-7ff746328afe

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/35906901-8335-4b39-81ce-0b9a480736f6)



### API Estacionamento
- `(POST) API de iniicar o estacionamento`:
- `Rota POST - estacionamento`: localhost:9080/estacionamento/iniciar

exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/d783b6fb-2c85-450c-8435-65816a2922d7)


- `(GET) API de buscar estacionamento`:
- `Rota GET - estacionamento`: localhost:9080/estacionamento/3b45155f-69b7-4400-a62b-7606feb970b0	

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/253f4823-2f81-4d9c-a539-6854080600c4)
  <br>

- `(GET) API de calcular estacionamento fixo`:
- `Rota GET - estacionamento`: localhost:9080/estacionamento/calcular_pagametno/3b45155f-69b7-4400-a62b-7606feb970b0

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/sistema-parquimetro/assets/64719344/27653158-5bc3-49ea-8cec-a09ba9f110d7)
  <br>


Dificuldades
* Esse módulo foi muito complicado por conta do tempo. O Grupo trabalha juntos na mesma empresa e foi muito corrido. Não tivemos tempo de focar completamente.
* Foi dificil encontrar horário para andarmos com o projeto e com o própria aulas do curso. Não foi possível preencher todos os requisitos. Não foi possível entregar
* todo o sistema como queriamos embora conseguimos cumpriar a maior parte. Tentar buscar para os proximos modulos mais tempo para focar nas atividades pois podemos entregar
* muito melhor. 
