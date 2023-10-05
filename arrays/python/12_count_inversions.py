# Count Inversions
# Detailed explanation ( Input/output format, Notes, Constraints, Images )
# Sample Input 1 :
# 3
# 3 2 1
# Sample Output 1 :
# 3
# Explanation Of Sample Output 1:
# We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
# Sample Input 2 :
# 5
# 2 5 1 3 4
# Sample Output 2 :
# 4

# GFG Solution
# Python3 program to count inversions 
# in an array
  
# Function to Use Inversion Count
def mergeSort(arr, n):
    # A temp_arr is created to store
    # sorted array in merge function
    temp_arr = [0]*n
    return _mergeSort(arr, temp_arr, 
                      0, n - 1)
  
# This Function will use MergeSort to 
# count inversions
def _mergeSort(arr, temp_arr, left, right):
  
    # A variable inv_count is used to store
    # inversion counts in each recursive call
  
    inv_count = 0
  
    # We will make a recursive call if and 
    # only if we have more than one elements
  
    if left < right:
  
        # mid is calculated to divide the array 
        # into two subarrays
        # Floor division is must in case of python
  
        mid = (left + right)//2
  
        # It will calculate inversion 
        # counts in the left subarray
        inv_count += _mergeSort(arr, temp_arr, 
                                left, mid)
  
        # It will calculate inversion 
        # counts in right subarray
        inv_count += _mergeSort(arr, temp_arr, 
                                mid + 1, right)
  
        # It will merge two subarrays in 
        # a sorted subarray
        inv_count += merge(arr, temp_arr, 
                           left, mid, right)
    return inv_count
  
# This function will merge two subarrays 
# in a single sorted subarray
def merge(arr, temp_arr, left, mid, right):
  
    # Starting index of left subarray
    i = left     
  
    # Starting index of right subarray
    j = mid + 1 
  
    # Starting index of to be sorted subarray
    k = left     
    inv_count = 0
  
    # Conditions are checked to make sure that 
    # i and j don't exceed their
    # subarray limits.
  
    while i <= mid and j <= right:
  
        # There will be no inversion if 
        # arr[i] <= arr[j]
        if arr[i] <= arr[j]:
            temp_arr[k] = arr[i]
            k += 1
            i += 1
        else:
  
            # Inversion will occur.
            temp_arr[k] = arr[j]
            inv_count += (mid-i + 1)
            k += 1
            j += 1
  
    # Copy the remaining elements of left 
    # subarray into temporary array
    while i <= mid:
        temp_arr[k] = arr[i]
        k += 1
        i += 1
  
    # Copy the remaining elements of right 
    # subarray into temporary array
    while j <= right:
        temp_arr[k] = arr[j]
        k += 1
        j += 1
  
    # Copy the sorted subarray into 
    # Original array
    for m in range(left, right + 1):
        arr[m] = temp_arr[m]

    return inv_count
  
# Driver Code
# Given array is
arr = [6,9,3,2,1]
n = len(arr)
result = mergeSort(arr, n)
print("Number of inversions are", result)