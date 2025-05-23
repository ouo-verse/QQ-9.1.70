package sa3;

import android.net.Uri;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.wink.request.QQWinkGetWangZheTabDataReq;
import com.tencent.mobileqq.wink.utils.ar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowWangZheReportTabData$HokTabInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lsa3/b;", "", "", "b", "", "needShow", "", "e", "c", "Ljava/lang/String;", "schemaWangZheUrl", "Z", "isSchemaMode", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f433595a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String schemaWangZheUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isSchemaMode;

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        if (z16 && j3 == 0) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type qshadow.ShadowWangZheReportTabData.HokTabInfoRsp");
            ShadowWangZheReportTabData$HokTabInfoRsp shadowWangZheReportTabData$HokTabInfoRsp = (ShadowWangZheReportTabData$HokTabInfoRsp) obj;
            ar arVar = ar.f326685a;
            arVar.m("ae_key_editor_need_show_wang_zhe_report_tab", shadowWangZheReportTabData$HokTabInfoRsp.show_hok_tab.get());
            arVar.m("ae_key_editor_need_show_wang_zhe_report_red_dot", shadowWangZheReportTabData$HokTabInfoRsp.show_red_point.get());
            String str2 = shadowWangZheReportTabData$HokTabInfoRsp.hok_report_url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "tabData.hok_report_url.get()");
            arVar.r("ae_key_editor_wang_zhe_report_url", str2);
            w53.b.a("WinkWangZheReportManager", "requestWangZheTabData success. showTab: " + shadowWangZheReportTabData$HokTabInfoRsp.show_hok_tab.get() + ", showRedDot: " + shadowWangZheReportTabData$HokTabInfoRsp.show_red_point.get() + ", url: " + shadowWangZheReportTabData$HokTabInfoRsp.hok_report_url.get());
            return;
        }
        w53.b.c("WinkWangZheReportManager", "requestWangZheTabData failed. retCode: " + j3 + ", errMsg: " + str);
    }

    @Nullable
    public final String b() {
        String i3;
        boolean z16;
        String str = "https://h5.qzone.qq.com/v2/h5.tu/web/kings-honor-report/index?_wv=16777217&_wwv=532612&_fv=0&disable_landscape=true&hide_back=true&taskid=fabuqi_tab";
        if (isSchemaMode) {
            i3 = schemaWangZheUrl;
        } else {
            i3 = ar.f326685a.i("ae_key_editor_wang_zhe_report_url", "https://h5.qzone.qq.com/v2/h5.tu/web/kings-honor-report/index?_wv=16777217&_wwv=532612&_fv=0&disable_landscape=true&hide_back=true&taskid=fabuqi_tab");
        }
        if (i3 != null && i3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            str = i3;
        }
        Uri parse = Uri.parse(str);
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        for (String str2 : parse.getQueryParameterNames()) {
            String queryParameter = parse.getQueryParameter(str2);
            if (queryParameter != null) {
                if (Intrinsics.areEqual(str2, "_wv")) {
                    clearQuery.appendQueryParameter(str2, String.valueOf((Integer.parseInt(queryParameter) & 0) | 16777216));
                } else if (Intrinsics.areEqual(str2, "_wwv")) {
                    clearQuery.appendQueryParameter(str2, String.valueOf(Integer.parseInt(queryParameter) | 8192 | 524288));
                } else {
                    clearQuery.appendQueryParameter(str2, queryParameter);
                }
            }
        }
        return clearQuery.build().toString();
    }

    public final void c() {
        VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), new QQWinkGetWangZheTabDataReq(), new VSDispatchObserver.OnVSRspCallBack() { // from class: sa3.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                b.d(baseRequest, z16, j3, str, obj);
            }
        });
    }

    public final void e(boolean needShow) {
        ar.f326685a.m("ae_key_editor_need_show_wang_zhe_report_red_dot", needShow);
    }
}
