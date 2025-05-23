package ui1;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\t\u001a\u00020\b*\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\\\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000326\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\r\u00a8\u0006\u0017"}, d2 = {"Lui1/e;", "", "Landroid/view/View;", "", "", "params", "", AdMetricTag.Report.TYPE, "", "c", "Landroidx/fragment/app/Fragment;", "parentFragment", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "v", "Lcom/tencent/widget/ActionSheet;", "sheet", "onConfirmCallback", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f439033a = new e();

    e() {
    }

    private final void c(View view, Map<String, ? extends Object> map, int i3) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildNoticeActionSheetExt", 1, "clickDtReport--params: " + map + ", reportType: " + i3);
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("sgrp_btn_type", Integer.valueOf(i3));
        VideoReport.setElementId(view, "em_sgrp_node_slides_left_pop");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 onConfirmCallback, ActionSheet actionSheet, Map map, ActionSheet this_with, View v3, int i3) {
        Intrinsics.checkNotNullParameter(onConfirmCallback, "$onConfirmCallback");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        if (i3 == 124076834) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            onConfirmCallback.invoke(v3, actionSheet);
            f439033a.c(v3, map, 1);
            this_with.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Map map, ActionSheet this_with, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        e eVar = f439033a;
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        eVar.c(v3, map, 2);
        this_with.dismiss();
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void d(@NotNull Fragment parentFragment, @Nullable final Map<String, ? extends Object> reportParams, @NotNull final Function2<? super View, ? super ActionSheet, Unit> onConfirmCallback) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(onConfirmCallback, "onConfirmCallback");
        Context requireContext = parentFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "parentFragment.requireContext()");
        Dialog createDialog = ActionSheetHelper.createDialog(requireContext, null, true);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.f144730pk);
        actionSheet.addButton(R.string.f144720pj, 0, 124076834);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: ui1.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                e.e(Function2.this, actionSheet, reportParams, actionSheet, view, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: ui1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.f(reportParams, actionSheet, view);
            }
        });
        actionSheet.preInitView();
        VideoReport.setLogicParent(actionSheet.mContentContainer, parentFragment.requireView());
        View childAt = actionSheet.mContentContainer.getChildAt(0);
        if (childAt instanceof RelativeLayout) {
            relativeLayout = (RelativeLayout) childAt;
        } else {
            relativeLayout = null;
        }
        if (relativeLayout != null) {
            int d16 = (int) cw.d(10);
            ViewExtKt.d(relativeLayout, d16);
            ViewExtKt.e(relativeLayout, d16);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.action_sheet_title);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.action_sheet_title)");
                textView.setTypeface(null, 0);
                textView.setTextSize(2, 12.0f);
                textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_secondary));
            }
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) actionSheet.mContentContainer.findViewById(124076834);
        if (relativeLayout2 != null) {
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "findViewById<RelativeLayout>(BASE_ID + CONFIRM)");
            TextView textView2 = (TextView) relativeLayout2.findViewById(R.id.action_sheet_button);
            if (textView2 != null) {
                textView2.setTextColor(actionSheet.getContext().getColor(R.color.f157028hz));
            }
        }
        actionSheet.show();
    }
}
