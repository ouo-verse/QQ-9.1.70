package w04;

import android.text.TextUtils;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y04.d;
import y04.e;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final c[] f444145a = {new y04.c(), new e(), new y04.b(), new d()};

    public static void a() {
        FileUtil.i(e());
    }

    private static String b(List<String> list, ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList2.addAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        String f16 = f();
        File file = new File(f16);
        if (file.exists() && file.isFile()) {
            FileUtil.i(file);
        }
        if (!FileUtil.l(arrayList2, f16, false)) {
            return null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            FileUtil.i(new File(it.next()));
        }
        return f16;
    }

    public static FdLeakDumpResult c(int i3, b bVar) {
        FdLeakDumpResult fdLeakDumpResult;
        if (bVar != null) {
            bVar.g(i3);
        }
        c[] cVarArr = f444145a;
        int length = cVarArr.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                c cVar = cVarArr[i16];
                if (cVar.getType() == i3) {
                    fdLeakDumpResult = cVar.a(d(i3, e()));
                    break;
                }
                i16++;
            } else {
                fdLeakDumpResult = null;
                break;
            }
        }
        if (fdLeakDumpResult == null) {
            fdLeakDumpResult = FdLeakDumpResult.failure(i3, 2);
        }
        if (bVar != null) {
            bVar.c(i3, fdLeakDumpResult);
        }
        return fdLeakDumpResult;
    }

    private static String d(int i3, File file) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        str = "";
                    } else {
                        str = "fd_stacks.txt";
                    }
                } else {
                    str = "heap.hprof";
                }
            } else {
                str = "threads.txt";
            }
        } else {
            str = "fd.txt";
        }
        return new File(file, str).getAbsolutePath();
    }

    public static File e() {
        return new File(com.tencent.rmonitor.fd.a.b(), "dump_root");
    }

    public static String f() {
        return new File(new File(com.tencent.rmonitor.fd.a.b(), "zips"), "fd_dump_" + System.currentTimeMillis() + ".zip").getAbsolutePath();
    }

    public static String g(List<FdLeakDumpResult> list, ArrayList<String> arrayList) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (FdLeakDumpResult fdLeakDumpResult : list) {
                if (fdLeakDumpResult.isSuccess() && !TextUtils.isEmpty(fdLeakDumpResult.getDumpFilePath())) {
                    arrayList2.add(fdLeakDumpResult.getDumpFilePath());
                } else {
                    a14.c.e("RMonitor_FdLeak_kDumpHelper", "dump result error or dump file path is empty");
                }
            }
            return b(arrayList2, arrayList);
        }
        return null;
    }
}
