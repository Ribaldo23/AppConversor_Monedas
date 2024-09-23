# Conversor de Monedas en Java

Este proyecto es un conversor de monedas que utiliza la API de [Fixer.io](https://fixer.io/)
para obtener tasas de cambio en tiempo real. El programa permite convertir diferentes monedas y guardar las conversiones realizadas en un archivo.

## Funcionalidades

- Conversión de monedas entre EUR y otras divisas (USD, GBP, JPY, AUD, CAD, CHF, CNY).
- Manejo de errores robusto para la conexión a la API.
- Opción para cargar tasas de cambio desde un archivo local en caso de fallo de conexión.
- Opción para guardar las conversiones realizadas en un archivo.

## Estructura del Proyecto

El proyecto está dividido en varias clases:

- **APIClient**: Maneja la conexión a la API y obtiene las tasas de cambio.
- **ConversorMonedas**: Realiza las conversiones de moneda y almacena las conversiones realizadas.
- **GestorArchivos**: Se encarga de escribir las conversiones en un archivo.
- **Moneda**: Representa una moneda y su tasa de cambio.
- **AppConversor**: Clase principal que interactúa con el usuario.

## Requisitos

- JDK 8 o superior
- Conexión a Internet para acceder a la API (o un archivo de tasas de cambio local).
  
