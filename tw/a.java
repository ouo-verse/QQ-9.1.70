package tw;

import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f437854a;

    /* renamed from: b, reason: collision with root package name */
    public int f437855b;

    /* renamed from: c, reason: collision with root package name */
    public float f437856c;

    /* renamed from: d, reason: collision with root package name */
    public float f437857d;

    public static a a() {
        a aVar = new a();
        aVar.f437854a = Build.VERSION.SDK_INT;
        aVar.f437857d = ((float) m.c()) / 1.07374182E9f;
        aVar.f437855b = ah.n();
        aVar.f437856c = ((float) AVCoreSystemInfo.getMaxCpuFreq()) / 1048576.0f;
        return aVar;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("[apiLevel: ");
        sb5.append(this.f437854a);
        sb5.append(", cpuNum: ");
        sb5.append(this.f437855b);
        sb5.append(", maxFreqGHZ: ");
        sb5.append(this.f437856c);
        sb5.append(", ramSizeGB:");
        sb5.append(this.f437857d);
        sb5.append("]");
        return sb5.toString();
    }
}
