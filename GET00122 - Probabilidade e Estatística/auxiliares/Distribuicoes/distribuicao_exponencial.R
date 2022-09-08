#Distribuicao Exponencial

#Problemas do tipo: Se X~Exponencial(1), qual P(X<0.3)?
pexp(0.3,rate=1)

#Problemas do tipo: Se X~Exponencial(5), qual P(X<0.2)?
pexp(0.2,rate=5)

#Problemas do tipo: Se X~Exponencial(0.5), qual P(X>2.2)?
#P(X>2.2)=1-P(X<=2.2)
1-pexp(2.2,rate=0.5)

#Problemas do tipo: Se X~Exponencial(1), qual valor de p 
#tal que P(X<p)=1/2?
qexp(1/2,rate=1)