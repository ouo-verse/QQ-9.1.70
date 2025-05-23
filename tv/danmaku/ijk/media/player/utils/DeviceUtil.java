package tv.danmaku.ijk.media.player.utils;

import com.tencent.oskplayer.support.log.Logger;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes30.dex */
public class DeviceUtil {
    public static int getBaseScore() {
        boolean isNEON = isNEON();
        double curCpuFreq = getCurCpuFreq();
        if (curCpuFreq < 0.0d) {
            Logger.g().w("AbstractMediaPlayer", "no cpuinfo");
            return 5;
        }
        int numberOfCores = getNumberOfCores();
        int memoryInfo = getMemoryInfo();
        Logger.g().w("AbstractMediaPlayer", "getScore  getNumberOfCores " + Integer.toString(numberOfCores) + " getCurCpuFreq " + Double.toString(curCpuFreq) + " , getMemoryInfo " + Integer.toString(memoryInfo) + " isNeon " + Boolean.toString(isNEON));
        double d16 = ((double) numberOfCores) * curCpuFreq;
        if (d16 >= 6.4d && memoryInfo >= 600) {
            return 26;
        }
        if (d16 >= 4.8d && memoryInfo >= 600) {
            return 21;
        }
        if (d16 >= 2.0d && memoryInfo >= 400) {
            return 16;
        }
        if (d16 < 1.0d || memoryInfo < 400) {
            return 5;
        }
        return 11;
    }

    private static String getCPUInfos() {
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "cat  /proc/cpuinfo").getInputStream()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static double getCurCpuFreq() {
        int i3 = 0;
        for (int i16 = 0; i16 < getNumberOfCores(); i16++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i16 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i17 = 0;
                        while (true) {
                            byte b16 = bArr[i17];
                            if (b16 < 48 || b16 > 57 || i17 >= 128) {
                                break;
                            }
                            i17++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i17)));
                        if (valueOf.intValue() > i3) {
                            i3 = valueOf.intValue();
                        }
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                    fileInputStream.close();
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
        if (i3 > 0) {
            return Math.rint(((i3 * 10.0d) / 1024.0d) / 1024.0d) / 10.0d;
        }
        return 0.0d;
    }

    private static int getMemoryInfo() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "cat /proc/meminfo").getInputStream()), 8192);
            int i3 = 0;
            int i16 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || i3 >= 2) {
                    break;
                }
                i3++;
                i16 += Integer.parseInt(readLine.substring(readLine.indexOf(58) + 1, readLine.indexOf(107)).trim());
            }
            return (int) Math.rint(i16 / 1024.0d);
        } catch (IOException e16) {
            e16.getMessage();
            return 0;
        }
    }

    private static int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: tv.danmaku.ijk.media.player.utils.DeviceUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (Pattern.matches("cpu[0-9]+", file.getName())) {
                        return true;
                    }
                    return false;
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private static int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static boolean isNEON() {
        String lowerCase;
        String cPUInfos = getCPUInfos();
        if (cPUInfos == null || (lowerCase = cPUInfos.toLowerCase()) == null || !lowerCase.contains("neon")) {
            return false;
        }
        return true;
    }
}
