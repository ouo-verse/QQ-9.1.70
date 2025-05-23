package xg;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.qzone.reborn.feedx.util.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f447955a;

    public i(Activity activity) {
        this.f447955a = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(BusinessFeedData businessFeedData, View view) {
        if (view.getId() == R.id.n0y) {
            c(businessFeedData);
        } else if (view.getId() == R.id.n0x) {
            b(businessFeedData);
        }
    }

    private String f(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getCellSummaryV2() != null) {
            Map<String, String> map = businessFeedData.getCellSummaryV2().mapExt;
            if (map != null && map.containsKey("diy_font_id") && !TextUtils.isEmpty(map.get("diy_font_id"))) {
                return "font";
            }
            if (map != null && map.containsKey("sparkle_json") && !TextUtils.isEmpty(map.get("sparkle_json"))) {
                return "colorFont";
            }
        }
        return "default";
    }

    public void b(BusinessFeedData businessFeedData) {
        long j3 = businessFeedData.owner_uin;
        if (j3 == 0) {
            j3 = businessFeedData.getUser().uin;
        }
        LpReportInfo_pf00064.report(129, 3);
        vo.c.E(BaseApplication.getContext(), j3, f(businessFeedData));
    }

    public void c(BusinessFeedData businessFeedData) {
        String str = businessFeedData.getCellSummaryV2() != null ? businessFeedData.getCellSummaryV2().summary : null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().s(TextCellParser.toPlainText(str));
    }

    public boolean e(View view, final BusinessFeedData businessFeedData) {
        if (view != null && businessFeedData != null && this.f447955a != null) {
            if (businessFeedData.isAdFeeds()) {
                QLog.e("QZoneFeedxTextContentLongClickProcess", 1, "onContentLongClick ad feeds can not long click");
                return false;
            }
            com.tencent.biz.qqcircle.richframework.widget.menu.c cVar = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
            cVar.a(R.id.n0y, HardCodeUtil.qqStr(R.string.rfw));
            if (!ef.b.d(businessFeedData)) {
                cVar.a(R.id.n0x, HardCodeUtil.qqStr(R.string.rfh));
            }
            w.a().b(view, cVar, new w.c() { // from class: xg.h
                @Override // com.qzone.reborn.feedx.util.w.c
                public final void onClick(View view2) {
                    i.this.d(businessFeedData, view2);
                }
            });
            return true;
        }
        QLog.e("QZoneFeedxTextContentLongClickProcess", 1, "onContentLongClick params error");
        return false;
    }
}
