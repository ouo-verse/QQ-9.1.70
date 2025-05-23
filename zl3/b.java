package zl3;

import android.text.TextUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.now.app.music.model.data.MusicItem;
import f3.f;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static String f452751d = "MusicDownLoader";

    /* renamed from: a, reason: collision with root package name */
    private volatile List<e> f452752a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f452753b = false;

    /* renamed from: c, reason: collision with root package name */
    private e f452754c = new e(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements h3.a {
        a() {
        }

        @Override // h3.a
        public void a(String str, g3.a aVar, g3.b bVar) {
            b.this.m("\u6b4c\u66f2\u4e0b\u8f7d\u5931\u8d25\uff01" + str);
            LogUtil.i(b.f452751d, "OriginalFile onLoadingFailed :" + str, new Object[0]);
            if (b.this.f452754c != null && b.this.f452754c.f452762b != null) {
                b.this.f452754c.f452762b.c(b.this.f452754c.f452761a, str, aVar.a(), "\u4e0b\u8f7d\u5931\u8d25");
            }
            b.this.i();
        }

        @Override // h3.a
        public void b(String str) {
            LogUtil.i(b.f452751d, "OriginalFile onLoadingStarted :" + str, new Object[0]);
            if (b.this.f452754c != null && b.this.f452754c.f452762b != null) {
                b.this.f452754c.f452762b.b(b.this.f452754c.f452761a, str, 0 / b.this.f452754c.f452761a.getFactor(), 100);
            }
        }

        @Override // h3.a
        public void c(String str, File file, g3.b bVar) {
            LogUtil.i(b.f452751d, "OriginalFile onLoadingComplete :" + str, new Object[0]);
            if (b.this.f452754c != null) {
                b.this.m("\u6b4c\u66f2\u4e0b\u8f7d\u6210\u529f\uff01");
                if (TextUtils.isEmpty(b.this.f452754c.f452761a.accompanyUrl) || !b.this.f452754c.f452761a.accompanyUrl.startsWith("http") || file == null) {
                    b.this.m("\u6b4c\u66f2\u6ca1\u6709\u4f34\u594f\uff01");
                    if (b.this.f452754c.f452762b != null && file != null) {
                        b.this.f452754c.f452762b.a(b.this.f452754c.f452761a, str, file.getAbsolutePath(), null, null);
                    }
                    b.this.i();
                    return;
                }
                b.this.m("\u6709\u4f34\u594f\uff0c\u5f00\u59cb\u4e0b\u8f7d\u4f34\u594f\uff01");
                b.this.h(str, file.getAbsolutePath(), b.this.f452754c.f452761a.accompanyUrl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zl3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C11696b implements h3.b {
        C11696b() {
        }

        @Override // h3.b
        public void a(String str, int i3, int i16) {
            if (b.this.f452754c != null && b.this.f452754c.f452762b != null) {
                b.this.f452754c.f452762b.b(b.this.f452754c.f452761a, str, ((i3 * 100) / i16) / b.this.f452754c.f452761a.getFactor(), 100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements h3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f452757a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f452758b;

        c(String str, String str2) {
            this.f452757a = str;
            this.f452758b = str2;
        }

        @Override // h3.a
        public void a(String str, g3.a aVar, g3.b bVar) {
            b.this.m("\u4f34\u594f\u4e0b\u8f7d\u5931\u8d25\uff01" + str);
            LogUtil.i(b.f452751d, "AccompanyFile onLoadingFailed :" + str, new Object[0]);
            if (b.this.f452754c == null) {
                return;
            }
            if (b.this.f452754c.f452762b != null) {
                b.this.f452754c.f452762b.c(b.this.f452754c.f452761a, str, aVar.a(), aVar.toString());
            }
            b.this.i();
        }

        @Override // h3.a
        public void b(String str) {
            LogUtil.i(b.f452751d, "AccompanyFile onLoadingStarted :" + str, new Object[0]);
        }

        @Override // h3.a
        public void c(String str, File file, g3.b bVar) {
            LogUtil.i(b.f452751d, "AccompanyFile onLoadingComplete :" + str, new Object[0]);
            if (b.this.f452754c != null) {
                b.this.m("\u4f34\u594f\u4e0b\u8f7d\u5b8c\u6210\uff01");
                if (b.this.f452754c.f452762b != null && file != null) {
                    b.this.f452754c.f452762b.a(b.this.f452754c.f452761a, this.f452757a, this.f452758b, str, file.getAbsolutePath());
                }
                b.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements h3.b {
        d() {
        }

        @Override // h3.b
        public void a(String str, int i3, int i16) {
            if (b.this.f452754c != null && b.this.f452754c.f452762b != null) {
                b.this.f452754c.f452762b.b(b.this.f452754c.f452761a, str, (((i3 * 100) / i16) / b.this.f452754c.f452761a.getFactor()) + 50, 100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public MusicItem f452761a;

        /* renamed from: b, reason: collision with root package name */
        public zl3.a f452762b;

        public e(MusicItem musicItem, zl3.a aVar) {
            this.f452761a = musicItem;
            this.f452762b = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2, String str3) {
        LogUtil.i(f452751d, "downloadAccompanyFile :" + str3, new Object[0]);
        f.j().l(str3, new c(str, str2), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f452752a.size() == 0) {
            this.f452754c = null;
            this.f452753b = false;
            return;
        }
        this.f452753b = true;
        this.f452754c = this.f452752a.get(0);
        this.f452752a.remove(0);
        m("\u5f00\u59cb\u4e0b\u8f7d\u6b4c\u66f2\uff01");
        k(this.f452754c.f452761a.originalUrl);
    }

    private void k(String str) {
        LogUtil.i(f452751d, "downloadOriginalFile :" + str, new Object[0]);
        f.j().l(str, new a(), new C11696b());
    }

    private void l(MusicItem musicItem, zl3.a aVar) {
        this.f452752a.add(0, new e(musicItem, aVar));
        LogUtil.i(f452751d, "insert top", new Object[0]);
        if (!this.f452753b) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        e eVar = this.f452754c;
        if (eVar != null && eVar.f452761a != null) {
            LogUtil.i(f452751d, str + " \u6b4c\u66f2\u540d\u79f0:" + this.f452754c.f452761a.songName + " \u6b4c\u5531:" + this.f452754c.f452761a.singerName, new Object[0]);
        }
    }

    public void f(MusicItem musicItem) {
        this.f452752a.add(new e(musicItem, null));
        if (!this.f452753b) {
            i();
        }
    }

    public void g() {
        f.j().m();
    }

    public void j(MusicItem musicItem, zl3.a aVar) {
        if (musicItem != null) {
            LogUtil.i(f452751d, "\u6dfb\u52a0\u6b4c\u66f2! \u6b4c\u5531:" + musicItem.singerName + " \u540d\u79f0:" + musicItem.songName + " id:" + musicItem.songId + " songUrl:" + musicItem.originalUrl + " accompanyUrl:" + musicItem.accompanyUrl, new Object[0]);
        }
        e eVar = this.f452754c;
        if (eVar != null && musicItem != null && musicItem.equals(eVar.f452761a)) {
            this.f452754c.f452762b = aVar;
            return;
        }
        e eVar2 = this.f452754c;
        if (eVar2 != null && musicItem != null && !musicItem.equals(eVar2.f452761a) && this.f452753b) {
            f.j().d(this.f452754c.f452761a.originalUrl);
            LogUtil.i(f452751d, "cancel :" + this.f452754c.f452761a.originalUrl, new Object[0]);
            if (!TextUtils.isEmpty(this.f452754c.f452761a.accompanyUrl)) {
                f.j().d(this.f452754c.f452761a.accompanyUrl);
                LogUtil.i(f452751d, "cancel :" + this.f452754c.f452761a.accompanyUrl, new Object[0]);
            }
            this.f452754c = null;
            this.f452753b = false;
        }
        l(musicItem, aVar);
    }
}
