package yi3;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\u00a8\u0006$"}, d2 = {"Lyi3/d;", "Lyi3/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "id", "Landroid/net/Uri;", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", WadlProxyConsts.KEY_JUMP_URL, "I", "d", "()I", "showExpire", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "text", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "f", "()Landroid/graphics/drawable/Drawable;", "icon", "type", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi3.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanStatusBubbleInfo extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri jumpUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int showExpire;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Drawable icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int type;

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
        if (!(other instanceof ZPlanStatusBubbleInfo)) {
            return false;
        }
        ZPlanStatusBubbleInfo zPlanStatusBubbleInfo = (ZPlanStatusBubbleInfo) other;
        if (getId() == zPlanStatusBubbleInfo.getId() && Intrinsics.areEqual(getJumpUrl(), zPlanStatusBubbleInfo.getJumpUrl()) && getShowExpire() == zPlanStatusBubbleInfo.getShowExpire() && Intrinsics.areEqual(this.text, zPlanStatusBubbleInfo.text) && Intrinsics.areEqual(this.icon, zPlanStatusBubbleInfo.icon)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final Drawable getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode;
        int a16 = androidx.fragment.app.a.a(getId()) * 31;
        if (getJumpUrl() == null) {
            hashCode = 0;
        } else {
            hashCode = getJumpUrl().hashCode();
        }
        return ((((((a16 + hashCode) * 31) + getShowExpire()) * 31) + this.text.hashCode()) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanStatusBubbleInfo(id=" + getId() + ", jumpUrl=" + getJumpUrl() + ", showExpire=" + getShowExpire() + ", text=" + this.text + ", icon=" + this.icon + ')';
    }
}
