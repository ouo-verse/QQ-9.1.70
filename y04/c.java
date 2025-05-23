package y04;

import android.annotation.SuppressLint;
import android.system.Os;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.rmonitor.fd.cluser.FdCluster;
import com.tencent.rmonitor.fd.data.FdCountable;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f449238b = Pattern.compile("[^0-9]+");

    /* renamed from: c, reason: collision with root package name */
    private static int f449239c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static String f449240d;

    /* renamed from: a, reason: collision with root package name */
    private final FdCluster f449241a = new FdCluster();

    @NotNull
    public static List<String> g() {
        File[] listFiles = new File(k()).listFiles();
        if (listFiles == null) {
            a14.c.e("RMotnior_FdLeak_ProcFdDump", "dumpFdList failed");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            String o16 = o(file.getAbsolutePath());
            if (o16 != null) {
                arrayList.add(o16);
            }
        }
        return arrayList;
    }

    private String h(float f16) {
        return (((int) (f16 * 10000.0f)) / 100.0f) + "%";
    }

    public static int i() {
        File[] listFiles = new File(k()).listFiles();
        if (listFiles != null) {
            return listFiles.length;
        }
        return Integer.MAX_VALUE;
    }

    private static String j() {
        return "/proc/self/limits";
    }

    private static String k() {
        return "/proc/self/fd";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileReader, java.io.Reader] */
    public static int l() {
        Closeable closeable;
        Throwable th5;
        BufferedReader bufferedReader;
        IOException e16;
        int i3 = f449239c;
        ?? r16 = -1;
        if (i3 != -1) {
            return i3;
        }
        try {
            try {
                r16 = new FileReader(j());
                try {
                    bufferedReader = new BufferedReader(r16);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains("Max open files")) {
                                f449239c = n(readLine);
                            }
                        } catch (IOException e17) {
                            e16 = e17;
                            a14.c.c("RMotnior_FdLeak_ProcFdDump", "get fd max count failed", e16);
                            a14.b.a(r16);
                            a14.b.a(bufferedReader);
                            return f449239c;
                        }
                    }
                } catch (IOException e18) {
                    bufferedReader = null;
                    e16 = e18;
                } catch (Throwable th6) {
                    closeable = null;
                    th5 = th6;
                    a14.b.a(r16);
                    a14.b.a(closeable);
                    throw th5;
                }
            } catch (IOException e19) {
                bufferedReader = null;
                e16 = e19;
                r16 = 0;
            } catch (Throwable th7) {
                closeable = null;
                th5 = th7;
                r16 = 0;
            }
            a14.b.a(r16);
            a14.b.a(bufferedReader);
            return f449239c;
        } catch (Throwable th8) {
            th5 = th8;
        }
    }

    public static String m(int i3) {
        switch (i3) {
            case 1:
                return com.tencent.mobileqq.msf.core.d.f247918u;
            case 2:
                return "eventfd";
            case 3:
                return "ashmem";
            case 4:
                return "dmabuf";
            case 5:
                return "file";
            case 6:
                return SemanticAttributes.NetTransportValues.PIPE;
            case 7:
                return ChildProcessServiceWrapper.PROCESS_TYPE_GPU;
            case 8:
                return "device";
            case 9:
                return "system_file";
            default:
                return "others";
        }
    }

    public static int n(String str) {
        String str2;
        String[] split = f449238b.split(str);
        if (split.length > 1) {
            str2 = split[1];
        } else {
            str2 = null;
        }
        if (str2 != null) {
            try {
                return Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                a14.c.b("RMotnior_FdLeak_ProcFdDump", "parseMaxOpenFiles failed: " + str2);
                return -1;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Nullable
    private static String o(String str) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        InputStream inputStream;
        ?? r46;
        InputStream inputStream2 = null;
        if (AndroidVersion.isOverL()) {
            try {
                String readlink = Os.readlink(str);
                f449240d = null;
                return readlink;
            } catch (Exception e16) {
                f449240d = e16.getMessage();
                a14.c.b("RMotnior_FdLeak_ProcFdDump", "Os.readlink(" + str + ") failed: " + e16.getMessage());
            }
        } else {
            String str2 = "sh -c readlink -f " + str;
            try {
                inputStream = RuntimeMonitor.exec(Runtime.getRuntime(), str2).getInputStream();
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                } catch (IOException e17) {
                    e = e17;
                    inputStreamReader = null;
                    r46 = inputStreamReader;
                    a14.c.b("RMotnior_FdLeak_ProcFdDump", str2 + " failed: " + e.getMessage());
                    a14.b.a(inputStream);
                    a14.b.a(inputStreamReader);
                    a14.b.a(r46);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    r46 = 0;
                }
                try {
                    r46 = new BufferedReader(inputStreamReader);
                } catch (IOException e18) {
                    e = e18;
                    r46 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    r46 = 0;
                    inputStream2 = inputStream;
                    closeable = r46;
                    a14.b.a(inputStream2);
                    a14.b.a(inputStreamReader);
                    a14.b.a(closeable);
                    throw th;
                }
            } catch (IOException e19) {
                e = e19;
                inputStream = null;
                inputStreamReader = null;
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                closeable = null;
                a14.b.a(inputStream2);
                a14.b.a(inputStreamReader);
                a14.b.a(closeable);
                throw th;
            }
            try {
                try {
                    String readLine = r46.readLine();
                    a14.b.a(inputStream);
                    a14.b.a(inputStreamReader);
                    a14.b.a(r46);
                    return readLine;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream2 = inputStream;
                    closeable = r46;
                    a14.b.a(inputStream2);
                    a14.b.a(inputStreamReader);
                    a14.b.a(closeable);
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
                a14.c.b("RMotnior_FdLeak_ProcFdDump", str2 + " failed: " + e.getMessage());
                a14.b.a(inputStream);
                a14.b.a(inputStreamReader);
                a14.b.a(r46);
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    private void p(Map<Integer, v04.a> map, float f16, BufferedWriter bufferedWriter) throws IOException {
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            v04.a aVar = map.get(Integer.valueOf(it.next().intValue()));
            bufferedWriter.write(String.format("%s,%d,%s", m(aVar.k()), Integer.valueOf(aVar.h()), h(aVar.h() / f16)));
            bufferedWriter.newLine();
            for (FdCountable fdCountable : aVar.j()) {
                bufferedWriter.write(String.format("%s,%d", fdCountable.getItem(), Integer.valueOf(fdCountable.getCount())));
                bufferedWriter.newLine();
            }
            bufferedWriter.newLine();
        }
    }

    @Override // y04.a
    protected FdLeakDumpResult c(String str) {
        BufferedWriter bufferedWriter;
        FileWriter fileWriter;
        List<String> g16 = g();
        Map<Integer, v04.a> b16 = this.f449241a.b(g16);
        if (!g16.isEmpty() && !b16.isEmpty()) {
            float size = g16.size();
            FileWriter fileWriter2 = null;
            try {
                fileWriter = new FileWriter(str);
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (IOException e16) {
                    e = e16;
                    bufferedWriter = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = null;
                }
            } catch (IOException e17) {
                e = e17;
                bufferedWriter = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedWriter = null;
            }
            try {
                p(b16, size, bufferedWriter);
                bufferedWriter.flush();
                FdLeakDumpResult f16 = f(str, b16);
                a14.b.a(fileWriter);
                a14.b.a(bufferedWriter);
                return f16;
            } catch (IOException e18) {
                e = e18;
                fileWriter2 = fileWriter;
                try {
                    a14.c.c("RMotnior_FdLeak_ProcFdDump", "dump failed", e);
                    FdLeakDumpResult e19 = e(5, e.getMessage());
                    a14.b.a(fileWriter2);
                    a14.b.a(bufferedWriter);
                    return e19;
                } catch (Throwable th7) {
                    th = th7;
                    a14.b.a(fileWriter2);
                    a14.b.a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                fileWriter2 = fileWriter;
                a14.b.a(fileWriter2);
                a14.b.a(bufferedWriter);
                throw th;
            }
        }
        return e(11, f449240d);
    }

    @Override // w04.c
    public int getType() {
        return 1;
    }
}
