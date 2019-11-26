A orillas del rio reconquista yacen numerosas industrias, de las cuales el 70porciento no cumple 
con alguna de las normas establecidas para arrojar residuos al rio.
un inspector visita 30 de ellos
1-estimar la prob de que mas de 18 esten en infraccion. estimar cuantas industrias debe visitar 
  el inspector para que tal probabilidad sea mayor a 0.95
2-resolver el ejercicio de forma exacta
3-graficar la convergencia de la primera estimacion
  
  x = "# industrias en infraccion entre 30" ~ Bi(30,0.7)
  P(x > 18)
  n/ P(x>n)>0.95
  
  
1a)
  n1 <- 10000
  x <- rbinom(n1,30,0.7)
  y <- x[x>18]
  z <- length(y) / n1

1b)
  yo quiero que z > 0.95
  o sea que length(y)/10000 > 0.95
  o sea que length(y) > 0.95 * 10000
  o sea que length(rbinom(10000,n1,0.7)[x>18]) > 9500
  
  n2 <- 40
  repes <- 0
  z <- 0
  for(i in 1:n2){
    x <- rbinom(n2,i,0.7)
    y <- x[x>18]
    z <- length(y)/i
    if(z > 0.95){
      repes <- i
    }
  }
  y
  repes