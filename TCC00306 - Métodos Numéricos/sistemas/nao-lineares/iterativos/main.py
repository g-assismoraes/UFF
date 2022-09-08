import numpy as np
from newton import newton

def F(x):
    f = np.zeros(2)

    '''f[0] = x[0]*x[0] + x[0]*x[1] - 10
    f[1] = x[1] + 3*x[0]*x[1]*x[1] - 57'''

    f[0] = -(x[0]*x[0]) + x[0] + 0.5 - x[1]
    f[1] = x[1] + 5*x[0]*x[1] - x[0]*x[0]

    return f

def J(x):
    j = np.zeros((2,2))

    '''j[0][0] = 2*x[0] + x[1]
    j[0][1] = x[0]
    j[1][0] = 3*x[1]*x[1]
    j[1][1] = 1 + 6*x[0]*x[1]'''

    j[0][0] = -2*(x[0]) + 1
    j[0][1] = -1
    j[1][0] = -2*x[0] + 5*x[1]
    j[1][1] = 1 + 5*x[0]

    return j

x0 = np.array((1.2, 1.2))
x, it = newton(F, J, x0, 0.0000000001, 20)

print("A resposta para o sistema não linear é {}, alcançada com {} iterações.".format(x, it))
