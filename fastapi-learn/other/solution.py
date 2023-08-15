class Solution:
    def permute(self, nums: list[int]) -> list[list[int]]:
        res = []
        path = []
        if len(nums) == 0:
            return res
        self.dfs(nums, res, path, 0)
        return res

    def dfs(self, nums: list, res: list, path, level):
        if len(path) == len(nums):
            res.append(path.copy())

        for num in nums:
            if num in path:
                continue
            path.append(num)
            self.dfs(nums, res, path, level + 1)
            path.pop()


solution = Solution()
print(solution.permute([1, 2, 3]))
