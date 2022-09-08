import numpy as np
from gauss import gauss

def checaErros(x, x0, tol):
    n = len(x)
    vetorIsOk = [False]*n

    for i in range(n):
        if x[i]:
            if abs(x[i] - x0[i])/abs(x[i]) < tol:
                vetorIsOk[i] = True
        else: vetorIsOk[i] = True

    return not (False in vetorIsOk)


def newton(F, J, x0, tol, itmax):
    n = len(x0)
    x = np.zeros(n)

    for it in range(1, itmax + 1):
        j = J(x0)
        b = np.dot(j, x0) - F(x0)

        x = np.linalg.solve(j, b)

        if checaErros(x, x0, tol): break

        x0 = np.copy(x)
    
    return x, it
