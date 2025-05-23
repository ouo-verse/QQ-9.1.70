package wi1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 /2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u000201B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\t\u001a\u00020\u0003*\u00020\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\f\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001c\u0010\u001a\u001a\u00020\u00032\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eJ\u0014\u0010!\u001a\u00020\u00032\n\u0010\u0019\u001a\u00060\u0002R\u00020\u0000H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lwi1/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lwi1/c$b;", "", "u0", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "l0", "w0", "Landroid/view/View;", "n0", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState$a;", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "k0", "o0", "Landroid/widget/FrameLayout$LayoutParams;", "m0", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "s0", "holder", "r0", "getItemCount", "show", "hide", "", ViewStickEventHelper.IS_SHOW, "p0", "t0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "mContainer", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "quiEmptyState", "D", "quiNetErrorState", "E", "Z", "lastVisibleStatus", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState quiEmptyState;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState quiNetErrorState;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean lastVisibleStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lwi1/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lwi1/c;Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class b extends RecyclerView.ViewHolder {
        final /* synthetic */ c E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c cVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = cVar;
        }
    }

    private final GuildQUIEmptyState k0(GuildQUIEmptyState.a aVar) {
        GuildQUIEmptyState a16 = aVar.n(true).o(0).a();
        QUIButton qUIButton = (QUIButton) a16.findViewById(R.id.uuk);
        if (qUIButton != null) {
            Intrinsics.checkNotNullExpressionValue(qUIButton, "findViewById<QUIButton?>\u2026d.empty_state_medium_btn)");
            ViewGroup.LayoutParams layoutParams = qUIButton.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = qUIButton.getResources().getDimensionPixelSize(R.dimen.c_0);
            }
            ViewGroup.LayoutParams layoutParams2 = qUIButton.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = qUIButton.getResources().getDimensionPixelSize(R.dimen.c_c);
            }
            qUIButton.setTextSize(17.0f);
        }
        return a16;
    }

    private final FrameLayout l0(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams m06 = m0();
        m06.height = 0;
        frameLayout.setLayoutParams(m06);
        frameLayout.setPadding(frameLayout.getResources().getDimensionPixelSize(R.dimen.f158700mp), 0, frameLayout.getResources().getDimensionPixelSize(R.dimen.f158700mp), 0);
        w0(frameLayout);
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    private final FrameLayout.LayoutParams m0() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        return layoutParams;
    }

    private final View n0() {
        Context context;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("GuildFeedBatchEmptyAdapter", 1, "getTipView = " + this.quiNetErrorState);
            return this.quiNetErrorState;
        }
        GuildQUIEmptyState guildQUIEmptyState = this.quiEmptyState;
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout != null) {
            context = frameLayout.getContext();
        } else {
            context = null;
        }
        QLog.d("GuildFeedBatchEmptyAdapter", 1, "getTipView = " + guildQUIEmptyState + ", mContainer = " + frameLayout + ", context = " + context);
        return this.quiEmptyState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lastVisibleStatus = z16;
        FrameLayout frameLayout = this$0.mContainer;
        if (frameLayout != null) {
            this$0.w0(frameLayout);
        }
    }

    private final void u0() {
        GuildQUIEmptyState guildQUIEmptyState;
        Context context;
        Context context2;
        FrameLayout frameLayout = this.mContainer;
        GuildQUIEmptyState guildQUIEmptyState2 = null;
        if (frameLayout != null && (context2 = frameLayout.getContext()) != null) {
            GuildQUIEmptyState.a q16 = new GuildQUIEmptyState.a(context2).s(7).u("\u7f51\u7edc\u5f02\u5e38").q("\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u540e\u91cd\u8bd5");
            String qqStr = HardCodeUtil.qqStr(R.string.zxy);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.feed_retry)");
            guildQUIEmptyState = k0(q16.p(qqStr, new View.OnClickListener() { // from class: wi1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.v0(c.this, view);
                }
            }));
        } else {
            guildQUIEmptyState = null;
        }
        this.quiNetErrorState = guildQUIEmptyState;
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null && (context = frameLayout2.getContext()) != null) {
            guildQUIEmptyState2 = k0(new GuildQUIEmptyState.a(context).s(3).u("\u6682\u65e0\u5e16\u5b50"));
        }
        this.quiEmptyState = guildQUIEmptyState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w0(FrameLayout frameLayout) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null) {
            layoutParams = frameLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = m0();
        }
        if (this.lastVisibleStatus) {
            frameLayout.setVisibility(0);
            layoutParams.height = -1;
            frameLayout.removeAllViews();
            View n06 = n0();
            if (n06 != null) {
                frameLayout.addView(n06);
                return;
            }
            return;
        }
        frameLayout.setVisibility(8);
        layoutParams.height = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 11;
    }

    public final void hide() {
        p0(false);
    }

    public final void p0(final boolean isShow) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: wi1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.q0(c.this, isShow);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.d("GuildFeedBatchEmptyAdapter", 1, "onBindViewHolder, old = " + this.mContainer + ", new = " + holder.itemView);
        View view = holder.itemView;
        if (view instanceof FrameLayout) {
            frameLayout = (FrameLayout) view;
        } else {
            frameLayout = null;
        }
        this.mContainer = frameLayout;
        u0();
        FrameLayout frameLayout2 = this.mContainer;
        if (frameLayout2 != null) {
            w0(frameLayout2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.mContainer = l0(context);
        u0();
        FrameLayout frameLayout = this.mContainer;
        Intrinsics.checkNotNull(frameLayout);
        return new b(this, frameLayout);
    }

    public final void show() {
        p0(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull b holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        this.mContainer = null;
    }

    private final void o0() {
    }
}
