#teste para caso de aumento da media

dados = c(20.0, 12.8, 15.6, 19.3, 10.0, 27.3, 12.3,
          19.3, 17.3, 13.1, 14.8, 21.3, 20.2, 10.6,
          19.6, 26.4, 32.5, 26.4, 11.0, 18.6, 22.0,
          20.4, 15.8, 30.2, 23.4, 14.9, 20.1, 22.3,
          17.3, 21.1, 15.7, 34.3, 25.2, 27.1, 23.3)
mean(dados)
sd = sd(dados)


erro = 0.01
porcentagem = 1 - erro
sd = 1.1
n = 300
h0 = 1.9

qt(porcentagem, df= n -1)
e = qt(porcentagem, df=(n - 1)) * (sd /  sqrt(n))

# >
h0 + e
# <
h0 - e
# !=
porcentagem = 1 - erro/2
