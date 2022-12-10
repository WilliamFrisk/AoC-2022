

def task_1(matrix: list[list]) -> int:
    result = 0

    for i in range(len(input_matrix)):
        for j in range(len(input_matrix[i])):
            length = input_matrix[i][j]


            right = list(filter(lambda a: a >= length, input_matrix[i][j+1:]))
            left = list(filter(lambda a: a >= length, input_matrix[i][:j]))
            down = []
            up = []

            for k in range(len(input_matrix)):
                if k < i:
                    up.append(input_matrix[k][j])
                elif k > i:
                    down.append(input_matrix[k][j])

            up = list(filter(lambda a: a >= length, up))
            down = list(filter(lambda a: a >= length, down))

            if len(right) == 0 or len(left) == 0 or len(up) == 0 or len(down) == 0:
                result += 1

    return result


def task_2(matrix: list[list]) -> int:
    result = 0

    for i in range(len(input_matrix)):
        for j in range(len(input_matrix[i])):
            length = input_matrix[i][j]

            right = input_matrix[i][j+1:]
            right_value = 0
            for k in range(len(right)):
                if right[k] < length:
                    right_value += 1
                else:
                    right_value += 1
                    break

            left = input_matrix[i][:j]
            left = list(reversed(left))
            left_value = 0
            for k in range(len(left)):
                if left[k] < length:
                    left_value += 1
                else:
                    left_value += 1
                    break

            down = []
            up = []

            for k in range(len(input_matrix)):
                if k < i:
                    up.append(input_matrix[k][j])
                elif k > i:
                    down.append(input_matrix[k][j])

            up = list(reversed(up))
            up_value = 0
            for k in range(len(up)):
                if up[k] < length:
                    up_value += 1
                else:
                    up_value += 1
                    break

            down_value = 0
            for k in range(len(down)):
                if down[k] < length:
                    down_value += 1
                else:
                    down_value += 1
                    break

            
            temp = down_value * up_value * right_value * left_value
            if temp > result:
                result = temp

    return result


if __name__ == "__main__":
    input_matrix = []
    with open('./src/day8/puzzle_input.txt', 'r') as file:
        for i, line in enumerate(file):
            input_matrix.append([])
            for c in line[:-1]:
                input_matrix[i].append(c)


    print(task_2(input_matrix))