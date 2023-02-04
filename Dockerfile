FROM jdk-17.0.4.1
MAINTAINER jhoanslopez@outlook.com
COPY build/libs/api-cuentas-0.0.1-SNAPSHOT.jar api-cuentas-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/api-cuentas-0.0.1-SNAPSHOT.jar"]
RUN apk add --update --no-cache openssh
RUN mkdir -p /temp
RUN chmod 755 /temp