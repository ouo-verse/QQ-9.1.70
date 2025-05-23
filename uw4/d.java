package uw4;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.DLReportInfo;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface d extends ITimerListener, ICmdListener {
    IBusinessCallback a(long j3);

    void b(@NonNull BusinessUpdateParams businessUpdateParams, com.tencent.vas.update.entity.a aVar, DLReportInfo dLReportInfo);

    void c(b bVar);

    a d();

    void e();

    void f(BusinessUpdateParams businessUpdateParams, int i3);

    void g(List<BusinessUpdateParams> list);

    void h(int i3);

    void i(BusinessUpdateParams businessUpdateParams, long j3, long j16, int i3);

    void j(BusinessUpdateParams businessUpdateParams);

    void k(int i3, int i16, HashMap<String, ItemUpdateVerPtr> hashMap);

    void l(long j3, String str);
}
