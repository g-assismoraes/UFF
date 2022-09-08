#Carregar dados
dados<-c(1.6, 2.5, 1.2, 2.3, 1.5)


#Remover os NA's
dados<-na.omit(dados)

#Calcular a media \barra{X}
media<-mean(dados)
sd =sd(dados)

variancia = sd*sd

#Vamos calcular um intervalo de confianca 95% 
#para a media. Vamos calcular o epsilon
# sd() para desvio padrao
# qt() para 0 t-student (1-alpha/2) com n-1 graus de liberdade

#quando sao os valores
porcentagem = 0.90
x = 1 - (1 - porcentagem)/2

media = 1.8
tam = 300
desvio = 1.1
epsilon=(desvio/sqrt(tam)*qt(x, tam-1))
while(epsilon >= 0.5){
  epsilon = (desvio/sqrt(tam)*qt(x, tam-1))
  tam = tam + 1
}

epsilon = (desvio/sqrt(tam)*qt(x, tam-1))
media-epsilon
media+epsilon
intervalo<-c(media-epsilon,media+epsilon)

qnorm(0.975)
qnorm(0.025)

#quando tem um vetor
media<-mean(dados)
sd(dados)
epsilon<-(sd(dados)/sqrt(length(dados)))*qt(x,length(dados)-1)

#Construir o intervalo
intervalo<-c(media-epsilon,media+epsilon)

#Metodo via t.test (automatico)
intervalo2<-t.test(dados,conf.level = porcentagem)$conf.int


remove(dados)
remove(intervalo)
remove(intervalo2)
