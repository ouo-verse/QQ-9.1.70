package ub4;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nv4.c;
import nv4.h;
import nv4.i;
import nv4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J,\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\b\b\u0002\u0010\n\u001a\u00020\u0007J6\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a8\u0006\u0014"}, d2 = {"Lub4/a;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "Lcom/tencent/common/app/AppInterface;", "e", "", "", "idList", "Lnv4/c;", "source", "", "a", "taskFactoryType", "Lnv4/l;", "extInfo", "Lnv4/i;", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a */
    public static final a f438773a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"ub4/a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ub4.a$a */
    /* loaded from: classes36.dex */
    public static final class C11336a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<c> f438774a;

        C11336a(e<c> eVar) {
            this.f438774a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanSameStyleReqUtil_", 1, "batchGetTemplateById errCode:" + errCode + ", errMsg:" + errMsg);
            this.f438774a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f438774a.onResultFailure(-10, "rsp is null");
                QLog.e("ZplanSameStyleReqUtil_", 1, "batchGetTemplateById error! data is null!");
                return;
            }
            try {
                e<c> eVar = this.f438774a;
                c c16 = c.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Exception e16) {
                QLog.e("ZplanSameStyleReqUtil_", 1, "batchGetTemplateById throw e:" + e16.getMessage(), e16);
                this.f438774a.onResultFailure(-13, e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"ub4/a$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements td3.a {

        /* renamed from: a */
        final /* synthetic */ e<i> f438775a;

        b(e<i> eVar) {
            this.f438775a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZplanSameStyleReqUtil_", 1, "doReportTask errCode:" + errCode + ", errMsg:" + errMsg);
            this.f438775a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f438775a.onResultFailure(-10, "rsp is null");
                QLog.e("ZplanSameStyleReqUtil_", 1, "doReportTask error! data is null!");
                return;
            }
            try {
                e<i> eVar = this.f438775a;
                i c16 = i.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Exception e16) {
                QLog.e("ZplanSameStyleReqUtil_", 1, "doReportTask throw e:" + e16.getMessage(), e16);
                this.f438775a.onResultFailure(-13, e16.getMessage());
            }
        }
    }

    a() {
    }

    private final AppInterface e(e<?> callback) {
        AppInterface appInterface = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getAppInterface();
        if (appInterface == null) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        QLog.i("ZplanSameStyleReqUtil_", 1, "getAppInterface app:" + appInterface);
        if (appInterface instanceof AppInterface) {
            return appInterface;
        }
        return null;
    }

    public final void a(List<Integer> idList, e<c> callback, int source) {
        int[] intArray;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(idList, "idList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZplanSameStyleReqUtil_", 1, "batchGetTemplateById idList:" + idList);
        AppInterface e16 = e(callback);
        if (e16 == null) {
            return;
        }
        List<Integer> list = idList;
        if (list.isEmpty()) {
            callback.onResultFailure(-14, "id list empty");
            return;
        }
        nv4.b bVar = new nv4.b();
        intArray = CollectionsKt___CollectionsKt.toIntArray(list);
        bVar.f421389a = intArray;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, e16, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "BatchGetTemplateByID", byteArray, emptyMap, new C11336a(callback), source, 0, 128, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, int i3, List list, e eVar, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            list = new ArrayList();
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        aVar.c(i3, list, eVar, i16);
    }

    public static /* synthetic */ void b(a aVar, List list, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        aVar.a(list, eVar, i3);
    }

    public final void c(int taskFactoryType, List<l> extInfo, e<i> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZplanSameStyleReqUtil_", 1, "doReportTask taskFactoryType:" + taskFactoryType + ", extInfo:" + extInfo);
        AppInterface e16 = e(callback);
        if (e16 == null) {
            return;
        }
        h hVar = new h();
        Object[] array = extInfo.toArray(new l[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        hVar.f421405b = (l[]) array;
        hVar.f421404a = taskFactoryType;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(hVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, e16, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "ReportTask", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }
}
