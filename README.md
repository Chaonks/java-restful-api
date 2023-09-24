 # Publicando Api Rest SpringBoot 3 +  Java + Gradle na Nuvem
 
 - Tem como o objetivo a criação da uma api para organizar música em playlist

## Tecnologias utilizadas

<div style="display: inline_block">
</br>
  <img height="60" width="" align="center"alt="java"src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg"/>
  <img height="30" width="" align="center"alt="swagger"src="https://www.nearshoretechnology.com/sites/default/cache/file/407A40F4-EC23-4856-A6E28B4B9CCF61AB.png" />&nbsp;&nbsp;&nbsp;
  <img height="30" width="" align="center"alt="spring"src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />&nbsp;&nbsp;&nbsp;
  <img height="25" width="" align="center"alt="Gradle"src="https://www.cdnlogo.com/logos/g/48/gradle.svg" /> &nbsp;&nbsp;&nbsp;
  <img height="60" width="" align="center"alt="git"src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-plain-wordmark.svg" />&nbsp;&nbsp;&nbsp;
  <img height="35" width="" align="center"alt="github"src="https://cdn-icons-png.flaticon.com/512/270/270798.png" /> 
  &nbsp;&nbsp;&nbsp;
  <img height="50" width="" align="center"alt="UML"src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/UML_logo.svg/400px-UML_logo.svg.png?20201218070520" />&nbsp;&nbsp;&nbsp;
  <img height="40" width="" align="center"alt="railaway"src="https://railway.app/brand/logotype-light.png" /> 
  &nbsp;&nbsp;&nbsp;
  <img height="50" width="" align="center"alt="PostgrSQL"src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-plain.svg" />
              

</div></br>

- Java Jdk&nbsp; 17
- Swagger &nbsp;&nbsp;OpenApi &nbsp; 2.2.0
- Spring &nbsp;  3.1.3
- Gradle &nbsp;  7.6.1 
- PostgreSQL - Versão via Gradle (runtimeOnly 'org.postgresql:postgresql')
- RailAway - Plataforma Hospedeira de Soluções
- Git - Sistema de controle de versões
- GitHub - Plataforma de hospedagem de código
- UML - Linguagem padrão para a elaboração da estrutura de projeto

## O Código


- O Back-End tem os métodos do CRUD para cada entidade <br>
Nos métodos "adicionarPlaylist" e "adicionarMusica", tem como requisito o "id" dos itens que deseja associar<br>
- No tratamento de exceções, foi aplicado o padrão RFC 7807 - Problem Details for HTTP APIs, que detalha com mais precisão uma possível "exceção"

## A UML

```mermaid
classDiagram
    class Music {
        -id: Integer
        -name: String
    }
    class Playlist {
        -id: Integer
        -name: String
        -users: List<User>
        -musics: List<Music>
    }
    class User {
        -id: Integer
        -name: String
        -playlists: List<Playlist>
        -playlist: Playlist
    }

    Music -- Playlist: "1" * -- "N" *
    Playlist -- User: "1" * -- "N" *
    Playlist -- Music: "N" * -- "N" *
    User -- Playlist: "N" * -- "1" *
    User -- Playlist: "1" * -- "1"
```

