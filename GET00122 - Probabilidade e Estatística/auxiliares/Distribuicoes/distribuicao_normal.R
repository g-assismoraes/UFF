# Distribuicao Normal

#Para problemas do tipo: Z~N(0,1), calcular P(Z<q)
q = 2 #substituir aqui o valor
pnorm(q)

#Para problemas do tipo: Z~N(0,1), qual P(v1<Z<v2)
#Sabe-se que P(v1<Z<v2)=P(Z<v2)-P(Z<v1)
v1 = 0.5
v2 = 1.5
pnorm(v2) - pnorm(v1)

#Para problemas do tipo: Seja Z~N(0,1), qual valor de x para P(Z<x) = valor
valor = 0.8921
qnorm(valor)

#----------------------------------------------------------------------------#

#As funcoes supracitadas podem ser utilizadas para distribuicoes normais com
#média e variancias diferentes. Para tal basta alterar os parametros mean e 
#sd (ATENÇÃO, sd -> desvio padrão)

#Para problemas do tipo: Seja X~N(1,2), qual P(Z<q)
q = 2
media = 1
desvio_padrao = sqrt(2)

pnorm(1.5, media, desvio_padrao)

#Para problemas do tipo Seja X~N(1,4), qual valor de x para P(Z<x) = valor
valor = 0.8921
media = 1
desvio_padrao = sqrt(4)

qnorm(valor, media, desvio_padrao)