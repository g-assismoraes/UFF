n=1000
jorel=425

#Metodo primitivo
p=jorel/n

ic<- c(p-sqrt(p*(1-p)/n)*qnorm(0.975),
              p+sqrt(p*(1-p)/n)*qnorm(0.975))

#Metodo moderno
p2<-(jorel+2)/(n+4)

ic_mod<- c(p2-sqrt(p2*(1-p2)/(n+4))*qnorm(0.975),
              p2+sqrt(p2*(1-p2)/(n+4))*qnorm(0.975))

#Metodo automatico
ic_aut<-prop.test(x=425,n=1000,conf.level = 0.95,
                  correct = F)$conf.int
