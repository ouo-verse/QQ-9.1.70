package ub1;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f438758a;

    /* renamed from: b, reason: collision with root package name */
    private Context f438759b;

    /* renamed from: c, reason: collision with root package name */
    private String f438760c;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f438761d;

    public b(QQAppInterface qQAppInterface, Context context, String str, List<Integer> list) {
        this.f438759b = context;
        this.f438758a = qQAppInterface;
        this.f438760c = str;
        this.f438761d = list;
    }

    @Override // ub1.a
    public void a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 11) {
                            QLog.i("QFileOfflineSearchTypeController", 4, "unknown search type.");
                            return;
                        } else {
                            ReportController.o(this.f438758a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 5, 0, "", "", "", "");
                            SearchTypeDetailActivity.G2(this.f438759b, i3, this.f438760c, this.f438761d);
                            return;
                        }
                    }
                    ReportController.o(this.f438758a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 1, 0, "", "", "", "");
                    SearchTypeDetailActivity.G2(this.f438759b, i3, this.f438760c, this.f438761d);
                    return;
                }
                ReportController.o(this.f438758a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 2, 0, "", "", "", "");
                SearchTypeDetailActivity.G2(this.f438759b, i3, this.f438760c, this.f438761d);
                return;
            }
            ReportController.o(this.f438758a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 4, 0, "", "", "", "");
            SearchTypeDetailActivity.G2(this.f438759b, i3, this.f438760c, this.f438761d);
            return;
        }
        ReportController.o(this.f438758a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 3, 0, "", "", "", "");
        SearchTypeDetailActivity.G2(this.f438759b, i3, this.f438760c, this.f438761d);
    }
}
