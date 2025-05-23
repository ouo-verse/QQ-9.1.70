package zs0;

import android.view.View;
import com.tencent.guild.aio.component.emoji.GuildAioEmojiUIState;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tn0.a;
import tn0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lzs0/b;", "Lcom/tencent/aio/base/mvvm/a;", "Ltn0/a;", "Lcom/tencent/guild/aio/component/emoji/GuildAioEmojiUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "", "bindViewAndData", "state", "d1", "d", "Landroid/view/View;", "mEmojiView", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.a<tn0.a, GuildAioEmojiUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mEmojiView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.C11301a());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        View view = this.mEmojiView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            view = null;
        }
        view.setSelected(false);
        View view2 = this.mEmojiView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            view2 = null;
        }
        vs0.a.o(view2, "em_aio_expression", null, 4, null);
        View view3 = this.mEmojiView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            view3 = null;
        }
        vs0.a.m("imp", view3, null, 4, null);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<tn0.a, GuildAioEmojiUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioEmojiUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        View view = this.mEmojiView;
        if (view == null) {
            return;
        }
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            view = null;
        }
        view.setSelected(state.getEmoPanelShowing());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View findViewById = createViewParams.b().findViewById(R.id.vxa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "createViewParams.parent.\u2026id.guild_aio_emoji_image)");
        this.mEmojiView = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: zs0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.e1(b.this, view);
            }
        });
        View view = this.mEmojiView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmojiView");
            return null;
        }
        return view;
    }
}
