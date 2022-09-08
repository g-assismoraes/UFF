import numpy as np

def pivotear(A, P, index):
    linha_pivot = index
    pivot = abs(A[index][index])

    for candidato in range(index + 1, len(A)):
        if abs(A[candidato][index]) > pivot:
            linha_pivot, pivot = candidato, A[candidato][index]
    
    if linha_pivot != index:
        temp = A[index].copy()
        A[index]= A[linha_pivot]
        A[linha_pivot] = temp

        temp = P[index].copy()
        P[index]= P[linha_pivot]
        P[linha_pivot] = temp

    return A, P


def escalona(A):
    n = len(A)

    P = np.identity(n)

    for i in range(n-1):
        A, P = pivotear(A, P, i)
        for j in range(i + 1, n):
            pivot = A[j][i]/A[i][i]

            for k in range(i, n):
                A[j][k] -= pivot*A[i][k]
            
            A[j][i] = pivot
    
    return A, P

def fowardSubstitution(L, b, P):
    n = len(L)
    b = np.dot(P, b)
    d = np.zeros(n)

    for i in range(n):
        aux = b[i]
        for j in range(i):
            aux -= L[i][j]*d[j]

        d[i] = aux
    
    return d

def backSubstitution(U, d):
    n = len(U)
    r = np.zeros(n)

    for i in range(n-1, -1, -1):
        aux = d[i]
        for j in range(n-1, i, -1):
            aux -= U[i][j]*r[j]
        
        r[i] = aux/U[i][i]

    return r



def lu(A, b):
    lu, P = escalona(A)

    d = fowardSubstitution(lu, b, P)

    r = backSubstitution(lu, d)

    return r