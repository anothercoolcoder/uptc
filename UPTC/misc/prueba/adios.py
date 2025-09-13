import numpy as np
import matplotlib.pyplot as plt
from matplotlib.widgets import Slider

# Datos del problema
x = np.array([1, 2, 3, 4, 5, 6])
y = np.array([40, 85, 140, 200, 225, 245])

# Ajuste polinómico de tercer grado
coef = np.polyfit(x, y, 3)
modelo = np.poly1d(coef)

# Configuración de la figura
fig, ax = plt.subplots()
plt.subplots_adjust(bottom=0.25)  # espacio para el slider

# Curva del modelo
x_line = np.linspace(1, 6, 200)
y_line = modelo(x_line)
ax.plot(x_line, y_line, color="blue", label="Modelo cúbico")

# Datos originales
ax.scatter(x, y, color="red", label="Datos")

# Punto inicial de predicción
x_pred = 4.5
y_pred = modelo(x_pred)
(point,) = ax.plot(x_pred, y_pred, "go", markersize=12, label=f"Estimación (x={x_pred:.2f}, y={y_pred:.2f})")

ax.set_xlabel("x (miles de RPM)")
ax.set_ylabel("Potencia (HP)")
ax.set_title("Regresión Polinómica Cúbica con Slider")
ax.grid(True)
ax.legend()

# Slider en la parte inferior
ax_slider = plt.axes([0.2, 0.1, 0.6, 0.03])  # posición del slider [izq, abajo, ancho, alto]
slider = Slider(ax_slider, "x_pred", 1, 6, valinit=4.5, valstep=0.1)

# Función de actualización
def update(val):
    x_val = slider.val
    y_val = modelo(x_val)
    point.set_data([x_val], [y_val])  # mover el punto verde
    point.set_label(f"Estimación (x={x_val:.2f}, y={y_val:.2f})")
    ax.legend(loc="best")
    fig.canvas.draw_idle()

slider.on_changed(update)

plt.show()
