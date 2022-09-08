#importando o banco de dados
library(readxl)
Consumo <- read_excel("Consumo de carne.xlsx", +     sheet = "CWR of BBP")
View(Consumo)

#1.i)
plot(Consumo$ano, Consumo$consumo_bovino, type="l")

#1.ii)
#sem polimento
plot(Consumo$ano, Consumo$consumo_bovino, type="l")
lines(Consumo$ano,Consumo$consumo_frango)

#com os polimentos recomendados
plot(Consumo$ano, Consumo$consumo_bovino, type="l", ylim = c(30,100))
lines(Consumo$ano,Consumo$consumo_frango)
lines(Consumo$ano, Consumo$consumo_bovino, col="red")
lines(Consumo$ano, Consumo$consumo_frango, col="blue")

#o mais amigavel possivel conforme sugerido ao fim
plot(Consumo$ano, Consumo$consumo_bovino, type="l", ylim = c(30,100), 
     main = "Consumo de Carne Bovina e de Frango por Ano", 
     xlab = "Ano", ylab = "Consumo por habitante")
lines(Consumo$ano, Consumo$consumo_bovino, col="red", lwd=2)
lines(Consumo$ano, Consumo$consumo_frango, col="blue", lwd=2)
legend(x = "bottomright", legend = c("Bovina", "Frango"), lty = 1,lwd = 2, 
       bty = "n", col = c("red", "blue"))

#1.iii)
par(mfrow=c(1,2))

plot(Consumo$ano, Consumo$consumo_bovino, type="l", ylim = c(30,100), 
     main = "Consumo de Carne Bovina e de Frango por Ano", 
     xlab = "Ano", ylab = "Consumo por habitante")
lines(Consumo$ano, Consumo$consumo_bovino, col="red", lwd=2)
lines(Consumo$ano, Consumo$consumo_frango, col="blue", lwd=2)
legend(x = "bottomright", legend = c("Bovina", "Frango"), lty = 1,lwd = 2, 
       bty = "n", col = c("red", "blue"))

plot(Consumo$ano, Consumo$preco_bovino_varejo, type="l", ylim = c(0, 700), 
     main = "Preço de Carne Bovina e de Frango por Ano (Varejo)", 
     xlab = "Ano", ylab = "Preço por ano")
lines(Consumo$ano, Consumo$preco_bovino_varejo, col="red", lwd=2)
lines(Consumo$ano, Consumo$preco_frango_varejo, col="blue", lwd=2)
legend(x = "bottomright", legend = c("Bovino", "Frango"), lty = 1,lwd = 2, 
       bty = "n", col = c("red", "blue"))

#1.v)
par(mfrow=c(1,1))

#1.vii)
var(Consumo$preco_bovino_varejo)
var(Consumo$preco_frango_varejo)
var(Consumo$preco_suino_varejo)
#var_bovina(16719.81) > var_suino (5705.255) > var_frango (2223.662)
