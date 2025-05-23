package u4;

import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private com.qzone.publish.business.publishqueue.b f438208b;

    /* renamed from: c, reason: collision with root package name */
    private DownloadQueue.b f438209c;

    /* renamed from: a, reason: collision with root package name */
    private final String f438207a = "AlbumViewCallBackManager";

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<WeakReference<g>> f438210d = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements DownloadQueue.b {
        b() {
        }

        @Override // com.qzone.album.business.downloader.DownloadQueue.b
        public void a() {
            int A = QZonePublishQueue.w().A();
            int k3 = DownloadQueue.j().k();
            if (e.this.f438210d == null || e.this.f438210d.size() <= 0) {
                return;
            }
            Iterator it = new ArrayList(e.this.f438210d).iterator();
            while (it.hasNext()) {
                g gVar = (g) ((WeakReference) it.next()).get();
                if (gVar != null) {
                    gVar.a(A, k3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final e f438213a = new e();
    }

    public static final e d() {
        return c.f438213a;
    }

    public int c() {
        return DownloadQueue.j().k();
    }

    public int e() {
        return QZonePublishQueue.w().A();
    }

    public boolean f() {
        return DownloadQueue.j().m();
    }

    public boolean g() {
        return QZonePublishQueue.w().F();
    }

    public void b(g gVar) {
        if (gVar == null) {
            return;
        }
        synchronized (this) {
            if (this.f438208b == null) {
                this.f438208b = new a();
                QZonePublishQueue.w().i(this.f438208b);
            }
            if (this.f438209c == null) {
                this.f438209c = new b();
                DownloadQueue.j().a(this.f438209c);
            }
            Iterator<WeakReference<g>> it = this.f438210d.iterator();
            while (it.hasNext()) {
                g gVar2 = it.next().get();
                if (gVar2 == null) {
                    it.remove();
                } else if (gVar2 == gVar) {
                    return;
                }
            }
            this.f438210d.add(new WeakReference<>(gVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements com.qzone.publish.business.publishqueue.b {
        a() {
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void onQueueChanged() {
            int A = QZonePublishQueue.w().A();
            int k3 = DownloadQueue.j().k();
            if (e.this.f438210d == null || e.this.f438210d.size() <= 0) {
                return;
            }
            Iterator it = new ArrayList(e.this.f438210d).iterator();
            while (it.hasNext()) {
                g gVar = (g) ((WeakReference) it.next()).get();
                if (gVar != null) {
                    gVar.a(A, k3);
                }
            }
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void H(IQueueTask iQueueTask) {
        }
    }

    public void h() {
    }
}
