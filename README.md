# Intercorp challenge

El contenedor docker que aloja Jenkins fue creado con la siguiente configuración:

    ```
    FROM jenkins/jenkins:lts
    USER root
    RUN apt-get -y update && \
        apt-get install -y bash curl openrc git
    RUN curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
      && tar xzvf docker-17.04.0-ce.tgz \
      && mv docker/docker /usr/local/bin \
      && rm -r docker docker-17.04.0-ce.tgz
    USER jenkins
    EXPOSE 8080
    ```

## Jenkins Url
 * http://54.190.51.76:8080/

## Credenciales de acceso a Jenkins
 * Username: dryloayza
 * Password: dryloayza
 
## Endpoints
 * 172.17.0.3:8181/
 * 172.17.0.3:8181/api
 
***
Los endpoints son simplemente un hello world customizado que cuenta con una prueba unitaria como 
parte del proceso de construcción del jar para luego ser dockerizado y desplegado en la misma instancia EC2
 que aloja a Jenkins.