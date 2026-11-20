# ServerRest-java-restassured-cucumber

Projeto de automação de testes de API e UI com Java, Maven, Cucumber, JUnit, RestAssured e Selenium. Os cenários em Gherkin verificam o payload da listagem de usuários e a disponibilidade do formulário de login do ServeRest, sem alterar dados.

## Pré-requisitos

- Java 17 e Maven 3.8 ou superior.
- Google Chrome e um ChromeDriver compatível no PATH, ou acesso à internet para o Selenium Manager obter o driver.
- Acesso à API (`https://serverest.dev`) e à interface (`https://front.serverest.dev`).

## Execução

```bash
mvn test
```

O Chrome é executado em modo headless. Para executar apenas uma categoria:

```bash
mvn test -Dcucumber.filter.tags=@api
mvn test -Dcucumber.filter.tags=@ui
```

As URLs base podem ser substituídas por propriedades Maven, por exemplo:

```bash
mvn test -Dapi.url=http://localhost:3000 -Dui.url=http://localhost:3001
```

O relatório Cucumber é gerado em `target/cucumber-report.html`. A execução depende da disponibilidade e dos dados dos serviços configurados. O GitHub Actions executa os dois cenários em pushes e pull requests, além de permitir execução manual.
