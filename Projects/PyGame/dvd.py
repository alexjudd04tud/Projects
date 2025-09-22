import sys, pygame
pygame.init()

size = width, height = 1280, 721
speed = [0.5, 0.5]	
position = [width // 2, height // 2]


screen = pygame.display.set_mode(size)

ball = pygame.image.load("dvd2.jpg")
ballrect = ball.get_rect()

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            sys.exit()
    

    position[0] += speed[0]
    position[1] += speed[1]

    # Bounce the ball off the walls
    if position[0] - ballrect.width / 2 < 0 or position[0] + ballrect.width / 2 > width:
        speed[0] = -speed[0]
    if position[1] - ballrect.height / 2 < 0 or position[1] + ballrect.height / 2 > height:
        speed[1] = -speed[1]

    # Update the ball's rectangle position
    ballrect.center = (int(position[0]), int(position[1]))

    
   

    screen.fill("black")
    screen.blit(ball, ballrect)
    pygame.display.flip()