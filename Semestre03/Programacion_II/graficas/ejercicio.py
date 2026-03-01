import pandas as pd
import matplotlib.pyplot as plt

datos = pd.read_excel("ejercicio.xlsx")

plt.figure(figsize=(10,5))
plt.plot(datos['Mes'],datos['Ventas_Totales'], marker='o',linestyle='-',color='b',label='Ventas $')
plt.title('Tendencia de ventas - UPTC')
plt.xlabel('Mes')
plt.ylabel('Ventas en COP')
plt.grid(True)
plt.legend()
plt.show()

plt.figure(figsize=(7, 7))
plt.pie(datos['Ventas_Junio'], labels=datos['Categoria'], startangle=90)
plt.title('Participación de Ventas por Categoría (Junio)')
plt.show()