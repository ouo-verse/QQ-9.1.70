package vg2;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f441597a;

    /* renamed from: b, reason: collision with root package name */
    public int f441598b;

    /* renamed from: c, reason: collision with root package name */
    public int f441599c;

    /* renamed from: d, reason: collision with root package name */
    public int f441600d;

    public static b a(SosoLbsInfo sosoLbsInfo) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            b bVar = new b();
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            bVar.f441597a = (int) (sosoLocation.mLat02 * 1000000.0d);
            bVar.f441598b = (int) (sosoLocation.mLon02 * 1000000.0d);
            bVar.f441600d = 1;
            bVar.f441599c = (int) sosoLocation.altitude;
            return bVar;
        }
        return null;
    }

    @NonNull
    public String toString() {
        return "lat:" + this.f441597a + " lon:" + this.f441598b + " alt:" + this.f441599c + " type:" + this.f441600d;
    }
}
