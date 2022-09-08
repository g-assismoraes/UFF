####Distribuicao Normal

#Se Z~N(0,1), como calcular P(Z<q)?
#Utilizamos a funcao pnorm(q)

##Exemplo 1: Seja Z~N(0,1), qual P(Z<1.5)?

pnorm(1.5)

qnorm(0.025, mean = 5, sd= 4)

#Obs: na tabela da normal: 0.9332

##Exemplo 2: Seja Z~N(0,1), qual P(0.3<Z<1.5)?

#P(0.3<Z<1.5)=P(Z<1.5)-P(Z<0.3)
pnorm(1.5)-pnorm(0.3)

##Exemplo 3: Seja Z~N(0,1), qual valor de x para 
# termos P(Z<x)=0.8729?

#Vamos utilizar a funcao qnorm(x). 
qnorm(0.8729)
#Obs: na tabela da normal: 1.14

##Exemplo 4: Seja X~N(1,2), qual P(X<1.5)?

#O padrao da funcao pnorm() eh media 0 e desvio padrao 1.
#pnorm(q, mean = 0, sd = 1)
#Mas as funcoes pnorm() e qnorm() podem ser usadas com 
#qualquer distribuicao normal, basta definir a 
#media (mean) e desvio padrao (sd).
#Nesse exemplo, X~N(1,2), ou seja, a media eh 1 e a VARIANCIA 
#eh 2, ou seja, o desvio padrao eh raiz quadrada de 2.

pnorm(1.5,mean=1,sd=sqrt(2))
pnorm(175, mean = 180, sd = 200*sqrt(0.00045))
pnorm(490, mean = 510, sd=25)

1 - pnorm(4000, mean = 3750, sd = sqrt(25*10**4))
1 - 2
pnorm(500/7, mean=75, 20/sqrt(7))
pnorm(500, mean = 75*7, (20/sqrt(7)*7))
1 - pnorm(1000/17, mean = 60, 6/sqrt(17))
1 - pnorm(1000, mean = 17*60, sqrt(612))
# valorE < x < valorD = P(vD) - P(vE)
punif(4, min = 0, max = 4) - punif(2, 0, 4)

pnorm()
pnorm(520, 500, 10/sqrt(50)) - pnorm(480, 500, 10/sqrt(50))

#Se preferir, pode transformar a variavel X na Normal(0,1).
#P(X<1.5)=P((X-1)/sqrt(2) < (1.5-1)/sqrt(2)) = P(Z<0.3535534)

pnorm(0.3535534)

##Exemplo 5: Seja X~N(1,4), qual valor de p para 
# termos P(X<p)=0.8729?

qnorm(0.8729,mean=1,sd=2)
qnorm(0.9, mean = 225, sd = 75)

##Exemplo 6: Simule 100 sorteios da variável aleatoria Z,
#onde Z~N(0,1). Construa um histograma dos valores observados.

simulacao<- rnorm(100,mean=0,sd=1)
hist(simulacao)

##Exemplo 7: Simule 1000 sorteios da variável aleatoria X,
#onde X~N(-1,3). Construa um histograma dos valores observados.

simulacao2<- rnorm(1000,mean=-1,sd=sqrt(3))
hist(simulacao2,main="HISTOGRAMA",col="lightblue")
#Obs: main=titulo, col=cor das barras.