class Solution:
    def sortArray(nums: list[int]) -> list[int]:

        def merge(nums, left, mid, right, temp):
            i, j = left, mid+1
            k = left
            while i <= mid and j <= right:
                if nums[i] <= nums[j]:
                    temp[k] = nums[i]
                    i += 1

                else:
                    temp[k] = nums[j]
                    j += 1
                k += 1

            while i <= mid:
                temp[k] = nums[i]
                k += 1
                i += 1

            while j <= right:
                temp[k] = nums[j]
                k += 1
                j += 1
            for m in range(left, right + 1):
                nums[m] = temp[m]

        def mergeSort(nums, low, high, temp):
            mid = low+(high-low)//2
            if low < high:
                mergeSort(nums, low, mid, temp)
                mergeSort(nums, mid+1, high, temp)
                merge(nums, low, mid, high, temp)
            return nums

        def _mergeSort(nums, n):
            temp = [0]*n
            return mergeSort(nums, 0, n-1, temp)

        result = _mergeSort(nums, len(nums))

        return result

    num = [5, 64, 1, 4, 312, 12, 10, 1]
    print(sortArray(num))
