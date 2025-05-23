package w82;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.matchfriend.utils.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lw82/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "I", "mFrom", "e", "mSchemeFrom", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mFrom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSchemeFrom;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Map mapOf;
        super.onInitView(rootView);
        if (rootView != null) {
            VideoReport.setPageId(rootView, "pg_kl_new_home_page");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("kl_new_from_openid", b.d().j()), TuplesKt.to("kl_new_home_page_from", Integer.valueOf(this.mFrom)), TuplesKt.to("kl_new_home_page_scheme_from_id", Integer.valueOf(this.mSchemeFrom)));
            VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mapOf));
            VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        super.onPartCreate(activity, savedInstanceState);
        int i3 = 0;
        this.mFrom = (activity == null || (intent2 = activity.getIntent()) == null) ? 0 : intent2.getIntExtra("from_intent_key", 0);
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("scheme_from_intent_key", 0);
        }
        this.mSchemeFrom = i3;
        VideoReport.addToDetectionWhitelist(activity);
    }
}
