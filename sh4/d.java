package sh4;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0018\u0010\b\u001a\u00020\u0007*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a\"\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\n\u001a\u00020\t\u001a\"\u0010\u000f\u001a\u00020\u0007*\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0010"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/LifecycleOwner;", "f", "Lcom/tencent/image/URLImageView;", "Landroidx/lifecycle/LiveData;", "", "liveData", "", "c", "", "radius", "a", "Landroid/widget/TextView;", "", "isHint", "d", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"sh4/d$a", "Lsh4/c;", "", "p0", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends sh4.c<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f433818d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, float f16) {
            super(view);
            this.f433818d = f16;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable String p06) {
            Object m476constructorimpl;
            if (p06 == null) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            float f16 = this.f433818d;
            try {
                Result.Companion companion = Result.INSTANCE;
                gradientDrawable.setColor(Color.parseColor(p06));
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            gradientDrawable.setCornerRadius(f16);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                l.e("SkinEx", Result.m484toStringimpl(m476constructorimpl) + ".exceptionOrNull()");
            }
            View view = get();
            if (view != null) {
                view.setBackground(gradientDrawable);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"sh4/d$b", "Lsh4/c;", "", "p0", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends sh4.c<String> {
        b(URLImageView uRLImageView) {
            super(uRLImageView);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable String p06) {
            URLImageView uRLImageView;
            if (p06 == null) {
                return;
            }
            View view = get();
            if (view instanceof URLImageView) {
                uRLImageView = (URLImageView) view;
            } else {
                uRLImageView = null;
            }
            if (uRLImageView != null) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
                com.tencent.timi.game.utils.b.g(uRLImageView, p06, obtain);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"sh4/d$c", "Lsh4/c;", "", "p0", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends sh4.c<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f433819d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TextView textView, boolean z16) {
            super(textView);
            this.f433819d = z16;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable String p06) {
            Object m476constructorimpl;
            TextView textView;
            TextView textView2;
            if (p06 == null) {
                return;
            }
            boolean z16 = this.f433819d;
            try {
                Result.Companion companion = Result.INSTANCE;
                Unit unit = null;
                if (z16) {
                    View view = get();
                    if (view instanceof TextView) {
                        textView2 = (TextView) view;
                    } else {
                        textView2 = null;
                    }
                    if (textView2 != null) {
                        textView2.setHintTextColor(Color.parseColor(p06));
                        unit = Unit.INSTANCE;
                    }
                } else {
                    View view2 = get();
                    if (view2 instanceof TextView) {
                        textView = (TextView) view2;
                    } else {
                        textView = null;
                    }
                    if (textView != null) {
                        textView.setTextColor(Color.parseColor(p06));
                        unit = Unit.INSTANCE;
                    }
                }
                m476constructorimpl = Result.m476constructorimpl(unit);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                l.e("SkinEx", Result.m484toStringimpl(m476constructorimpl) + ".exceptionOrNull()");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"sh4/d$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sh4.d$d, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class ViewOnAttachStateChangeListenerC11229d implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ sh4.b f433820d;

        ViewOnAttachStateChangeListenerC11229d(sh4.b bVar) {
            this.f433820d = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            this.f433820d.getLifecycleRegistry().setCurrentState(Lifecycle.State.RESUMED);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            this.f433820d.getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        }
    }

    public static final void a(@NotNull View view, @NotNull LiveData<String> liveData, float f16) {
        LiveData liveData2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        LifecycleOwner f17 = f(view);
        Object tag = view.getTag(R.id.ybg);
        if (tag instanceof LiveData) {
            liveData2 = (LiveData) tag;
        } else {
            liveData2 = null;
        }
        if (liveData2 != null) {
            liveData2.removeObservers(f17);
        }
        view.setTag(R.id.ybg, liveData);
        liveData.observe(f17, new a(view, f16));
    }

    public static /* synthetic */ void b(View view, LiveData liveData, float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = 0.0f;
        }
        a(view, liveData, f16);
    }

    public static final void c(@NotNull URLImageView uRLImageView, @NotNull LiveData<String> liveData) {
        LiveData liveData2;
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        LifecycleOwner f16 = f(uRLImageView);
        Object tag = uRLImageView.getTag(R.id.ybi);
        if (tag instanceof LiveData) {
            liveData2 = (LiveData) tag;
        } else {
            liveData2 = null;
        }
        if (liveData2 != null) {
            liveData2.removeObservers(f16);
        }
        uRLImageView.setTag(R.id.ybi, liveData);
        liveData.observe(f16, new b(uRLImageView));
    }

    public static final void d(@NotNull TextView textView, @NotNull LiveData<String> liveData, boolean z16) {
        LiveData liveData2;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        LifecycleOwner f16 = f(textView);
        Object tag = textView.getTag(R.id.ybk);
        if (tag instanceof LiveData) {
            liveData2 = (LiveData) tag;
        } else {
            liveData2 = null;
        }
        if (liveData2 != null) {
            liveData2.removeObservers(f16);
        }
        textView.setTag(R.id.ybk, liveData);
        liveData.observe(f16, new c(textView, z16));
    }

    public static /* synthetic */ void e(TextView textView, LiveData liveData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        d(textView, liveData, z16);
    }

    private static final LifecycleOwner f(View view) {
        Object tag = view.getTag(R.id.ybj);
        if (tag instanceof sh4.b) {
            return (LifecycleOwner) tag;
        }
        sh4.b bVar = new sh4.b();
        view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC11229d(bVar));
        if (view.isAttachedToWindow()) {
            bVar.getLifecycleRegistry().setCurrentState(Lifecycle.State.RESUMED);
        } else if (view.getWindowToken() != null) {
            bVar.getLifecycleRegistry().setCurrentState(Lifecycle.State.RESUMED);
        }
        view.setTag(R.id.ybj, bVar);
        return bVar;
    }
}
