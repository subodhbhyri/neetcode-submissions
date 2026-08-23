class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned = []

        for c in s:
            if c.isalnum():
                cleaned.append(c.lower())
        
        new_s = "".join(cleaned)

        n = len(new_s)
        mid = n//2
        if n%2==0:
            return self.expandFromCenter(mid-1, mid, new_s)
        else:
            return self.expandFromCenter(mid, mid, new_s)
        return False
    
    def expandFromCenter(self, i: int, j: int, s:str) -> bool:
        while(i>=0 and j<len(s)):
            if(s[i] != s[j]):
                return False
            else:
                i-=1
                j+=1
        
        return True
        