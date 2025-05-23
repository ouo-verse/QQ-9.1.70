package xs3;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.base.mvvm.AIOViewModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001e\u001f B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rH\u0016R\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lxs3/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/base/mvvm/b;", "d1", "d", "Landroid/view/View;", "e1", "()Landroid/view/View;", "parentView", "e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onLayoutChangeListener", "", "f", "I", "lastParentViewHeight", "<init>", "(Landroid/view/View;)V", h.F, "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b extends com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View parentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener onLayoutChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastParentViewHeight;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lxs3/b$a;", "Lol3/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "height", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xs3.b$a, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ChangeHeight implements ol3.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public ChangeHeight(int i3) {
            this.height = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ChangeHeight) && this.height == ((ChangeHeight) other).height) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.height;
        }

        @NotNull
        public String toString() {
            return "ChangeHeight(height=" + this.height + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lxs3/b$c;", "Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "intent", "", "handleIntent", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c extends AIOViewModel<ol3.b, MviUIState> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
        public void handleIntent(@NotNull ol3.b intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent instanceof ChangeHeight) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                ChangeHeight changeHeight = (ChangeHeight) intent;
                String str = "handleIntent height = " + changeHeight.getHeight();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.AIO.ChangeBarHeightVirtualBinder", 1, (String) it.next(), null);
                }
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildInputBarHeightChangEvent(changeHeight.getHeight()));
            }
        }
    }

    public b(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.parentView = parentView;
        this.onLayoutChangeListener = f1();
    }

    private final ViewTreeObserver.OnGlobalLayoutListener f1() {
        return new ViewTreeObserver.OnGlobalLayoutListener() { // from class: xs3.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.g1(b.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.lastParentViewHeight != this$0.parentView.getHeight()) {
            this$0.lastParentViewHeight = this$0.parentView.getHeight();
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "OnGlobalLayoutListener Height=" + this$0.lastParentViewHeight + " " + this$0.getParentView();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.ChangeBarHeightVirtualBinder", 1, (String) it.next(), null);
            }
            this$0.sendIntent(new ChangeHeight(this$0.lastParentViewHeight));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.AIO.ChangeBarHeightVirtualBinder", 2, "bindViewAndData parentView Id = " + System.identityHashCode(getParentView()) + " / " + getParentView());
        }
        this.parentView.getViewTreeObserver().addOnGlobalLayoutListener(this.onLayoutChangeListener);
        sendIntent(new ChangeHeight(this.parentView.getHeight()));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new c();
    }

    @NotNull
    /* renamed from: e1, reason: from getter */
    public final View getParentView() {
        return this.parentView;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "onCreateView parentView Id = " + System.identityHashCode(getParentView()) + " / " + getParentView();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.AIO.ChangeBarHeightVirtualBinder", 1, (String) it.next(), null);
        }
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "onDestroy parentView Id = " + System.identityHashCode(getParentView()) + " / " + getParentView();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.AIO.ChangeBarHeightVirtualBinder", 1, (String) it.next(), null);
        }
        this.parentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onLayoutChangeListener);
    }
}
