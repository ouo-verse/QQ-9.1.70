package vm3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import g55.at;
import g55.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003-./B\u000f\u0012\u0006\u0010%\u001a\u00020\u0007\u00a2\u0006\u0004\b*\u0010+J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010$\u00a8\u00060"}, d2 = {"Lvm3/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "Lvm3/b$b;", "viewHolder", "", "position", "", "o0", "", "pkTimeMs", "", "l0", "Landroid/widget/ImageView;", "animContainer", "m0", "Lg55/at;", "pkInfo", "k0", "n0", "Landroid/view/View;", "btnView", "j0", "", "pkHistoryList", "setData", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "onBindViewHolder", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "pkType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "D", "footerCounter", "<init>", "(I)V", "E", "a", "b", "c", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<at> pkHistoryList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private final int footerCounter = 1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int pkType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020 \u00a2\u0006\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lvm3/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "pkResultLogo", UserInfo.SEX_FEMALE, "l", "anchorAvatar", "G", "p", "liveAnimView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "anchorNick", "I", "r", "pkTime", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/Button;", "sendInviteBtn", "K", "t", "tipsViewNotInLive", "Landroid/view/View;", "L", "Landroid/view/View;", "o", "()Landroid/view/View;", "itemGapLine", "itemView", "<init>", "(Landroid/view/View;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vm3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C11428b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView pkResultLogo;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView anchorAvatar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView liveAnimView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView anchorNick;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView pkTime;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final Button sendInviteBtn;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView tipsViewNotInLive;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final View itemGapLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11428b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f25460aw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.pk_result_logo)");
            this.pkResultLogo = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.a2o);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.avatar)");
            this.anchorAvatar = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.yko);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.live_anim_view)");
            this.liveAnimView = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.sop);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.anchor_name)");
            this.anchorNick = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f25510b1);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.pk_time_label)");
            TextView textView = (TextView) findViewById5;
            this.pkTime = textView;
            View findViewById6 = itemView.findViewById(R.id.f83134ir);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.send_invite_btn)");
            this.sendInviteBtn = (Button) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.zsh);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.not_in_live)");
            this.tipsViewNotInLive = (TextView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.xv9);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.item_gap_line)");
            this.itemGapLine = findViewById8;
            com.tencent.misc.utils.b.b(textView);
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getAnchorAvatar() {
            return this.anchorAvatar;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getAnchorNick() {
            return this.anchorNick;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final View getItemGapLine() {
            return this.itemGapLine;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ImageView getLiveAnimView() {
            return this.liveAnimView;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final ImageView getPkResultLogo() {
            return this.pkResultLogo;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getPkTime() {
            return this.pkTime;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final Button getSendInviteBtn() {
            return this.sendInviteBtn;
        }

        @NotNull
        /* renamed from: t, reason: from getter */
        public final TextView getTipsViewNotInLive() {
            return this.tipsViewNotInLive;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lvm3/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    public b(int i3) {
        this.pkType = i3;
    }

    private final void j0(View btnView, at pkInfo) {
        e55.a aVar = new e55.a();
        aVar.f395729a = pkInfo.f401328d.f401358a;
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(aVar.f395729a.f395735a));
        if (this.pkType == 2) {
            com.tencent.report.a.f364907a.d(btnView, true, null, "em_qqlive_pwpk_history_invite", hashMap);
        }
        if (this.pkType == 3) {
            com.tencent.report.a.f364907a.d(btnView, true, null, "em_qqlive_lppk_history_invite", hashMap);
        }
    }

    private final String k0(Context context, at pkInfo) {
        long j3 = pkInfo.f401327c.f401359b;
        long j16 = pkInfo.f401328d.f401359b;
        if (j3 > j16) {
            return an3.a.INSTANCE.h().a(context);
        }
        if (j3 < j16) {
            return an3.a.INSTANCE.g().a(context);
        }
        return an3.a.INSTANCE.f().a(context);
    }

    private final String l0(long pkTimeMs) {
        String format = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date(pkTimeMs));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(date)");
        return format;
    }

    private final void m0(ImageView animContainer) {
        u0.a.h().c("https://dlied5.qq.com/now/qq-live/images/pk-living.png", animContainer, new a.c(0, true, true));
    }

    private final void n0(at pkInfo) {
        e55.a aVar = new e55.a();
        aVar.f395729a = pkInfo.f401328d.f401358a;
        if (this.pkType == 2) {
            EventCenter.post(new ym3.a(5, aVar, 7));
        }
        if (this.pkType == 3) {
            EventCenter.post(new ym3.a(3, aVar, 6));
        }
    }

    private final void o0(Context context, C11428b viewHolder, int position) {
        boolean z16;
        e55.c cVar;
        final at atVar = this.pkHistoryList.get(position);
        com.tencent.mobileqq.qqlive.utils.c.a(viewHolder.getPkResultLogo(), k0(context, atVar));
        e eVar = atVar.f401328d;
        if (eVar != null && (cVar = eVar.f401358a) != null) {
            ImageLoader.getInstance().displayImage(cVar.f395738d, viewHolder.getAnchorAvatar(), new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).build());
            viewHolder.getAnchorNick().setText(cVar.f395737c);
        }
        e eVar2 = atVar.f401328d;
        if (eVar2 != null && eVar2.f401360c == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            viewHolder.getLiveAnimView().setVisibility(0);
            m0(viewHolder.getLiveAnimView());
        } else {
            viewHolder.getLiveAnimView().setVisibility(8);
        }
        viewHolder.getPkTime().setText(l0(atVar.f401329e * 1000));
        int i3 = this.pkType;
        if (i3 != 2 && i3 != 3) {
            viewHolder.getSendInviteBtn().setVisibility(8);
            viewHolder.getTipsViewNotInLive().setVisibility(8);
        } else if (z16) {
            viewHolder.getSendInviteBtn().setVisibility(0);
            viewHolder.getSendInviteBtn().setOnClickListener(new View.OnClickListener() { // from class: vm3.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.p0(b.this, atVar, view);
                }
            });
            viewHolder.getTipsViewNotInLive().setVisibility(8);
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_lp_anchor_id", String.valueOf(atVar.f401328d.f401358a.f395735a));
            com.tencent.report.a.f364907a.d(viewHolder.getSendInviteBtn(), true, null, "em_qqlive_lppk_history_invite", hashMap);
        } else {
            viewHolder.getSendInviteBtn().setVisibility(8);
            viewHolder.getTipsViewNotInLive().setVisibility(0);
        }
        if (position == (getNUM_BACKGOURND_ICON() - this.footerCounter) - 1) {
            viewHolder.getItemGapLine().setVisibility(8);
        } else {
            viewHolder.getItemGapLine().setVisibility(0);
        }
        j0(viewHolder.getSendInviteBtn(), atVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(b this$0, at pkInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pkInfo, "$pkInfo");
        this$0.n0(pkInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.pkHistoryList.size() + this.footerCounter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.footerCounter > 0 && position >= this.pkHistoryList.size()) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof C11428b) {
            Context context = viewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "viewHolder.itemView.context");
            o0(context, (C11428b) viewHolder, position);
        }
        boolean z16 = viewHolder instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View footerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.e9b, parent, false);
            Intrinsics.checkNotNullExpressionValue(footerView, "footerView");
            return new c(footerView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fdf, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new C11428b(view);
    }

    public final void setData(@NotNull List<at> pkHistoryList) {
        Intrinsics.checkNotNullParameter(pkHistoryList, "pkHistoryList");
        this.pkHistoryList = pkHistoryList;
    }
}
