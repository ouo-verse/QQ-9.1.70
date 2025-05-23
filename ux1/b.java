package ux1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.fragments.j;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.GuildChannelSelectedData;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextChannelInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ux1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004$%&'B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lux1/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemCount", "getItemViewType", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "list", "setData", "Lux1/b$d$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lux1/b$d$a;", "getParams", "()Lux1/b$d$a;", "params", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "getMCallback", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "mCallback", "D", "Ljava/util/List;", "mDataList", "<init>", "(Lux1/b$d$a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;)V", "E", "a", "b", "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final j mCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<GuildChannelSelectedData> mDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.AdapterParams params;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\"\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lux1/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Landroid/view/View;", "view", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lux1/b$d$a;", "E", "Lux1/b$d$a;", "mPermissionType", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;", "mCallback", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mChannelIconView", "H", "Landroid/view/View;", "mChannelIconEmptyView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mChannelNameView", "Landroid/widget/CheckBox;", "J", "Landroid/widget/CheckBox;", "mChannelSelectedView", "itemView", "<init>", "(Landroid/view/View;Lux1/b$d$a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/j;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Companion.AdapterParams mPermissionType;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final j mCallback;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private ImageView mChannelIconView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private View mChannelIconEmptyView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView mChannelNameView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private CheckBox mChannelSelectedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @NotNull Companion.AdapterParams mPermissionType, @NotNull j mCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mPermissionType, "mPermissionType");
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            this.mPermissionType = mPermissionType;
            this.mCallback = mCallback;
            View findViewById = itemView.findViewById(R.id.trz);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_icon)");
            this.mChannelIconView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f164768ts1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.channel_icon_empty)");
            this.mChannelIconEmptyView = findViewById2;
            View findViewById3 = itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.channel_name)");
            this.mChannelNameView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f82074fw);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.select_checkbox)");
            this.mChannelSelectedView = (CheckBox) findViewById4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(View view) {
            if (view != null && (view.getTag() instanceof GuildChannelSelectedData)) {
                Object tag = view.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.model.repositories.GuildChannelSelectedData");
                GuildChannelSelectedData guildChannelSelectedData = (GuildChannelSelectedData) tag;
                if (guildChannelSelectedData.getChannelInfo() == null) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.rg.ChannelPermissionEditAdapter", 2, "onItemClicked channelInfo is null");
                        return;
                    }
                    return;
                }
                this.mCallback.a(view, String.valueOf(guildChannelSelectedData.getChannelInfo().getChannelId()));
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.rg.ChannelPermissionEditAdapter", 2, "onItemClicked error");
            }
        }

        private final void p(GuildChannelSelectedData data) {
            this.itemView.setOnClickListener(null);
            this.mChannelSelectedView.setEnabled(false);
            this.mChannelSelectedView.setChecked(data.getIsSelected());
        }

        private final void q(GuildChannelSelectedData data) {
            if (!data.getIsSelectable()) {
                p(data);
            }
        }

        public final void m(@NotNull GuildChannelSelectedData data) {
            int i3;
            boolean z16;
            int i16;
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.getChannelInfo() == null) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.rg.ChannelPermissionEditAdapter", 2, "ChannelItemViewHolder bindData data channelInfo is null");
                    return;
                }
                return;
            }
            this.mChannelNameView.setText(data.getName());
            int i17 = 0;
            this.mChannelSelectedView.setVisibility(0);
            this.mChannelSelectedView.setClickable(false);
            this.mChannelSelectedView.setEnabled(true);
            this.mChannelSelectedView.setChecked(data.getIsSelected());
            ImageView imageView = this.mChannelIconView;
            int channelType = data.getChannelInfo().getChannelType();
            IGProTextChannelInfo textChannelInfo = data.getChannelInfo().getTextChannelInfo();
            if (textChannelInfo != null) {
                i3 = textChannelInfo.getSubTypeId();
            } else {
                i3 = 0;
            }
            GuildChannelIconUtil.r(imageView, channelType, i3, null, 8, null);
            if (this.mPermissionType.getNewSquareStyle() && data.getChannelInfo().getChannelType() == 7) {
                z16 = false;
            } else {
                z16 = true;
            }
            ImageView imageView2 = this.mChannelIconView;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
            View view = this.mChannelIconEmptyView;
            if (!(!z16)) {
                i17 = 8;
            }
            view.setVisibility(i17);
            this.itemView.setTag(data);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: ux1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.a.n(b.a.this, view2);
                }
            });
            q(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lux1/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "uiData", "", "extraTopSpace", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mCategoryName", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ux1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C11372b extends RecyclerView.ViewHolder {

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView mCategoryName;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0011\u0010\t\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lux1/b$b$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lux1/b$b;", "b", "", "a", "()I", TtmlNode.TAG_LAYOUT, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ux1.b$b$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return R.layout.f66;
            }

            @JvmStatic
            @NotNull
            public final C11372b b(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View view = LayoutInflater.from(parent.getContext()).inflate(a(), parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                return new C11372b(view);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11372b(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = this.itemView.findViewById(R.id.arv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.category_name)");
            this.mCategoryName = (TextView) findViewById;
        }

        public final void l(@NotNull GuildChannelSelectedData uiData, boolean extraTopSpace) {
            int dip2px;
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            int i3 = 0;
            if (!extraTopSpace) {
                dip2px = 0;
            } else {
                dip2px = ScreenUtil.dip2px(1.0f);
            }
            this.itemView.setPadding(0, dip2px, 0, 0);
            this.mCategoryName.setText(uiData.getName());
            if (!(this.itemView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (extraTopSpace) {
                i3 = QQGuildUIUtil.e(13.0f, this.itemView.getResources());
            }
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i3, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            this.itemView.requestLayout();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lux1/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "data", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTitle", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.tsi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.channel_title)");
            this.mTitle = (TextView) findViewById;
        }

        public final void l(@NotNull GuildChannelSelectedData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mTitle.setText(data.getName());
        }
    }

    public b(@NotNull Companion.AdapterParams params, @NotNull j mCallback) {
        List<GuildChannelSelectedData> emptyList;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.params = params;
        this.mCallback = mCallback;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mDataList = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mDataList.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GuildChannelSelectedData guildChannelSelectedData = this.mDataList.get(position);
        boolean z16 = true;
        if (guildChannelSelectedData.getType() == 2) {
            if (holder instanceof c) {
                ((c) holder).l(guildChannelSelectedData);
            } else if (holder instanceof C11372b) {
                if (position == 0 && (position <= 0 || this.mDataList.get(position - 1).getType() == 3)) {
                    z16 = false;
                }
                ((C11372b) holder).l(guildChannelSelectedData, z16);
            }
        } else if (guildChannelSelectedData.getType() == 1) {
            ((a) holder).m(guildChannelSelectedData);
        } else if (guildChannelSelectedData.getType() == 3) {
            if (holder instanceof vx1.e) {
                ((vx1.e) holder).m(guildChannelSelectedData.getName());
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (guildChannelSelectedData.getType() == 4) {
            if (holder instanceof vx1.d) {
                ((vx1.d) holder).m(guildChannelSelectedData.getName());
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.rg.ChannelPermissionEditAdapter", "onBindViewHolder pos:" + position + " data:" + guildChannelSelectedData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType != 3) {
                    if (viewType == 4) {
                        return vx1.d.INSTANCE.b(parent);
                    }
                    throw new IllegalArgumentException("Guild.rg.ChannelPermissionEditAdapter onCreateViewHolder viewType is error");
                }
                return vx1.e.INSTANCE.b(parent);
            }
            if (this.params.getNewSquareStyle()) {
                return C11372b.INSTANCE.b(parent);
            }
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ehr, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ry_layout, parent, false)");
            return new c(inflate);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168045ei2, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf\u2026em_layout, parent, false)");
        return new a(inflate2, this.params, this.mCallback);
    }

    public final void setData(@NotNull List<GuildChannelSelectedData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mDataList = list;
        notifyDataSetChanged();
    }
}
