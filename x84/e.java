package x84;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.friendsdressup.widget.AvatarContainerLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zb3.FriendsDressUpData;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u001b\b\u0000\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b:\u0010;J\u0006\u0010\u0003\u001a\u00020\u0000J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\nJ\u0014\u0010\u0017\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0017\u00105\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0011\u00107\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b6\u00104R\u0011\u00109\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b8\u00104\u00a8\u0006>"}, d2 = {"Lx84/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "k0", "Lx84/g;", "listener", "", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemViewType", "getItemCount", "", "Lzb3/a;", "fiendZPlanInfoList", "s0", "m0", "j0", "", "show", "p0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lx84/g;", "", "D", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "E", "Z", "isLoadingMore", "()Z", "setLoadingMore", "(Z)V", UserInfo.SEX_FEMALE, "I", "n0", "()I", "scaleViewId", "o0", "screenWidth", "l0", "avatarFrameWidth", "<init>", "(Landroid/content/Context;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final a G = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    private g listener;

    /* renamed from: D, reason: from kotlin metadata */
    private List<FriendsDressUpData> data;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: F, reason: from kotlin metadata */
    private final int scaleViewId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lx84/e$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_AVATAR", "I", "TYPE_EMPTY", "TYPE_FOOTER", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = new ArrayList();
        this.scaleViewId = View.generateViewId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(e this$0, int i3, FriendsDressUpData memberBean, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberBean, "$memberBean");
        g gVar = this$0.listener;
        if (gVar != null) {
            gVar.a(i3, memberBean);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size() + 2;
    }

    public final void j0(List<FriendsDressUpData> fiendZPlanInfoList) {
        Intrinsics.checkNotNullParameter(fiendZPlanInfoList, "fiendZPlanInfoList");
        this.data.addAll(fiendZPlanInfoList);
        notifyItemRangeInserted(getItemCount() - 1, fiendZPlanInfoList.size());
    }

    public final e k0() {
        e eVar = new e(this.context);
        eVar.listener = this.listener;
        eVar.data = this.data;
        eVar.isLoadingMore = this.isLoadingMore;
        return eVar;
    }

    public final int l0() {
        return o0() / 4;
    }

    /* renamed from: n0, reason: from getter */
    public final int getScaleViewId() {
        return this.scaleViewId;
    }

    public final int o0() {
        return this.context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        f fVar = holder instanceof f ? (f) holder : null;
        if (fVar != null) {
            fVar.m(this);
            ImageView avatarImagView = fVar.getAvatarImagView();
            if (avatarImagView != null) {
                avatarImagView.setScaleX(1.0f);
                avatarImagView.setScaleY(1.0f);
                final FriendsDressUpData friendsDressUpData = this.data.get(position - 1);
                y84.a.a(avatarImagView, String.valueOf(friendsDressUpData.getUin()));
                holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: x84.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.q0(e.this, position, friendsDressUpData, view);
                    }
                });
            }
        }
        com.tencent.sqshow.zootopia.friendsdressup.a.b("MembersAvatarAdapter", "holder  " + holder + "  position " + position + " ");
        c cVar = holder instanceof c ? (c) holder : null;
        if (cVar != null) {
            cVar.m(this);
            cVar.l(this.isLoadingMore);
        }
        b bVar = holder instanceof b ? (b) holder : null;
        if (bVar != null) {
            bVar.l(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            ImageView imageView = new ImageView(this.context);
            AvatarContainerLayout avatarContainerLayout = new AvatarContainerLayout(this.context, null, 0, 6, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            avatarContainerLayout.addView(imageView, layoutParams);
            return new f(avatarContainerLayout, imageView);
        }
        if (viewType == 3) {
            FrameLayout frameLayout = new FrameLayout(parent.getContext());
            ImageView imageView2 = new ImageView(parent.getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(30.0f), ViewUtils.dpToPx(30.0f));
            layoutParams2.leftMargin = ViewUtils.dpToPx(30.0f);
            layoutParams2.gravity = 16;
            imageView2.setLayoutParams(layoutParams2);
            imageView2.setImageResource(R.drawable.i36);
            frameLayout.addView(imageView2);
            return new c(frameLayout, imageView2);
        }
        return new b(new FrameLayout(parent.getContext()));
    }

    public final void p0(boolean show) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("MembersAvatarAdapter", "notifyLoadingMore " + show + " " + (getItemCount() - 1));
        if (this.isLoadingMore == show) {
            return;
        }
        this.isLoadingMore = show;
        notifyItemChanged(getItemCount() - 1);
    }

    public final void r0(g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void s0(List<FriendsDressUpData> fiendZPlanInfoList) {
        Intrinsics.checkNotNullParameter(fiendZPlanInfoList, "fiendZPlanInfoList");
        this.data.clear();
        this.data.addAll(fiendZPlanInfoList);
        notifyDataSetChanged();
    }

    public final FriendsDressUpData m0(int position) {
        if (position < 0 || position >= this.data.size()) {
            return null;
        }
        return this.data.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        return position == this.data.size() + 1 ? 3 : 2;
    }
}
