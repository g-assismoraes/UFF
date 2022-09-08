import numpy as np
import scipy.stats as sts
import matplotlib.pyplot as plt

def interpol_polinomial(x, y, v):
    n = len(x)

    matriz = []
    for i in range(n):
        linha = []
        for j in range(n):
            linha.append(x[i]**(n-j-1))
        matriz.append(linha)

    matriz = np.array(matriz)

    r = np.linalg.solve(matriz, y)

    y_interpolado = 0
    j = 0
    for i in range(len(r) - 1, -1, -1):
        y_interpolado += r[i] * v**j
        j += 1

    return r, y_interpolado

''' --------------------------------- Linear ---------------------------------------- '''
temperaturas_2 = (300, 400)
temperaturas_2 = np.array(temperaturas_2)

me_2 = (0.616, 0.525)
me_2 = np.array(me_2)

print("Linear: ")
r_linear, resp = interpol_polinomial(temperaturas_2, me_2, 350)
print(r_linear)
x = r_linear[0]*350 + r_linear[1]
print(resp)
print()

''' ------------------------------------- Quadrática -----------------------------------'''

temperaturas_3 = (300, 400, 500)
temperaturas_3 = np.array(temperaturas_3)

me_3 = (0.616, 0.525, 0.457)
me_3 = np.array(me_3)

print("Quadratica: ")
r_linear, resp = interpol_polinomial(temperaturas_3, me_3, 350)
print(r_linear)
x = r_linear[0]*350*350 + r_linear[1]*350 + r_linear[2]
print(resp)

#plt.plot(temperaturas, me, "o")
#plt.show()
