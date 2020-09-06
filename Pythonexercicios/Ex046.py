from time import sleep
from emoji import emojize
for c in range(10, - 1, -1):
    print(c)
    sleep(1)
print('\033[31mBOOOOOMMM\033[m')
print(emojize('\033[31m:fireworks::fireworks::fireworks::fireworks::fireworks::fireworks:'))