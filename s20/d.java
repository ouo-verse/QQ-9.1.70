package s20;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Ls20/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/c;", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, String feedId, QCircleReportBean qCircleReportBean, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        aa aaVar = aa.f83750a;
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        if (qCircleReportBean == null || (str = qCircleReportBean.getDtPageId()) == null) {
            str = "";
        }
        aaVar.R(context, feedId, "rec_bar", str);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull StrategyImage info) {
        final String str;
        Intrinsics.checkNotNullParameter(info, "info");
        Object obj = info.b().get("feedId");
        final QCircleReportBean qCircleReportBean = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Object obj2 = info.b().get("reportBean");
        if (obj2 instanceof QCircleReportBean) {
            qCircleReportBean = (QCircleReportBean) obj2;
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: s20.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.n(d.this, str, qCircleReportBean, view);
            }
        });
    }
}
