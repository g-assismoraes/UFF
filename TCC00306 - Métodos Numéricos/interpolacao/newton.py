import numpy as np
import matplotlib.pyplot as plt


#Formula de diferença finita linear
'''
f(x) - f(x1)      f(x2) - f(x1)                        f(x2) - f(x1)
------------   =  -------------    → f(x) = f(x1) +  ---------------- * (x - x1)
   x - x1            x2 - x1                              x2 - x1
'''

ln2 = 0 + ((np.log(6) - np.log(1))/(6-1)) * (2-1) #usando o log de 6; ou seja intervalo (1, 6)
ln2 = 0 + ((np.log(4) - np.log(1))/(4-1)) * (2-1) #usando o log de 4; ou seja intervalo (1, 4)

#print(ln2)
#print(np.log(2))

#print((np.log(2) - ln2)/np.log(2)) #erro

''''-------------------------------------------------------------------------------------------------------'''

#Quadrática
'''
f(x) = b0 + b1 *(x - x1) + b2*(x-x1)*(x-x2)

onde,

b0 = f(x1),                    

      f(x2) - f(x1)                                
b1 = ---------------  = f[x2, x1]
        x2 - x1


       f(x3) - f(X1)       f(x2) - f(x1)
b2 =  -------------   -  ---------------
         x3 - x1              x2 - x1
    ----------------------------------------            = f[x3, x2, x1]
                x3      -       x1

E assim se pode generalizar para graus maiores...
'''
def newton(x, y, v, n=-1):
      if n < 0: n = len(x)

      f = np.zeros((n,n))

      for i in range(n):
            f[i][0] = y[i]
      
      for j in range(1, n):
            for i in range(n - j):
                  f[i][j] = (f[i+1][j-1] - f[i][j-1])/(x[i+j] - x[i])
      
      delta_x = 1
      resp = f[0][0]
      for i in range(1, n):
            delta_x  *= (v - x[i-1])
            resp += f[0][i] * delta_x
      

      return resp, f

x = (1, 4, 6, 5, 3, 1.5, 2.5, 3.5)
x = np.array(x)

y = []
for e in x:
      y.append(np.log(e))
y = np.array(y)

r, f = newton(x, y, 2)

print(r)
#print(f)
