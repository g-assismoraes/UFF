from math import exp, sin, tan, cos

'''def f(x):
    return 9.8*68.1/x*(1 - exp(-x/68.1*10)) - 40

def df(x):
    return exp(-x/68.1*10)*(98*x - 9.8*68.1*exp(x/68.1*10) + 9.8*68.1)/x*x'''

def f(x):
    return x*x*x -5*x*x + x + 3

def df(x):
    return 3*x*x - 10*x + 1

'''def f(x):
    return x*x*x -x + 1

def df(x):
    return 2*x*x - 1'''

'''def f(x):
    return sin(x) - tan(x)

def df(x):
    return cos(x) - (1/cos(x))*(1/cos(x))'''

'''def f(x):
    return 3*x - cos(x)

def df(x):
    return 3 - sin(x)'''

'''def f(x):
    return x*x*x - 4

def df(x):
    return 3*x*x'''


def secante(x0, x1, tol, iMax):
    i, ea, = 1, 1


    while i < iMax and ea > tol:

        xR = x1 - f(x1)*(x0 - x1)/(f(x0) - f(x1))

        if xR: ea = abs((xR - x1))

        x0 = x1
        x1 = xR

        print("Valor de xR: {} - ea: {}".format(xR, ea))

        i += 1

    return xR


def newton(xR, tol, iMax):
    i, ea = 1, 1

    while i < iMax and ea > tol:
        xROld = xR

        xR = xR - f(xR)/df(xR)

        if xR: ea = abs((xR - xROld)/xR)

        print("Valor de xR: {} - ea: {}".format(xR, ea))

        i += 1

    return xR