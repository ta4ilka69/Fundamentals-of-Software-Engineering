#give me numbers from 1 to 80 in random order

import random

numbers = list(range(1, 81))
random.shuffle(numbers)

for i in range(80):
    print(numbers[i], end=' ')
    if i % 10 == 9:
        print()