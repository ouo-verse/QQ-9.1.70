package y04;

import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e extends a {
    @NotNull
    public static List<x04.b> g() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        ArrayList arrayList = new ArrayList(allStackTraces.size());
        for (Thread thread : allStackTraces.keySet()) {
            arrayList.add(new x04.b(thread, h(allStackTraces.get(thread))));
        }
        return arrayList;
    }

    private static List<String> h(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(stackTraceElementArr.length);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            arrayList.add(stackTraceElement.toString());
        }
        return arrayList;
    }

    @Override // y04.a
    protected FdLeakDumpResult c(String str) {
        BufferedWriter bufferedWriter;
        FdLeakDumpResult e16;
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(str);
            try {
                bufferedWriter = new BufferedWriter(fileWriter2);
                try {
                    List<x04.b> g16 = g();
                    Iterator<x04.b> it = g16.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.write(it.next().toString());
                        bufferedWriter.newLine();
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.flush();
                    e16 = f(str, g16);
                    a14.b.a(fileWriter2);
                } catch (IOException e17) {
                    e = e17;
                    fileWriter = fileWriter2;
                    try {
                        a14.c.b("RMonitor_FdLeak_ThreadsDumper", "dump failed: " + e.getMessage());
                        e16 = e(5, e.getMessage());
                        a14.b.a(fileWriter);
                        a14.b.a(bufferedWriter);
                        return e16;
                    } catch (Throwable th5) {
                        th = th5;
                        a14.b.a(fileWriter);
                        a14.b.a(bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileWriter = fileWriter2;
                    a14.b.a(fileWriter);
                    a14.b.a(bufferedWriter);
                    throw th;
                }
            } catch (IOException e18) {
                e = e18;
                bufferedWriter = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedWriter = null;
            }
        } catch (IOException e19) {
            e = e19;
            bufferedWriter = null;
        } catch (Throwable th8) {
            th = th8;
            bufferedWriter = null;
        }
        a14.b.a(bufferedWriter);
        return e16;
    }

    @Override // w04.c
    public int getType() {
        return 2;
    }
}
