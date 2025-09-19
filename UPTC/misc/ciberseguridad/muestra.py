import matplotlib.pyplot as plt
import numpy as np

# Fases de Sponge
fases = ["Absorción", "Permutación", "Exprimido"]

# Estado simulado (matriz de bits 8x8 para que se vea mejor)
estado = np.zeros((8, 8))

fig, axes = plt.subplots(1, 3, figsize=(12, 4))

for i, fase in enumerate(fases):
    ax = axes[i]
    
    if fase == "Absorción":
        # El mensaje entra (rellenamos con un patrón de bits)
        estado = np.random.randint(0, 2, size=(8, 8))
    elif fase == "Permutación":
        # Mezclamos (simulación de permutación)
        estado = np.roll(estado, shift=2, axis=1) ^ np.roll(estado, shift=3, axis=0)
    elif fase == "Exprimido":
        # Sacamos parte del estado como salida
        estado = estado[:4, :4]  # solo una parte visible
    
    ax.imshow(estado, cmap="Blues", vmin=0, vmax=1)
    ax.set_title(fase, fontsize=14)
    ax.axis("off")

plt.suptitle("Demostración visual de SHA-3 (Sponge)", fontsize=16)
plt.show()
