#A orillas del río Reconquista yacen numerosas industrias,
#de las cuales el 70% no cumple con alguna de las normas establecidas para arrojar residuos al río.
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
resultA2 <- 100
for(iA2 in 1:100){
  xA2 <- rbinom(nA2,iA2,0.7)
  cA2 <- xA2 > 18
  probabilidadA2 <- sum(cA2)/nA2
  if(probabilidadA2 > 0.95 & iA2<resultA2){
    resultA2 <- iA2
    }
}
resultA2
    #El inspector necesita visitar al menos 33 industrias

#(b) Resolver el item anterior usando R y calcularlo de manera exacta.
resultB1 <-  1 - pbinom(18, 30, 0.7) #Esta funcion pbinom me devolveria la probabilidad de que x>18 para x~binom(30,0.7)
resultB1
    #Esto me dice que la probabilidad es de 0.8406782
resB2 <- 1000
for(iB2 in 1:100){
  nB2 <- qbinom(0.95,iB2,0.7)
  if(nB2 >= 18 & iB2 <= resB2){
    resB2 <- iB2 
  }
}
resB2
    #Esto me dice que la cantidad de industrias que necesita visitar el inspector es de 21

#(c) Graficar la convergencia de la primera estimación.
  #Del a, lo que quiero es un plot de n comparado con la probabilida de que x > 18

xC <- c(1:1000)
distribucionC <- function(k){
  yC <- rbinom(k,30,0.7)
  cC <- yC>18
  probabilidadC <- sum(cC)/k
    #Esta funcion estimaria pbinom
  }
plot(xC,distribucionC, type='l')


#####################################################################################################################
#2. Para apreciar aún un poco más la Ley de los Grandes Números, realizar el siguiente experimento:
#  (a) Considerar dos observaciones x 1 y x 2 de variables aleatorias X 1 y X 2 independientes con dis-
#  tribución E(Î») (para algún Î» a elección) y guardar el promedio de ambas, es decir, x 2 . Repetir
#1000 veces y a partir de los valores obtenidos realizar un histograma, un boxplot y un QQ-plot.
#¿Qué características tienen?
delta <- 0.4
x1 <- rexp(1000,delta)
x2 <- rexp(1000,delta)
x3 <- (x1+x2)/2
hist(x3)
boxplot(x3)
qqnorm(x3)
qqline(x3)

#  (b) Aumentar a cinco las variables promediadas, es decir, considerar ahora n = 5 observaciones de
#variables aleatorias independientes con la misma distribución del ítem anterior y guardar x 5 .
#Repetir 1000 veces y realizar un histograma, un boxplot y un QQ-plot para los valores obtenidos.
#Comparar con los obtenidos en el ítem anterior. ¿Qué se observa?

delta <- 0.4
n <- 5
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedion <- rep(0,1000)
for(k in 1:1000){
  promedion[k] <- sum(xn[k,])/n
}
hist(promedion)
boxplot(promedion)
qqnorm(promedion)
qqline(promedion)


#  (c) Aumentar a n = 30 el número de observaciones de v.a.i.i.d. y repetir el ítem anterior. Repetir
#con n = 500.

delta <- 0.4
n <- 30
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedion <- rep(0,1000)
for(k in 1:1000){
  promedion[k] <- sum(xn[k,])/n
}
hist(promedion)
boxplot(promedion)
qqnorm(promedion)
qqline(promedion)


delta <- 0.4
n <- 500
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedion <- rep(0,1000)
for(k in 1:1000){
  promedion[k] <- sum(xn[k,])/n
}
hist(promedion)
boxplot(promedion)
qqnorm(promedion)
qqline(promedion)
#(d) ¿Qué pasaría si se siguiera aumentando el tamaño de la muestra?
#Los gráficos presentarían dos características: Los valores se irían concentrando mas alrededor de la media,
#y las gráficas en si se irían pareciendo más al de una normal.
#  (e) Por último, hacer un boxplot de los 4 conjuntos de datos en el mismo gráfico (es decir, â€œboxplots
#                                                                                    paralelosâ€).

delta <- 0.4
n <- 2
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedio2 <- rep(0,1000)
for(k in 1:1000){
  promedio2[k] <- sum(xn[k,])/n
}

n <- 5
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedio5 <- rep(0,1000)
for(k in 1:1000){
  promedio5[k] <- sum(xn[k,])/n
}

n <- 30
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedio30 <- rep(0,1000)
for(k in 1:1000){
  promedio30[k] <- sum(xn[k,])/n
}

n <- 500
xn <- array(0,c(1000,n))
for(i in 1:n){
  for(j in 1:1000){
    xn[j,i] <- rexp(1,delta)[[1]]
  }
}
promedio500 <- rep(0,1000)
for(k in 1:1000){
  promedio500[k] <- sum(xn[k,])/n
}


boxplot(promedio2, promedio5, promedio30, promedio500)

#####################################################################################################################
#Enunciado 3. El teorema central del límite nos dice que cuando hacemos la siguiente transformación con los promedios:  
# la distribución de esta variable aleatoria se aproxima a la de la normal estándar si n es suficientemente grande. 
# Comprobaremos mediante una simulación este resultado. 
#(a) Calcular la esperanza y varianza de X1 donde X1 es la misma distribución que en el ejercicio 2. 

delta <- 0.4
x1 <- rexp(1000,delta)
esperanzaX1 <- mean(x1)
varianzaX1 <- var(x1)*((1000-1)/1000)
esperanzaX1
varianzaX1

#(b) Realizar la transformación mencionada en los 4 conjuntos de datos del ítem 2 y graficar 
# box-plots paralelos y QQ-plots. 

promedion <- function(n,delta){
  xn <- array(0,c(1000,n))
  for(i in 1:n){
    for(j in 1:1000){
      xn[j,i] <- rexp(1,delta)[[1]]
    }
  }
  promedioaux <- rep(0,1000)
  for(k in 1:1000){
    promedioaux[k] <- sum(xn[k,])/n
  }
  promedion <- promedioaux
}

delta <- 0.4
x1 <- rexp(1000,delta)
esperanzaX1 <- mean(x1)
varianzaX1 <- var(x1)*((1000-1)/1000)
promedio2 <- promedion(2,delta)
promedio5 <- promedion(5,delta)
promedio30 <- promedion(30,delta)
promedio500 <- promedion(500,delta)

normalizacion <- function(n,promedion){
  normalizacion <- (promedion - esperanzaX1) / (  (varianzaX1/n) ^ 1/2  )
}

nuevoX2 <- normalizacion(2,promedio2)
nuevoX5 <- normalizacion(5,promedio5)
nuevoX30 <- normalizacion(30,promedio30)
nuevoX500 <- normalizacion(500,promedio500)

boxplot(nuevoX2,nuevoX5,nuevoX30,nuevoX500)
qqnorm(nuevoX2)
qqline(nuevoX2)
qqnorm(nuevoX5)
qqline(nuevoX5)
qqnorm(nuevoX30)
qqline(nuevoX30)
qqnorm(nuevoX500)
qqline(nuevoX500)

#(c) Realizar 4 histogramas y a cada uno de ellos superponerle la densidad de la normal estándar.

printHis <- function(vec){
  hist(vec, freq=F, breaks=12)
  lines(seq(-500, 500, by=.5), 
        dnorm(seq(-500, 500, by=.5), mean(vec), sd(vec)),
        col="blue")
}

printHis(nuevoX2)
printHis(nuevoX5)
printHis(nuevoX30)
printHis(nuevoX500)


#(d) Explicar los resultados obtenidos. 
#A medida que aumenta el n, las graficas se van asemejando más a la densidad de una normal estándar.

#####################################################################################################################
#4. Sea (Ui)ieN una sucesion de variables aleatorias uniformes en [0,1]. Definimos N = inf{n e N :
  #SUM(i=1,n)Ui >= 1}. Realizar simulaciones de la variable aleatoria N ...

sumOfnUniforms <- function(n){
  sumOfnUniforms <- sum(runif(n,0,1))
}

calculateInf <- function(x){
  nInf <- x
  for(n in 1:x){
    s <- sumOfnUniforms(n)
    if(s >= 1 && n <= nInf){
      nInf <- n
      #"my n that I consider, presently, as the infimum"
      #nInf
      #"my sum of nInf number of uniform variables"
      #s
      break
    }
  }
  "my sum of the final sum of uniform variables"
  s
  "final infinum"
  calculateInf <- nInf
}

z <- calculateInf(10000)
#...y estimar E(N).
#Se estima haciendo el promedio, y nada mas.

x <- 1000
v <- rep(0,x)
for(i in 1:x){
  v[i] <- calculateInf(x)
}
y <- sum(v)/x
y

#####################################################################################################################
#5. Se compararon tres dietas respecto al control de azucar
#en la sangre en pacientes diabeticos. En el archivo estad descriptiva.txt 
#se encuentran los valores de glucosa para las tres dietas consideradas
#(A, B, C), que contienen las lecturas de glucosa en la sangre de los pacientes.
#Es deseable que el paciente tenga valores entre 80 - 110 mg/dl.
#(a) Cargue los datos al R.
  #enviroment, import data set,fromtext(base)


#(b) Para cada una de las tres dietas calcule medidas de centralidad:
# la media,
meanA <- mean(dietas$dietaa)
meanB <- mean(dietas$dietab)
meanC <- mean(dietas$dietac)

# la mediana,
fiftyqA <- quantile(c(dietas$dietaa))
fiftyqB <- quantile(c(dietas$dietab))
fiftyqC <- quantile(c(dietas$dietac))

# la media 0.1-podada 
meanTrim0point1A <- mean(dietas$dietaa,trim=0.1)
meanTrim0point1B <- mean(dietas$dietab,trim=0.1)
meanTrim0point1C <- mean(dietas$dietac,trim=0.1)

# la media 0.2-podada
meanTrim0point2A <- mean(dietas$dietaa,trim=0.2)
meanTrim0point2B <- mean(dietas$dietab,trim=0.2)
meanTrim0point2C <- mean(dietas$dietac,trim=0.2)

meanA
meanB
meanC

fiftyqA
fiftyqB
fiftyqC

meanTrim0point1A
meanTrim0point1B
meanTrim0point1C

meanTrim0point2A
meanTrim0point2B
meanTrim0point2C

#Para cada dieta compare los valores obtenidos de las cuatro medidas de posicion,
#si observa una notable diferencia ¿a que podria deberse?
  #Si bien entra las dos primeras dietas no hay una notable diferencia, no es así al considerar la dieta-c. 
  #Es posible que esto se deba a una distribución dispareja de sus valores, lo cual se puede observar 
  #por la diferencia entre la media y la mediana de la misma, que presentan una diferencia bastante mas grande 
  #que las vistas en las otras dietas.

#(c) Calcule medidas de dispersión: el desvío estándar, 
deA <- var(dietas$dietaa)^(0.5)
deB <- var(dietas$dietab)^(0.5)
deC <- var(dietas$dietac)^(0.5)
deA
deB
deC

##la distancia inter-cuartil (o inter-cuartos)
distInterCuartilA <- quantile(c(dietas$dietaa))[4] - quantile(c(dietas$dietaa))[2]
distInterCuartilA
distInterCuartilB <- quantile(c(dietas$dietab))[4] - quantile(c(dietas$dietab))[2]
distInterCuartilB
distInterCuartilC <- quantile(c(dietas$dietac))[4] - quantile(c(dietas$dietac))[2]
distInterCuartilC

##y la MAD en cada una de las dietas.
  calcularMAD <- function(vectorDeFuncion){
    calcularMAD <- sum(vectorDeFuncion - mean(vectorDeFuncion))/length(vectorDeFuncion)
  }  

  MADA <- calcularMAD(dietas$dietaa)
  MADB <- calcularMAD(dietas$dietab)
  MADC <- calcularMAD(dietas$dietac)
  MADA
  MADB
  MADC
  
#Compare los valores de dispersión obtenidos, si observa una notable diferencia ¿a qué podría deberse? 
#¿Cuál de las dietas parece ser la más estable? 
 # La mayor diferencia se nota en los valores de la dieta-b, que tiene un mayor desvío estándar.
 # La más estable parecería ser la dieta-a, dado que presenta menor desvío estándar y distancia inter-cuartil. 
 # Las MAD son muy similares.
  
#(d) Obtenga los percentiles 10, 25, 50, 75 y 90. Compare los valores de los percentiles 
##obtenidos entre las distintas dietas. 
  diezA <- quantile(c(dietas$dietaa),0.1)
  veinticincoA <- quantile(c(dietas$dietaa))[2]
  cincuentaA <- quantile(c(dietas$dietaa))[3]
  setentaycincoA <- quantile(c(dietas$dietaa))[4]
  noventaA <- quantile(c(dietas$dietaa),0.9)
  
  diezB <- quantile(c(dietas$dietab),0.1)
  veinticincoB <- quantile(c(dietas$dietab))[2]
  cincuentaB <- quantile(c(dietas$dietab))[3]
  setentaycincoB <- quantile(c(dietas$dietab))[4]
  noventaB <- quantile(c(dietas$dietab),0.9)
  
  diezC <- quantile(c(dietas$dietac),0.1)
  veinticincoC <- quantile(c(dietas$dietac))[2]
  cincuentaC <- quantile(c(dietas$dietac))[3]
  setentaycincoC <- quantile(c(dietas$dietac))[4]
  noventaC <- quantile(c(dietas$dietac),0.9)
  
  diezA
  veinticincoA
  cincuentaA
  setentaycincoA
  noventaA
  
  diezB
  veinticincoB
  cincuentaB
  setentaycincoB
  noventaB
  
  diezC
  veinticincoC
  cincuentaC
  setentaycincoC
  noventaC

#(e) Construya histogramas que permitan visualizar los valores de glucosa para cada dieta. 
  hist(dietas$dietaa)
  hist(dietas$dietab)
  hist(dietas$dietac)
  
#Compare la distribución de glucosa. En alguna de ellas ¿parece haber valores alejados?
  #Si. En realidad, en todas. (se cuentan: valores por encima de los 120 y aquellos menores a 70)
  
#¿Las dietas mantienen a los pacientes en los valores deseados? 
  #Solo la dieta a parece mantener notablemente los valores entre 80 y 110.
  
#¿La distribución de glucosa es asimétrica en alguno de los grupos?
  #Si. La misma se ve muy tirada a izquierda para la dieta c.
  
#¿En algún caso el ajuste normal parece razonable? 
  #Si; los valores de glucosa de aquellos que siguen la dieta A parecería estar siguiendo una distribución normal.
  
#Realice los diagramas de tallo-hoja correspondientes. 
  stem(dietas$dietaa) 
  stem(dietas$dietab) 
  stem(dietas$dietac) 
  
#(f) Grafique los box-plots correspondientes.
  boxplot(dietas$dietaa, xlab="dietaA")
  boxplot(dietas$dietab, xlab="dietaB")
  boxplot(dietas$dietac, xlab="dietaC")
  
#¿Cómo se compara la información que dan estos gráficos con la obtenida con los histogramas? 
#En base a los gráficos obtenidos, discuta simetría, presencia de outliers y compare dispersiones nuevamente. 
  #Nuevamente se ve que la dieta-a presenta similitudes con una distribución normal.
  #De la dieta-b, se sigue viendo la simetría, aunque es más fácil ver en el histograma
  #la 'trampa' que tienen sus datos, escondiendo el hecho de que hay tan pocos valores en su centro.
  #En el box-plot de la dieta-c se ve muy bien la asimetría presente, así como la presencia de 
  #valores muy alejados en los extremos.

#(g) Grafique los qq-plots correspondientes. ¿En algún caso el ajuste normal parece razonable? 
  
  qqnorm(dietas$dietaa) 
  qqnorm(dietas$dietab) 
  qqnorm(dietas$dietac) 

  #Nuevamente, en el qq-plot normal~dieta-A se ven las similitudes, mientras que no tanto asi en los otros dos qq-plots.
  
  
#(h) En base al análisis anterior, ¿cuál le parece la dieta más aconsejable?
  #Basado en todo lo visto, la dieta mas recomendable parecería ser la dieta a.