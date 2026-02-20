def mini_sponge(mensaje, rounds):

    state = [0] * 16  # estado pequeño de 16 enteros

    # --- Absorción ---
    for i, b in enumerate(mensaje.encode("utf-8")):
        state[i % len(state)] ^= b  # mezcla con XOR

    # --- Permutaciones simuladas ---
    for r in range(rounds):
        state = [(x * 7 + r) % 256 for x in state]  # "mezcla"

    # --- Exprimido ---
    return ''.join(f"{x:02x}" for x in state[:8])  # 8 bytes como "hash"

# Ejemplo
print("Escriba lo que desea ocultar")
x = input()
print("Mini esponja -> ", mini_sponge(x,3))
