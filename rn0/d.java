package rn0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lrn0/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "h1", "", "count", "e1", "", "isSelectMode", "f1", "Lcom/tencent/mvi/api/help/a;", "params", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "d1", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "state", "g1", "Lvn0/d;", "d", "Lvn0/d;", "mBinding", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.a<fo0.e, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private vn0.d mBinding;

    private final void e1(int count) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        vn0.d dVar = null;
        if (count > 0) {
            vn0.d dVar2 = this.mBinding;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                dVar = dVar2;
            }
            TextView textView = dVar.f441930d;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = mobileQQ.getString(R.string.f142400j_);
            Intrinsics.checkNotNullExpressionValue(string, "app.getString(R.string.g\u2026sen_aio_select_msg_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            return;
        }
        vn0.d dVar3 = this.mBinding;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dVar = dVar3;
        }
        dVar.f441930d.setText(mobileQQ.getString(R.string.f1648626z));
    }

    private final void f1(boolean isSelectMode) {
        vn0.d dVar = null;
        if (isSelectMode) {
            vn0.d dVar2 = this.mBinding;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                dVar = dVar2;
            }
            dVar.f441929c.setVisibility(0);
            return;
        }
        vn0.d dVar3 = this.mBinding;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            dVar = dVar3;
        }
        dVar.f441929c.setVisibility(8);
    }

    private final void h1() {
        vn0.d dVar = this.mBinding;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            dVar = null;
        }
        dVar.f441930d.setOnClickListener(new View.OnClickListener() { // from class: rn0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.i1(d.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(FrameLayout rootView, d this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (rootView.getVisibility() == 0) {
            i3 = rootView.getHeight();
        } else {
            i3 = 0;
        }
        this$0.sendIntent(new a.InputBarHeightChangeIntent(i3));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> createVM() {
        return new h();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) {
            f1(((GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) state).getMode());
        } else if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) {
            e1(((GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) state).getCount());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioDefaultInputUIState>> getObserverStates() {
        List<Class<? extends GuildAioDefaultInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAioDefaultInputUIState.GuildMultiSelectModeChanged.class, GuildAioDefaultInputUIState.GuildMultiSelectCountChanged.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        vn0.d g16 = vn0.d.g(LayoutInflater.from(params.a()), params.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, params.parent, false)");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        final FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: rn0.c
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                d.j1(root, this);
            }
        });
        return root;
    }
}
