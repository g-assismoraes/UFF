#Carregar banco de dados
dados <- read.csv("dados_peso.csv")
dados = c(20.0, 12.8, 15.6, 19.3, 10.0, 27.3, 12.3,
          19.3, 17.3, 13.1, 14.8, 21.3, 20.2, 10.6,
          19.6, 26.4, 32.5, 26.4, 11.0, 18.6, 22.0,
          20.4, 15.8, 30.2, 23.4, 14.9, 20.1, 22.3,
          17.3, 21.1, 15.7, 34.3, 25.2, 27.1, 23.3)

#Verificar media dos dados
mean(dados)

#Vamos montar o teste de hipotese,
#com significancia de 5%
#H0: m=6.5 x H1: m>6.5

#Realizando o teste com t.test()
t.test(dados, mu=25, alternative = "less")

#t=estatística do teste 
#df=graus de liberdade (n-1)
#p-value=p-valor (pvalor<alpha => rejeita H0)
#alternative hypothesis=como escolhemos H1
#95 percent confidence interval=quando a hip. alternativa 
#eh "two-sided", nos retorna o interv. de conficanca 95%

#greater, less