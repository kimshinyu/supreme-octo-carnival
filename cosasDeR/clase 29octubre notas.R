df <- data.frame( emp_id=c(1:5), 
                 salario=c(70500,83210,68750,85000,60123),
                 emp_nom = c('Ana','Beto','Carlos','Diego','Elena'),
                 start_date = as.Date(c('2011-01-01','2012-02-02','2014-04-04','2016-06-06','2010-05-09'))
                 ,stringsAsFactors = FALSE
                 )
df
str(df)

summary(df)

df$salario

df[3,c(1,2)]

read.table('~/Downloads/Untitled 2.txt', header = TRUE)

