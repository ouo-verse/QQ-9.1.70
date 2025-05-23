package tn0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.guild.aio.component.emoji.GuildAioEmojiUIState;
import com.tencent.mobileqq.R;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tn0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ltn0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Ltn0/a;", "Lcom/tencent/guild/aio/component/emoji/GuildAioEmojiUIState;", "", "panelShowing", "", "h1", "", "d1", "g1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "bindViewAndData", "state", "e1", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mEmojiLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mEmojiIcon", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildAioEmojiUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mEmojiLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mEmojiIcon;

    private final int d1(boolean panelShowing) {
        if (panelShowing) {
            return R.drawable.qui_guild_emoticon_aio_icon_aio_toolbar_active;
        }
        return R.drawable.qui_emoticon_aio_oversized_icon_aio_toolbar_normal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(c this$0, View view) {
        com.tencent.aio.api.runtime.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        boolean z16 = false;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && com.tencent.guild.aio.util.d.a(aVar)) {
            z16 = true;
        }
        if (!z16) {
            this$0.g1();
            this$0.sendIntent(new a.C11301a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1() {
        HashMap hashMap = new HashMap();
        ImageView imageView = this.mEmojiIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
            imageView = null;
        }
        VideoReport.setElementId(imageView, "em_aio_stickers");
        ImageView imageView3 = this.mEmojiIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
            imageView3 = null;
        }
        VideoReport.setElementExposePolicy(imageView3, ExposurePolicy.REPORT_ALL);
        ImageView imageView4 = this.mEmojiIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
            imageView4 = null;
        }
        VideoReport.setElementClickPolicy(imageView4, ClickPolicy.REPORT_NONE);
        ImageView imageView5 = this.mEmojiIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
        } else {
            imageView2 = imageView5;
        }
        VideoReport.reportEvent("clck", imageView2, hashMap);
    }

    private final void h1(boolean panelShowing) {
        ImageView imageView = this.mEmojiIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
            imageView = null;
        }
        imageView.setBackgroundResource(d1(panelShowing));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        h1(false);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildAioEmojiUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioEmojiUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        h1(state.getEmoPanelShowing());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        View findViewById = params.b().findViewById(R.id.vxc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "params.parent.findViewBy\u2026d.guild_aio_emoji_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mEmojiLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiLayout");
            linearLayout = null;
        }
        View findViewById2 = linearLayout.findViewById(R.id.vxa);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mEmojiLayout.findViewByI\u2026id.guild_aio_emoji_image)");
        ImageView imageView = (ImageView) findViewById2;
        this.mEmojiIcon = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tn0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.f1(c.this, view);
            }
        });
        LinearLayout linearLayout2 = this.mEmojiLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiLayout");
            return null;
        }
        return linearLayout2;
    }
}
