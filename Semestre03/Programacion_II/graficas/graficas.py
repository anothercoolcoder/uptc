import pandas as pd
import matplotlib.pyplot as plt

datos = pd.read_excel("graficas.xlsx")
print(datos)


x = datos['Nombre']
y = datos['Edad']

plt.bar(x,y)
plt.title("Edad por persona")
plt.xlabel("Nombres")
plt.ylabel("Edades")
plt.show()