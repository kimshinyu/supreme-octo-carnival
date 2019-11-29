# Comments

import turtle

gamewindow = turtle.Screen()
gamewindow.title("Pong by @shin")
gamewindow.bgcolor("black")
gamewindow.setup(width=800,height=600)
gamewindow.tracer(0)


#main game loop

while True:
    gamewindow.update()