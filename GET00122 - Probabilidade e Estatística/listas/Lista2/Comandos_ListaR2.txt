#dado que o banco de dados original esta referenciado por diabetes
#importa as bibliotecas a serem utilizadas
library(dplyr)
library(epiDisplay)

#1.i)
#criar uma tabela simples baseada em outcome
outcome <- table(diabetes$Outcome)

#criar um grafico de pizza baseado na tabela anterior, e depois modificar o grafico para ficar mais agradavel(titulo)
pie(outcome)
pie(outcome, main = "Grafico de Pizza - Diabetes: Positivos(1) X Negativos(0)")


#1.ii)
#Como idade é uma variavel quantitativa, criar um histograma auxiliar
hist_idades <- hist(diabetes$Age)

#"invocar" o histograma para saber como foi feita a divisao de classes
hist_idades

#criar os cortes baseados na forma com que o histograma fez
corte_porIdade <- cut(diabetes$Age, breaks = seq(20, 85, 5), right = F)

#criar uma tabela simples baseada no recorte de classes, depois criar um grafico de pizza e em seguida polir(o melhor que pude), mudando as cores e titulo
tab_porIdade <- table(corte_porIdade)
pie(tab_porIdade)
pie(tab_porIdade, col = rainbow(13), main = "Grafico de Pizza - Idade dos Pacientes")


#1.iii)
#criar uma tabela de frequencia
tab1(corte_porIdade, graph = F)


#1.iv)
#filtrar do banco de dados original somente os que apresentam Outcome = 1 para positivo e analogamente Outcome = 0 para negativo
positivo <- filter(diabetes, Outcome == 1)
negativo <- filter(diabetes, Outcome == 0)


#1.v)
#para o positivo
#criar um histograma baseado na variavel Glucose(que é quantitativa) de positivo e em seguida o polir, mudando a extensao de eixos, titulo, nome dos eixos
hist_GlucoseP <- hist(positivo$Glucose)
hist_GlucoseP <- hist(positivo$Glucose, ylim = c(0, 80), main="Taxa de Glucose - Positivos", xlab = "Glucose", ylab = "Frequencia")

#"invocar" o histograma para saber como ele fez a divisao de classes
hist_GlucoseP

#criar o corte por glucose baseado na informacao anterior
corte_porGlucoseP <- cut(positivo$Glucose, breaks = seq(0, 200, 20), right = F)

#criar a tabela de frequencia
tab1(corte_porGlucoseP, graph = F)

#para o negativo
#comandos analogos aos para positivo
hist_GlucoseN <- hist(negativo$Glucose)
hist_GlucoseN <- hist(negativo$Glucose, ylim = c(0, 200), main="Taxa de Glucose - Negativos", xlab = "Glucose", ylab = "Frequencia")
hist_GlucoseN
corte_porGlucoseN <- cut(negativo$Glucose, breaks = seq(0, 200, 20), right = F)
tab1(corte_porGlucoseN, graph = F)


#1.vi)
#criar o histograma baseado na variavel insulina de positivo, em seguida polir o mesmo com extensao de eixos, titulo, nome dos eixos
hist_insulinaP <- hist(positivo$Insulin)
hist_insulinaP <- hist(positivo$Insulin, xlim = c(0, 900), ylim = c(0, 200), main="Taxa de Insulina - Positivos", xlab = "Insulina", ylab = "Frequencia")

#analogo aos comandos anteriores
hist_insulinaN <- hist(negativo$Insulin)
hist_insulinaN <- hist(negativo$Insulin, ylim = c(0, 400), main="Taxa de Insulina - Negativos", xlab = "Insulina", ylab = "Frequencia")