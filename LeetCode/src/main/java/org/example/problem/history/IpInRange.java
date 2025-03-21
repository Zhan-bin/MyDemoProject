package org.example.problem.history;

/**
 * 判断IP是否存在指定区间内
 * 1. 先调用load加载区间，使用long存储ip
 * 2. 再调用inRange判断是否存在区间内
 */
class IpInRange {
    static long[][] longTypeIpRange;

    public static void load(String[][] ipRange) {
        int len = ipRange.length;
        longTypeIpRange = new long[len][2];
        for (int i = 0; i < len; i++) {
            longTypeIpRange[i][0] = ipToLong(ipRange[i][0]);
            longTypeIpRange[i][1] = ipToLong(ipRange[i][1]);
        }
    }

    public static boolean inRange(String ip) {
        int low = 0, height = longTypeIpRange.length - 1;
        long longTypeIp = ipToLong(ip);
        while (low <= height) {
            int mid = (low + height) >> 1;
            if (longTypeIp < longTypeIpRange[mid][0]) {
                height = mid - 1;
            } else if (longTypeIp > longTypeIpRange[mid][1]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static long ipToLong(String ip) {
        long res = 0;
        String[] ipSem = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            res += Integer.parseInt(ipSem[i]) * Math.pow(256, 3 - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] testData = {
                "10.0.0.0",
                "20.0.0.223",
                "60.60.60.60",
                "90.5.0.1",
                "90.5.0.2",
                "90.4.0.1",
                "100.0.6.0"
        };

        String[][] ipRange = {
                {"10.0.0.1", "30.0.0.1"},
                {"50.0.0.1", "80.0.0.1"},
                {"90.0.0.1", "90.5.0.1"},
                {"100.0.0.1", "100.0.6.1"}
        };

        load(ipRange);
        for (String ip : testData) {
            System.out.println(ip + ": " + inRange(ip));
        }
    }
}
