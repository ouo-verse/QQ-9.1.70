package yc3;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B'\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lyc3/a;", "T", "Lqa4/b;", "Lyc3/b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mData", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a<T> extends qa4.b<T, b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, ArrayList<T> mData) {
        super(context, mData);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mData, "mData");
    }

    @Override // qa4.c
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public b u(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ZootopiaPlayerView zootopiaPlayerView = new ZootopiaPlayerView(parent.getContext(), null, 0, 6, null);
        zootopiaPlayerView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        zootopiaPlayerView.setBackgroundRadius(ViewUtils.dpToPx(16.0f));
        return new b(zootopiaPlayerView);
    }
}
