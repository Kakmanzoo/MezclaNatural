# Mezcla Natural con Archivos en Java

Este proyecto implementa el **algoritmo de ordenamiento Mezcla Natural
(Natural Merge Sort)** en el contexto de **archivos de texto**.\
El objetivo es ordenar números almacenados en un archivo utilizando el
método de mezcla natural, generando archivos auxiliares en el proceso y
mostrando paso a paso cómo se realiza la mezcla.

------------------------------------------------------------------------

## 📌 ¿Qué es la Mezcla Natural?

La **Mezcla Natural** es una variante del método **Merge Sort** que
aprovecha las subsecuencias ya ordenadas en el archivo de entrada.\
El algoritmo divide el archivo en secuencias ordenadas llamadas **runs**
y las va mezclando sucesivamente en archivos auxiliares hasta obtener un
único archivo final completamente ordenado.

------------------------------------------------------------------------

## ⚙️ Funcionamiento del programa

1.  Se lee un archivo de entrada con números desordenados.
2.  El programa identifica subsecuencias ordenadas (**runs**) dentro del
    archivo.
3.  Divide estas secuencias en dos archivos auxiliares (`F1.txt`,
    `F2.txt`).
4.  Realiza la mezcla de los runs en un archivo de salida
    (`mezcla.txt`).
5.  Repite el proceso hasta que el archivo final esté totalmente
    ordenado.
6.  Muestra en consola el **paso a paso** de cómo se van formando las
    subsecuencias y cómo se realiza cada mezcla.

------------------------------------------------------------------------

## 📂 Estructura del Proyecto

    ├── src/
    │   └── MezclaNatural.java   # Código principal
    ├── datos.txt                # Archivo de entrada con los números desordenados
    ├── F1.txt                   # Archivo auxiliar 1
    ├── F2.txt                   # Archivo auxiliar 2
    ├── mezcla.txt               # Archivo de salida final ordenado
    └── README.md                # Documentación del proyecto

------------------------------------------------------------------------

## 🚀 Ejecución

1.  Coloca un archivo `datos.txt` en la raíz del proyecto con los
    números a ordenar.\
    Ejemplo de contenido:

        8 3 5 7 2 6 4 9

2.  Compila y ejecuta el programa:

    ``` bash
    javac MezclaNatural.java
    java MezclaNatural
    ```

3.  El programa generará los archivos auxiliares y mostrará en consola
    el proceso de mezcla.\
    El archivo `mezcla.txt` contendrá el resultado final ordenado.

------------------------------------------------------------------------

## 📖 Ejemplo de salida en consola

    ➡ Secuencias encontradas en datos.txt
    Run 1: 8
    Run 2: 3 5 7
    Run 3: 2 6
    Run 4: 4 9

    ➡ Mezcla paso 1
    F1: 8 3 5 7
    F2: 2 6 4 9
    Salida: 2 6 4 8 3 5 7 9

    ➡ Mezcla final
    Archivo mezcla.txt: 2 3 4 5 6 7 8 9

------------------------------------------------------------------------

## 🛠️ Requisitos

-   **Java JDK 8+**
-   Editor o IDE (Visual Studio Code, IntelliJ, NetBeans, etc.)

------------------------------------------------------------------------

## 👨‍💻 Kakmanzoo

Proyecto desarrollado como ejercicio de **estructuras de datos** para la
implementación del **método de mezcla natural** en archivos.
