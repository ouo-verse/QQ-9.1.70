package vg1;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lvg1/a;", "Lcom/tencent/mobileqq/guild/contentshare/e;", "", "getBackgroundColor", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "", "a", "Lcom/tencent/mobileqq/guild/contentshare/f;", "Lcom/tencent/mobileqq/guild/contentshare/f;", "layoutListener", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/f;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.mobileqq.guild.contentshare.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.contentshare.f layoutListener;

    public a(@NotNull com.tencent.mobileqq.guild.contentshare.f layoutListener) {
        Intrinsics.checkNotNullParameter(layoutListener, "layoutListener");
        this.layoutListener = layoutListener;
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull com.tencent.mobileqq.guild.contentshare.d shareData, @Nullable h style) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        parent.setBackground(new ColorDrawable(-1));
        this.layoutListener.a();
    }

    @Override // com.tencent.mobileqq.guild.contentshare.e
    public int getBackgroundColor() {
        return -1;
    }
}
