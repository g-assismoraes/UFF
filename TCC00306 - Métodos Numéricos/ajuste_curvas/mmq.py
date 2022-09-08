import numpy as np
import scipy.stats as sts
import matplotlib.pyplot as plt

def reg_linear(x, y, coeficientesOnly=False):
    #metricas auxiliares
    n = len(x)
    mediaX = np.average(x)
    mediaY = np.average(y)

    sumX = sum(x) #calculo de somatorio de x
    sumY = sum(y) #calculo de somatorio de y
    sumXY, sumXX = 0, 0
    for i in range(n):
        sumXY += x[i]*y[i] #calculo de somatorio de x*y
        sumXX += x[i]*x[i] #calculo de somatorio de x*x

    #calculo dos coeficientes
    a1 = (n*sumXY - sumX*sumY)/(n*sumXX - (sumX*sumX))
    a0 = mediaY - mediaX*a1

    if coeficientesOnly: return a0, a1

    #calculo de St (residual antes da regressao)
    #calculo Sr (residual depois da regressao)
    st, sr = 0, 0
    for i in range(n):
        st += (y[i] - mediaY)**2
        sr += (y[i] - (a1 * x[i] + a0))**2
    
    #calculo do Syx (erro padrao da estimativa; se é menor que o sd é um bom indicativo de merito)
    syx = (sr/n-2)**0.5

    #calculo do r (quantificador do quao melhor é a estimativa)
    r = ((st-sr)/st)**0.5
    return a0, a1, st, sr, syx, r


def lin_polinomio(x, y, coeficientesOnly=False):
    lx = np.log10(x)
    ly = np.log10(y)

    logAlpha, beta = reg_linear(lx, ly, True)
    alpha = 10**logAlpha

    if coeficientesOnly: return alpha, beta

    #calculo de St (residual antes da regressao)
    #calculo Sr (residual depois da regressao)
    mediaY = np.average(y)
    st, sr = 0, 0
    for i in range(n):
        st += (y[i] - mediaY)**2
        sr += (y[i] - (alpha*x[i]**beta))**2
    
    #calculo do Syx (erro padrao da estimativa; se é menor que o sd é um bom indicativo de merito)
    syx = (sr/n-2)**0.5

    #calculo do r (quantificador do quao melhor é a estimativa)
    r = ((st-sr)/st)**0.5

    return alpha, beta, st, sr, syx, r

    
#eixo x
velocidades = (10, 20, 30, 40, 50, 60, 70, 80)
velocidades = np.array(velocidades)

#eixo y
forcas = (25, 70, 380, 550, 610, 1220, 830, 1450)
forcas = np.array(forcas)

n = len(forcas)

#regressao linear mmq y = a0 + a1*x
a0, a1 = reg_linear(velocidades, forcas, coeficientesOnly=True) 
#linearizacao polinomial y = alpha*x^beta → logy = logAlpha + beta*logx 
alpha, beta = lin_polinomio(velocidades, forcas, coeficientesOnly=True) 

#geracao de pontos para plotar o grafico da reta sobre os pontos
y = []
for i in range(n):
    y.append(a1*velocidades[i] + a0)

y2 = []
for i in range(n):
    y2.append(alpha*velocidades[i]**beta)

plt.plot(velocidades, forcas, "o", color="midnightblue")
plt.plot(velocidades, y, color="slateblue")
plt.plot(velocidades, y2, color="cornflowerblue")
plt.show()

