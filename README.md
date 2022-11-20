# api-rest-voll-med
API Rest da aplicação Voll.med - Curso alura de Java .

Criado configuração automatica do SpringBoot pelo site
https://start.spring.io/

Seguindo padrão DTO(Data Transfer Object), implementação utilizando Record, lançado oficial no java 16.
O record é um recurso que permite representar uma classe imutável, contendo apenas atributos, construtor e métodos de leitura, de uma maneira muito simples e enxuta.

Documentação do Record : https://docs.oracle.com/en/java/javase/16/language/records.html

Banco de dados: Utilizando MYSQL e padrão repository!

Por que o padrão repository ao invés do DAO utilizando Spring?
O padrão de repositório incentiva um design orientado a domínio, fornecendo uma compreensão mais fácil do domínio e da estrutura de dados. Além disso, utilizando o repository do Spring não temos que nos preocupar em utilizar diretamente a API da JPA, bastando apenas criar os métodos que o Spring cria a implementação em tempo de execução, deixando o código muito mais simples, menor e legível.

Usaremos migrations, ou ferramentas de migrações, para registrar as atualizações no banco de dados. Já registramos o Flyway, uma dessas ferramentas suportadas pelo Spring Boot.