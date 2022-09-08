import numpy as np

def pivotear(A, b, index):
    linha_pivot = index
    pivot = abs(A[index][index])

    for candidato in range(index + 1, len(A)):
        if abs(A[candidato][index]) > pivot:
            linha_pivot, pivot = candidato, A[candidato][index]
    
    if linha_pivot != index:
        temp = A[index].copy()
        A[index]= A[linha_pivot]
        A[linha_pivot] = temp
        
        temp = b[index].copy()
        b[index] = b[linha_pivot]
        b[linha_pivot] = temp

    return A, b


def escalona(A, b, p=False):
    n = len(A)

    for i in range(n - 1):
        if p: A, b = pivotear(A, b, i)
        for j in range(i + 1, n):
            pivot = A[j][i]/A[i][i]
    
            for k in range(i, n):
                A[j][k] -= pivot*A[i][k]

            b[j] -= pivot*b[i]
    
    return A, b

def backSubstitution(A, b):
    n = len(A)
    r = np.zeros(n)

    for i in range(n - 1, -1, -1):
        aux = b[i]
        for j in range(n - 1, i, -1):
            aux -= r[j]*A[i][j]
        
        r[i] = aux/A[i][i]
    
    return r


def gauss(A, b, p=False):
   
    A, b = escalona(A, b, p)
    r = backSubstitution(A, b)

    return r