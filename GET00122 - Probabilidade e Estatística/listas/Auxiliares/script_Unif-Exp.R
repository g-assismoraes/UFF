###Distribuicao Uniforme

##Exemplo 1: Se X~Uniforme(0,1), qual P(X<0.3)?
punif(0.3,min=0,max=1)

##Exemplo 2: Se X~Uniforme(0,5), qual P(X<1.2)?
punif(1.2,min=0,max=5)

##Exemplo 3: Se X~Uniforme(1,3), qual P(X>2.2)?
#P(X>2.2)=1-P(X<=2.2)
1-punif(2.2,min=1,max=3)

##Exemplo 4: Se X~Uniforme(0,3), qual valor de p 
#tal que P(X<p)=1/3?
qunif(1/3,min=0,max=3)

##Exemplo 5: Simule 1000 observacoes independentes de uma 
#variavel aleatoria X~Uniforme(0,1) e construa o histograma.

simulacao<-runif(1000,min=0,max=1)
hist(simulacao,col="lightpink")

#----------------------------------------------------------

###Distribuicao Exponencial


##Exemplo 1: Se X~Exponencial(1), qual P(X<0.3)?
pexp(0.3,rate=1)

##Exemplo 2: Se X~Exponencial(5), qual P(X<0.2)?
pexp(0.2,rate=5)

##Exemplo 3: Se X~Exponencial(0.5), qual P(X>2.2)?
#P(X>2.2)=1-P(X<=2.2)
1-pexp(2.2,rate=0.5)

##Exemplo 4: Se X~Exponencial(1), qual valor de p 
#tal que P(X<p)=1/2?
qexp(1/2,rate=1)

##Exemplo 5: Simule 1000 observacoes independentes de uma 
#variavel aleatoria X~Exponencial(1) e construa o histograma.

simulacao2<-rexp(1000,rate=1)
hist(simulacao2,col="orange")
