def task_1(input: str) -> int:
    for i in range(3, len(input)):
        current = input[i-3:i+1]
        is_start_of_packet = True
        for c in current:
            if current.count(c) > 1:
                is_start_of_packet = False
                break
        
        if is_start_of_packet:
            return i + 1


def task_2(input: str) -> int:
    for i in range(13, len(input)):
        current = input[i-13:i+1]
        is_start_of_packet = True
        for c in current:
            if current.count(c) > 1:
                is_start_of_packet = False
                break
        
        if is_start_of_packet:
            return i + 1
        

if __name__ == "__main__":
    with open('./src/day6/puzzle_input.txt', 'r') as f:
        input_string = f.read()

    print(task_1(input_string))
