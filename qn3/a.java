package qn3;

import android.text.TextUtils;
import com.tencent.now.od.logic.app.multiavchat.consts.MultiAvChatUserType;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @MultiAvChatUserType
    public int f429098a;

    /* renamed from: b, reason: collision with root package name */
    public long f429099b;

    /* renamed from: c, reason: collision with root package name */
    public String f429100c;

    /* renamed from: d, reason: collision with root package name */
    public String f429101d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f429102e;

    /* renamed from: f, reason: collision with root package name */
    public int f429103f;

    /* renamed from: g, reason: collision with root package name */
    public long f429104g;

    /* renamed from: h, reason: collision with root package name */
    public int f429105h;

    /* renamed from: i, reason: collision with root package name */
    public int f429106i;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f429098a == aVar.f429098a && this.f429099b == aVar.f429099b && this.f429102e == aVar.f429102e && this.f429103f == aVar.f429103f && this.f429104g == aVar.f429104g && this.f429105h == aVar.f429105h && TextUtils.equals(this.f429100c, aVar.f429100c) && TextUtils.equals(this.f429101d, aVar.f429101d) && this.f429106i == aVar.f429106i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f429098a), Long.valueOf(this.f429099b), this.f429100c, this.f429101d, Boolean.valueOf(this.f429102e), Integer.valueOf(this.f429103f), Long.valueOf(this.f429104g), Integer.valueOf(this.f429105h), Integer.valueOf(this.f429106i));
    }
}
