package xf1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildChannelIconTypeApi;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0005R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lxf1/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/channel/manage/b;", "uiData", "", "n0", "", "channelInfoList", "", "setData", "i0", "Landroid/view/View$OnClickListener;", "onClickListener", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "viewHolder", "position", "onBindViewHolder", "k0", "l0", "m0", "getItemViewType", "", "getItemId", "getItemCount", "sorting", "o0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "j0", "()Ljava/util/List;", "mChannelList", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mOnClickListener", "D", "Z", "getSorting", "()Z", "setSorting", "(Z)V", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener mOnClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean sorting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.channel.manage.b> mChannelList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000201\u00a2\u0006\u0004\b9\u00106R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\"\u00100\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b\u0003\u00106\u00a8\u0006:"}, d2 = {"Lxf1/h$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "p", "()Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/widget/RelativeLayout;)V", "mNoneLayout", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "v", "()Landroid/widget/ImageView;", "H", "(Landroid/widget/ImageView;)V", "mTypeIcon", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "mChannelLayout", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "mTitleLayout", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "y", "(Landroid/widget/TextView;)V", "mNameTextView", "J", "t", "D", "mTitleView", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mRightIconImageView", "L", "l", "w", "mArrowIconImageView", "M", "r", "B", "mSelectIconImageView", "Landroid/view/View;", "N", "Landroid/view/View;", "u", "()Landroid/view/View;", "(Landroid/view/View;)V", "mTopMarginView", "itemView", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        public RelativeLayout mNoneLayout;

        /* renamed from: F, reason: from kotlin metadata */
        public ImageView mTypeIcon;

        /* renamed from: G, reason: from kotlin metadata */
        public RelativeLayout mChannelLayout;

        /* renamed from: H, reason: from kotlin metadata */
        public RelativeLayout mTitleLayout;

        /* renamed from: I, reason: from kotlin metadata */
        public TextView mNameTextView;

        /* renamed from: J, reason: from kotlin metadata */
        public TextView mTitleView;

        /* renamed from: K, reason: from kotlin metadata */
        public ImageView mRightIconImageView;

        /* renamed from: L, reason: from kotlin metadata */
        public ImageView mArrowIconImageView;

        /* renamed from: M, reason: from kotlin metadata */
        public ImageView mSelectIconImageView;

        /* renamed from: N, reason: from kotlin metadata */
        public View mTopMarginView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void A(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRightIconImageView = imageView;
        }

        public final void B(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mSelectIconImageView = imageView;
        }

        public final void C(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mTitleLayout = relativeLayout;
        }

        public final void D(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitleView = textView;
        }

        public final void E(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mTopMarginView = view;
        }

        public final void H(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mTypeIcon = imageView;
        }

        @NotNull
        public final ImageView l() {
            ImageView imageView = this.mArrowIconImageView;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mArrowIconImageView");
            return null;
        }

        @NotNull
        public final RelativeLayout m() {
            RelativeLayout relativeLayout = this.mChannelLayout;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mChannelLayout");
            return null;
        }

        @NotNull
        public final TextView o() {
            TextView textView = this.mNameTextView;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mNameTextView");
            return null;
        }

        @NotNull
        public final RelativeLayout p() {
            RelativeLayout relativeLayout = this.mNoneLayout;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mNoneLayout");
            return null;
        }

        @NotNull
        public final ImageView q() {
            ImageView imageView = this.mRightIconImageView;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRightIconImageView");
            return null;
        }

        @NotNull
        public final ImageView r() {
            ImageView imageView = this.mSelectIconImageView;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mSelectIconImageView");
            return null;
        }

        @NotNull
        public final RelativeLayout s() {
            RelativeLayout relativeLayout = this.mTitleLayout;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
            return null;
        }

        @NotNull
        public final TextView t() {
            TextView textView = this.mTitleView;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            return null;
        }

        @NotNull
        public final View u() {
            View view = this.mTopMarginView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTopMarginView");
            return null;
        }

        @NotNull
        public final ImageView v() {
            ImageView imageView = this.mTypeIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTypeIcon");
            return null;
        }

        public final void w(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mArrowIconImageView = imageView;
        }

        public final void x(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mChannelLayout = relativeLayout;
        }

        public final void y(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mNameTextView = textView;
        }

        public final void z(@NotNull RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mNoneLayout = relativeLayout;
        }
    }

    private final boolean n0(com.tencent.mobileqq.guild.channel.manage.b uiData) {
        IGProChannel iGProChannel;
        if (uiData != null) {
            iGProChannel = uiData.f215084d;
        } else {
            iGProChannel = null;
        }
        if (iGProChannel == null || iGProChannel.getHiddenPostChannel() == 1) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mChannelList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mChannelList.get(position).f215081a;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.channel.manage.b> i0() {
        return this.mChannelList;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.channel.manage.b> j0() {
        return this.mChannelList;
    }

    public final boolean k0(int position) {
        Object orNull;
        Object orNull2;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mChannelList, position);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.mChannelList, position - 1);
        com.tencent.mobileqq.guild.channel.manage.b bVar = (com.tencent.mobileqq.guild.channel.manage.b) orNull2;
        if (n0((com.tencent.mobileqq.guild.channel.manage.b) orNull) && !n0(bVar)) {
            return true;
        }
        return false;
    }

    public final boolean l0(int position) {
        Object orNull;
        Object orNull2;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mChannelList, position);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.mChannelList, position + 1);
        com.tencent.mobileqq.guild.channel.manage.b bVar = (com.tencent.mobileqq.guild.channel.manage.b) orNull2;
        if (n0((com.tencent.mobileqq.guild.channel.manage.b) orNull) && !n0(bVar)) {
            return true;
        }
        return false;
    }

    public final boolean m0(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mChannelList, position);
        return n0((com.tencent.mobileqq.guild.channel.manage.b) orNull);
    }

    public final void o0(boolean sorting) {
        if (this.sorting != sorting) {
            this.sorting = sorting;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        int i3;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        com.tencent.mobileqq.guild.channel.manage.b bVar = this.mChannelList.get(position);
        if (!(viewHolder instanceof a)) {
            return;
        }
        a aVar = (a) viewHolder;
        aVar.v().setVisibility(8);
        int i16 = bVar.f215081a;
        int i17 = 0;
        if (i16 == 0) {
            if (k0(position) && l0(position)) {
                i3 = R.drawable.guild_token_setting_round_rect_8_selector;
            } else if (k0(position)) {
                i3 = R.drawable.guild_token_setting_top_round_rect_8_selector;
            } else if (l0(position)) {
                i3 = R.drawable.guild_token_setting_bottom_round_rect_8_selector;
            } else {
                i3 = R.drawable.guild_token_setting_rect_8_selector;
            }
            View view = aVar.itemView;
            view.setBackground(ContextCompat.getDrawable(view.getContext(), i3));
            aVar.o().setTextColor(aVar.itemView.getResources().getColor(R.color.qui_common_text_primary));
            ViewGroup.LayoutParams layoutParams = aVar.o().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart((int) cw.b(16));
            layoutParams2.setMarginEnd((int) cw.b(35));
            aVar.o().setLayoutParams(layoutParams2);
            aVar.o().setText(bVar.f215084d.getChannelName());
            aVar.s().setVisibility(8);
            aVar.m().setVisibility(0);
            aVar.p().setVisibility(8);
            aVar.u().setVisibility(8);
            viewHolder.itemView.setOnClickListener(this.mOnClickListener);
            viewHolder.itemView.setTag(bVar);
            if (this.sorting) {
                aVar.l().setVisibility(8);
                aVar.r().setVisibility(0);
            } else {
                aVar.l().setVisibility(0);
                aVar.r().setVisibility(8);
                if (QQTheme.isVasTheme()) {
                    new DrawableType(R.drawable.qui_chevron_right_icon_secondary_01, Integer.valueOf(R.color.qui_common_text_primary)).b(aVar.l());
                } else {
                    aVar.l().setImageResource(R.drawable.qui_chevron_right_icon_secondary_01);
                }
            }
            if (bVar.f215084d.getChannelType() != 7) {
                aVar.v().setVisibility(0);
                IGuildChannelIconTypeApi iGuildChannelIconTypeApi = (IGuildChannelIconTypeApi) QRoute.api(IGuildChannelIconTypeApi.class);
                ImageView v3 = aVar.v();
                int channelType = bVar.f215084d.getChannelType();
                IGProTextChannelInfo textChannelInfo = bVar.f215084d.getTextChannelInfo();
                if (textChannelInfo != null) {
                    i17 = textChannelInfo.getSubTypeId();
                }
                iGuildChannelIconTypeApi.setSameChannelIcon(v3, channelType, i17);
            }
        } else if (i16 == 1) {
            aVar.s().setBackground(null);
            aVar.itemView.setBackground(null);
            aVar.t().setText(bVar.f215082b);
            aVar.s().setVisibility(0);
            aVar.m().setVisibility(8);
            aVar.p().setVisibility(8);
            aVar.u().setVisibility(8);
            aVar.q().setVisibility(8);
            viewHolder.itemView.setOnClickListener(null);
        } else {
            aVar.m().setVisibility(8);
            aVar.s().setVisibility(8);
            RelativeLayout p16 = aVar.p();
            if (this.sorting) {
                i17 = 8;
            }
            p16.setVisibility(i17);
            aVar.u().setVisibility(8);
        }
        if (bVar.f215081a == 0) {
            float f28 = 1.0f;
            if (this.sorting) {
                TextView o16 = aVar.o();
                if (bVar.f215090j) {
                    f19 = 1.0f;
                } else {
                    f19 = 0.5f;
                }
                o16.setAlpha(f19);
                ImageView l3 = aVar.l();
                if (bVar.f215090j) {
                    f26 = 1.0f;
                } else {
                    f26 = 0.5f;
                }
                l3.setAlpha(f26);
                ImageView r16 = aVar.r();
                if (bVar.f215090j) {
                    f27 = 1.0f;
                } else {
                    f27 = 0.5f;
                }
                r16.setAlpha(f27);
                ImageView v16 = aVar.v();
                if (!bVar.f215090j) {
                    f28 = 0.5f;
                }
                v16.setAlpha(f28);
                viewHolder.itemView.setEnabled(bVar.f215090j);
                return;
            }
            TextView o17 = aVar.o();
            if (bVar.f215088h) {
                f16 = 1.0f;
            } else {
                f16 = 0.5f;
            }
            o17.setAlpha(f16);
            ImageView l16 = aVar.l();
            if (bVar.f215088h) {
                f17 = 1.0f;
            } else {
                f17 = 0.5f;
            }
            l16.setAlpha(f17);
            ImageView r17 = aVar.r();
            if (bVar.f215088h) {
                f18 = 1.0f;
            } else {
                f18 = 0.5f;
            }
            r17.setAlpha(f18);
            ImageView v17 = aVar.v();
            if (!bVar.f215088h) {
                f28 = 0.5f;
            }
            v17.setAlpha(f28);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ei8, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ting_item, parent, false)");
        a aVar = new a(inflate);
        View findViewById = inflate.findViewById(R.id.f165449w22);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewGroup.findViewById(R\u2026l_list_item_channel_name)");
        aVar.y((TextView) findViewById);
        View findViewById2 = inflate.findViewById(R.id.w1u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "viewGroup.findViewById(R\u2026_channel_item_title_more)");
        aVar.A((ImageView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.f165451w24);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "viewGroup.findViewById(R\u2026nel_list_item_title_name)");
        aVar.D((TextView) findViewById3);
        View findViewById4 = inflate.findViewById(R.id.f165448w21);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "viewGroup.findViewById(R\u2026_channel_list_item_arrow)");
        aVar.w((ImageView) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.f165450w23);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "viewGroup.findViewById(R\u2026channel_list_item_select)");
        aVar.B((ImageView) findViewById5);
        View findViewById6 = inflate.findViewById(R.id.w1t);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "viewGroup.findViewById(R\u2026hannel_item_title_layout)");
        aVar.C((RelativeLayout) findViewById6);
        View findViewById7 = inflate.findViewById(R.id.w1r);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "viewGroup.findViewById(R\u2026nnel_item_channel_layout)");
        aVar.x((RelativeLayout) findViewById7);
        View findViewById8 = inflate.findViewById(R.id.w1w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "viewGroup.findViewById(R\u2026d_channel_item_type_icon)");
        aVar.H((ImageView) findViewById8);
        View findViewById9 = inflate.findViewById(R.id.w1s);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "viewGroup.findViewById(R\u2026channel_item_none_layout)");
        aVar.z((RelativeLayout) findViewById9);
        View findViewById10 = inflate.findViewById(R.id.w1v);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "viewGroup.findViewById(R\u2026_channel_item_top_margin)");
        aVar.E(findViewById10);
        return aVar;
    }

    public final void p0(@Nullable View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public final void setData(@Nullable List<? extends com.tencent.mobileqq.guild.channel.manage.b> channelInfoList) {
        this.mChannelList.clear();
        List<com.tencent.mobileqq.guild.channel.manage.b> list = this.mChannelList;
        Intrinsics.checkNotNull(channelInfoList);
        list.addAll(channelInfoList);
        notifyDataSetChanged();
    }
}
