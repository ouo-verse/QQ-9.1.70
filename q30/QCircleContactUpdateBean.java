package q30;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\t\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lq30/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", "nick", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "schemas", "e", "unReadFeedId", "Z", "()Z", "f", "(Z)V", "enable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: q30.f, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QCircleContactUpdateBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> schemas;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> unReadFeedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enable;

    public QCircleContactUpdateBean(@NotNull String uin, @NotNull String nick, @NotNull List<String> schemas, @NotNull List<String> unReadFeedId, boolean z16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(schemas, "schemas");
        Intrinsics.checkNotNullParameter(unReadFeedId, "unReadFeedId");
        this.uin = uin;
        this.nick = nick;
        this.schemas = schemas;
        this.unReadFeedId = unReadFeedId;
        this.enable = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final List<String> c() {
        return this.schemas;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    public final List<String> e() {
        return this.unReadFeedId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleContactUpdateBean)) {
            return false;
        }
        QCircleContactUpdateBean qCircleContactUpdateBean = (QCircleContactUpdateBean) other;
        if (Intrinsics.areEqual(this.uin, qCircleContactUpdateBean.uin) && Intrinsics.areEqual(this.nick, qCircleContactUpdateBean.nick) && Intrinsics.areEqual(this.schemas, qCircleContactUpdateBean.schemas) && Intrinsics.areEqual(this.unReadFeedId, qCircleContactUpdateBean.unReadFeedId) && this.enable == qCircleContactUpdateBean.enable) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.enable = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.uin.hashCode() * 31) + this.nick.hashCode()) * 31) + this.schemas.hashCode()) * 31) + this.unReadFeedId.hashCode()) * 31;
        boolean z16 = this.enable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "QCircleContactUpdateBean(uin=" + this.uin + ", nick=" + this.nick + ", schemas=" + this.schemas + ", unReadFeedId=" + this.unReadFeedId + ", enable=" + this.enable + ')';
    }
}
