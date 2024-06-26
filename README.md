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

spring.application.name=gerenciamento
spring.datasource.url=jdbc:h2:mem:gerenciamento
spring.jpa.generate-dll=true
spring.jpa.hibernate.dll-auto=update
spring.h2.console.enabled=true
spring.jpa.show-sql=true

5- Após configurar o banco de dados deve-se executaar o projeto e utilizar o Postman ou Insomnia para realizar as requisições HTTP conforme os exemplos abaixo:


# GET

# POST

# PUT

# DELETE
