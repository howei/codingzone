package string;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int minLen = Math.min(v1.length, v2.length);
        while (i < minLen && Integer.valueOf(v1[i]) == Integer.valueOf(v2[i])) {
        	i++;
        }

        if (i < minLen && Integer.valueOf(v1[i]) > Integer.valueOf(v2[i])) {
        	return 1;
        } else if (i < minLen && Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) {
        	return -1;
        }

        if (v1.length > minLen && Integer.valueOf(v1[i]) > 0) {
        	return 1;
        } else if (v2.length > minLen && Integer.valueOf(v2[i]) > 0) {
        	return -1;
        }
        return 0;
    }
}
