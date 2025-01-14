package DFS;

import java.util.*;

public class BabyNamesLCCI {
    public static void main(String[] args) {
        String[] names = new String[]{"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"};
        String[] synonyms = new String[]{"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"};
        String[] result = trulyMostPopular(names, synonyms);
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    public static String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> liveName = new HashSet<>();
        for (int i = 0; i < synonyms.length; i++) {
            String[] split = synonyms[i].substring(1, synonyms[i].length() - 1).split(",");
            List<String> orDefault = map.getOrDefault(split[0], new ArrayList<>());
            orDefault.add(split[1]);
            map.put(split[0], orDefault);
            liveName.add(split[0]);
            liveName.add(split[1]);
        }
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(0, names[i].indexOf("("));
            if (!liveName.contains(name)) {
                liveName.add(name);
                map.put(name, new ArrayList<>());
            }
        }
        List<Set<String>> all = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(entry.getKey());
            temp.addAll(entry.getValue());
            SortedSet<String> set = new TreeSet<>(temp);
            all.add(set);
        }


        List<Set<String>> lastAll = mergeSets(all);


        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(0, names[i].indexOf("("));
            int count = Integer.parseInt(names[i].substring(names[i].indexOf("(") + 1, names[i].length() - 1));
            for (int j = 0; j < lastAll.size(); j++) {
                if (lastAll.get(j).contains(name)) {
                    int preCount = stringIntegerMap.getOrDefault(lastAll.get(j).iterator().next(), 0);
                    int curCount = preCount + count;
                    stringIntegerMap.put(lastAll.get(j).iterator().next(), curCount);
                }
            }
        }
        String[] result = new String[stringIntegerMap.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            result[index] = entry.getKey() + "(" + entry.getValue() + ")";
            index++;
        }
        return result;
    }

    public static List<Set<String>> mergeSets(List<Set<String>> originalList) {
        List<Set<String>> resultList = new ArrayList<>();
        boolean[] visited = new boolean[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            if (!visited[i]) {
                SortedSet<String> mergedSet = new TreeSet<>(originalList.get(i));
                visited[i] = true;
                mergeWithConnectedSets(originalList, visited, mergedSet, i);
                resultList.add(mergedSet);
            }
        }
        return resultList;
    }
    public static void mergeWithConnectedSets(List<Set<String>> originalList, boolean[] visited, Set<String> mergedSet, int index) {
        for (int i = 0; i < originalList.size(); i++) {
            if (!visited[i]) {
                Set<String> currentSet = originalList.get(i);
                SortedSet<String> intersection = new TreeSet<>(mergedSet);
                intersection.retainAll(currentSet);
                if (!intersection.isEmpty()) {
                    visited[i] = true;
                    mergedSet.addAll(currentSet);
                    mergeWithConnectedSets(originalList, visited, mergedSet, i); // 递归检查与当前集合合并后的新集合
                }
            }
        }
    }
}
