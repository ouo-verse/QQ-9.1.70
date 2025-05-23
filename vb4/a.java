package vb4;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nv4.i;
import nv4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lvb4/a;", "", "", "templateId", "contentType", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f441348a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"vb4/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnv4/i;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vb4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11411a implements e<i> {
        C11411a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(i result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SameStyleTaskReportHelper_", 1, "sameStyleProcessDone onResultSuccess result.errCd:" + result.f421406a + ", result.msg:" + result.f421407b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SameStyleTaskReportHelper_", 1, "sameStyleProcessDone onResultFailure error:" + error + ", message:" + message);
        }
    }

    a() {
    }

    public final void a(int templateId, int contentType) {
        QLog.i("SameStyleTaskReportHelper_", 1, "sameStyleProcessDone templateId:" + templateId + ", contentType:" + contentType);
        ArrayList arrayList = new ArrayList();
        l lVar = new l();
        lVar.f421413a = "template_id";
        lVar.f421414b = String.valueOf(templateId);
        arrayList.add(lVar);
        l lVar2 = new l();
        lVar2.f421413a = "commited_ts";
        lVar2.f421414b = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
        arrayList.add(lVar2);
        ub4.a.d(ub4.a.f438773a, 1, arrayList, new C11411a(), 0, 8, null);
    }
}
