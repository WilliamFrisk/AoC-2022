

def task_1(arr: list) -> int:
    result = 0

    for rucksack in arr:
        mid = len(rucksack) // 2

        left = rucksack[:mid]
        right = rucksack[mid:]
    
        for c in left:
            if c in right:
                result += num_value(c)
                break

    return result


def task_2(arr: list) -> int:
    result = 0

    for i in range(0, len(arr), 3):
        first = set(arr[i])
        mid = set(arr[i + 1])
        last = set(arr[i + 2])

        rucksacks = (first, mid, last)

        table = {}

        for sack in rucksacks:
            for c in sack:
                if c in table.keys():
                    table[c] += 1
                else:
                    table[c] = 1

        for key in table.keys():
            if table.get(key) == 3:
                result += num_value(key)
                break

    return result



        



def num_value(c: str) -> int:
    result = 0

    if c.isupper():
        result += 26
        c = c.lower()

    alfa = "abcdefghijklmnopqrstuvwxyz"

    result += alfa.find(c) + 1

    return result


if __name__ == "__main__":
    input_array = []
    with open('./src/day-3/puzzle_input.txt') as f:
        for line in f:
            input_array.append(line[:-1])

    print(task_2(input_array))
