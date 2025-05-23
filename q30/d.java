package q30;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import q30.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0013\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u001b"}, d2 = {"Lq30/d;", "Landroidx/recyclerview/widget/ListAdapter;", "Lq30/f;", "Lq30/d$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "itemView", "", "position", "", "k0", "", QZoneDTLoginReporter.SCHEMA, "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "m0", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends ListAdapter<QCircleContactUpdateBean, b> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lq30/d$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "", QZoneDTLoginReporter.SCHEMA, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "E", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "o", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "setMAvatarView", "(Lcom/tencent/mobileqq/proavatar/QQProAvatarView;)V", "mAvatarView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "setMNicknameTv", "(Landroid/widget/TextView;)V", "mNicknameTv", "itemView", "<init>", "(Lq30/d;Landroid/view/View;)V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private QQProAvatarView mAvatarView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private TextView mNicknameTv;
        final /* synthetic */ d G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull final d dVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = dVar;
            View findViewById = itemView.findViewById(R.id.vfm);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026_update_list_item_avatar)");
            this.mAvatarView = (QQProAvatarView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.vfn);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026pdate_list_item_nickname)");
            this.mNicknameTv = (TextView) findViewById2;
            itemView.setOnClickListener(new View.OnClickListener() { // from class: q30.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.b.m(d.b.this, dVar, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, d this$1, View view) {
            Object obj;
            boolean contains$default;
            Object last;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition != -1) {
                QCircleContactUpdateBean j06 = d.j0(this$1, adapterPosition);
                if (j06.e().isEmpty() && (!j06.c().isEmpty())) {
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) j06.c());
                    this$0.q(view, (String) last);
                } else if ((!j06.e().isEmpty()) && (!j06.c().isEmpty())) {
                    i.f428290a.j(Long.parseLong(j06.getUin()));
                    Iterator<T> it = j06.c().iterator();
                    while (true) {
                        obj = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) next, (CharSequence) j06.e().get(0), false, 2, (Object) null);
                        if (contains$default) {
                            obj = next;
                            break;
                        }
                    }
                    String str = (String) obj;
                    if (str != null) {
                        Intrinsics.checkNotNullExpressionValue(view, "view");
                        this$0.q(view, str);
                    }
                } else {
                    com.tencent.xaction.log.b.a("QCircleContactUpdateAdapter", 1, "jumpBySchema schema is empty. ");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void q(View view, String schema) {
            boolean z16;
            Context context = view.getContext();
            boolean z17 = true;
            if (schema.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String l06 = this.G.l0(schema);
                if (TextUtils.isEmpty(l06) || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_contacts_aperture_jump_anim", false)) {
                    z17 = false;
                }
                if (z17) {
                    schema = com.tencent.mobileqq.qcircle.api.utils.d.b(schema, view, 0L, l06, true);
                    Intrinsics.checkNotNullExpressionValue(schema, "wrapperAnimInfo(schema, view, 0, coverUrl, true)");
                }
                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse(schema));
                context.startActivity(intent);
                return;
            }
            com.tencent.xaction.log.b.a("QCircleContactUpdateAdapter", 1, "jumpBySchema schema is empty. ");
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final QQProAvatarView getMAvatarView() {
            return this.mAvatarView;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getMNicknameTv() {
            return this.mNicknameTv;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull DiffUtil.ItemCallback<QCircleContactUpdateBean> diffCallback) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
    }

    public static final /* synthetic */ QCircleContactUpdateBean j0(d dVar, int i3) {
        return dVar.getItem(i3);
    }

    private final void k0(QCircleContactUpdateBean item, View itemView, int position) {
        String str;
        VideoReport.setElementId(itemView, QCircleDaTongConstant.ElementId.EM_KL_XSJ_VIDEO_UPDATE);
        VideoReport.setElementReuseIdentifier(itemView, item.getUin());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        if (item.getEnable()) {
            str = "bright";
        } else {
            str = "grey";
        }
        hashMap.put("status", str);
        hashMap.put("item_index", Integer.valueOf(position + 1));
        hashMap.put("to_uin", item.getUin());
        VideoReport.setElementParams(itemView, hashMap);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l0(String schema) {
        List<String> list;
        MatchResult find$default = Regex.find$default(new Regex("cover_pic_url=([^&]+)"), schema, 0, 2, null);
        if (find$default != null) {
            list = find$default.getGroupValues();
        } else {
            list = null;
        }
        if (list == null || !(!find$default.getGroupValues().isEmpty())) {
            return null;
        }
        return Uri.decode(find$default.getGroupValues().get(1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        int dpToPx;
        int dpToPx2;
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        if (position == 0) {
            dpToPx = ViewUtils.dpToPx(18.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(10.0f);
        }
        int paddingTop = holder.itemView.getPaddingTop();
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            dpToPx2 = ViewUtils.dpToPx(18.0f);
        } else {
            dpToPx2 = ViewUtils.dpToPx(10.0f);
        }
        view.setPadding(dpToPx, paddingTop, dpToPx2, holder.itemView.getPaddingBottom());
        QCircleContactUpdateBean item = getItem(position);
        holder.getMNicknameTv().setText(item.getNick());
        e.a g16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100);
        if (item.getEnable()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        g16.i(i3);
        holder.getMAvatarView().x(1, item.getUin(), g16.a());
        Intrinsics.checkNotNullExpressionValue(item, "item");
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        k0(item, view2, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gwa, parent, false);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(this, itemView);
    }
}
