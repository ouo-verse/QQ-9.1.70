package s92;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import n92.a;
import n92.e;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.nearby.now.view.b f433518a;

    /* renamed from: b, reason: collision with root package name */
    private n92.a f433519b;

    /* renamed from: c, reason: collision with root package name */
    private VideoData f433520c;

    /* renamed from: d, reason: collision with root package name */
    private int f433521d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: s92.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11216a implements a.b {
        C11216a() {
        }

        @Override // n92.a.b
        public void a() {
            if (a.this.f433518a != null) {
                a.this.f433518a.showToast(BaseApplicationImpl.getApplication().getString(R.string.dxg));
                a.this.f433518a.hideLoading();
                a.this.f433518a.showBadNetworkConnection();
            }
        }

        @Override // n92.a.b
        public void b(Comments comments) {
            if (a.this.f433518a != null) {
                a.this.f433521d++;
                a.this.f433518a.showDataInView(comments);
                a.this.f433518a.hideLoading();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements a.c {
        b() {
        }

        @Override // n92.a.c
        public void a(Comments.Comment comment) {
            if (a.this.f433518a != null) {
                a.this.f433518a.addCommentInView(comment);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "onPublishSuccess");
                }
            }
        }

        @Override // n92.a.c
        public void b(Comments.Comment comment, int i3, String str) {
            if (a.this.f433518a != null) {
                a.this.f433518a.publishCommentFailed(comment, i3, str);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "onDataNotAvailable, code=" + i3 + ", tip=" + str + ", comment=" + comment);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class c implements a.InterfaceC10832a {
        c() {
        }

        @Override // n92.a.InterfaceC10832a
        public void a(Comments.Comment comment, int i3) {
            if (a.this.f433518a != null) {
                if (i3 == 0) {
                    a.this.f433518a.removeCommentDirectly(comment);
                    a.this.f433518a.showToast(BaseApplicationImpl.getApplication().getString(R.string.dxd));
                    ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
                    return;
                }
                a.this.f433518a.showToast(BaseApplicationImpl.getApplication().getString(R.string.dxc));
            }
        }
    }

    public a(com.tencent.mobileqq.nearby.now.view.b bVar, Object obj, AppInterface appInterface) {
        this.f433518a = bVar;
        VideoData videoData = (VideoData) obj;
        this.f433519b = new e(videoData, (QQAppInterface) appInterface);
        this.f433520c = videoData;
    }

    public void d(Comments.Comment comment) {
        this.f433519b.b(comment, new c());
    }

    public int e() {
        return this.f433521d;
    }

    public void f() {
        com.tencent.mobileqq.nearby.now.view.b bVar = this.f433518a;
        if (bVar != null) {
            bVar.showLoading();
        }
        this.f433519b.c(this.f433521d, new C11216a());
    }

    public void g(Comments.Comment comment) {
        this.f433519b.a(comment, new b());
    }

    public void h() {
        this.f433518a = null;
    }

    public void i() {
        this.f433521d = 0;
        f();
    }
}
