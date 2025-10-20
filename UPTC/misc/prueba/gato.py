import threading
import time
import random

N = 5  # número de filósofos (y tenedores)
EAT_TIMES = 3  # cuántas veces come cada filósofo en la demo

# Un tenedor es un Lock
forks = [threading.Lock() for _ in range(N)]

# Mayordomo: permite hasta N-1 filósofos "intentando comer" a la vez
butler = threading.Semaphore(N - 1)

def philosopher(i: int):
    left = forks[i]
    right = forks[(i + 1) % N]
    for meal in range(EAT_TIMES):
        # Pensar
        think_time = random.uniform(0.2, 0.8)
        print(f"Philosopher {i} is thinking for {think_time:.2f}s.")
        time.sleep(think_time)

        # Pide permiso al mayordomo para intentar coger tenedores
        print(f"Philosopher {i} asks the butler for permission to eat.")
        with butler:  # bloquea hasta que se permita (como N-1)
            print(f"Philosopher {i} got permission from the butler.")

            # Coger tenedores: primero izquierda, luego derecha (orden fijo)
            print(f"Philosopher {i} tries to pick up left fork.")
            left.acquire()
            print(f"Philosopher {i} picked up left fork.")

            print(f"Philosopher {i} tries to pick up right fork.")
            right.acquire()
            print(f"Philosopher {i} picked up right fork.")

            # Comer
            eat_time = random.uniform(0.2, 0.6)
            print(f"Philosopher {i} is eating for {eat_time:.2f}s. (meal {meal+1})")
            time.sleep(eat_time)

            # Soltar tenedores
            left.release()
            right.release()
            print(f"Philosopher {i} released both forks and thanks the butler.")

    print(f"Philosopher {i} is done (finished {EAT_TIMES} meals).")

def main():
    threads = []
    for i in range(N):
        t = threading.Thread(target=philosopher, args=(i,), daemon=False)
        threads.append(t)
        t.start()

    for t in threads:
        t.join()

    print("All philosophers have finished.")

if __name__ == "__main__":
    main()
