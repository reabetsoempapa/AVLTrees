import subprocess
import os

insMin,insMax,insAvg,serMin,serMax,serAvg = [],[],[],[],[],[]


for i in range(0,200001,10000):
    os.system("java -cp bin AVLExperiment "+ str(i))
    
    array = []
    file = open("insertion_"+str(i),"r")
    for j in file:
        array.append(int(j))
    insMin.append(min(array))
    insMax.append(max(array))
    insAvg.append(round(sum(array)/len(array)))
    
    array2 = []
    file2 = open("search_"+str(i),"r")
    for m in file2:
        array2.append(int(m))
    serMin.append(min(array2))
    serMax.append(max(array2))
    serAvg.append(round(sum(array2)/len(array2)))

print("The min insertion comparison operations")
print(insMin)
print("The max insertion comparison operations")
print(insMax)
print("The average insertion comparison operations")
print(insAvg)
print()
print("The min search comparison operations")
print(serMin)
print("The max search comparison operations")
print(serMax)
print("The average search comparison operations")
print(serAvg)
