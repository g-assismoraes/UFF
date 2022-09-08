import numpy as np
from gauss import gauss

'''a = [[3, -0.1, -0.2], [0.1, 7, -0.3], [0.3, -0.2, 10]]
c = [7.85, -19.3, 71.4]'''

'''a = [[0.0003, 3], [1, 1]]
c = [2.0001, 1]'''

'''a = [[0, 2, 3], [4, 6, 7], [2, -3, 6]]
c = [8, -3, 5]'''

'''a = [[1, -3, 4], [-1, 4, -3], [3, -5, 2]]
c = [5, 0, -7]'''

'''a = [[5, 1, 1], [3, 4, 1], [3, 3, 6]]
c = [6, 13, 0]'''

a = [[6.5, 1.5], [36.75, 32.75]]
c = [17.5, 167.25]


A = np.zeros((len(a), len(a[0])))
b = np.zeros((len(c), 1))
for i in range(len(a)):
    A[i] = a[i]
for i in range(len(c)):
    b[i] = c[i]

#x1 = np.linalg.solve(A, b)

#print(x1)



if len(A) == len(b): print("Os valores de x que satisfazem o sistema são {}.".format(gauss(A, b, True)))
else: print("O tamanho da matriz A e do vetor b não são compatíveis")