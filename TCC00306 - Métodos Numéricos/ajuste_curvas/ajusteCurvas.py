import numpy as np
import scipy.stats as sts
import matplotlib.pyplot as plt

velocidades = (10, 20, 30, 40, 50, 60, 70, 80)
velocidades = np.array(velocidades)

forcas = (25, 70, 380, 550, 610, 1220, 830, 1450)
forcas = np.array(forcas)
plt.plot(velocidades, forcas, "+")
plt.show()


'''--------------------------------------------------------------------------'''


coeficientes = [6.495, 6.595, 6.615, 6.635, 6.485, 6.555, 6.665, 6.505, 6.435, 6.625, 6.715, 6.655, 6.755, 6.625, 6.715, 6.575, 6.655, 6.605, 6.565,
                6.515, 6.555, 6.395, 6.775, 6.685]
coeficientes = np.array(coeficientes)

media = np.average(coeficientes)
sd = np.std(coeficientes)
var = np.var(coeficientes)
cv = np.std(coeficientes)/np.average(coeficientes)

#plt.plot(coeficientes, sts.norm.pdf(coeficientes, media, sd))
bins = np.array([6, 6.2, 6.4, 6.6, 6.8, 7, 7.2])
plt.hist(coeficientes, bins=bins)
plt.show()

bins = np.array([6, 6.1, 6.2, 6.3, 6.4, 6.5, 6.6, 6.7, 6.8, 6.9, 7])
plt.hist(coeficientes, bins=bins)
plt.show()

print('Media:', media)
print('Desvio Padrao:', sd)
print('Variancia', var)
print('Coeficiente de Variancia', cv)
