+#!/bin/bash

# Definir la URL base del servicio
BASE_URL="http://localhost:8080/Calculadora/calculadora"

# Suma
echo "Probando Suma..."
curl -X GET "$BASE_URL/suma?operando1=10&operando2=5" -H "Accept: application/json"
echo -e "\n"

# Resta
echo "Probando Resta..."
curl -X GET "$BASE_URL/resta?operando1=10&operando2=5" -H "Accept: application/json"
echo -e "\n"

# Multiplicación
echo "Probando Multiplicación..."
curl -X GET "$BASE_URL/multiplicacion?operando1=6&operando2=7" -H "Accept: application/json"
echo -e "\n"

# División
echo "Probando División..."
curl -X GET "$BASE_URL/division?operando1=20&operando2=4" -H "Accept: application/json"
echo -e "\n"

# División por cero (error esperado)
echo "Probando División por Cero..."
curl -X GET "$BASE_URL/division?operando1=10&operando2=0" -H "Accept: application/json"
echo -e "\n"
