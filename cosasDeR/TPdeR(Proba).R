#A orillas del rı́o Reconquista yacen numerosas industrias,
#de las cuales el 70% no cumple con alguna de las normas establecidas para arrojar residuos al rı́o.
#Un inspector visita 30 de ellas.
#(a) Estimar la probabilidad de que más de 18 estén en infracción.
  #O sea, p(x>18) = 1 - p(x<=18)
nA1 <- 100000
xA1 <- rbinom(nA1,30,0.7)
cA1 <- xA1>18
probabilidadA1 <- sum(cA1)/nA1
probabilidadA1
    #La probabilida de que mas de 18 esten en infraccion es de 0.84 aprox.

#     Estimar cuántas industrias debe visitar el inspector para que tal probabilidad sea mayor a 0.95.
##yo quiero que probabilidadASacar <- 95/100
##o sea, que sum(c) > 95
nA2 <- 100
resultA2 <- 60
for(iA2 in 1:60){
  xA2 <- rbinom(nA2,iA2,0.7)
  cA2 <- xA2 > 18
  probabilidadA2 <- sum(cA2)/nA2
  if(probabilidadA2 > 0.95 & iA2<resultA2){
    resultA2 <- iA2
    break
    }
}
resultA2
    #El inspector necesita visitar al menos 33 industrias

#(b) Resolver el item anterior usando R y calcularlo de manera exacta.
resultB1 <- 1 - pbinom(18, 30, 0.7) #Esta funcion dbinom me devolveria la probabilidad de que x>18 para x~binom(30,0.7)
resultB1 
    #Esto me dice que la probabilidad es de 0.07485173
nB2 <- 100
resultB2 <- 60
for(iB2 in 1:60){
  probabilidadB2 <- 1 - pbinom(18, iB2, 0.7)
  if(probabilidadB2 > 0.95 & iB2<resultB2){
    resultB2 <- iB2
    break
  }
}
resultB2
    #Esto me dice que la cantidad de industrias que necesita visitar el inspector es de 25

#(c) Graficar la convergencia de la primera estimación.
  #Del a, lo que quiero es un plot de n comparado con la probabilida de que x > 18

xC <- c(1:1000)
distribucionC <- function(k){
  yC <- rbinom(k,30,0.7)
  cC <- yC>18
  probabilidadC <- sum(cC)/k
    #Esta funcion estimaria pbinom
  }
plot(xC,sapply(xC,distribucionC), type='l')


#####################################################################################################################

#2. Para apreciar aún un poco más la Ley de los Grandes Números, realizar el siguiente experimento:
#  (a) Considerar dos observaciones x 1 y x 2 de variables aleatorias X 1 y X 2 independientes con dis-
#  tribución E(λ) (para algún λ a elección) y guardar el promedio de ambas, es decir, x 2 . Repetir
#1000 veces y a partir de los valores obtenidos realizar un histograma, un boxplot y un QQ-plot.
#¿Qué caracterı́sticas tienen?

xa1 <- rexp(1000,0.4)
xa2 <- rexp(1000,0.4)
xa3 <- (x1+x2)/2
#hist(x3)
boxplot(xa3)
qqnorm(xa3)
mean(x3)
median(x3)
(mean(x1)+mean(x2))/2

#  (b) Aumentar a cinco las variables promediadas, es decir, considerar ahora n = 5 observaciones de
#variables aleatorias independientes con la misma distribución del ı́tem anterior y guardar x 5 .
#Repetir 1000 veces y realizar un histograma, un boxplot y un QQ-plot para los valores obtenidos.
#Comparar con los obtenidos en el ı́tem anterior. ¿Qué se observa?

n <- 2
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,0.4)[[1]]
  }
}
promedion <- rep(0,1000)
for(k in 1:1000){
  promedion[k] <- sum(xn[k,])/n
}
boxplot(promedion)


#  (c) Aumentar a n = 30 el número de observaciones de v.a.i.i.d. y repetir el ı́tem anterior. Repetir
#con n = 500.
#(d) ¿Qué pasarı́a si se siguiera aumentando el tamaño de la muestra?
#  (e) Por último, hacer un boxplot de los 4 conjuntos de datos en el mismo gráfico (es decir, “boxplots
#                                                                                    paralelos”).













#PARA MANDAR TP NAHUEL.I.ARCA@GMAIL.COM




