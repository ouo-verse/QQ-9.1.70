package ry0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.icgame.liveroom.impl.room.widget.operatorbartips.DefinitionButtonTipsView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import rv0.ShowControllerUIEvent;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lry0/a;", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lry0/a$a;", "", "Landroid/view/View;", "operationBar", "Landroid/view/ViewGroup;", "b", "targetView", "tipsView", "tipsContainer", "", "arrowMarginRight", "", h.F, "f", "", "tagStr", "c", "", "g", "Lf32/a;", "componentContext", "i", "e", "d", "definition_tag", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ry0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"ry0/a$a$a", "Lcom/tencent/icgame/liveroom/impl/room/widget/operatorbartips/DefinitionButtonTipsView$a;", "", "a", "onHide", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ry0.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C11194a implements DefinitionButtonTipsView.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f32.a f432942a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<DefinitionButtonTipsView> f432943b;

            C11194a(f32.a aVar, Ref.ObjectRef<DefinitionButtonTipsView> objectRef) {
                this.f432942a = aVar;
                this.f432943b = objectRef;
            }

            @Override // com.tencent.icgame.liveroom.impl.room.widget.operatorbartips.DefinitionButtonTipsView.a
            public void a() {
                rt0.a.INSTANCE.k("ICGameUnknown|definition", "showDefinitionTips.onSwitchDefinition", "user show switchDefinition menu, and hide tips");
                this.f432942a.w0(new uv0.b());
                this.f432942a.w0(new ShowControllerUIEvent(false));
                this.f432943b.element.i();
                a.INSTANCE.f(this.f432943b.element);
            }

            @Override // com.tencent.icgame.liveroom.impl.room.widget.operatorbartips.DefinitionButtonTipsView.a
            public void onHide() {
                rt0.a.INSTANCE.k("ICGameUnknown|definition", "showDefinitionTips.onHide", "hide definition tips");
                this.f432943b.element.i();
                a.INSTANCE.f(this.f432943b.element);
                this.f432942a.w0(new ShowControllerUIEvent(false));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ViewGroup b(View operationBar) {
            return null;
        }

        private final View c(ViewGroup tipsContainer, String tagStr) {
            for (int childCount = tipsContainer.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = tipsContainer.getChildAt(childCount);
                Intrinsics.checkNotNullExpressionValue(childAt, "tipsContainer.getChildAt(i)");
                Object tag = childAt.getTag();
                boolean z16 = false;
                if (tag != null && tag.equals(tagStr)) {
                    z16 = true;
                }
                if (z16) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(View tipsView) {
            if (tipsView.getParent() instanceof ViewGroup) {
                ViewParent parent = tipsView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(tipsView);
            }
        }

        private final boolean g(ViewGroup tipsContainer) {
            if (!(tipsContainer.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewParent parent = tipsContainer.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            if (((ViewGroup) parent).findViewById(R.id.f66593b2) == null) {
                return false;
            }
            return true;
        }

        private final void h(View targetView, View tipsView, View tipsContainer, int arrowMarginRight) {
            int e16 = uu0.b.e(targetView);
            int f16 = uu0.b.f(targetView);
            int dpToPx = ViewUtils.dpToPx(6.0f);
            ViewGroup.LayoutParams layoutParams = tipsView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.rightMargin = ((tipsContainer.getWidth() - e16) - (targetView.getWidth() / 2)) - arrowMarginRight;
            layoutParams2.bottomMargin = (tipsContainer.getHeight() - f16) - dpToPx;
            layoutParams2.gravity = 85;
            tipsView.setLayoutParams(layoutParams2);
        }

        public final void d(@NotNull View operationBar) {
            Intrinsics.checkNotNullParameter(operationBar, "operationBar");
            ViewGroup b16 = b(operationBar);
            if (b16 == null) {
                return;
            }
            b16.removeAllViews();
        }

        public final void e(@NotNull View operationBar) {
            View c16;
            Intrinsics.checkNotNullParameter(operationBar, "operationBar");
            ViewGroup b16 = b(operationBar);
            if (b16 == null || (c16 = c(b16, "ICGameUnknown|definition")) == null) {
                return;
            }
            f(c16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, android.view.View, com.tencent.icgame.liveroom.impl.room.widget.operatorbartips.DefinitionButtonTipsView] */
        public final void i(@NotNull f32.a componentContext, @NotNull View operationBar, @NotNull View targetView) {
            Intrinsics.checkNotNullParameter(componentContext, "componentContext");
            Intrinsics.checkNotNullParameter(operationBar, "operationBar");
            Intrinsics.checkNotNullParameter(targetView, "targetView");
            ViewGroup b16 = b(operationBar);
            if (b16 == null) {
                return;
            }
            if (g(b16)) {
                rt0.a.INSTANCE.k("ICGameUnknown|definition", "showDefinitionTips", "quick gift tips show, return");
                return;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Context context = operationBar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "operationBar.context");
            ?? definitionButtonTipsView = new DefinitionButtonTipsView(context);
            objectRef.element = definitionButtonTipsView;
            definitionButtonTipsView.setTag("ICGameUnknown|definition");
            b16.addView((View) objectRef.element);
            T t16 = objectRef.element;
            h(targetView, (View) t16, b16, ((DefinitionButtonTipsView) t16).e());
            ((DefinitionButtonTipsView) objectRef.element).setOnListener(new C11194a(componentContext, objectRef));
            ((DefinitionButtonTipsView) objectRef.element).d();
        }

        Companion() {
        }
    }
}
