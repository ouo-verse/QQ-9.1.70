package yi3;

import android.net.Uri;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020\u001e\u0012\u0006\u0010)\u001a\u00020\u001e\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010'\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010 \u001a\u0004\b&\u0010\"R\u0017\u0010)\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b(\u0010\"R\u001a\u0010*\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\u00a8\u0006-"}, d2 = {"Lyi3/c;", "Lyi3/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "id", "Landroid/net/Uri;", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", WadlProxyConsts.KEY_JUMP_URL, "I", "d", "()I", "showExpire", "Ljava/net/URL;", "Ljava/net/URL;", "g", "()Ljava/net/URL;", "picUrl", "", "e", UserInfo.SEX_FEMALE, h.F, "()F", "width", "f", "height", "i", "xFromRight", "j", "yFromTop", "type", "<init>", "(JLandroid/net/Uri;ILjava/net/URL;FFFF)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi3.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanOperateBubbleInfo extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int showExpire;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final URL picUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float width;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float height;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final float xFromRight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final float yFromTop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanOperateBubbleInfo(long j3, @Nullable Uri uri, int i3, @NotNull URL picUrl, float f16, float f17, float f18, float f19) {
        super(null);
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        this.id = j3;
        this.jumpUrl = uri;
        this.showExpire = i3;
        this.picUrl = picUrl;
        this.width = f16;
        this.height = f17;
        this.xFromRight = f18;
        this.yFromTop = f19;
        this.type = 1;
    }

    @Override // yi3.e
    /* renamed from: b, reason: from getter */
    public long getId() {
        return this.id;
    }

    @Override // yi3.e
    @Nullable
    /* renamed from: c, reason: from getter */
    public Uri getJumpUrl() {
        return this.jumpUrl;
    }

    @Override // yi3.e
    /* renamed from: d, reason: from getter */
    public int getShowExpire() {
        return this.showExpire;
    }

    @Override // yi3.e
    /* renamed from: e, reason: from getter */
    public int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanOperateBubbleInfo)) {
            return false;
        }
        ZPlanOperateBubbleInfo zPlanOperateBubbleInfo = (ZPlanOperateBubbleInfo) other;
        if (getId() == zPlanOperateBubbleInfo.getId() && Intrinsics.areEqual(getJumpUrl(), zPlanOperateBubbleInfo.getJumpUrl()) && getShowExpire() == zPlanOperateBubbleInfo.getShowExpire() && Intrinsics.areEqual(this.picUrl, zPlanOperateBubbleInfo.picUrl) && Float.compare(this.width, zPlanOperateBubbleInfo.width) == 0 && Float.compare(this.height, zPlanOperateBubbleInfo.height) == 0 && Float.compare(this.xFromRight, zPlanOperateBubbleInfo.xFromRight) == 0 && Float.compare(this.yFromTop, zPlanOperateBubbleInfo.yFromTop) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final URL getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: h, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode;
        int a16 = androidx.fragment.app.a.a(getId()) * 31;
        if (getJumpUrl() == null) {
            hashCode = 0;
        } else {
            hashCode = getJumpUrl().hashCode();
        }
        return ((((((((((((a16 + hashCode) * 31) + getShowExpire()) * 31) + this.picUrl.hashCode()) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.xFromRight)) * 31) + Float.floatToIntBits(this.yFromTop);
    }

    /* renamed from: i, reason: from getter */
    public final float getXFromRight() {
        return this.xFromRight;
    }

    /* renamed from: j, reason: from getter */
    public final float getYFromTop() {
        return this.yFromTop;
    }

    @NotNull
    public String toString() {
        return "ZPlanOperateBubbleInfo(id=" + getId() + ", jumpUrl=" + getJumpUrl() + ", showExpire=" + getShowExpire() + ", picUrl=" + this.picUrl + ", width=" + this.width + ", height=" + this.height + ", xFromRight=" + this.xFromRight + ", yFromTop=" + this.yFromTop + ')';
    }
}
