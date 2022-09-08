#dado que o banco de dados original esta referenciado por diabetes
#importa as bibliotecas a serem utilizadas
library(dplyr)
library(epiDisplay)

#1.i)
outcome <- table(diabetes$Outcome)
pie(outcome)
pie(outcome, main = "Grafico de Pizza - Diabetes: Positivos(1) X Negativos(0)")

#1.ii)
hist_idades <- hist(diabetes$Age)
hist_idades
corte_porIdade <- cut(diabetes$Age, breaks = seq(20, 85, 5), right = F)
tab_porIdade <- table(corte_porIdade)
pie(tab_porIdade)
pie(tab_porIdade, col = rainbow(13), main = "Grafico de Pizza - Idade dos Pacientes")

#1.iii)
tab1(corte_porIdade, graph = F)

#1.iv)
positivo <- filter(diabetes, Outcome == 1)
negativo <- filter(diabetes, Outcome == 0)

#1.v)
#para o positivo
hist_GlucoseP <- hist(positivo$Glucose)
hist_GlucoseP <- hist(positivo$Glucose, ylim = c(0, 80), main="Taxa de Glucose - Positivos", xlab = "Glucose", ylab = "Frequencia")
hist_GlucoseP
corte_porGlucoseP <- cut(positivo$Glucose, breaks = seq(0, 200, 20), right = F)
tab1(corte_porGlucoseP, graph = F)

#para o negativo
hist_GlucoseN <- hist(negativo$Glucose)
hist_GlucoseN <- hist(negativo$Glucose, ylim = c(0, 200), main="Taxa de Glucose - Negativos", xlab = "Glucose", ylab = "Frequencia")
hist_GlucoseN
corte_porGlucoseN <- cut(negativo$Glucose, breaks = seq(0, 200, 20), right = F)
tab1(corte_porGlucoseN, graph = F)

#1.vi)
hist_insulinaP <- hist(positivo$Insulin)
hist_insulinaP <- hist(positivo$Insulin, xlim = c(0, 900), ylim = c(0, 200), main="Taxa de Insulina - Positivos", xlab = "Insulina", ylab = "Frequencia")

hist_insulinaN <- hist(negativo$Insulin)
hist_insulinaN <- hist(negativo$Insulin, ylim = c(0, 400), main="Taxa de Insulina - Negativos", xlab = "Insulina", ylab = "Frequencia")

hist_insulinaN
corte_porInsulinaN <- cut(negativo$Insulin, breaks = seq(0, 800, 100), right = F)
tab1(corte_porInsulinaN, graph = F)

corte_porInsulinaP <- cut(positivo$Insulin, breaks = hist_insulinaP$breaks, right = F)
tab1(corte_porInsulinaP, graph = F)
