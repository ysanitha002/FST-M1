import pytest
# calculator Test

def test_addition():
    num1 = 10
    num2 = 15

    sum= num1+num2
    assert sum==25

def test_sub():
    num1 = 40
    num2 = 15

    diff = num1 - num2
    assert diff==25

@pytest.mark.activity
def test_multiplication():
    num1 = 10
    num2 = 15

    prod= num1*num2
    assert prod==150

@pytest.mark.activity
def test_div():
    num1 = 24
    num2 = 3

    quiotent= num1/num2
    assert quiotent==8

