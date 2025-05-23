package vg2;

import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public byte[] f441606b;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.mobileqq.qqexpand.bean.chat.a f441615k;

    /* renamed from: a, reason: collision with root package name */
    public String f441605a = "";

    /* renamed from: c, reason: collision with root package name */
    public String f441607c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f441608d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f441609e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f441610f = 30;

    /* renamed from: g, reason: collision with root package name */
    public String f441611g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f441612h = "0";

    /* renamed from: i, reason: collision with root package name */
    public int f441613i = 1;

    /* renamed from: j, reason: collision with root package name */
    public String f441614j = "";

    public void a() {
        this.f441605a = "";
        this.f441606b = Utils.E("");
        this.f441607c = "";
        this.f441608d = "";
        this.f441609e = -1L;
        this.f441610f = -1;
        this.f441612h = "0";
        this.f441613i = 0;
        this.f441614j = "";
        this.f441615k = null;
    }

    public d b() {
        d dVar = new d();
        dVar.f441605a = this.f441605a;
        dVar.f441606b = (byte[]) this.f441606b.clone();
        dVar.f441607c = this.f441607c;
        dVar.f441608d = this.f441608d;
        dVar.f441609e = this.f441609e;
        dVar.f441610f = this.f441610f;
        dVar.f441612h = this.f441612h;
        return dVar;
    }

    public boolean c() {
        String e16 = Utils.e(this.f441606b);
        if (!TextUtils.isEmpty(this.f441607c) && !TextUtils.isEmpty(this.f441607c) && !TextUtils.isEmpty(e16)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f441605a) || TextUtils.isEmpty(this.f441607c) || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f441605a.equals(dVar.f441605a) || !this.f441607c.equals(dVar.f441607c) || this.f441609e != dVar.f441609e) {
            return false;
        }
        return true;
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{uin: ");
        sb5.append(this.f441605a);
        sb5.append("}");
        String e16 = Utils.e(this.f441606b);
        if (e16 != null) {
            i3 = e16.length();
        } else {
            i3 = 0;
        }
        sb5.append("{sig: ");
        sb5.append(i3);
        sb5.append("}");
        sb5.append("{matchUin: ");
        sb5.append(this.f441607c);
        sb5.append("}");
        sb5.append("{tipsWording: ");
        sb5.append(this.f441608d);
        sb5.append("}");
        sb5.append("{timeStamp: ");
        sb5.append(this.f441609e);
        sb5.append("}");
        sb5.append("{nickName: ");
        sb5.append(this.f441611g);
        sb5.append("}");
        sb5.append("{algorithmID: ");
        sb5.append(this.f441612h);
        sb5.append("}");
        sb5.append("{tagId: ");
        sb5.append(this.f441613i);
        sb5.append("}");
        sb5.append("{tagName: ");
        sb5.append(this.f441614j);
        sb5.append("}");
        com.tencent.mobileqq.qqexpand.bean.chat.a aVar = this.f441615k;
        if (aVar != null) {
            sb5.append(aVar.toString());
        }
        return sb5.toString();
    }
}
