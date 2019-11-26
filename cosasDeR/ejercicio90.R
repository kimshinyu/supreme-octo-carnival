ys <- array(0,c(3000,4))
ns <- c(2,5,30,500)*10-1
for (k in 1:4) {
  for (m in 1:3000) {
    ys[m,k] <- quantile(runif(ns[k]),0.9)[[1]]
  }
}
#y[m,n] es el valor observado del maximo
#entre n variables en la m-esima simulacion.

for (k in 1:4) {
  xs <- ys[,k]
  proba <- sum((xs>0.6)&(xs<0.8))/3000
  print(c("Para n=",ns[k]),quote=FALSE)
  print(c("la probabilidad es ",proba),quote=FALSE)
}

empiricas <- function(k,x) {sum(ys[,k]<=x)/3000}
for (k in 1:4) {
  xs <- seq(from=0,to=1,by=0.01)
  empirica <- function(x) {empiricas(k,x)}
  plot(xs,sapply(xs,empirica),main=c("n=",ns[k]),type="l")
}

for (k in 1:4) {
  xs <- ys[,k]
  print(c("Para n=",ns[k]),quote=FALSE)
  print(c("la esperanza es ",mean(xs)),quote=FALSE)
  print(c("la varianza es ",var(xs)),quote=FALSE)
  print(c("la mediana es ",median(xs)),quote=FALSE)
  print(c("la media 0.1-podada es ",mean(xs,trim = 0.1)),
        quote=FALSE)
  print(c("el desvio estandar es ",sqrt(var(xs))),quote=FALSE)
  print(c("la distancia intercuartil es ",
          quantile(xs,0.75)[[1]]-quantile(xs,0.25)[[1]]),
        quote=FALSE)
}
#La mediana es mayor que la media,
#lo que indica asimetria a izquierda.

for (k in 1:4) {
  xs <- ys[,k]
  n <- ns[k]
  hist(xs,main=c("n=",n),freq = FALSE)
}

for (k in 1:4) {
  boxplot(ys[,k],main=c("n=",ns[k]))
}

for (k in 1:4) {
  xs <- ys[,k]
  qqnorm(xs,main=c("n=",ns[k]))
  qqline(xs)
}

boxplot(ys[,1],ys[,2],ys[,3],ys[,4])