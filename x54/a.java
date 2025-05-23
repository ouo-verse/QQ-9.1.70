package x54;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b54.FunctionReportArgs;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u54.c;
import w64.e;
import y54.SlashItemCommandDescPayload;
import y54.SlashItemCommandNamePayload;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001&B\u0015\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\"\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u001cH\u0016J.\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0012\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016\u00a8\u0006'"}, d2 = {"Lx54/a;", "Lw54/a;", "Lx54/b;", "Lb74/a;", "Lx54/a$a;", "Lu54/c;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", DomainData.DOMAIN_NAME, "", "name", ReportConstant.COSTREPORT_PREFIX, "desc", "r", "", "", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "p", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "e", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lw64/e;", "mDialogContext", "<init>", "(Lw64/e;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends w54.a<b, b74.a, C11530a, c> implements View.OnClickListener {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lx54/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "tvName", UserInfo.SEX_FEMALE, "l", "tvDesName", "Landroid/view/View;", "G", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "divider", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: x54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11530a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tvName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView tvDesName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View divider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11530a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f106946_3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_command_name)");
            this.tvName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f1069069z);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_command_des)");
            this.tvDesName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.kmm);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(co\u2026leqq.qqui.R.id.v_divider)");
            this.divider = findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getTvDesName() {
            return this.tvDesName;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTvName() {
            return this.tvName;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull e<c> mDialogContext) {
        super(mDialogContext);
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
    }

    private final void n(b item, C11530a holder) {
        holder.itemView.setOnClickListener(this);
        String str = item.getCommandInfo().name;
        Intrinsics.checkNotNullExpressionValue(str, "item.commandInfo.name");
        s(holder, str);
        String str2 = item.getCommandInfo().desc;
        Intrinsics.checkNotNullExpressionValue(str2, "item.commandInfo.desc");
        r(holder, str2);
    }

    private final void q(C11530a holder, List<? extends Object> payloads) {
        Object first;
        List list;
        first = CollectionsKt___CollectionsKt.first(payloads);
        if (first instanceof List) {
            list = (List) first;
        } else {
            list = null;
        }
        if (list != null) {
            for (Object obj : list) {
                if (obj instanceof SlashItemCommandNamePayload) {
                    s(holder, ((SlashItemCommandNamePayload) obj).getCommandName());
                } else if (obj instanceof SlashItemCommandDescPayload) {
                    r(holder, ((SlashItemCommandDescPayload) obj).getCommandDesc());
                }
            }
        }
    }

    private final void r(C11530a holder, String desc) {
        holder.getTvDesName().setText(desc);
    }

    private final void s(C11530a holder, String name) {
        holder.getTvName().setText(name);
    }

    @Override // v64.b
    public void e(@NotNull RecyclerView.ViewHolder holder) {
        b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.e(holder);
        Object tag = holder.itemView.getTag(R.id.f86144qv);
        Integer num = null;
        if (tag instanceof b) {
            bVar = (b) tag;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        Object tag2 = holder.itemView.getTag(R.id.f86164qx);
        if (tag2 instanceof Integer) {
            num = (Integer) tag2;
        }
        if (num != null) {
            int intValue = num.intValue();
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            l().e().h(new SlashDialogMsgIntent.OnReportFunctionImpMsgIntent(new FunctionReportArgs(view, bVar.getRobotInfo(), bVar.getCommandInfo(), false, 1, intValue)));
        }
    }

    @Override // v64.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean h(@NotNull b74.a item, @NotNull List<? extends b74.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof b;
    }

    @Override // v64.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull b item, @NotNull C11530a holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(R.id.f86144qv, item);
        holder.itemView.setTag(R.id.f86154qw, holder);
        holder.itemView.setTag(R.id.f86164qx, Integer.valueOf(position));
        if (payloads.isEmpty()) {
            n(item, holder);
        } else {
            q(holder, payloads);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Object obj;
        b bVar;
        Object obj2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer num = null;
        if (v3 != null) {
            obj = v3.getTag(R.id.f86144qv);
        } else {
            obj = null;
        }
        if (obj instanceof b) {
            bVar = (b) obj;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            if (v3 != null) {
                obj2 = v3.getTag(R.id.f86164qx);
            } else {
                obj2 = null;
            }
            if (obj2 instanceof Integer) {
                num = (Integer) obj2;
            }
            if (num != null) {
                l().e().h(new SlashDialogMsgIntent.OnReportFunctionClickMsgIntent(new FunctionReportArgs(v3, bVar.getRobotInfo(), bVar.getCommandInfo(), false, 1, num.intValue())));
                l().e().h(new CommonListMsgIntent.OnItemClickMsgIntent(bVar));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // v64.b
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C11530a c(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168855h23, parent, false);
        VideoReport.setElementClickPolicy(contentView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(contentView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(contentView, EndExposurePolicy.REPORT_NONE);
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return new C11530a(contentView);
    }
}
