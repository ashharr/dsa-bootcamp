class Solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        # p1, p2 = m - 1, n - 1
        # pos = m + n - 1
        # while p1 >= 0 and p2 >= 0:
        #     if nums1[p1] >= nums2[p2]:
        #         nums1[pos] = nums1[p1]
        #         p1 -= 1
        #     else:
        #         nums1[pos] = nums2[p2]
        #         p2 -= 1
        #     pos -= 1
        # while p2 >= 0:
        #     nums1[pos] = nums2[p2]
        #     p2 -= 1
        #     pos -= 1 

        gap = -(-len(nums1)//2)
        if n!=0:
            nums1[-n:]=nums2
        while gap>0 and n!=0:
            p1 = 0
            p2 = gap
            while p2<len(nums1):
                if nums1[p1] >nums1[p2]:
                    nums1[p1],nums1[p2] = nums1[p2],nums1[p1]
                p1+=1
                p2+=1
            if gap==1:
                gap =0
            gap = -(-gap//2)