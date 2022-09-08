# Distribuição Uniforme

#Problemas do tipo: Se X~Uniforme(0,1), qual P(X<0.3)?
punif(0.3,min=0,max=1)

#Problemas do tipo: Se X~Uniforme(0,5), qual P(X<1.2)?
punif(1.2,min=0,max=5)

#Problemas do tipo: Se X~Uniforme(1,3), qual P(X>2.2)?
#P(X>2.2)=1-P(X<=2.2)
1-punif(2.2,min=1,max=3)

#Problemas do tipo: Se X~Uniforme(0,3), qual valor de p tal que P(X<p)=1/3?
qunif(1/3,min=0,max=3)