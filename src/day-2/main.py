

def task_1(arr: list) -> int:
    result = 0
    for i in arr:
        value0 = char_to_int(i[0])
        value1 = char_to_int(i[1])



        result += value1
        if value1 == 3 and value0 == 1:
            continue
        elif value0 == 3 and value1 == 1:
            result += 6
        elif value1 > value0:
            result += 6
        elif value1 == value0:
            result += 3

    return result


def task_2(arr: list) -> int:
    result = 0
    for i in arr:
        value0 = char_to_int(i[0])
        value1 = char_to_int(i[1])

        if value1 == 1:
            if value0 == 1:
                result += 3
            else:
                result += value0 - 1
        elif value1 == 3:
            if value0 == 3:
                result += 7
            else:
                result += value0 + 7
        else:
            result += 3 + value0

    return result



def char_to_int(c):
    if c == 'A' or c == 'X':
        return 1
    if c == 'B' or c == 'Y':
        return 2
    if c == 'C' or c == 'Z':
        return 3
     


if __name__ == "__main__":
    input_array = []
    with open('./src/day-2/puzzle_input.txt') as f:
        for line in f:
            first, second = line[:-1].split(" ")
            input_array.append((first, second))

    print(task_2(input_array))
