package u60;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f438467a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QFSSearchInfo f438468b;

    public b(int i3) {
        this.f438467a = i3;
        this.f438468b = new QFSSearchInfo();
    }

    public String a() {
        int i3 = this.f438467a;
        if (i3 != 1) {
            if (i3 != 2) {
                return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE;
            }
            return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_CONNECTIVE_PAGE;
    }

    public b(int i3, String str) {
        this.f438467a = i3;
        QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
        this.f438468b = qFSSearchInfo;
        qFSSearchInfo.k(str);
    }

    public b(int i3, QFSSearchInfo qFSSearchInfo) {
        this.f438467a = i3;
        this.f438468b = qFSSearchInfo;
    }
}
