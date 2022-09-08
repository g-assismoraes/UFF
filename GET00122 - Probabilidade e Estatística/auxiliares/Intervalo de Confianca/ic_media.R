# Intervalo de Confiança para Média

dados = c(10, 6, 7, 6, 8.2, 9, 9.4, 9.8, 4.0) #ex

#calculando pela formulação

# qt() para 0 t-student (1-alpha/2) com n-1 graus de liberdade
media = mean(dados)
ic = 95/100 #intervalo de confiança 
alpha = 1 - ic
parametro = 1 - alpha/2
epsilon = (sd(dados)/sqrt(length(dados)))*qt(parametro,length(dados)-1)
intervalo = c(media-epsilon,media+epsilon)

#calculando diretamente
intervalo2 = t.test(dados,conf.level = ic)$conf.int
