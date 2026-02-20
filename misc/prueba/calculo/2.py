import numpy as np
import matplotlib.pyplot as plt
from matplotlib.widgets import Slider

plt.ion()

# ------------------------------
#      DATA GENERATION
# ------------------------------

# Range for x (Case 1)
x = np.linspace(0.1, 26.9, 1000)

# Volume function for Case 1
v1 = 108 * x**2 - 4 * x**3

# Range for h (Case 2)
h = np.linspace(0.1, 35.9, 1000)

# Volume function for Case 2
v2 = 54 * h**2 - 1.5 * h**3


# ==================================
#            GRAPH CASE 1
# ==================================

fig1 = plt.figure(figsize=(8, 6))
ax1 = fig1.add_subplot(111)
fig1.subplots_adjust(bottom=0.3)

ax1.plot(x, v1)

# DEFAULT VALUE for Case 1
x_default = 10
V1_default = 108 * x_default**2 - 4 * x_default**3

# Initial red point
point1, = ax1.plot(x_default, V1_default, 'ro')

# Initial text
text1 = ax1.text(
    0.05, 0.95,
    f"x = {x_default:.2f}, V = {V1_default:.2f}",
    transform=ax1.transAxes,
    fontsize=10,
    verticalalignment='top'
)

ax1.set_title("Volumen vs Lado Base (Caso 1)")
ax1.set_xlabel("x (in)")
ax1.set_ylabel("V (in^3)")
ax1.grid(True)

# Slider for Case 1
ax_slider1 = fig1.add_axes([0.15, 0.15, 0.7, 0.03])
slider1 = Slider(ax_slider1, 'x', x.min(), x.max(), valinit=x_default)


def update1(val):
    xv = slider1.val
    Vv = 108 * xv**2 - 4 * xv**3
    point1.set_data([xv], [Vv])
    text1.set_text(f"x = {xv:.2f}, V = {Vv:.2f}")
    fig1.canvas.draw_idle()


slider1.on_changed(update1)


# ==================================
#            GRAPH CASE 2
# ==================================

fig2 = plt.figure(figsize=(8, 6))
ax2 = fig2.add_subplot(111)
fig2.subplots_adjust(bottom=0.3)

ax2.plot(h, v2)

# DEFAULT VALUE for Case 2
h_default = 12
V2_default = 54 * h_default**2 - 1.5 * h_default**3

# Initial red point
point2, = ax2.plot(h_default, V2_default, 'ro')

# Initial text
text2 = ax2.text(
    0.05, 0.95,
    f"h = {h_default:.2f}, V = {V2_default:.2f}",
    transform=ax2.transAxes,
    fontsize=10,
    verticalalignment='top'
)

ax2.set_title("Volumen vs h (Caso 2)")
ax2.set_xlabel("h (in)")
ax2.set_ylabel("V (in^3)")
ax2.grid(True)

# Slider for Case 2
ax_slider2 = fig2.add_axes([0.15, 0.15, 0.7, 0.03])
slider2 = Slider(ax_slider2, 'h', h.min(), h.max(), valinit=h_default)


def update2(val):
    hv = slider2.val
    Vv = 54 * hv**2 - 1.5 * hv**3
    point2.set_data([hv], [Vv])
    text2.set_text(f"h = {hv:.2f}, V = {Vv:.2f}")
    fig2.canvas.draw_idle()


slider2.on_changed(update2)

plt.show(block=True)
