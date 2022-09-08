import numpy as np

def lagrange(x, y, v):
    n = len(x)

    r = 0
    for i in range(n):
        l = 1
        for j in range(n):
            if i != j: l *= (v - x[j])/(x[i] - x[j])
        r += l * y[i]
    
    return r


x = [0, 20, 40]
x = np.array(x)

y = [3.850, 0.800, 0.212]
y = np.array(y)

print(lagrange(x, y, 15))
