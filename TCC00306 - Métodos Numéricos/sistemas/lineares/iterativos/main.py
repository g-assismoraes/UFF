from iterativos import *

'''a = [[5, 1, 1], [3, 4, 1], [3, 3, 6]]
c = [6, 13, 0]'''

'''a = [[1, -3, 4], [-1, 4, -3], [3, -5, 2]]
c = [5, 0, -7]'''

''''a = [[10, 2, 1], [1, 5, 1], [2, 3, 10]]
c = [7, -8, 6]'''

'''a = [[3, 2, -1], [2, -4, 2], [-1, 1, 5]]
c = [8, -4, 3]'''

'''a = [[10, -2], [-3, 12]]
c = [8, 9]'''

'''a = [[6.5, 1.5], [36.75, 32.75]]
c = [17.5, 167.25]'''

'''a = [[6, -1], [3, 8]]
c = [5, 11]'''

'''a = [[-3, 12], [10, -2]]
c = [9, 8]'''

a = [[10, -2], [-3, 12]]
c = [8, 9]


A = np.zeros((len(a), len(a[0])))

b = np.zeros((len(c), 1))
for i in range(len(a)):
    A[i] = a[i]
for i in range(len(c)):
    b[i] = c[i]

x1 = np.linalg.solve(A, b)

print(x1)
print("---------------------")

if len(A) == len(b):
    print("Os valores de x que satisfazem o sistema, calculados por Gauss-Seidel são: \n {}.".format(gauss_seidel(A, b, 0.0001, 20, 1.25)))
    print("Os valores de x que satisfazem o sistema, calculados por Jacobi são: \n {}.".format(jacobi(A, b, 0.001, 20)))
else: print("O tamanho da matriz A e do vetor b não são compatíveis")
