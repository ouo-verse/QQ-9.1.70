package zi1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#\u00a8\u0006'"}, d2 = {"Lzi1/a;", "Landroidx/viewbinding/ViewBinding;", "", "state", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "f", "", "k", "l", "i", "j", "Landroid/view/View;", "", "isVisible", "e", "getRoot", "g", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "b", "Landroid/widget/FrameLayout;", "frameRoot", "Landroidx/recyclerview/widget/RecyclerView;", "<set-?>", "c", "Landroidx/recyclerview/widget/RecyclerView;", h.F, "()Landroidx/recyclerview/widget/RecyclerView;", "feedRecyclerView", "d", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "quiEmptyState", "Landroid/view/View;", "loadingView", "<init>", "(Landroid/content/Context;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements ViewBinding {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final C11683a f452586f = new C11683a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout frameRoot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView feedRecyclerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState quiEmptyState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lzi1/a$a;", "", "", "ANIMATION_DURATION", "J", "", "EMPTY_SEARCH_RESULT_TIPS", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zi1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C11683a {
        public /* synthetic */ C11683a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        C11683a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"zi1/a$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f452592d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f452593e;

        b(View view, boolean z16) {
            this.f452592d = view;
            this.f452593e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            int i3;
            View view = this.f452592d;
            if (this.f452593e) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final void e(View view, boolean z16) {
        boolean z17;
        float f16;
        if (view.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 == z16 && Intrinsics.areEqual(view.getTag(), Boolean.valueOf(z16))) {
            return;
        }
        view.animate().cancel();
        view.setTag(Boolean.valueOf(z16));
        view.setVisibility(0);
        ViewPropertyAnimator animate = view.animate();
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        animate.alpha(f16).setDuration(150L).setListener(new b(view, z16)).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    private final GuildQUIEmptyState f(int state) {
        GuildQUIEmptyState guildQUIEmptyState = this.quiEmptyState;
        if (guildQUIEmptyState != null) {
            if (state != 1) {
                if (state == 3) {
                    guildQUIEmptyState.setTitle("\u7f51\u7edc\u5df2\u65ad\u5f00\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    guildQUIEmptyState.setImageView(7);
                    return guildQUIEmptyState;
                }
                return guildQUIEmptyState;
            }
            guildQUIEmptyState.setTitle("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7ed3\u679c");
            guildQUIEmptyState.setImageView(9);
            return guildQUIEmptyState;
        }
        return null;
    }

    private final void i() {
        if (this.frameRoot == null) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.frameRoot = frameLayout;
        }
    }

    private final void j() {
        if (this.loadingView != null) {
            return;
        }
        ScanningLightView scanningLightView = new ScanningLightView(this.context, null, 2, null);
        scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
        scanningLightView.setImageResource(R.drawable.guild_feed_square_load_arc);
        scanningLightView.setVisibility(8);
        scanningLightView.setAlpha(0.0f);
        scanningLightView.setScaleType(ImageView.ScaleType.FIT_START);
        FrameLayout frameLayout = this.frameRoot;
        if (frameLayout != null) {
            frameLayout.addView(scanningLightView, new FrameLayout.LayoutParams(-1, -1));
        }
        this.loadingView = scanningLightView;
    }

    private final void k() {
        ViewParent viewParent;
        GuildQUIEmptyState guildQUIEmptyState = this.quiEmptyState;
        if (guildQUIEmptyState != null) {
            viewParent = guildQUIEmptyState.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            return;
        }
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(this.context).u("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7ed3\u679c").s(9).r(false).a();
        a16.setVisibility(8);
        a16.setAlpha(0.0f);
        FrameLayout frameLayout = this.frameRoot;
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(a16, layoutParams);
        }
        this.quiEmptyState = a16;
    }

    private final void l() {
        ViewParent viewParent;
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView != null) {
            viewParent = recyclerView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            return;
        }
        RecyclerView recyclerView2 = new RecyclerView(this.context);
        recyclerView2.setHasFixedSize(true);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(recyclerView2.getContext());
        safeLinearLayoutManager.setOrientation(1);
        recyclerView2.setLayoutManager(safeLinearLayoutManager);
        recyclerView2.setItemAnimator(null);
        recyclerView2.setOverScrollMode(2);
        recyclerView2.setVisibility(8);
        recyclerView2.setAlpha(0.0f);
        FrameLayout frameLayout = this.frameRoot;
        if (frameLayout != null) {
            frameLayout.addView(recyclerView2, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        this.feedRecyclerView = recyclerView2;
    }

    public final void g(int state) {
        boolean z16;
        boolean z17;
        i();
        boolean z18 = false;
        if (state == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            l();
        }
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView != null) {
            e(recyclerView, z16);
        }
        if (state != 1 && state != 3) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            k();
        }
        f(state);
        GuildQUIEmptyState guildQUIEmptyState = this.quiEmptyState;
        if (guildQUIEmptyState != null) {
            e(guildQUIEmptyState, z17);
        }
        if (state == 2) {
            z18 = true;
        }
        if (z18) {
            j();
        }
        View view = this.loadingView;
        if (view != null) {
            e(view, z18);
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        i();
        FrameLayout frameLayout = this.frameRoot;
        Intrinsics.checkNotNull(frameLayout);
        return frameLayout;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final RecyclerView getFeedRecyclerView() {
        return this.feedRecyclerView;
    }
}
