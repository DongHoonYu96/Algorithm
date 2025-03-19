def find_kth_number(k):
    # 자릿수 찾기
    length = 1
    count = 2 ** length  # 해당 자릿수의 수의 개수
    
    while k > count:
        k -= count
        length += 1
        count = 2 ** length
    
    # k는 이제 해당 자릿수 내에서의 위치 (1-인덱스)
    k -= 1  # 0-인덱스로 변환
    
    # k를 이진수로 변환하고 길이를 length로 맞춤
    binary = bin(k)[2:].zfill(length)
    
    # 이진수의 0을 4로, 1을 7로 바꿈
    result = ''
    for digit in binary:
        if digit == '0':
            result += '4'
        else:  # digit == '1'
            result += '7'
    
    return result

# 입력 받기
k = int(input())

# K번째 수 출력
print(find_kth_number(k))