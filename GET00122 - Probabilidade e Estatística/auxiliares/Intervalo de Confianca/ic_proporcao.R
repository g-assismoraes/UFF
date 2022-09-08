# Intervalo de Confiança para Proporção

populacao = 16000
populacao_caracteristica = 3500

proporcao = populacao_caracteristica/populacao
proporcao_ajustada = (populacao_caracteristica + 2)/(populacao + 4)# proporcao ajustada para metodo mais moderno

#calculado pela formulacao
ic = 95/100 #intervalo de confiança 
alpha = 1 - ic
parametro = 1 - alpha/2

intervalo =
  c(proporcao_ajustada-sqrt(proporcao_ajustada*(1-proporcao_ajustada)/(populacao+4))*qnorm(parametro),
  proporcao_ajustada+sqrt(proporcao_ajustada*(1-proporcao_ajustada)/(populacao))*qnorm(parametro))


#calculando diretamente
intervalo2 = prop.test(x=populacao_caracteristica,n=populacao,conf.level = ic,
                  correct = F)$conf.int
