################# Roteiro Semana 2 #############################

################ Video 1

#Dados qualitativos (categoricos - fatores)  
# Importe os dados do arquivo austin_agua.csv  
library(dplyr)
library(lubridate)
dados<-mutate(austin,ano=year(austin$Date),mes=month(austin$Date))

################ Video 2

# Pacote epiDisplay
install.packages("epiDisplay")
library(epiDisplay)
# tabela de frequencia e grafico de barras 
tabela1 <- tab1(dados$Customer_Class)
tab1(dados$Customer_Class, graph = F) # nao produz o grafico 

#podemos modificar o grafico de barras 
# main - titulo e ylab (xlab) - nome eixos
tab1(dados$Customer_Class, main = "Distribuicao Customer Class", ylab = "Frequencia")
# cex.names, horz, col 
tab1(dados$Customer_Class, main = "Distribuicao Customer Class", xlab = "Frequencia", col= "blue", cex.names = 0.7,horiz = T, cex.axis = 0.7)
# bar.values, cex e sort.group (decreasing ou increasing)
tab1(dados$Customer_Class, main = "Distribuicao Customer Class", xlab = "Frequencia", col= "blue", cex.names = 0.6,horiz = F, cex.axis = 0.7, sort.group = "decreasing", bar.values = "percent", cex=0.7)

# Grafico de Pizza
freq <- table(dados$Customer_Class)
pie(freq)
# Utilizando a tabela1 criada com a funcao tab1
pie(tabela1[[2]][1:4,2], col = rainbow(4), main = "Grafico de Pizza - Customer Class", cex = 0.7, border = NA)

################ Video 3

# Dados Quantitativos (numericos)
library(epiDisplay)

dados<-mutate(dados,dezmil_gallons=Total_Gallons/10000000)

histograma<-hist(dados$dezmil_gallons)

histograma

consumo <- cut(dados$dezmil_gallons, breaks=c(0:13),right=F)

tab1(consumo,graph=F)

#Histograma

hist(dados$dezmil_gallons,col=rainbow(10), xlim=c(0,14), main="Histograma",xlab="Consumo (em 10mil Galoes)")

hist(dados$dezmil_gallons,col=rainbow(10), ylim=c(0,1),xlim=c(0,14),main="Histograma", xlab="Consumo (em 10mil Galoes)", prob=T)
