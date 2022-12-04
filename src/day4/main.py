
def task_1(arr: list) -> int:
    result = 0

    for pairs in arr:
        if (pairs[0] <= pairs[2]) and (pairs[1] >= pairs[3]):
            result += 1
        elif (pairs[0] >= pairs[2]) and (pairs[1] <= pairs[3]):
            result += 1

    return result


def task_2(arr: list) -> int:
    result = 0

    for pair in arr:
        if pair[2] <= pair[1] and pair[0] <= pair[3]:
            result += 1

    return result





if __name__ == "__main__":
    input_array = []
    with open('./src/day4/puzzle_input.txt') as f:
        for line in f:
            line = line[:-1]
            line = line.replace("-", ",")
            line = line.split(",")
            input_array.append([int(x) for x in line])

    print(task_2(input_array))
