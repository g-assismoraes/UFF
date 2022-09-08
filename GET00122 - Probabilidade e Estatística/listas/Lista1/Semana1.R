################# Roteiro Semana 1 #############################

################ Video 1

#Crie um projeto chamado "Semana1"
#Carregar banco de dados "titulos_federais.csv"
#Chame de "dados"

dim(dados)

names(dados) #lista todas as variaveis

str(dados)

################ Video 2

### Pacote dplyr
install.packages("dplyr")
library(dplyr)

# select

subset<-select(dados,Data,Sigla,Vencimento,Operacoes,Preco_Min_Negociacao:Preco_Max_Negociacao) #Seleciona apenasalgumas colunas

subset2<-select(subset,-Data,-Preco_Min_Negociacao) #Remover colunas, utilizando o sinal -

subset3<-select(dados,ends_with("o")) #Seleciona variaveis que terminam em "o"

subset4<-select(dados,Sigla,matches("Preco")) #Seleciona a vari?vel "Sigla." e vari?veis com a palavra "Preco"

# filter 
LFT<-filter(dados,Sigla=="LFT") #Seleciona apes os titulos LFT na var. Sigla.

NTNB70<-filter(dados,Sigla=="NTN-B" & Preco_medio_Negociacao>=70) #Filtra NTN-B com valores m?dios acima de 70.

################ Video 3

# arrange 
subset <- arrange(subset,Data)

subset <- arrange(subset, desc(Data))


# rename 
subset <- rename(subset, p_min = Preco_Min_Negociacao, p_max = Preco_Max_Negociacao)

# mutate
subset <- mutate(subset, p_dif = p_max-p_min)

# transmute
p_dif = transmute(subset, p_max-p_min)

#pacote "lubridate"
install.packages("lubridate")
library(lubridate)

subset<-mutate(subset, ano_venc = year(subset$Vencimento)) #Criamos variavel ano do vencimento do titulo

table(subset$ano_venc)

venc2021<-filter(subset,ano_venc==2021) #Filtramos titulos com vencimento em 20121

#group_by
anual<-group_by(subset,ano_venc)

Operacoes_anuais<-summarise(anual,sum(Operacoes))

#exportando banco de dados
write.table(subset,"subset_titulos.csv",sep=";",row.names = F)

