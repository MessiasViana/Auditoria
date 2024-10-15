## Inicialização e Execução do Projeto
Este projeto é uma aplicação Spring Boot que foi configurada para rodar em um contêiner Docker. As instruções a seguir irão guiá-lo sobre como inicializar e executar a aplicação.

### Pré-requisitos
- **Docker**: Certifique-se de que o Docker está instalado em sua máquina. Você pode baixá-lo em: [Docker Download](https://www.docker.com/get-started)
- **Java JDK 17**: A aplicação requer o JDK 17. Verifique se está instalado usando `java -version`.

  
#### Executando o Projeto pelo código-fonte
1. **Clone o repositório**:
`git clone https://github.com/MessiasViana/Auditoria.git
Navegue até o diretório do projeto:
`cd Auditoria`
2. **Construir a imagem Docker**:
`docker build -t messiasviana/auditoria-app:latest .`
3. **Executar a imagem Docker**:
`docker run -d -p 8080:8080 messiasviana/auditoria-app:latest`
A aplicação estará acessível em `http://localhost:8080`.

#### Executando o Projeto pela imagem do Docker Hub
1. **Puxar a Imagem do Docker Hub**:
Use o seguinte comando para puxar a imagem:
`docker pull messiasviana/auditoria-app:latest`
2. **Iniciar o Contêiner**:
Após puxar a imagem, inicie um contêiner com o seguinte comando:
`docker run -d -p 8080:8080 messiasviana/auditoria-app:latest`
O parâmetro `-d` executa o contêiner em modo destacado (background).
3. **Acessar a Aplicação**:
Depois que o contêiner estiver em execução, você pode acessar sua aplicação através do navegador ou de ferramentas como `curl` em:
`http://localhost:8080`
