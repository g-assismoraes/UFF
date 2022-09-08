# Outras distribuicoes

library(MASS)

p = 0
i = 0
while(p < 0.9){
  i = i + 1
  p = p + 0.7**(i-1) * 0.3
}

#geometrica
i = 0
p = 0
for(i in 1:3){
  p = p + 0.7**(i - 1) * 0.3
}

f = 1 - p
f = 0

#hipergeometrica
for(i in 5:6){
  p = p + choose(9, i) * choose(12 - 9, 6-i) / choose(12, 6)
}


#binomial negativa
i = 0
p = 0
for(i in 5:5){
  p = p + choose(i - 1, 3-1)* 1/3**3 * (1-1/3)**(i-3)
}

fractions(p)


#binomial
i = 0
p = 0
for(i in 4:5){
  p = p + choose(5, i) * (0.7165313)**(i) * (1 - 0.7165313)**(5 - i)
}

i = 0
p = 0
for(i in 17:17){
  p = p + choose(17, i) * (0.7905848)**(17) * (1-0.7905848)**(17 - i)
}
