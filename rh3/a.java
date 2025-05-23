package rh3;

import av4.d;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.event.impl.ZPlanEventAndMsgReportImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lrh3/a;", "", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "event", "Lrh3/b;", "cb", "", "report", "", "reqString", "reportMsg", "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "Lav4/d;", "msgInfo", "initRegisterDatabaseModelClass", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanEventAndMsgReportImpl.class)
/* loaded from: classes36.dex */
public interface a {
    void initRegisterDatabaseModelClass();

    void report(Event event, b cb5);

    void reportMsg(d msgInfo, b cb5);

    void reportMsg(ReportMsgBean reqString, b cb5);

    void reportMsg(String reqString, b cb5);
}
