# api-cuentas

Se desarrollo la siguiente API con SpringBoot 3.0.2, java en su versión 17 y gestor de dependencias gradle. Se realizaron pruebas unitarias con JUnit y Mockito, por otro lado se implementó bajo una arquitectura limpia orientada al dominio y uso de documentación swagger.


- Se incluye script sql "BaseDatos.sql" en los resources del proyecto
- Se incluye proyecto postman "API CUENTAS.postman_collection.json" en los resources del proyecto
- Se incluye Dockerfile ubicado en la raíz del proyecto
- Link swagger: "http://localhost:8080/api/swagger-ui/index.html"

# Docker
Verificar que se tiene la versión JDK 17
1. Ejecutar "gradlew clean build" en la raíz del proyecto para generar el .jar
2. Nos situamos afuera de la carpeta del proyecto y ejecutamos "docker build -t api-cuentas api-cuentas", esto creará la imagén docker.
3. Ejecutamos el siguiente comando para crear el contenedor docker: "docker run --name api-cuentas -e TZ=America/Bogota -d -p 8080:8080 api-cuentas:latest &
   "
4. Finalmente iniciamos el contenedor con "docker start api-cuentas"
