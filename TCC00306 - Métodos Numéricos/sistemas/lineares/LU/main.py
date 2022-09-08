from lu import *

'''a = [[5, 1, 1], [3, 4, 1], [3, 3, 6]]
c = [6, 13, 0]'''

'''a = [[1, -3, 4], [-1, 4, -3], [3, -5, 2]]
c = [5, 0, -7]'''

a = [[3, 2, -1], [2, -4, 2], [-1, 1, 5]]
c = [8, -4, 3]


A = np.zeros((len(a), len(a[0])))
b = np.zeros((len(c), 1))
for i in range(len(a)):
    A[i] = a[i]
for i in range(len(c)):
    b[i] = c[i]

x1 = np.linalg.solve(A, b)

'''print(x1)
print("---------------------")'''



if len(A) == len(b): print("Os valores de x que satisfazem o sistema são {}.".format(lu(A, b)))
else: print("O tamanho da matriz A e do vetor b não são compatíveis")