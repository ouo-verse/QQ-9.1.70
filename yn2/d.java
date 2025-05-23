package yn2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sn2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lyn2/d;", "Lsn2/g;", "", "o", "Landroid/widget/ImageView;", "f", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mSenderTitleView", "G", "mSenderSubTitleView", "H", "mSenderSeparatorView", "I", "mSecondTitleView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "layoutId", "<init>", "(Landroid/view/ViewGroup;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends g {

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mSenderTitleView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mSenderSubTitleView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mSenderSeparatorView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mSecondTitleView;

    public d(@Nullable ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        o();
    }

    private final void o() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        View findViewById = this.f433999d.findViewById(R.id.f166851io2);
        TextView textView4 = null;
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        this.mSenderTitleView = textView;
        View findViewById2 = this.f433999d.findViewById(R.id.f166850io1);
        if (findViewById2 instanceof TextView) {
            textView2 = (TextView) findViewById2;
        } else {
            textView2 = null;
        }
        this.mSenderSubTitleView = textView2;
        View findViewById3 = this.f433999d.findViewById(R.id.f166849io0);
        if (findViewById3 instanceof TextView) {
            textView3 = (TextView) findViewById3;
        } else {
            textView3 = null;
        }
        this.mSenderSeparatorView = textView3;
        View findViewById4 = this.f433999d.findViewById(R.id.il9);
        if (findViewById4 instanceof TextView) {
            textView4 = (TextView) findViewById4;
        }
        this.mSecondTitleView = textView4;
        if (aq.a()) {
            this.f433999d.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    @Override // sn2.g, sn2.a
    @NotNull
    public ImageView f() {
        ImageView f16 = super.f();
        Intrinsics.checkNotNullExpressionValue(f16, "super.getFaceImageView()");
        return f16;
    }
}
