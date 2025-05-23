package ur3;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f439875a;

    /* renamed from: b, reason: collision with root package name */
    private String f439876b;

    /* renamed from: c, reason: collision with root package name */
    private String f439877c;

    public a(String str, String str2, String str3) {
        this.f439875a = str;
        this.f439876b = str2;
        this.f439877c = str3;
    }

    public void a() {
        if (TextUtils.isEmpty(this.f439875a)) {
            this.f439875a = "";
        }
        if (TextUtils.isEmpty(this.f439876b)) {
            this.f439876b = "";
        }
        if (TextUtils.isEmpty(this.f439877c)) {
            this.f439877c = "";
        }
    }

    public String b() {
        return this.f439875a;
    }

    public String c() {
        return this.f439876b;
    }

    public String d() {
        return this.f439877c;
    }
}
