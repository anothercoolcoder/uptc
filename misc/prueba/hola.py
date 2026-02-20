import numpy as np
import matplotlib.pyplot as plt

# Datos del problema
x = np.array([1, 2, 3, 4, 5, 6])
y = np.array([40, 85, 140, 200, 225, 245])

# Ajuste polinomico de tercer grado
coef = np.polyfit(x, y, 3)
modelo = np.poly1d(coef)

# Estimacion para 4.5 (4500 revoluciones por minuto)

x_pred = 4.5
y_pred = modelo(x_pred)

# Graficar datos y modelo
x_line = np.linspace(1, 6, 100)
y_line = modelo(x_line)

plt.scatter(x, y, color="red", label="Datos")
plt.plot(x_line, y_line, color="blue", label="Modelo cúbico")
plt.scatter(x_pred, y_pred, color="green", s=100, label=f"Estimación (x=4.5, y={y_pred:.2f})")
plt.xlabel("x (miles de RPM)")
plt.ylabel("Potencia (HP)")
plt.title("Regresión Polinómica Cúbica")
plt.legend()
plt.grid(True)
plt.show()

coef, y_pred
