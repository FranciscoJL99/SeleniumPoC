# Reto Selenium
[![gradle](https://img.shields.io/badge/gradle-v6.8.X-yellow.svg)](https://gradle.org/install/)

## Prerequisites

Necesitarás las siguientes herramientas debidamente instaladas en tu ordenador.

* [Gradle](https://gradle.org)
* [Java JDK 1.8](https://www.oracle.com/java/technologies/downloads/)

## Descripción

En este proyecto se desarrolló la automatización de la funcionalidad en las páginas de:
* [Automation Practice](http://automationpractice.com/index.php)
* [DemoQA](https://demoqa.com/automation-practice-form)
  
Se buscó trabajar con [Selenium](https://www.selenium.dev/) como core de la automatización junto con [JUnit](https://junit.org/junit5/), sin aplicación de patrones, para ver como podemos trabajar directo con el framework.
De igual forma se aplica uno de los flujos con patron POM.

## Ejecución

Para ejecutar este proyecto, se recomienda reemplazar el chromedriver.exe por uno compatible con la versión de su navegador Chrome. Adicional para ejecutar desde consola se debe acceder a la raiz y ejecutar el comando
* `gradle clean test`

De igual forma puede dirigirse a las clases test y ejecutar de forma manual desde el IDE, con solo dar Run desde la etiqueta `Test`.

## Consideraciones


Si desea ingresar nuevos valores a la ejecución, dirijase al archivo del test a que quiere reemplazar y cambie a los valores que desea ver en la ejecución en los `SenKeys`.