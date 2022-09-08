#Carregar dados
dados<-airquality$Ozone

#Remover os NA's
dados<-na.omit(dados)

#Calcular a media \barra{X}
media<-mean(dados)

#Vamos calcular um intervalo de confianca 95% 
#para a media. Vamos calcular o epsilon
# sd() para desvio padrao
# qt() para 0 t-student (1-alpha/2) com n-1 graus de liberdade
epsilon<-(sd(dados)/sqrt(length(dados)))*qt(0.975,length(dados)-1)

#Construir o intervalo
intervalo<-c(media-epsilon,media+epsilon)

#Metodo via t.test (automatico)
intervalo2<-t.test(dados,conf.level = 0.95)$conf.int

