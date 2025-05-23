package yi3;

import android.net.Uri;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\u00a8\u0006!"}, d2 = {"Lyi3/a;", "Lyi3/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "b", "()J", "id", "I", "d", "()I", "showExpire", "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "text", "e", "type", "Landroid/net/Uri;", "Landroid/net/Uri;", "()Landroid/net/Uri;", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(JILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanInformationBubbleInfo extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int showExpire;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri jumpUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanInformationBubbleInfo(long j3, int i3, @NotNull String text) {
        super(null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = j3;
        this.showExpire = i3;
        this.text = text;
        this.type = -1;
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
        if (!(other instanceof ZPlanInformationBubbleInfo)) {
            return false;
        }
        ZPlanInformationBubbleInfo zPlanInformationBubbleInfo = (ZPlanInformationBubbleInfo) other;
        if (getId() == zPlanInformationBubbleInfo.getId() && getShowExpire() == zPlanInformationBubbleInfo.getShowExpire() && Intrinsics.areEqual(this.text, zPlanInformationBubbleInfo.text)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(getId()) * 31) + getShowExpire()) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "ZPlanInformationBubbleInfo(id=" + getId() + ", showExpire=" + getShowExpire() + ", text=" + this.text + ')';
    }
}
