package rr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    static a f431971g;

    /* renamed from: h, reason: collision with root package name */
    static final Object f431972h = new Object();

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, String> f431973a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f431974b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f431975c = "";

    /* renamed from: d, reason: collision with root package name */
    long f431976d = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f431977e;

    /* renamed from: f, reason: collision with root package name */
    final BroadcastReceiver f431978f;

    /* compiled from: P */
    /* renamed from: rr.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11154a extends BroadcastReceiver {
        C11154a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == null) {
                return;
            }
            a aVar = a.this;
            String str = aVar.f431974b;
            aVar.a();
            a.this.getClass();
        }
    }

    a() {
        C11154a c11154a = new C11154a();
        this.f431978f = c11154a;
        a();
        d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        VideoEnvironment.getContext().registerReceiver(c11154a, intentFilter);
        this.f431977e = true;
    }

    public static a b() {
        if (f431971g == null) {
            synchronized (f431972h) {
                if (f431971g == null) {
                    f431971g = new a();
                }
            }
        }
        return f431971g;
    }

    static boolean c(String str) {
        File file = new File(str + "/qz" + Thread.currentThread().getId());
        boolean z16 = false;
        try {
            if (file.exists()) {
                if (file.delete()) {
                    z16 = file.createNewFile();
                }
            } else {
                z16 = file.createNewFile();
            }
        } finally {
            try {
                return z16;
            } finally {
            }
        }
        return z16;
    }

    void a() {
        synchronized (this.f431973a) {
            this.f431973a.clear();
            this.f431974b = "";
            this.f431976d = 0L;
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (!this.f431973a.containsValue(absolutePath)) {
                this.f431973a.put("external_card", absolutePath);
            }
            for (String str : this.f431973a.values()) {
                try {
                    File file = new File(str);
                    if (file.exists() && file.canWrite() && c(str)) {
                        StatFs statFs = new StatFs(str);
                        long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
                        if (availableBlocks > 0 && this.f431976d < availableBlocks) {
                            this.f431976d = availableBlocks;
                            this.f431974b = str;
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    void d() {
        if (TextUtils.isEmpty(this.f431974b)) {
            return;
        }
        this.f431975c = this.f431974b + "/Android/data/com.tencent.mobileqq/qq/video";
        if (QLog.isColorLevel()) {
            QLog.e("TAG", 2, "updateStorePath:storeVideoPath=" + this.f431975c);
            QLog.e("TAG", 2, "updateStorePath:maxAvailableSizePath=" + this.f431974b);
        }
        try {
            File file = new File(this.f431975c);
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        } catch (Exception unused) {
            this.f431974b = null;
        }
    }
}
