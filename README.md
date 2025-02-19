
### **Module 1: Introduction to Pythonic Code**  

### **1️⃣ What is Pythonic Code?**  
🔹 Pythonic code follows best practices, is **clean**, **concise**, and **efficient**.  
🔹 It emphasizes **readability** and leverages **Python’s built-in features**.  
🔹 The **Zen of Python** (`import this`) defines guiding principles:  
   - Readability counts  
   - Simple is better than complex  
   - There should be one—and preferably only one—obvious way to do it  

📌 **Example: Non-Pythonic vs Pythonic Code**  

❌ **Non-Pythonic (Verbose & Cluttered Code)**  
```python
numbers = [1, 2, 3, 4, 5]
squared = []
for num in numbers:
    squared.append(num ** 2)
print(squared)
```
✅ **Pythonic (Using List Comprehensions)**  
```python
numbers = [1, 2, 3, 4, 5]
squared = [num ** 2 for num in numbers]
print(squared)
```
📌 **Key Takeaway:**  
🔹 **Avoid unnecessary loops when a built-in feature (list comprehension) exists**.  

---

### **2️⃣ Writing Clean, Readable Code**  

✅ **Pythonic Practices to Follow:**  
1️⃣ Use **meaningful variable names**  
   ```python
   # Bad
   x = 25  
   y = x * 10  

   # Good
   price_per_item = 25  
   total_price = price_per_item * 10  
   ```
2️⃣ Avoid **redundant code**  
   ```python
   # Bad
   if name != None:
       print("Hello", name)
   
   # Good
   if name:  # `None` is already falsy
       print("Hello", name)
   ```
3️⃣ Use **enumerate()** instead of `range(len(...))`  
   ```python
   # Bad
   fruits = ["apple", "banana", "cherry"]
   for i in range(len(fruits)):
       print(i, fruits[i])

   # Good
   for i, fruit in enumerate(fruits):
       print(i, fruit)
   ```
4️⃣ Use **tuple unpacking**  
   ```python
   # Bad
   point = (3, 4)
   x = point[0]
   y = point[1]

   # Good
   x, y = point
   ```
---

### **3️⃣ PEP 8 - Python's Style Guide**  

🔹 **Use 4 spaces per indentation** (not tabs).  
🔹 Keep line length ≤ **79 characters** for better readability.  
🔹 Use **snake_case** for variables/functions, **CamelCase** for classes.  

**Example (Bad Formatting):**  
```python
def ADD(a,b):return a+b
```
**Correct Formatting (PEP 8 Compliant):**  
```python
def add(a, b):
    return a + b
```
📌 **Why it matters?**  
🔹 Makes code easier to read and maintain.  
🔹 Helps teams follow a consistent coding style.  

---

## **💡 Exercises for Module 1**  

### **📝 Exercise 1: Fix the Non-Pythonic Code**  
Rewrite the following code to follow Pythonic principles:  
```python
# Given code (Non-Pythonic)
numbers = [1, 2, 3, 4, 5]
squares = []
for i in range(len(numbers)):
    squares.append(numbers[i] ** 2)

print(squares)
```
---

### **📝 Exercise 2: Use Enumerate**
Rewrite the loop using `enumerate()`:  
```python
fruits = ["apple", "banana", "cherry"]
index = 0
for fruit in fruits:
    print(index, fruit)
    index += 1
```
---

### **📝 Exercise 3: Use Tuple Unpacking**
Fix the following code using **tuple unpacking**:  
```python
# Given tuple
coordinates = (10, 20)

# Current Code:
x = coordinates[0]
y = coordinates[1]

print(x, y)
```
---

### **📝 Exercise 4: Format the Code Using PEP 8**
Fix the formatting issues in the following code snippet:  
```python
def CalcTotal(price,qty):total=price*qty;return total
```
---

## **Module 2: Condition Evaluation**  
### **Truthy and Falsy Values**  
🔹 Python treats certain values as `False`: `None`, `0`, `""`, `[]`, `{}`, `set()`, `False`.  
🔹 Everything else is `True` (e.g., `"Hello"`, `[0]`, `{1:2}`).  

### **Short-Circuit Evaluation (`and`, `or`)**  
🔹 `x or y` returns the first truthy value or `y` if none found.  
🔹 `x and y` returns the first falsy value or `y` if none found.  
🔹 This helps in writing concise conditions.  

**Example:**  
```python
name = input("Enter name: ") or "Guest"
```
➡️ Uses `or` to assign `"Guest"` if the user provides an empty input.  

### **Ternary Operators (One-liner if-else)**  
🔹 `x if condition else y`  
🔹 Example:  
```python
status = "Adult" if age >= 18 else "Minor"
```

### **Pattern Matching (Python 3.10+)**  
🔹 `match-case` is Python's alternative to `switch`.  
🔹 Example:  
```python
match status_code:
    case 200:
        print("OK")
    case 404:
        print("Not Found")
```

🔹 **Exercise:** Convert nested `if-else` blocks into more Pythonic conditions.

---

## **Module 3: Loops vs List Comprehensions**  
### **Traditional Loops (for, while)**  
🔹 When to use loops?  
  - When modifying a list **in-place**.  
  - When handling **complex logic** inside the loop body.  

🔹 **Example (Loop Approach):**
```python
squared = []
for num in range(10):
    squared.append(num ** 2)
```

### **List Comprehensions (Pythonic Alternative)**  
🔹 **More readable and faster** for simple transformations.  
🔹 `new_list = [expression for item in iterable if condition]`  
🔹 **Example (Comprehension Approach):**
```python
squared = [num ** 2 for num in range(10)]
```

### **Dictionary & Set Comprehensions**  
🔹 `{key: value for key, value in iterable}`  
🔹 Example:  
```python
squares = {num: num**2 for num in range(1, 6)}
```

🔹 **Exercise:** Convert traditional loops into comprehensions and measure performance using `timeit`.

---

## **Module 4: Breaking Code into Functions**  
### **Why Functions?**  
🔹 Promotes code reusability, readability, and modularity.  
🔹 Helps with debugging and maintenance.  

### **Function Signatures & Arguments**  
🔹 Positional vs Keyword Arguments  
🔹 Default Values (`def greet(name="Guest")`)  
🔹 `*args` and `**kwargs` (Handling variable arguments)  

### **Avoiding Code Duplication**  
🔹 Instead of repeating the same logic in multiple places, wrap it in a function.  
🔹 **Example:**  
```python
def calculate_discount(price, discount=0.1):
    return price - (price * discount)
```

🔹 **Exercise:** Refactor a monolithic script into multiple functions.

---

## **Module 5: Mutability vs Immutability**  
### **Immutable Data Types**  
🔹 `int`, `float`, `str`, `tuple`, `frozenset`  
🔹 Example:  
```python
a = "hello"
a[0] = 'H'  # ❌ Error: Strings are immutable!
```

### **Mutable Data Types**  
🔹 `list`, `dict`, `set`  
🔹 Example:  
```python
lst = [1, 2, 3]
lst.append(4)  # ✅ Allowed, lists are mutable.
```

### **Pitfall: Mutable Default Arguments**  
🔹 Common mistake:
```python
def add_to_list(item, lst=[]):  # ⚠️ Dangerous
    lst.append(item)
    return lst
```
🔹 **Fix:** Use `None` as default.
```python
def add_to_list(item, lst=None):
    if lst is None:
        lst = []
    lst.append(item)
    return lst
```

🔹 **Exercise:** Predict the output of mutation-based problems.

---

## **Module 6: List Comprehensions - In Depth**  
🔹 Using comprehensions with conditionals:
```python
evens = [x for x in range(10) if x % 2 == 0]
```
🔹 Nested comprehensions:
```python
matrix = [[j for j in range(3)] for i in range(3)]
```
🔹 Performance considerations – avoid complex comprehensions.

🔹 **Exercise:** Create a nested list comprehension to flatten a 2D list.

---

## **Module 7: String Formatting**  
### **Old vs New Methods**
1️⃣ **Old (`%` Formatting)**
```python
name = "Alice"
print("Hello, %s!" % name)
```
2️⃣ **`.format()` Method**
```python
print("Hello, {}!".format(name))
```
3️⃣ **Modern f-strings (Recommended)**
```python
print(f"Hello, {name}!")
```

🔹 **Exercise:** Convert older string formatting into f-strings.

---

## **Module 8: Functions & Decorators**  
### **Higher-Order Functions**  
🔹 Functions that take other functions as arguments.
```python
def apply_twice(func, value):
    return func(func(value))
```

### **Lambda Functions (One-Liners)**  
🔹 `lambda args: expression`
🔹 Example:
```python
square = lambda x: x ** 2
```

### **Closures**  
🔹 Functions inside functions that "remember" variables.
```python
def outer(msg):
    def inner():
        print(msg)
    return inner
```

### **What are Decorators?**  
🔹 Functions that modify other functions.
🔹 Example:
```python
def my_decorator(func):
    def wrapper():
        print("Something before function call")
        func()
        print("Something after function call")
    return wrapper

@my_decorator
def say_hello():
    print("Hello!")

say_hello()
```

🔹 **Exercise:** Implement a decorator that logs function execution time.

---

### **Final Test**
📝 **Includes:**
- Conceptual MCQs
- Code Transformations
- List Comprehension, String Formatting, and Decorator Problems
- A real-world coding challenge on employee data processing

---

This structured approach ensures the interns grasp Pythonic coding best practices while engaging in **hands-on exercises**. Let me know if you need modifications! 🚀


## **Interview Questions and Answers**  

### **1️⃣ Conceptual Questions**  

#### **Q1: What does it mean for code to be “Pythonic”?**  
**A:** Pythonic code follows Python best practices, emphasizing readability, conciseness, and efficiency. It leverages built-in functions, idiomatic structures (like list comprehensions), and follows PEP 8 guidelines.  

#### **Q2: What is the Zen of Python? How do you access it?**  
**A:** The Zen of Python is a collection of principles for writing clean, readable Python code. You can access it by running:  
```python
import this
```

#### **Q3: Why should we avoid using `range(len(list))` in a for loop?**  
**A:** Instead of iterating over indices, it's more Pythonic to use `enumerate()` to get both index and value directly:  
```python
fruits = ["apple", "banana", "cherry"]
for index, fruit in enumerate(fruits):
    print(index, fruit)
```

#### **Q4: What is short-circuit evaluation in Python?**  
**A:** Short-circuiting means stopping evaluation once the result is known.  
- In `A or B`, if `A` is truthy, `B` is never evaluated.  
- In `A and B`, if `A` is falsy, `B` is never evaluated.  

Example:  
```python
x = None
print(x or "Default Value")  # Output: "Default Value"
```

#### **Q5: What are mutable and immutable objects in Python? Give examples.**  
**A:**  
- **Mutable**: Can be modified after creation (e.g., `list`, `dict`, `set`).  
- **Immutable**: Cannot be modified after creation (e.g., `str`, `tuple`, `frozenset`).  

Example:  
```python
s = "hello"
s[0] = 'H'  # ❌ Error (strings are immutable)

lst = [1, 2, 3]
lst.append(4)  # ✅ Allowed (lists are mutable)
```

#### **Q6: What is the problem with mutable default arguments in functions? How do you fix it?**  
**A:**  
Mutable default arguments retain state across function calls.  

**Wrong Approach:**  
```python
def add_to_list(item, lst=[]):
    lst.append(item)
    return lst

print(add_to_list(1))  # [1]
print(add_to_list(2))  # [1, 2] (unexpected behavior)
```
**Correct Approach:**  
```python
def add_to_list(item, lst=None):
    if lst is None:
        lst = []
    lst.append(item)
    return lst
```

#### **Q7: What is the difference between `is` and `==` in Python?**  
**A:**  
- `==` checks **value equality**.  
- `is` checks **object identity (memory address)**.  

Example:  
```python
a = [1, 2, 3]
b = [1, 2, 3]

print(a == b)  # ✅ True (same values)
print(a is b)  # ❌ False (different objects in memory)
```

---

## **Coding Problems & Solutions**  

### **1️⃣ Pythonic Refactoring**  
#### **Problem:** Rewrite the following non-Pythonic code in a more Pythonic way.  
```python
numbers = [1, 2, 3, 4, 5]
squares = []
for i in range(len(numbers)):
    squares.append(numbers[i] ** 2)

print(squares)
```
#### **Solution:**  
```python
squares = [num ** 2 for num in numbers]
print(squares)
```
---

### **2️⃣ List Comprehension Challenge**  
#### **Problem:** Given a list of words, create a new list containing only words that have more than 4 letters.  
```python
words = ["apple", "is", "a", "fruit", "bat"]
```
#### **Solution:**  
```python
long_words = [word for word in words if len(word) > 4]
print(long_words)  # Output: ['apple', 'fruit']
```
---

### **3️⃣ Using Enumerate**  
#### **Problem:** Modify the following loop to use `enumerate()` instead of manually tracking the index.  
```python
names = ["Alice", "Bob", "Charlie"]
index = 0
for name in names:
    print(index, name)
    index += 1
```
#### **Solution:**  
```python
for index, name in enumerate(names):
    print(index, name)
```
---

### **4️⃣ String Formatting Challenge**  
#### **Problem:** Convert the following string formatting into f-strings.  
```python
name = "Alice"
age = 25
print("My name is {} and I am {} years old.".format(name, age))
```
#### **Solution:**  
```python
print(f"My name is {name} and I am {age} years old.")
```
---

### **5️⃣ Using a Decorator**  
#### **Problem:** Write a decorator that logs function execution time.  
```python
import time

def timer(func):
    def wrapper(*args, **kwargs):
        start = time.time()
        result = func(*args, **kwargs)
        end = time.time()
        print(f"Executed {func.__name__} in {end - start:.4f} seconds")
        return result
    return wrapper

@timer
def slow_function():
    time.sleep(2)
    print("Finished slow function")

slow_function()
```
✅ **Expected Output:**  
```
Finished slow function
Executed slow_function in 2.0003 seconds
```
---

### **6️⃣ Mutable Default Argument Fix**  
#### **Problem:** Fix the following function so it doesn’t retain the state across function calls.  
```python
def append_to_list(value, my_list=[]):
    my_list.append(value)
    return my_list

print(append_to_list(1))  # [1]
print(append_to_list(2))  # [1, 2] (incorrect)
```
#### **Solution:**  
```python
def append_to_list(value, my_list=None):
    if my_list is None:
        my_list = []
    my_list.append(value)
    return my_list
```
---

### **7️⃣ Flatten a Nested List Using List Comprehension**  
#### **Problem:** Convert a nested list into a single flat list using list comprehension.  
```python
nested = [[1, 2, 3], [4, 5], [6, 7, 8]]
```
#### **Solution:**  
```python
flat = [num for sublist in nested for num in sublist]
print(flat)  # Output: [1, 2, 3, 4, 5, 6, 7, 8]
```
---

### **Real-World Pythonic Coding Challenges** 🚀  

These problems incorporate **Pythonic principles** such as **list comprehensions, decorators, efficient looping, and function decomposition**.  

---

## **1️⃣ Filtering Employee Records (List Comprehension & Lambda Functions)**  
🔹 **Problem:**  
Given a list of employee dictionaries, filter out employees who earn more than 50,000.  

```python
employees = [
    {"name": "Alice", "salary": 60000},
    {"name": "Bob", "salary": 48000},
    {"name": "Charlie", "salary": 75000},
    {"name": "David", "salary": 50000},
]
```
🔹 **Solution:**  
```python
high_earners = [emp for emp in employees if emp["salary"] > 50000]
print(high_earners)
```
✅ **Expected Output:**  
```python
[{'name': 'Alice', 'salary': 60000}, {'name': 'Charlie', 'salary': 75000}]
```
---

## **2️⃣ Find the Most Frequent Word (Using Counter & Dictionary Comprehension)**  
🔹 **Problem:**  
Given a string, find the most frequently occurring word. Ignore case sensitivity.  

```python
text = "Python is great and Python is easy. Learning python is fun!"
```
🔹 **Solution:**  
```python
from collections import Counter

words = text.lower().split()
word_count = Counter(words)
most_frequent = max(word_count, key=word_count.get)
print(most_frequent)
```
✅ **Expected Output:**  
```python
'python'
```
---

## **3️⃣ Convert a List of Tuples into a Dictionary (Tuple Unpacking)**  
🔹 **Problem:**  
Convert the following list of (key, value) tuples into a dictionary.  
```python
data = [("name", "Alice"), ("age", 25), ("city", "New York")]
```
🔹 **Solution:**  
```python
dictionary = {key: value for key, value in data}
print(dictionary)
```
✅ **Expected Output:**  
```python
{'name': 'Alice', 'age': 25, 'city': 'New York'}
```
---

## **4️⃣ Implement an LRU Cache (Using `functools.lru_cache`)**  
🔹 **Problem:**  
Optimize a recursive Fibonacci function using an LRU cache.  

🔹 **Solution:**  
```python
from functools import lru_cache

@lru_cache(maxsize=None)
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

print(fibonacci(50))  # Much faster than normal recursion!
```
---

## **5️⃣ Extract Email Domains from a List (Regex & List Comprehension)**  
🔹 **Problem:**  
Extract email domains from a given list of emails.  
```python
emails = ["alice@example.com", "bob@company.org", "charlie@gmail.com"]
```
🔹 **Solution:**  
```python
import re

domains = [re.search("@(.+)", email).group(1) for email in emails]
print(domains)
```
✅ **Expected Output:**  
```python
['example.com', 'company.org', 'gmail.com']
```
---

## **6️⃣ Decorator to Log Function Calls**  
🔹 **Problem:**  
Write a decorator that logs every function call along with its arguments and return value.  

🔹 **Solution:**  
```python
def log_function(func):
    def wrapper(*args, **kwargs):
        result = func(*args, **kwargs)
        print(f"Called {func.__name__} with {args}, {kwargs} → Returned {result}")
        return result
    return wrapper

@log_function
def multiply(a, b):
    return a * b

multiply(5, 3)
```
✅ **Expected Output:**  
```python
Called multiply with (5, 3), {} → Returned 15
```
---

## **7️⃣ Find Anagrams from a List (Sorting & Dictionary)**  
🔹 **Problem:**  
Given a list of words, group anagrams together.  

```python
words = ["listen", "silent", "enlist", "rat", "tar", "art"]
```
🔹 **Solution:**  
```python
from collections import defaultdict

anagrams = defaultdict(list)
for word in words:
    sorted_word = "".join(sorted(word))
    anagrams[sorted_word].append(word)

print(list(anagrams.values()))
```
✅ **Expected Output:**  
```python
[['listen', 'silent', 'enlist'], ['rat', 'tar', 'art']]
```
---

## **8️⃣ Flatten a Deeply Nested List (Recursion)**  
🔹 **Problem:**  
Flatten a deeply nested list of unknown depth.  

```python
nested_list = [1, [2, [3, [4, 5]]], 6]
```
🔹 **Solution:**  
```python
def flatten(lst):
    result = []
    for item in lst:
        if isinstance(item, list):
            result.extend(flatten(item))
        else:
            result.append(item)
    return result

print(flatten(nested_list))
```
✅ **Expected Output:**  
```python
[1, 2, 3, 4, 5, 6]
```
---

## **9️⃣ Remove Duplicates from a List While Maintaining Order (Set + Dictionary)**  
🔹 **Problem:**  
Remove duplicates from a list while preserving the order.  

```python
numbers = [4, 5, 2, 4, 5, 6, 2, 7]
```
🔹 **Solution:**  
```python
unique_numbers = list(dict.fromkeys(numbers))
print(unique_numbers)
```
✅ **Expected Output:**  
```python
[4, 5, 2, 6, 7]
```
---

## **🔟 Find Pairs in a List that Sum to a Target (Two-Pointer Technique)**  
🔹 **Problem:**  
Find all unique pairs that sum to a given target.  

```python
nums = [1, 2, 3, 4, 5, 6, 7]
target = 8
```
🔹 **Solution:**  
```python
nums.sort()
left, right = 0, len(nums) - 1
pairs = []

while left < right:
    s = nums[left] + nums[right]
    if s == target:
        pairs.append((nums[left], nums[right]))
        left += 1
        right -= 1
    elif s < target:
        left += 1
    else:
        right -= 1

print(pairs)
```
✅ **Expected Output:**  
```python
[(1, 7), (2, 6), (3, 5)]
```
---

## **Final Thoughts**  
✅ These challenges **simulate real-world problems** and test knowledge of:  
🔹 List comprehensions  
🔹 String manipulation  
🔹 Functional programming (`lambda`, `map`, `filter`)  
🔹 Dictionary tricks  
🔹 Efficient looping & recursion  

Would you like **more advanced problems**, or should I create **a structured test** using these? 🚀

### **Lambda Function Exercises with Solutions** 🚀  

Lambda functions (anonymous functions) are widely used in Python for short, inline functions. These exercises will reinforce their usage in different contexts like `map()`, `filter()`, `sorted()`, and list comprehensions.

---

## **1️⃣ Square of a Number (Basic Lambda)**  
🔹 **Problem:** Write a lambda function that takes a number and returns its square.

#### ✅ **Solution:**  
```python
square = lambda x: x ** 2
print(square(5))  # Output: 25
```

---

## **2️⃣ Sort a List of Tuples by Second Element**  
🔹 **Problem:** Given a list of tuples, sort them based on the second element using `lambda`.  
```python
pairs = [(1, 3), (4, 2), (2, 5), (3, 1)]
```
#### ✅ **Solution:**  
```python
sorted_pairs = sorted(pairs, key=lambda x: x[1])
print(sorted_pairs)
```
🔹 **Expected Output:**  
```python
[(3, 1), (4, 2), (1, 3), (2, 5)]
```

---

## **3️⃣ Filter Even Numbers from a List (`filter()`)**  
🔹 **Problem:** Use `lambda` with `filter()` to extract even numbers from a list.  

```python
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]
```
#### ✅ **Solution:**  
```python
even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
print(even_numbers)
```
🔹 **Expected Output:**  
```python
[2, 4, 6, 8]
```

---

## **4️⃣ Convert a List of Strings to Uppercase (`map()`)**  
🔹 **Problem:** Use `lambda` with `map()` to convert all words to uppercase.  
```python
words = ["hello", "world", "python"]
```
#### ✅ **Solution:**  
```python
uppercase_words = list(map(lambda word: word.upper(), words))
print(uppercase_words)
```
🔹 **Expected Output:**  
```python
['HELLO', 'WORLD', 'PYTHON']
```

---

## **5️⃣ Find the Maximum of Two Numbers**  
🔹 **Problem:** Write a lambda function to return the maximum of two numbers.  

#### ✅ **Solution:**  
```python
max_number = lambda a, b: a if a > b else b
print(max_number(10, 20))  # Output: 20
```

---

## **6️⃣ Extract First Letter of Each Word (`map()`)**  
🔹 **Problem:** Extract the first letter of each word from a list using `map()`.  
```python
words = ["apple", "banana", "cherry"]
```
#### ✅ **Solution:**  
```python
first_letters = list(map(lambda word: word[0], words))
print(first_letters)
```
🔹 **Expected Output:**  
```python
['a', 'b', 'c']
```

---

## **7️⃣ Find Words Longer than `n` (`filter()`)**  
🔹 **Problem:** Use `lambda` and `filter()` to get words longer than 4 characters.  
```python
words = ["dog", "elephant", "cat", "giraffe"]
```
#### ✅ **Solution:**  
```python
long_words = list(filter(lambda word: len(word) > 4, words))
print(long_words)
```
🔹 **Expected Output:**  
```python
['elephant', 'giraffe']
```

---

## **8️⃣ Multiply Corresponding Elements of Two Lists (`map()`)**  
🔹 **Problem:** Multiply elements at the same index from two lists using `map()`.  
```python
list1 = [1, 2, 3]
list2 = [4, 5, 6]
```
#### ✅ **Solution:**  
```python
product = list(map(lambda x, y: x * y, list1, list2))
print(product)
```
🔹 **Expected Output:**  
```python
[4, 10, 18]
```

---

## **9️⃣ Sort a List of Dictionaries by a Key (`sorted()`)**  
🔹 **Problem:** Sort a list of dictionaries based on the `"age"` key.  
```python
people = [{"name": "Alice", "age": 30}, {"name": "Bob", "age": 25}, {"name": "Charlie", "age": 35}]
```
#### ✅ **Solution:**  
```python
sorted_people = sorted(people, key=lambda person: person["age"])
print(sorted_people)
```
🔹 **Expected Output:**  
```python
[{'name': 'Bob', 'age': 25}, {'name': 'Alice', 'age': 30}, {'name': 'Charlie', 'age': 35}]
```

---

## **🔟 Count Occurrences of Each Character (`reduce()`)**  
🔹 **Problem:** Count the frequency of characters in a string using `reduce()`.  
```python
from functools import reduce

text = "hello"
char_count = reduce(lambda acc, char: {**acc, char: acc.get(char, 0) + 1}, text, {})
print(char_count)
```
🔹 **Expected Output:**  
```python
{'h': 1, 'e': 1, 'l': 2, 'o': 1}
```

---

## **BONUS: Custom Sorting (Sort by Last Letter of Word)**  
🔹 **Problem:** Sort a list of words based on their last letter.  
```python
words = ["banana", "apple", "cherry", "blueberry"]
```
#### ✅ **Solution:**  
```python
sorted_words = sorted(words, key=lambda word: word[-1])
print(sorted_words)
```
🔹 **Expected Output:**  
```python
['banana', 'apple', 'blueberry', 'cherry']
```

---

### **Final Thoughts** 🚀  
These exercises cover **lambda functions** in different real-world applications like:  
✅ `map()`, `filter()`, and `reduce()`  
✅ `sorted()` for custom sorting  
✅ String and list manipulations  

Would you like **more advanced challenges**, or should I create a **structured test** with lambda-based coding problems? 💡


Here are some **real-world coding challenges using decorators** that focus on logging, authentication, memoization, timing, and more. These will **help interns understand the power of decorators** in Python.

---

## **1️⃣ Logging Function Calls (Basic Decorator)**
🔹 **Problem:** Write a decorator that logs the function name and arguments before calling it.

#### ✅ **Solution:**
```python
def log_function(func):
    def wrapper(*args, **kwargs):
        print(f"Calling {func.__name__} with arguments: {args}, {kwargs}")
        return func(*args, **kwargs)
    return wrapper

@log_function
def add(a, b):
    return a + b

print(add(5, 3))  # Output: Calling add with arguments: (5, 3), {} → 8
```

---

## **2️⃣ Measuring Execution Time**
🔹 **Problem:** Write a decorator that measures the execution time of a function.

#### ✅ **Solution:**
```python
import time

def timer(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"{func.__name__} took {end_time - start_time:.5f} seconds")
        return result
    return wrapper

@timer
def slow_function():
    time.sleep(2)
    return "Finished"

print(slow_function())  
# Output: slow_function took ~2.000x seconds → Finished
```

---

## **3️⃣ Authentication Check**
🔹 **Problem:** Create a decorator that checks if a user is logged in before executing the function.

#### ✅ **Solution:**
```python
def authenticate(user):
    def decorator(func):
        def wrapper(*args, **kwargs):
            if not user.get("is_logged_in"):
                print("Access Denied: User is not logged in!")
                return
            return func(*args, **kwargs)
        return wrapper
    return decorator

user = {"name": "Alice", "is_logged_in": False}

@authenticate(user)
def view_dashboard():
    print("Welcome to the dashboard!")

view_dashboard()  # Output: Access Denied: User is not logged in!

user["is_logged_in"] = True
view_dashboard()  # Output: Welcome to the dashboard!
```

---

## **4️⃣ Caching Function Results (Memoization with `functools.lru_cache`)**
🔹 **Problem:** Optimize Fibonacci calculations using an LRU cache.

#### ✅ **Solution:**
```python
from functools import lru_cache

@lru_cache(maxsize=100)
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

print(fibonacci(50))  # Output: 12586269025 (Computed much faster)
```

---

## **5️⃣ Retry Mechanism for Unreliable APIs**
🔹 **Problem:** Write a decorator that retries a function if it fails.

#### ✅ **Solution:**
```python
import random
import time

def retry(times):
    def decorator(func):
        def wrapper(*args, **kwargs):
            for _ in range(times):
                try:
                    return func(*args, **kwargs)
                except Exception as e:
                    print(f"Error: {e}, Retrying...")
                    time.sleep(1)
            print("Max retries reached. Exiting.")
        return wrapper
    return decorator

@retry(3)
def unstable_api():
    if random.random() < 0.7:
        raise Exception("API Failure!")
    return "Success!"

print(unstable_api())  
# Output: If it fails, retries up to 3 times before giving up.
```

---

## **6️⃣ Enforce Function Argument Types**
🔹 **Problem:** Write a decorator that ensures function arguments match expected types.

#### ✅ **Solution:**
```python
def enforce_types(*expected_types):
    def decorator(func):
        def wrapper(*args, **kwargs):
            for i, arg in enumerate(args):
                if not isinstance(arg, expected_types[i]):
                    raise TypeError(f"Argument {i} must be {expected_types[i].__name__}")
            return func(*args, **kwargs)
        return wrapper
    return decorator

@enforce_types(int, int)
def add(a, b):
    return a + b

print(add(5, 3))  # Output: 8
# print(add("5", 3))  # Raises TypeError: Argument 0 must be int
```

---

## **7️⃣ Restrict Function Calls (Rate Limiting)**
🔹 **Problem:** Write a decorator that allows a function to be called at most **N** times per second.

#### ✅ **Solution:**
```python
import time

def rate_limiter(calls_per_second):
    interval = 1.0 / calls_per_second
    def decorator(func):
        last_called = [0.0]

        def wrapper(*args, **kwargs):
            elapsed = time.time() - last_called[0]
            if elapsed < interval:
                time.sleep(interval - elapsed)
            last_called[0] = time.time()
            return func(*args, **kwargs)
        return wrapper
    return decorator

@rate_limiter(2)  # Max 2 calls per second
def say_hello():
    print("Hello!")

for _ in range(5):
    say_hello()
```
🔹 **Expected Output:** The function executes at a controlled rate.

---

## **8️⃣ Convert Function Output to JSON**
🔹 **Problem:** Write a decorator that converts a function’s return value to JSON format.

#### ✅ **Solution:**
```python
import json

def to_json(func):
    def wrapper(*args, **kwargs):
        result = func(*args, **kwargs)
        return json.dumps(result)
    return wrapper

@to_json
def get_data():
    return {"name": "Alice", "age": 25}

print(get_data())  # Output: '{"name": "Alice", "age": 25}'
```

---

## **9️⃣ Ensure Function Output is Non-Empty**
🔹 **Problem:** Write a decorator that ensures a function’s return value is not `None` or empty.

#### ✅ **Solution:**
```python
def ensure_non_empty(func):
    def wrapper(*args, **kwargs):
        result = func(*args, **kwargs)
        if not result:
            raise ValueError("Function returned empty result!")
        return result
    return wrapper

@ensure_non_empty
def get_username():
    return ""

# print(get_username())  # Raises ValueError: Function returned empty result!
```

---

## **🔟 Trace Function Calls with Indentation**
🔹 **Problem:** Write a decorator that visually traces function calls.

#### ✅ **Solution:**
```python
def trace(func):
    def wrapper(*args, **kwargs):
        print(f"> Calling {func.__name__}({args}, {kwargs})")
        result = func(*args, **kwargs)
        print(f"< {func.__name__} returned {result}")
        return result
    return wrapper

@trace
def multiply(a, b):
    return a * b

print(multiply(4, 5))
# Output:
# > Calling multiply((4, 5), {})
# < multiply returned 20
```

---

### **🚀 Summary: Why These Decorators Matter?**
These decorators solve **real-world problems**, including:  
✅ **Logging function calls**  
✅ **Performance optimization (caching, timing, retrying API calls)**  
✅ **Security (authentication check)**  
✅ **Data validation (argument types, non-empty return values)**  
✅ **Rate limiting (prevent spamming APIs)**  

Would you like **more exercises** or a **structured test** on decorators? 💡🚀
