package rd0;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public long f431096a;

    /* renamed from: b, reason: collision with root package name */
    public int f431097b;

    /* renamed from: c, reason: collision with root package name */
    public int f431098c;

    /* renamed from: d, reason: collision with root package name */
    public int f431099d;

    /* renamed from: e, reason: collision with root package name */
    public String f431100e;

    /* renamed from: f, reason: collision with root package name */
    public int f431101f;

    /* renamed from: g, reason: collision with root package name */
    public int f431102g;

    /* renamed from: h, reason: collision with root package name */
    public int f431103h;

    /* renamed from: i, reason: collision with root package name */
    public String f431104i;

    /* renamed from: j, reason: collision with root package name */
    public i f431105j;

    /* renamed from: k, reason: collision with root package name */
    public int f431106k;

    public f(int i3, int i16) {
        this.f431097b = i3;
        this.f431101f = R.string.f1635123b;
        this.f431102g = 1;
        this.f431103h = i16;
        switch (i3) {
            case 65793:
                this.f431099d = 1;
                this.f431100e = "Windows";
                this.f431101f = R.string.f1635923j;
                this.f431096a = 1L;
                this.f431098c = 1;
                return;
            case 65799:
            case 67586:
                this.f431104i = "\u624b\u673a";
                this.f431101f = R.string.f1636123l;
                this.f431098c = 7;
                return;
            case Friends.TERM_TYPE_MOBILE_HD /* 65805 */:
            case Friends.TERM_TYPE_ANDROID_PAD /* 68104 */:
                this.f431099d = 4;
                this.f431100e = "Pad";
                this.f431101f = R.string.f1635023a;
                this.f431098c = 2;
                this.f431102g = 2;
                return;
            case 66818:
            case 66831:
                this.f431099d = 2;
                this.f431100e = "Mac";
                this.f431101f = R.string.f1635723h;
                this.f431098c = 1;
                return;
            case Friends.TERM_TYPE_MOBILE_IPAD /* 68361 */:
            case Friends.TERM_TYPE_MOBILE_IPAD_NEW /* 72194 */:
                this.f431099d = 3;
                this.f431100e = "iPad";
                this.f431101f = R.string.f1635423e;
                this.f431098c = 2;
                this.f431102g = 2;
                return;
            case 75023:
                this.f431099d = 5;
                this.f431100e = HardCodeUtil.qqStr(R.string.nue);
                this.f431101f = R.string.f1635523f;
                this.f431098c = 3;
                this.f431102g = 3;
                return;
            case 77313:
                this.f431099d = 6;
                this.f431100e = "Windows";
                this.f431101f = R.string.f1636023k;
                this.f431096a = 1L;
                this.f431098c = 1;
                return;
            case 78082:
            case 78096:
                this.f431099d = 5;
                this.f431100e = HardCodeUtil.qqStr(R.string.nue);
                this.f431101f = R.string.f1636223m;
                this.f431098c = 3;
                this.f431102g = 3;
                return;
            case 81154:
                this.f431099d = 2;
                this.f431100e = "Mac";
                this.f431101f = R.string.f1635823i;
                this.f431098c = 1;
                return;
            case 83714:
                if (i16 == 1029) {
                    this.f431099d = 2;
                    this.f431100e = "Mac";
                    this.f431101f = R.string.f1635723h;
                    this.f431098c = 1;
                    return;
                }
                if (i16 == 1024) {
                    this.f431099d = 1;
                    this.f431100e = "Windows";
                    this.f431101f = R.string.f1635923j;
                    this.f431098c = 1;
                    return;
                }
                if (i16 == 1035) {
                    this.f431099d = 8;
                    this.f431100e = "Harmony";
                    this.f431101f = R.string.f1635323d;
                    this.f431098c = 1;
                    return;
                }
                this.f431099d = 7;
                this.f431100e = "Linux";
                this.f431101f = R.string.f1635623g;
                this.f431098c = 1;
                return;
            case 88322:
                this.f431099d = 9;
                this.f431100e = "Harmony Pad";
                this.f431101f = R.string.f1635223c;
                this.f431098c = 2;
                this.f431102g = 2;
                return;
            default:
                return;
        }
    }

    public String a(Context context) {
        if (context == null) {
            return "";
        }
        return context.getString(this.f431101f);
    }

    public String toString() {
        return "LoginDevItem[" + this.f431097b + "|" + this.f431096a + "|" + this.f431102g + "|" + this.f431105j + this.f431106k + "]";
    }
}
