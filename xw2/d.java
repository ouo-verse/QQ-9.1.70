package xw2;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f448917a;

    /* renamed from: b, reason: collision with root package name */
    private String f448918b;

    /* renamed from: c, reason: collision with root package name */
    private String f448919c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f448920d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f448921e;

    /* renamed from: f, reason: collision with root package name */
    private String f448922f;

    /* renamed from: g, reason: collision with root package name */
    private String f448923g;

    /* renamed from: h, reason: collision with root package name */
    private String f448924h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f448925i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f448926j = true;

    /* renamed from: k, reason: collision with root package name */
    public Bundle f448927k = new Bundle();

    public String a() {
        return this.f448918b;
    }

    public d b(boolean z16) {
        this.f448920d = z16;
        return this;
    }

    public void c(String str) {
        this.f448923g = str;
    }

    public void d(String str) {
        this.f448918b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f448918b;
        if (str == null) {
            if (dVar.f448918b != null) {
                return false;
            }
        } else if (!str.equals(dVar.f448918b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f448918b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    public String toString() {
        return "QADVideoData {\n\t\t\t\thash:" + hashCode() + ", title:" + this.f448922f + ", vid:" + this.f448918b + ", sdtfrom:" + this.f448919c + ", imageurl:" + this.f448923g + ", playkey:" + this.f448917a + ", ismute:" + this.f448925i + ", isAutoPlay:" + this.f448920d + ", isAutoPlayNext:" + this.f448921e + ", channelid:" + this.f448924h + ", \n\t\t\t }\n";
    }
}
