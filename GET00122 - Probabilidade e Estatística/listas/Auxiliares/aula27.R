#Carregar o banco de dados refrigerante.csv

#Verificar o histograma
hist(refrigerante$volume,freq=F)

#Plotar a densidade de uma distr. normal
curve(dnorm(x,mean= mean(refrigerante$volume),
              sd=sd(refrigerante$volume)), 
              add=T, col="blue")

#Realizar o qqnorm
qqnorm(refrigerante$volume)
qqline(refrigerante$volume, col="red", lwd=2, lty=2)

#Teste de Shapiro-Wilk
#H0: Tem distr. Normal x H1:nao tem distr. Normal
shapiro.test(refrigerante$volume)

#Shapiro-Wilk e Q-QPlot
library(epiDisplay)
shapiro.qqnorm(refrigerante$volume)

#Teste de Shapiro-Francia
library(nortest)
sf.test(refrigerante$volume)

#Teste de Kolmogorov-Smirnov
ks.test(x=refrigerante$volume, "pnorm" ,
        mean=mean(refrigerante$volume),
        sd=sd(refrigerante$volume))

#Teste de Lilliefors
nortest::lillie.test(refrigerante$volume)

#Teste de Anderson-Darling
nortest::ad.test(refrigerante$volume)
