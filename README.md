# api-cuentas
- Se incluye script sql "BaseDatos.sql"
- Despliegue con Dockerfile ubicado en la raíz del proyecto
1. Ejecutar "gradlew clean build" en la raíz del proyecto para generar el .jar
2. No situamos afuera de la carpeta del proyecto y ejecutamos "docker build -t api-cuentas api-cuentas", esto creará la imagén docker.
3. Ejecutamos el siguiente comando para crear el contenedor docker: "docker run --name api-cuentas -e TZ=America/Bogota -d -p 8080:8080 api-cuentas:latest &
   "
4. Finalmente iniciamos el contenedor con "docker start api-cuentas"
