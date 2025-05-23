package ys1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.dq;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lys1/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", "mode", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "", "getItemId", "getItemCount", "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "k0", "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mModeList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "mGameInfo", "gameModes", "<init>", "(Ljava/util/ArrayList;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private dq mGameInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<dq> mModeList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lys1/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "isCheck", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "gameMode", "l", "Landroid/widget/RadioButton;", "E", "Landroid/widget/RadioButton;", "getModeBtn", "()Landroid/widget/RadioButton;", "modeBtn", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getModeImg", "()Landroid/widget/ImageView;", "modeImg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RadioButton modeBtn;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView modeImg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f166754hv2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.radioButton)");
            this.modeBtn = (RadioButton) findViewById;
            View findViewById2 = itemView.findViewById(R.id.zcv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.mode_image)");
            this.modeImg = (ImageView) findViewById2;
        }

        public final void l(@NotNull dq gameMode) {
            Intrinsics.checkNotNullParameter(gameMode, "gameMode");
            u.q(gameMode.getImage(), this.modeImg, true);
        }

        public final void m(boolean isCheck) {
            this.modeBtn.setChecked(isCheck);
        }
    }

    public b(@NotNull ArrayList<dq> gameModes) {
        Intrinsics.checkNotNullParameter(gameModes, "gameModes");
        this.mModeList = gameModes;
        dq dqVar = gameModes.get(0);
        Intrinsics.checkNotNullExpressionValue(dqVar, "gameModes[0]");
        this.mGameInfo = dqVar;
    }

    private final void j0(View view, String mode) {
        Map mapOf;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_game_mode", mode));
        ch.T0(view, "em_sgrp_honorofkings_game_mode", clickPolicy, exposurePolicy, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b this$0, dq gameInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gameInfo, "$gameInfo");
        this$0.notifyDataSetChanged();
        Object tag = it.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGameModesResult");
        this$0.mGameInfo = (dq) tag;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String id5 = gameInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id5, "gameInfo.id");
        this$0.j0(it, id5);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mModeList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        String id5 = this.mModeList.get(position).getId();
        Intrinsics.checkNotNullExpressionValue(id5, "mModeList[position].id");
        return Long.parseLong(id5);
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final dq getMGameInfo() {
        return this.mGameInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            dq dqVar = this.mModeList.get(position);
            Intrinsics.checkNotNullExpressionValue(dqVar, "mModeList[position]");
            final dq dqVar2 = dqVar;
            holder.itemView.setTag(dqVar2);
            a aVar = (a) holder;
            aVar.l(dqVar2);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: ys1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.l0(b.this, dqVar2, view);
                }
            });
            Object tag = holder.itemView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGameModesResult");
            if (Intrinsics.areEqual(((dq) tag).getId(), this.mGameInfo.getId())) {
                aVar.m(true);
            } else {
                aVar.m(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.esq, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }
}
