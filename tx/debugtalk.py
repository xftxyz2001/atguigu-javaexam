import random
import string

# 获取一个随机数
def get_random():
    return random.randint(1, 10)


# 获取一个随机字符串
def get_random_str():
    return "".join(random.sample(string.ascii_letters + string.digits, 8))


# 测试
if __name__ == '__main__':
    print(get_random())
    print(get_random_str())