import numpy as np

def checaErros(x, x0, tol):
    n = len(x)
    vetorIsOk = [False]*n

    for i in range(n):
        if x[i]:
            if abs(x[i] - x0[i])/abs(x[i]) < tol:
                vetorIsOk[i] = True
        else: vetorIsOk[i] = True

    return not (False in vetorIsOk)

def jacobi(A, b, tol, itMax):
    n = len(A)
    x = np.zeros((n, 1))
    x.astype('double')
    x0 = np.copy(x)

    for it in range(1, itMax + 1):
        for i in range(n):
            x[i] = b[i]

            for j in range(0, i):
                x[i] -= A[i][j]*x0[j]
            for j in range(i+1, n):
                x[i] -= A[i][j]*x0[j]
            
            x[i] /= A[i][i]

        
        if checaErros(x, x0, tol): break


        x0 = np.copy(x)

    print(it)
    return x


def gauss_seidel(A, b, tol, itMax, sigma=1):
    n = len(A)
    x = np.zeros((n, 1))
    x.astype('double')
    x0 = np.copy(x)

    for it in range(1, itMax + 1):
        for i in range(n):
            x[i] = b[i]

            for j in range(0, i):
                x[i] -= A[i][j]*x[j]
            for j in range(i+1, n):
                x[i] -= A[i][j]*x[j]
            
            x[i] /= A[i][i]

            x[i] = sigma*x[i] + (1-sigma)*x0[i]

        
        if checaErros(x, x0, tol): break

        x0 = np.copy(x)
    
    print(it)
    return x
