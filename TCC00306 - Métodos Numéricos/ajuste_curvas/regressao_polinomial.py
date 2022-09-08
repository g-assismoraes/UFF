import numpy as np
import matplotlib.pyplot as plt


def calcula_somatorios(x, y, grau):
    somatoriosX = [0]*(grau*2 + 1)
    somatoriosY = [0]*(grau + 1)

    for i in range(grau*2 + 1):
        for j in range(len(x)):
            somatoriosX[i] += x[j]**(i)

    for i in range(grau + 1):
        for j in range(len(x)):
            somatoriosY[i] += y[j]*x[j]**(i)
    
    somatoriosX = np.array(somatoriosX)
    somatoriosY = np.array(somatoriosY)
    return somatoriosX, somatoriosY

def monta_matriz(somatorios, grau):
    matriz = np.zeros((grau+1, grau+1))

    for i in range(grau+1):
        for j in range(grau+1):
            matriz[i][j] = somatorios[i+j]
    
    return matriz


x = np.array([0, 1, 2, 3, 4, 5])
y = np.array([2.1, 7.7, 13.6, 27.2, 40.9, 61.1])
somatoriosX, somatoriosY = calcula_somatorios(x, y, 2)
A = monta_matriz(somatoriosX, 2)

r = np.linalg.solve(A, somatoriosY)

aux = []
for i in range(len(x)):
    aux.append(r[0] + r[1]*x[i] + r[2]*x[i]*x[i])

plt.plot(x, y, "o", color="midnightblue")
plt.plot(x, aux, color="slateblue")
plt.show()

print(r)
