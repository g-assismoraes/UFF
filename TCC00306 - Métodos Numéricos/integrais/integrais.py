import numpy as np
import matplotlib.pyplot as plt


def f(x):
    return 0.2 + 25*x - 200*x**2 + 675*x**3 - 900*x**4 + 400*x**5

    #return x * np.log(x)


'''
Regra do Trapezio
I = (b-a) x f(a)*f(b)
           -----------
                2
'''

def newton_trapezio(a, b, f):
    return (b-a) * (f(a) + f(b))/2

def newton_trapezioComposta(x, y):
    n = len(x) - 1 #qtd de segmentos

    s = 0
    for i in range(1, n):
        s += y[i]
    
    s = 2*s + y[0] + y[n]

    h = (x[n] - x[0])/(n)

    return h/2 * s

def simpson_13Composta(x, y):
    n = len(x) - 1

    s = y[0]
    for i in range(1, n):
        if i%2 == 0: s += 2*y[i]
        else: s+= 4*y[i]

    #print(s)

    h = (x[n] - x[0])/n
    return h/3 * s

def pontos_gauss(num_pontos):
    if num_pontos == 2:
        return [1, 1], [-0.5773503, 0.5773503]
    if num_pontos == 3:
        return [0.555556, 0.888889, 0.555556], [-0.77459669, 0, 0.77459669]

def quadratura_gauss(a, b, n, f):

    c, r = pontos_gauss(n)

    s = 0
    for i in range(n):
        x = (b-a)/2 * r[i] + (b+a)/2

        print(f(x))
        s += c[i] * f(x)
    
    print("s:", s)
    
    return ((b-a)/2) * s




x = list()
i = 0
while i <= 0.8:

    x.append(i)

    i+= 0.8/3

y = list()
[y.append(f(e)) for e in x]



#plt.plot(x, y)
#plt.show()

r = newton_trapezio(0, 0.8, f)
r2 = newton_trapezioComposta(x, y)
r3 = simpson_13Composta(x, y)
r4 = quadratura_gauss(0, 0.8, 3, f)

print("Pelo metodo do trapezio: ", r)
#print((1.64053 - r)/1.64053) #erro relativo
print("Pelo metodo do trapezio composto: ", r2)
print("Pelo metodo de Simpson 1/3 composto: ", r3)
print("Pelo metodo da quadratura de Gauss: ", r4)
