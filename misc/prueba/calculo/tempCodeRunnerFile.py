# --- Optimización caja USPS con base cuadrada (con slider y valores en el gráfico) ---
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.widgets import Slider

# --- Funciones matemáticas ---
def longitud(s):
    return 108 - 4*s  # Restricción del USPS

def volumen(s):
    L = longitud(s)
    return s**2 * L if L >= 0 else 0

# --- Datos iniciales ---
s_inicial = 18.0
s_vals = np.linspace(0, 27, 300)
V_vals = [volumen(x) for x in s_vals]

# --- Configurar figura ---
fig, ax = plt.subplots(figsize=(8, 4))
plt.subplots_adjust(bottom=0.25)

# Gráfica inicial
(linea,) = plt.plot(s_vals, V_vals, color='orange', label='V(s) = s²(108 - 4s)')
(punto,) = plt.plot(s_inicial, volumen(s_inicial), 'bo', label='Punto actual')
linea_vertical = ax.axvline(s_inicial, color='blue', linestyle='--', alpha=0.5)
plt.title("Volumen de la caja según el lado de la base (s)")
plt.xlabel("Lado de la base s (pulgadas)")
plt.ylabel("Volumen (pulgadas³)")
plt.grid(True)
plt.legend()

# --- Texto en el gráfico (se actualizará dinámicamente) ---
L_inicial = longitud(s_inicial)
V_inicial = volumen(s_inicial)
texto_info = ax.text(
    0.05, 0.95,
    f"s = {s_inicial:.2f} pulgadas\nL = {L_inicial:.2f} pulgadas\nV = {V_inicial:.2f} pulgadas³",
    transform=ax.transAxes,
    fontsize=11,
    verticalalignment='top',
    bbox=dict(facecolor='white', alpha=0.8, edgecolor='gray')
)

# --- Crear slider ---
ax_slider = plt.axes([0.15, 0.1, 0.7, 0.05])
slider_s = Slider(ax_slider, "Lado s (pulgadas)", 0, 27, valinit=s_inicial, valstep=0.5)

# --- Función de actualización ---
def actualizar(val):
    s = slider_s.val
    L = longitud(s)
    V = volumen(s)

    # Actualizar punto y línea vertical
    punto.set_data([s], [V])
    linea_vertical.set_xdata([s])

    # Actualizar texto dentro del gráfico
    texto_info.set_text(f"s = {s:.2f} pulgadas\nL = {L:.2f} pulgadas\nV = {V:.2f} pulgadas³")

    fig.canvas.draw_idle()

# --- Conectar slider ---
slider_s.on_changed(actualizar)

# --- Mostrar ---
plt.show()
