package DFS;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge_721 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Hanzo","Hanzo2@m.co","Hanzo3@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo4@m.co","Hanzo5@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo4@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo7@m.co","Hanzo8@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo1@m.co","Hanzo2@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo6@m.co","Hanzo7@m.co"));
        accounts.add(Arrays.asList("Hanzo","Hanzo5@m.co","Hanzo6@m.co"));
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;         // 统计一个有多少个不同的邮箱
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailCount);
        // 将一个账户下的邮箱的index合并起来，让他们都有同一个父级
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);      // 拿到第一邮箱的出现的编号
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);                // 接下来所有该账户下邮箱的父级都是第一个邮箱
            }
        }

        // 统计哪些邮箱是同一个用户下的
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));       // 找到这个邮箱的最顶级
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        System.out.println(indexToEmails);

        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }


        return merged;
    }


}
class UnionFind {
    int[] parent;           // 记录每个人的上级是谁，parent[16] = 6 => 就意味着16号的上级为6号

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // 一开始每个人都是自己的上级
        }
    }

    // 将两个不同的分支合并在一起，主要做法就是指定其中分支的最上级为另外一个分支中最上级的下级，
    // 只要他们只要往上找，就都能找到相同的上级
    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    // 找到某个元素的最上级
    public int find(int index) {
        // 就一层层的往上去找，直到找到最上级，因为最上级的上级就是自己本身
        // index：多少号， parent[index]: 这个人上级是多少号
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
