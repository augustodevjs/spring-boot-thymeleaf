## 🖼️ Spring Boot - Thymeleaf

<p align="justify">
Utilizei o Spring Boot com Thymeleaf para desenvolver uma aplicação. Dividi os módulos e conectei tudo ao banco de dados MySQL. 
</p>
<p align="justify">
  Dito isso, o projeto foi estruturado em 4 "camadas" que são:
</p>

- **Controller**: Pacote referente aos controllers do sistema;
- **application**: Encarregado da comunicação com o Domain, incluindo classes de serviços e interfaces;
- **Repositories**: Abrange o suporte geral a outras implementações, como repositórios;
- **Entities**: Contém todas as entidades, interfaces e validações;

## 💡 Rodando o Projeto

### Pre-requisitos

Antes de tudo é necessário instalar:

- Instalar o Java 17
- IntelliJ
- MySql

- Clonando o repositório
  ```sh
  git clone https://github.com/augustodevjs/spring-boot-thymeleaf
  ```

### Configuração do Banco

Abra o arquivo application.properties e ajuste as seguintes variáveis de acordo com as configurações do seu banco de dados.
Certifique-se de alterar as informações de URL, username e password conforme as configurações do seu banco de dados.
Inicie o projeto no IntelliJ e verifique se a aplicação se conecta corretamente ao banco de dados.

## :desktop_computer: Principais tecnologias utilizadas no Projeto

- <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Java 17</a>
- <a href="https://www.thymeleaf.org">Thymeleaf</a>
- <a href="https://spring.io/projects/spring-boot">SpringBoot</a>
- <a href="https://www.mysql.com">MySql</a>
