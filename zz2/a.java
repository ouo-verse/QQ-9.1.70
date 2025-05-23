package zz2;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.avatar.IVasAvatarView;
import com.tencent.mobileqq.vas.avatar.NtVasAvatarView;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nw3.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lzz2/a;", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lnw3/a;", "view", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends com.tencent.qqnt.chats.inject.avatar.a {
    @Override // com.tencent.qqnt.chats.inject.avatar.a
    public void a(@NotNull g item, @NotNull nw3.a view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z16 = view instanceof c;
        if (z16) {
            Drawable drawable = null;
            if (SimpleUIUtil.isNowSimpleMode()) {
                ((c) view).getPendantView().setImageDrawable(null);
                return;
            }
            if (item.y().n()) {
                c cVar = (c) view;
                ImageView pendantView = cVar.getPendantView();
                Function1<Integer, Drawable> c16 = item.y().c();
                if (c16 != null) {
                    drawable = c16.invoke(Integer.valueOf(item.y().b()));
                }
                pendantView.setImageDrawable(drawable);
                cVar.getPendantView().setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                ((c) view).getPendantView().setImageDrawable(null);
            }
        }
        if (z16) {
            view = ((c) view).c();
        }
        if (!(view instanceof NtVasAvatarView)) {
            return;
        }
        IVasAvatarView.DefaultImpls.startLoadAvatar$default((IVasAvatarView) view, String.valueOf(item.l()), 0, 0, 0, 12, null);
    }
}
