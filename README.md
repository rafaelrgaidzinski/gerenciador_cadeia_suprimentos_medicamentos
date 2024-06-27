Projeto de uma API para o gerenciamento de uma cadeia de suprimentos de medicamentos.

Este projeto foi desenvolvido utilizando a linguagem Java e o framework Spring Boot.

O projeto foi implementado com os seguintes models:

- Endereco Model
- FornecedorModel
- Insumo Model
- ServicosModel

Além dos models foram implementados os Dtos para cada model para fazer a validação dos dados do corpo da requisição HTTP.

Para persistir os dados foram criados os repositories para os respectivos models que herdam as funções da classe JpaRepository
para realizar a persistência dos dados no banco de dados Postgres que teve sua depedência adicionada no pom.xml e foi configurado no arquivo 
application.properties.

Foram implementados os seguintes Services:

- FornecedorService, InsumosService e ServicosService: com os métodos save, delete e findAllPageable, findById e FindBynome que serão utilizados
no Controller para a criação do CRUD e que utilizam da Annotation @Autowired para fazer a injeção de dependência dos respectivos @Repositories.

Os seguintes Controllers foram implementados:

- FornecedorController, InsumosController e ServicosController: que utilizam da Annotation @Autowired para fazer a injeção de dependência dos
respectivos @Services e possuem os métodos POST para salvar, PUT para atualizar, DELETE para deletar e GET para buscar todas ou somente uma informação.
- AjudaController: foi implementado somente com o método GET para retornar as informações do projeto.


Para executar este projeto, basta seguir os seguintes passos:

1- Abrir o terminal de comando (CMD) e navegar até o diretório onde deseja salvar o projeto 

2- Utilizar o seguinte comando no terminal para copiar o projeto para o seu repositório local: 
   git clone https://github.com/rafaelrgaidzinski/gerenciador_cadeia_suprimentos_medicamentos.git

3- Abrir a pasta do projeto utilizando o IntelliJ ou outra IDE

4- No arquivo application.properties que fica na pasta resources do projeto substituir a configuração do Postgres para o H2 com a seguinte configuração:

spring.application.name=gerenciamento <br>
spring.datasource.url=jdbc:h2:mem:gerenciamento <br>
spring.jpa.generate-dll=true <br>
spring.jpa.hibernate.dll-auto=update <br>
spring.h2.console.enabled=true <br>
spring.jpa.show-sql=true <br>

5- Após configurar o banco de dados deve-se executaar o projeto e utilizar o Postman ou Insomnia para realizar as requisições HTTP conforme os exemplos abaixo:


## GET

Para realizar este tipo de requisiçao deve-se selecionar o método GET e informar uma das seguintes URL que irá retornar as informações de forma 
paginada com 5 itens por página, caso não seja informado nenhum parametro:

- http://localhost:8080/fornecedores
- http://localhost:8080/insumos
- http://localhost:8080/servicos

É possível também informar os seguintes parametros para customizar a paginação:

http://localhost:8080/servicos?&pagina=1&resultados=3

## POST

Para persistir uma informação no banco de dados através da API deve-se realizar a seguinte configuração utilizando o método POST:


### Fornecedores

#### URL
http://localhost:8080/fornecedores

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Fornecedor A", 
  "cnpj": "12345678000100",
  "telefone": "(11) 1234-5678",
  "enderecoId": 1
}
```
### Insumos

#### URL
http://localhost:8080/insumos

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Farinha de Trigo",
  "descricao": "Farinha para uso culinário",
  "unidade": "kg",
  "quantidadeAtual": 25.5
}
```

### Servicos

#### URL
http://localhost:8080/servicos

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Validação de Processos",
  "descricao": "Serviço de validação de processos farmacêuticos conforme regulamentação vigente."
}
```

## PUT

Para Atualizar uma informação no banco de dados através da API deve-se realizar a seguinte configuração utilizando o método PUT:

### Fornecedores

#### URL
http://localhost:8080/fornecedores/{id}

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Fornecedor Z",
  "cnpj": "12345678000100",
  "telefone": "(11) 1234-5678",
  "enderecoId": 3
}
```

### Insumos

#### URL
http://localhost:8080/insumos/{id}

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Trigo",
  "descricao": "Trigo para uso culinário",
  "unidade": "kg",
  "quantidadeAtual": 20.0
}
```

### Servicos

#### URL
http://localhost:8080/servicos/{id}

##### Headers
Content-Type = application/json

#### Body
```
{
  "nome": "Validação ",
  "descricao": "Serviço de processos farmacêuticos conforme regulamentação vigente."
}
```

## DELETE

Para excluir informações do banco de dados deve-se realizar utilizar o método DELETE utilizando uma das seguintes URLs 
e informar o ID da informação que deseja excluir como parametro:

- http://localhost:8080/fornecedores/{id}
- http://localhost:8080/insumos/{id}
- http://localhost:8080/servicos/{id}
