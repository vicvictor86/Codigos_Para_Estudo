import math
angulo = int(input('Digite um ângulo'))
rad = angulo * math.pi / 180
sen = math.sin(rad)
cos = math.cos(rad)
tg = math.tan(rad)
print(' Sendo o ângulo {:.2f},\n o sen do mesmo é {:.2f}, \n o cosseno é {:.2f} \n e a tangente é {:2f}'.format(angulo,sen,cos,tg))
