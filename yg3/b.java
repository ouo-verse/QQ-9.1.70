package yg3;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.x;
import java.util.List;
import kotlin.Metadata;
import zg3.ZPlanDownloadParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lyg3/b;", "Lvb3/b;", "", "Lzg3/b;", "downloadParamList", "", "O0", "Lcom/tencent/mobileqq/zootopia/download/x;", "a", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "cancel", "Lcom/tencent/mobileqq/zootopia/download/ah;", "downloadListener", "h0", "G", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface b extends vb3.b {
    void G(ah downloadListener);

    void O0(List<ZPlanDownloadParam> downloadParamList);

    List<x> a();

    void cancel(String taskId);

    void h0(ah downloadListener);
}
