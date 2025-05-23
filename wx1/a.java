package wx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wx1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 \u001a2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004\u001b\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lwx1/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lwx1/a$b;", "", "Lwx1/a$a;", "dataList", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "getItemCount", "holder", "position", "j0", "Lwx1/a$d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lwx1/a$d;", "callback", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "<init>", "(Lwx1/a$d;)V", "D", "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<ChannelGroupUIData> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lwx1/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lwx1/a$a;", "uiData", "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "groupNameTV", UserInfo.SEX_FEMALE, "adminNumTV", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "arrowIV", "Landroid/view/View;", "H", "Landroid/view/View;", "dividerLine", "I", "Lwx1/a$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Lwx1/a;Landroid/view/ViewGroup;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView groupNameTV;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView adminNumTV;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView arrowIV;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final View dividerLine;

        /* renamed from: I, reason: from kotlin metadata */
        private ChannelGroupUIData uiData;
        final /* synthetic */ a J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull final a aVar, ViewGroup parent) {
            super(a.INSTANCE.b(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.J = aVar;
            View findViewById = this.itemView.findViewById(R.id.trx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_group_name)");
            this.groupNameTV = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.se_);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.admin_number)");
            this.adminNumTV = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.w1g);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026category_list_item_arrow)");
            this.arrowIV = (ImageView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.aco);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.bottom_divider_line)");
            this.dividerLine = findViewById4;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: wx1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.m(a.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(a this$0, b this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            d dVar = this$0.callback;
            ChannelGroupUIData channelGroupUIData = this$1.uiData;
            if (channelGroupUIData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiData");
                channelGroupUIData = null;
            }
            dVar.a(channelGroupUIData);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(@NotNull ChannelGroupUIData uiData) {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            this.uiData = uiData;
            this.groupNameTV.setText(uiData.getName());
            this.adminNumTV.setText(uiData.getAdminNum() + "\u4eba");
            QQGuildUIUtil.N(uiData.getIsEmptyTip() ^ true, this.itemView);
            TextView textView = this.adminNumTV;
            int i17 = 0;
            if (!uiData.getIsEmptyTip()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            ImageView imageView = this.arrowIV;
            if (!uiData.getIsEmptyTip()) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            View view = this.dividerLine;
            if (!uiData.getIsShowBottomDividerLine()) {
                i17 = 8;
            }
            view.setVisibility(i17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\b"}, d2 = {"Lwx1/a$c;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wx1.a$c, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f68, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026mber_item, parent, false)");
            return inflate;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lwx1/a$d;", "", "Lwx1/a$a;", "uiData", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface d {
        void a(@NotNull ChannelGroupUIData uiData);
    }

    public a(@NotNull d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.dataList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.dataList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(this, parent);
    }

    public final void setData(@NotNull List<ChannelGroupUIData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lwx1/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "id", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "name", "c", "I", "()I", "adminNum", "maxCnt", "e", "Z", "()Z", "isEmptyTip", "f", "g", "(Z)V", "isShowBottomDividerLine", "<init>", "(JLjava/lang/String;IIZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wx1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ChannelGroupUIData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int adminNum;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxCnt;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isEmptyTip;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isShowBottomDividerLine;

        public ChannelGroupUIData(long j3, @NotNull String name, int i3, int i16, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = j3;
            this.name = name;
            this.adminNum = i3;
            this.maxCnt = i16;
            this.isEmptyTip = z16;
            this.isShowBottomDividerLine = z17;
        }

        /* renamed from: a, reason: from getter */
        public final int getAdminNum() {
            return this.adminNum;
        }

        /* renamed from: b, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: c, reason: from getter */
        public final int getMaxCnt() {
            return this.maxCnt;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsEmptyTip() {
            return this.isEmptyTip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelGroupUIData)) {
                return false;
            }
            ChannelGroupUIData channelGroupUIData = (ChannelGroupUIData) other;
            if (this.id == channelGroupUIData.id && Intrinsics.areEqual(this.name, channelGroupUIData.name) && this.adminNum == channelGroupUIData.adminNum && this.maxCnt == channelGroupUIData.maxCnt && this.isEmptyTip == channelGroupUIData.isEmptyTip && this.isShowBottomDividerLine == channelGroupUIData.isShowBottomDividerLine) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsShowBottomDividerLine() {
            return this.isShowBottomDividerLine;
        }

        public final void g(boolean z16) {
            this.isShowBottomDividerLine = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((((androidx.fragment.app.a.a(this.id) * 31) + this.name.hashCode()) * 31) + this.adminNum) * 31) + this.maxCnt) * 31;
            boolean z16 = this.isEmptyTip;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (a16 + i16) * 31;
            boolean z17 = this.isShowBottomDividerLine;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ChannelGroupUIData(id=" + this.id + ", name=" + this.name + ", adminNum=" + this.adminNum + ", maxCnt=" + this.maxCnt + ", isEmptyTip=" + this.isEmptyTip + ", isShowBottomDividerLine=" + this.isShowBottomDividerLine + ")";
        }

        public /* synthetic */ ChannelGroupUIData(long j3, String str, int i3, int i16, boolean z16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0L : j3, str, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? true : z17);
        }
    }
}
