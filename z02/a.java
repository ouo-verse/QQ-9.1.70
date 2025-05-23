package z02;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* compiled from: P */
    /* renamed from: z02.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C11642a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f451706d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f451707e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f451708f;

        C11642a(Runnable runnable, Runnable runnable2, ActionSheet actionSheet) {
            this.f451706d = runnable;
            this.f451707e = runnable2;
            this.f451708f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.f451707e.run();
                }
            } else {
                this.f451706d.run();
            }
            this.f451708f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f451709d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f451710e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f451711f;

        b(Runnable runnable, Runnable runnable2, ActionSheet actionSheet) {
            this.f451709d = runnable;
            this.f451710e = runnable2;
            this.f451711f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            if (i3 != 0) {
                if (i3 != 1) {
                    str = "em_sgrp_mine_head_cancel";
                } else {
                    this.f451710e.run();
                    str = "em_sgrp_mine_head_photograph";
                }
            } else {
                this.f451709d.run();
                str = "em_sgrp_mine_head_album";
            }
            VideoReport.setElementId(view, str);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("dt_clck", view, new HashMap());
            this.f451711f.dismiss();
        }
    }

    public static void a(Activity activity, Runnable runnable, Runnable runnable2) {
        if (activity == null) {
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(activity, null);
        actionSheet.addButton("\u4ece\u76f8\u518c\u9009\u62e9", 0);
        actionSheet.addButton("\u62cd\u7167", 0);
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.setOnButtonClickListener(new C11642a(runnable2, runnable, actionSheet));
        actionSheet.show();
    }

    public static void b(Activity activity, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        if (activity == null) {
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(activity, null);
        actionSheet.addButton("\u4ece\u76f8\u518c\u9009\u62e9", 0);
        actionSheet.addButton("\u62cd\u7167", 0);
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.setOnButtonClickListener(new b(runnable3, runnable2, actionSheet));
        actionSheet.show();
        VideoReport.setPageId(actionSheet, "pg_sgrp_mine_edit");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.setPageParams(actionSheet, new PageParams(hashMap));
    }
}
