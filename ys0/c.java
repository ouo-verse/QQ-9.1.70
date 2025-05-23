package ys0;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.guild.aio.chosen.title.g;
import com.tencent.guild.aio.title.GuildAioTitleBackBtnUIState;
import com.tencent.guild.aio.title.GuildAioTitleTextUIState;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guildmedia.aio.excellentdetail.title.AnnounceDetailMoreIconVisible;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lys0/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", "h1", "f1", "", "selectState", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lys0/d;", "d1", "bindViewAndData", "state", "g1", "La22/a;", "d", "La22/a;", "mBinding", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a22.a mBinding;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451118a;

        static {
            int[] iArr = new int[IGuildAioTitleUIState.TYPE.values().length];
            try {
                iArr[IGuildAioTitleUIState.TYPE.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.BACKBTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IGuildAioTitleUIState.TYPE.EMPTY_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f451118a = iArr;
        }
    }

    private final void e1(boolean selectState) {
        if (!selectState) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) mContext).onBackPressed();
        }
    }

    private final void f1() {
        sendIntent(new g.a());
    }

    private final void h1() {
        sendIntent(new g.b());
        a22.a aVar = this.mBinding;
        a22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f25364d.setOnClickListener(new View.OnClickListener() { // from class: ys0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i1(c.this, view);
            }
        });
        a22.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f25363c.setOnClickListener(new View.OnClickListener() { // from class: ys0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.j1(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new c.l());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public d createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull IGuildAioTitleUIState state) {
        c cVar;
        Intrinsics.checkNotNullParameter(state, "state");
        a22.a aVar = null;
        if (!state.getResult()) {
            cVar = this;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            return;
        }
        int i3 = a.f451118a[state.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    AnnounceDetailMoreIconVisible announceDetailMoreIconVisible = (AnnounceDetailMoreIconVisible) state;
                    a22.a aVar2 = this.mBinding;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        aVar = aVar2;
                    }
                    vs0.a.p(aVar.f25363c, announceDetailMoreIconVisible.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
                    return;
                }
                return;
            }
            e1(((GuildAioTitleBackBtnUIState) state).getMultistate());
            return;
        }
        GuildAioTitleTextUIState guildAioTitleTextUIState = (GuildAioTitleTextUIState) state;
        a22.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar3;
        }
        aVar.f25365e.setText(guildAioTitleTextUIState.getName());
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        a22.a g16 = a22.a.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        this.mBinding = g16;
        a22.a aVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        g16.f25363c.setImageTintList(null);
        a22.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar2;
        }
        LinearLayout root = aVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }
}
