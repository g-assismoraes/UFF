from math import exp
from re import X

'''def f(x):
    return 9.8*68.1/x*(1 - exp(-x/68.1*10)) - 40'''

'''def f(x):
    return x*x*x - 9*x + 3'''

def f(x):
    return x*x-3

def falsaPosicao(xL, xU, tol, iMax):
    i, xR, ea = 1, xL, 1

    while i < iMax and ea > tol:
        fxL, fxU = f(xL), f(xU)
        xROld = xR

        xR = xU - fxU*(xL - xU)/(fxL - fxU)

        if xR: ea = abs((xR - xROld)/xR)

        teste = fxL*f(xR)

        if teste > 0: xL = xR
        elif teste < 0: xU = xR
        else: ea = 0

        print("Valor de xR: {} - ea: {}".format(xR, ea))

        i += 1

    return xR