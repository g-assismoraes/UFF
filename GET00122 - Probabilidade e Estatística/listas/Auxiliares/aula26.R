#Teste de Hip para proporcao

#1) Carregar banco de dados refrigerante.csv

#2) Verificar a prop. de envases acima de 345ml
library(dplyr)
library(epiDisplay)
dados = c(0,0,0,4,2,3,
          6,0,0,2,0,3,
          0,3,0,3,3,1,
          1,4,2,2,2,0,
          4,3,4,4,1,3)
caes = length(dados[dados > 0])
caes/length(dados)
n = length(dados)
x = length(dados[dados > 2])

refrigerante<-mutate(refrigerante,ok=as.logical(volume>=345))

#3) Visualização grafica e tabela de freq.
tab1(refrigerante$ok, col=c("red","blue"))

#4) Teste de hipotese para proporcao c/ 5% signif.
#H0: p=0.90
#H1: p<0.90

prop.test(x=1362, n=2270, p=0.585, alternative="greater",correct=F)

#less greater two-sided
#5) Fazendo o teste manualmente
p0<-0.43
n<-2270
alpha<-0.10
e<-sqrt(p0*(1-p0)/n)*qnorm(1-alpha)

nao_rejeicao<-c(p0 - e, 1)
p0 - e
