package tq0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.os.BundleKt;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.guild.aio.reserve2.busi.network.GuildNetworkMsgVB;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tq0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u00010\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016\u00a8\u0006\u0015"}, d2 = {"Ltq0/e;", "Lcom/tencent/aio/base/mvvm/a;", "Ltq0/c;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Lcom/tencent/aio/base/mvvm/b;", "c1", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e extends com.tencent.aio.base.mvvm.a<c, TopTipViewState> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(e this$0, View view, View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new c.a(view.getHeight()));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, TopTipViewState> createVM() {
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @NotNull
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof b) {
            return BundleKt.bundleOf(TuplesKt.to("height", Integer.valueOf(getHostView().getHeight())));
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new GuildNetworkMsgVB(), new com.tencent.guild.aio.reserve2.busi.chosen.d()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        final View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.ef_, createViewParams.b(), false);
        inflate.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: tq0.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                e.d1(e.this, inflate, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026)\n            }\n        }");
        return inflate;
    }
}
