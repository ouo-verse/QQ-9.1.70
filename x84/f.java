package x84;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lx84/f;", "Lx84/a;", "Lx84/e;", "adapter", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "avatarImagView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Landroid/widget/ImageView;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends a {

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView avatarImagView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View itemView, ImageView avatarImagView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(avatarImagView, "avatarImagView");
        this.avatarImagView = avatarImagView;
    }

    /* renamed from: l, reason: from getter */
    public final ImageView getAvatarImagView() {
        return this.avatarImagView;
    }

    public void m(e adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        com.tencent.sqshow.zootopia.friendsdressup.a.a("MembersAvatarAdapter", "avatarHolder " + adapter.l0() + " rywidth  " + adapter.o0());
        if (this.itemView.getLayoutParams() == null) {
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(adapter.l0(), -1)));
        } else {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = adapter.l0();
            }
        }
        this.avatarImagView.setId(adapter.getScaleViewId());
    }
}
