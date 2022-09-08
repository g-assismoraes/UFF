library(dplyr)
library(lubridate)

#1
dados <- airquality

#1.i)
dados <- na.omit(dados)

#1.ii)
histogramaOzonio <- hist(dados$Ozone, xlim = c(0, 200), ylim = c(0, 40), main = 
              "Nível de Ozônio", xlab = "Nível de Ozônio", ylab = "Frequência")
abline(v = mean(dados$Ozone), col= "red")
abline(v = median(dados$Ozone), col = "blue")

#1.iii)
dados<- mutate(dados, Data = ymd(paste(1975, dados$Month, dados$Day, sep = "-")))
plot(dados$Data, dados$Ozone, type = "l", main = "Evolução Temporal do Nível de
     Ozônio (1975)", xlab = "Mês", ylab = "Nível de Ozônio (ppb)")

plot(dados$Data, dados$Temp, type = "l", main = "Evolução Temporal da Temperatura
     (1975)", xlab = "Mês", ylab = "Temperatura (F)")

#1.iv)

linkado_poMes <- group_by(dados, Month)

mediaOzonioMes <- summarise(linkado_poMes, mean(Ozone))
sdOzonioMes <- summarise(linkado_poMes, sd(Ozone))
mediaTemperaturaMes <- summarise(linkado_poMes, mean(Temp))
sdTemperaturaMes <- summarise(linkado_poMes, sd(Temp))

tabela <- data.frame(mediaOzonioMes, mediaTemperaturaMes, sdOzonioMes,
                     sdTemperaturaMes)

tabela <- select(tabela, -Month.1, -Month.2, -Month.3)

write.csv(tabela, file = "tabela.csv")


#1.v)

boxplot(dados$Ozone~dados$Month, main="BoxPlot: Nível de Ozonio x Mês", xlab="Mês",
        ylab="Nível(ppb)")
boxplot(dados$Temp~dados$Month, main="BoxPlot: Temperatura x Mês", xlab="Mês",
        ylab="Temperatura(F)")
