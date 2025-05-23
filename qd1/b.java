package qd1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.util.e;
import com.tencent.mobileqq.gamecenter.qa.util.k;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0017J\b\u0010\u0017\u001a\u00020\rH\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018R\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lqd1/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lqd1/b$a;", "", "select", "", "n0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/qa/data/InviteData;", "list", "p0", "isNightTheme", "q0", "", "appId", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "position", "k0", "getItemCount", "", "", "j0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mDataList", "D", "I", "mAppId", "E", "Z", "<init>", "(Landroid/content/Context;)V", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<InviteData> mDataList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private int mAppId;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isNightTheme;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lqd1/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setIvFace", "(Landroid/widget/ImageView;)V", "ivFace", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "setTvName", "(Landroid/widget/TextView;)V", "tvName", "G", "getTvDesc", "setTvDesc", "tvDesc", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setIvSelect", "ivSelect", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setTvOfficialDesc", "tvOfficialDesc", "Landroid/view/ViewGroup;", "J", "Landroid/view/ViewGroup;", "o", "()Landroid/view/ViewGroup;", "setRlRoot", "(Landroid/view/ViewGroup;)V", "rlRoot", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ImageView ivFace;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView tvName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private TextView tvDesc;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private ImageView ivSelect;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView tvOfficialDesc;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private ViewGroup rlRoot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.dv9);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_face)");
            this.ivFace = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_name)");
            this.tvName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f167042k73);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_desc)");
            this.tvDesc = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.y8u);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_select)");
            this.ivSelect = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f109686gh);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_official_desc)");
            this.tvOfficialDesc = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.idg);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.rl_root)");
            this.rlRoot = (ViewGroup) findViewById6;
        }

        @NotNull
        public final TextView getTvDesc() {
            return this.tvDesc;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getIvFace() {
            return this.ivFace;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getIvSelect() {
            return this.ivSelect;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ViewGroup getRlRoot() {
            return this.rlRoot;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getTvName() {
            return this.tvName;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final TextView getTvOfficialDesc() {
            return this.tvOfficialDesc;
        }
    }

    public b(@Nullable Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(InviteData data, b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        data.o(!data.getIsSelected());
        this$0.notifyDataSetChanged();
        this$0.n0(data.getIsSelected());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n0(boolean select) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(2, "1");
        if (select) {
            str = "908049";
        } else {
            str = "908048";
        }
        e.a("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "1025", "916601", str, "20", String.valueOf(this.mAppId), hashMap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @NotNull
    public final List<String> j0() {
        ArrayList arrayList = new ArrayList();
        for (InviteData inviteData : this.mDataList) {
            if (inviteData.getIsSelected()) {
                arrayList.add(inviteData.getEncodeUin());
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.context != null && this.isNightTheme) {
            holder.getRlRoot().setBackgroundColor(this.context.getResources().getColor(R.color.cfr));
            holder.getTvName().setTextColor(this.context.getResources().getColor(R.color.f157842cg4));
            holder.getTvDesc().setTextColor(this.context.getResources().getColor(R.color.cfz));
            holder.getTvOfficialDesc().setTextColor(this.context.getResources().getColor(R.color.cfo));
        }
        final InviteData inviteData = this.mDataList.get(position);
        holder.getIvFace().setImageDrawable(k.l(inviteData.getFaceUrl(), 0, 0));
        holder.getTvName().setText(inviteData.getName());
        holder.getTvDesc().setText(inviteData.getDesc());
        ImageView ivSelect = holder.getIvSelect();
        if (inviteData.getIsSelected()) {
            if (this.isNightTheme) {
                i3 = R.drawable.mws;
            } else {
                i3 = R.drawable.mwr;
            }
        } else if (this.isNightTheme) {
            i3 = R.drawable.mwq;
        } else {
            i3 = R.drawable.mwp;
        }
        ivSelect.setBackgroundResource(i3);
        holder.getTvOfficialDesc().setText(inviteData.getOfficialDes());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: qd1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.l0(InviteData.this, this, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = View.inflate(this.context, R.layout.ebt, null);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }

    public final void o0(int appId) {
        this.mAppId = appId;
    }

    public final void p0(@NotNull ArrayList<InviteData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public final void q0(boolean isNightTheme) {
        this.isNightTheme = isNightTheme;
    }
}
