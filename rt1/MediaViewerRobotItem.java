package rt1;

import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lrt1/j;", "Lrt1/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "b", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rt1.j, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MediaViewerRobotItem extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final p userInfo;

    @NotNull
    /* renamed from: b, reason: from getter */
    public final p getUserInfo() {
        return this.userInfo;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MediaViewerRobotItem.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.user.model.MediaViewerRobotItem");
        if (Intrinsics.areEqual(this.userInfo, ((MediaViewerRobotItem) other).userInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.userInfo.hashCode() * 31) + getItemId().hashCode();
    }

    @NotNull
    public String toString() {
        return "MediaViewerRobotItem(userInfo=" + this.userInfo + ")";
    }
}
