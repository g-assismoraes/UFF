n=1362
jorel=2270

#Metodo primitivo
p=jorel/n
porcentagem = 0.99
x = 1 - (1 -porcentagem)/2

ic<- c(p-sqrt(p*(1-p)/n)*qnorm(x),
       p+sqrt(p*(1-p)/n)*qnorm(x))


#Metodo moderno
p2<-(jorel+2)/(n+4)

ic_mod<- c(p2-sqrt(p2*(1-p2)/(n+4))*qnorm(x),
           p2+sqrt(p2*(1-p2)/(n+4))*qnorm(x))

#Metodo automatico
ic_aut<-prop.test(x=1362,n=2270,conf.level = 0.99,
                  correct = F)$conf.int



epsilon = sqrt(p*(1-p)/n)*qnorm(x)
epsilon = 0.05
n = (qnorm(x)**2)/(4*epsilon**2)
