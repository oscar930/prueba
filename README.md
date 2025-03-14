# prueba
descripcion del repositorio

# API de Tickets (Spring Boot + GraphQL + PostgreSQL)

#Se necesita tener isntalado estas herramientas antes de correrlo
Docker
Docker Compose
Java 17+
Maven
Git

##  Cómo ejecutar en local

# 1 Clonar el repositorio

git clone https://github.com/oscar930/prueba.git
cd prueba


# 2 Levantar Docker
docker-compose up -d

docker start postgres_prueba

#Ejecutar el siguiente comando apra correr migraciones 
mvn clean flyway:migrate