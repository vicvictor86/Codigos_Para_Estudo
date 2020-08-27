import pygame
pygame.init()
largura = 640
altura = 480
pygame.display.set_caption('Snake')
sair = True
pygame.display.set_mode((640, 480))
while sair:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            sair = False
        print(event)
    pygame.display.update()
pygame.quit()
