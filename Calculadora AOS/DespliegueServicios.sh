cd ./Calculadora
mvn clean package && mvn wildfly:deploy

cd ../Suma
mvn clean package && mvn wildfly:deploy

cd ../Resta
mvn clean package && mvn wildfly:deploy

cd ../Multiplicacion
mvn clean package && mvn wildfly:deploy

cd ../Division
mvn clean package && mvn wildfly:deploy