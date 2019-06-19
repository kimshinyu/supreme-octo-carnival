#Datos iniciales

## detalles de la variable aleatoria uniforme
probaPuntualUniforme = function(b){
  probaPuntualUniforme = 1 / b
}

esperanzaUniforme = function(b){
  esperanzaUniforme = b/2
}

varianzaUniforme = function(b){
  varianzaUniforme = b * b / 12
}

funcGeneradoraDeMomentosUniforme = function(t, b){
  funcGeneradoraDeMomentosUniforme = (exp(t * b) - 1) / (t * b)
}

funcMaximaVerosimilitud = function()

v = runif(15, min = 0, max = 1)

promedio = function(x){
  promedio = 0
  for(ind in 1:length(x)){
    promedio = promedio + x[ind]
  }
  promedio = promedio / length(x)
}
y = promedio(v)
y

estimadorMediana = 







vUnitario = runif(15, min = 0, max = 1)