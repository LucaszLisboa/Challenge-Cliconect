# Challenge-Cliconect

Este é um sistema de gerenciamento de pacientes para uma clínica médica. Ele permite cadastrar pacientes com informações obrigatórias como nome, sexo, endereços, CPF (com validação), celular, data de nascimento (com validação) e e-mail (com validação). Além disso, permite registrar informações sobre os atendimentos médicos realizados.

O sistema também permite editar e excluir pacientes já cadastrados, além de oferecer recursos de listagem e busca/filtro pelo nome, e-mail e CPF.

Para o desenvolvimento, o backend do sistema expõe uma API REST e foi construído usando Java 17, Spring Data e Spring Boot. Além disso, foi adicionado testes unitários para garantir a qualidade do código. O frontend foi desenvolvido usando Angular.

<br>

# Como executar
Certifique-se de ter o Java 17 e o Maven instalados em sua máquina. Você pode verificar se eles estão instalados digitando "java -version" e "mvn -version" no terminal.

Faça o clone do repositório para sua máquina local.

Entre na pasta do backend no terminal e execute o seguinte comando para baixar as dependências do projeto:

``` mvn clean install ```

Entre na pasta do frontend do projeto e execute o seguinte comando para baixar as dependências do Angular:

``` npm install ```

Volte para pasta do backend do projeto e execute o seguinte comando para iniciar a aplicação:

``` mvn spring-boot:run``` 

Em outra aba do terminal, entre na pasta do frontend do projeto e execute o seguinte comando para iniciar o servidor do Angular:

``` ng serve ```

Ou ``` ng serve --open ``` para abrir a página no navegador diretamente.

Acesse a aplicação no navegador digitando "http://localhost:4200".
