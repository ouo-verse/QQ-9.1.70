package uq3;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    private static volatile k f439810c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile k f439811d;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f439812a;

    /* renamed from: b, reason: collision with root package name */
    private final c f439813b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a implements c {
        @Override // uq3.k.c
        public String getKey(String str) {
            return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        String getKey(String str);
    }

    k(MMKVOptionEntity mMKVOptionEntity, c cVar) {
        this.f439812a = mMKVOptionEntity;
        this.f439813b = cVar;
    }

    public static k a() {
        if (f439811d == null) {
            synchronized (k.class) {
                if (f439811d == null) {
                    f439811d = new k(QMMKV.from(RFWApplication.getApplication(), "QCIRCLE_MMKV_COMMON"), new a());
                }
            }
        }
        return f439811d;
    }

    public static k b() {
        if (f439810c == null) {
            synchronized (k.class) {
                if (f439810c == null) {
                    f439810c = new k(QMMKV.from(RFWApplication.getApplication(), "QCIRCLE_MMKV_COMMON"), new b());
                }
            }
        }
        return f439810c;
    }

    public boolean c(String str, boolean z16) {
        return this.f439812a.decodeBool(this.f439813b.getKey(str), z16);
    }

    public byte[] d(String str, byte[] bArr) {
        return this.f439812a.decodeBytes(this.f439813b.getKey(str), bArr);
    }

    public int e(String str, int i3) {
        return this.f439812a.decodeInt(this.f439813b.getKey(str), i3);
    }

    public long f(String str, long j3) {
        return this.f439812a.decodeLong(this.f439813b.getKey(str), j3);
    }

    public <T extends Parcelable> T g(String str, Class<T> cls, T t16) {
        return (T) this.f439812a.decodeParcelable(this.f439813b.getKey(str), cls, t16);
    }

    public String h(String str, @Nullable String str2) {
        return this.f439812a.decodeString(this.f439813b.getKey(str), str2);
    }

    public Set<String> i(String str, @Nullable Set<String> set) {
        return this.f439812a.decodeStringSet(this.f439813b.getKey(str), set);
    }

    public k j(String str, boolean z16) {
        this.f439812a.encodeBool(this.f439813b.getKey(str), z16);
        return this;
    }

    public k k(String str, byte[] bArr) {
        this.f439812a.encodeBytes(this.f439813b.getKey(str), bArr);
        return this;
    }

    public k l(String str, float f16) {
        this.f439812a.encodeFloat(this.f439813b.getKey(str), f16);
        return this;
    }

    public k m(String str, int i3) {
        this.f439812a.encodeInt(this.f439813b.getKey(str), i3);
        return this;
    }

    public k n(String str, long j3) {
        this.f439812a.encodeLong(this.f439813b.getKey(str), j3);
        return this;
    }

    public k o(String str, Parcelable parcelable) {
        this.f439812a.encodeParcelable(this.f439813b.getKey(str), parcelable);
        return this;
    }

    public k p(String str, @Nullable String str2) {
        this.f439812a.encodeString(this.f439813b.getKey(str), str2);
        return this;
    }

    public k q(String str, @Nullable Set<String> set) {
        this.f439812a.encodeStringSet(this.f439813b.getKey(str), set);
        return this;
    }

    public k r(String str) {
        this.f439812a.removeKey(this.f439813b.getKey(str));
        return this;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b implements c {
        @Override // uq3.k.c
        public String getKey(String str) {
            return str;
        }
    }
}
