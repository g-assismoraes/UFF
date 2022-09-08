from math import exp
from math import sin
from numpy import log as ln

'''def f(x):
    return 9.8*68.1/x*(1 - exp(-x/68.1*10)) - 40'''

def f(x):
    return x*x-3

'''def f(x):
    return x*x + ln(x)'''

'''def f(x):
    return exp(-x) - sin(x)'''

def bisseccao(xL, xU, tol, iMax):
    i, xR, ea = 1, xL, 1

    while i <= iMax and ea > tol:
        xROld = xR

        xR = (xL + xU)/2


        if xR: ea = abs((xR - xROld)/xR)

        teste = f(xL)*f(xR)

        if teste > 0: xL = xR
        elif teste < 0: xU = xR
        else: ea = 0

        print("Valor de xR: {} - ea: {}".format(xR, ea))

        i += 1

    return xR