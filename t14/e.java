package t14;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012\u00a8\u0006%"}, d2 = {"Lt14/e;", "Lt14/a;", "", "g", h.F, "c", "e", "", "i", "j", "toString", "", "b", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "picDayUrl", "getPicDayUrl", "setPicDayUrl", "picNightUrl", "getPicNightUrl", "setPicNightUrl", "picDayUrl9070", "getPicDayUrl9070", "setPicDayUrl9070", "picNightUrl9070", "getPicNightUrl9070", "setPicNightUrl9070", ZPlanPublishSource.FROM_SCHEME, "f", "setScheme", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends a {

    @SerializedName("name")
    @NotNull
    private String name = "";

    @SerializedName("pic_day_url")
    @NotNull
    private String picDayUrl = "";

    @SerializedName("pic_night_url")
    @NotNull
    private String picNightUrl = "";

    @SerializedName("9070_pic_day_url")
    @NotNull
    private String picDayUrl9070 = "";

    @SerializedName("9070_pic_night_url")
    @NotNull
    private String picNightUrl9070 = "";

    @SerializedName(ZPlanPublishSource.FROM_SCHEME)
    @NotNull
    private String scheme = "";

    private final String c() {
        boolean z16;
        String str = this.picDayUrl9070;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.picDayUrl;
        }
        return str;
    }

    private final String e() {
        boolean z16;
        String str = this.picNightUrl9070;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return this.picNightUrl;
        }
        return str;
    }

    /* renamed from: g, reason: from getter */
    private final String getPicDayUrl() {
        return this.picDayUrl;
    }

    /* renamed from: h, reason: from getter */
    private final String getPicNightUrl() {
        return this.picNightUrl;
    }

    @Override // t14.a
    public int b() {
        return 1;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    public boolean i() {
        boolean z16;
        boolean z17;
        if (this.picDayUrl9070.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (this.picDayUrl.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String j() {
        boolean z16 = true;
        if (Build.VERSION.SDK_INT >= 28) {
            if (je0.a.a(BaseApplication.getContext())) {
                if (e().length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    return e();
                }
            }
            return c();
        }
        if (je0.a.a(BaseApplication.getContext())) {
            if (getPicNightUrl().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                return getPicNightUrl();
            }
        }
        return getPicDayUrl();
    }

    @NotNull
    public String toString() {
        return "picDayUrl9070=" + this.picDayUrl9070 + ", picNightUrl9070=" + this.picNightUrl9070 + ", picDayUrl=" + this.picDayUrl + ", picNightUrl=" + this.picNightUrl + ", scheme=" + this.scheme;
    }
}
