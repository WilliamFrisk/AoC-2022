
def find_most_calories(input: list) -> int:

    input = sum_of_parts(input)
    input = sorted(input)

    return input[-1] + input[-2] + input[-3]

    """
    max_calorie = 0
    curr_elf = 0
    for i in input:
        if not is_num(i):
            if curr_elf > max_calorie:
                max_calorie = curr_elf
            curr_elf = 0
        else:
            curr_elf += int(i)
        
    return max_calorie
    """

def sum_of_parts(arr: list) -> list:
    output = []

    curr_elf = 0
    for i in arr:
        if not is_num(i):
            output.append(curr_elf)
            curr_elf = 0
        else:    
            curr_elf += int(i)

    return output


def is_num(num) -> bool:
    try:
        int(num)
        return True
    except ValueError:
        return False


if __name__ == "__main__":
    input_array = []
    with open('./src/day1/puzzle_input.txt') as f:
        for line in f:
            input_array.append(line)

    print(find_most_calories(input_array))