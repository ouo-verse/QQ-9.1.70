package r8;

import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import s8.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends k {

    /* renamed from: e, reason: collision with root package name */
    public k.a f430940e = new C11121a();

    /* renamed from: c, reason: collision with root package name */
    private FileCacheService f430938c = CacheManager.getZipCacheService();

    /* renamed from: d, reason: collision with root package name */
    private FileCacheService f430939d = CacheManager.getPersonaliseFontCacheService();

    /* compiled from: P */
    /* renamed from: r8.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11121a implements k.a {
        C11121a() {
        }

        @Override // s8.k.a
        public void a(String str, boolean z16) {
            a.this.f430938c.updateLruFile(str, z16);
        }

        @Override // s8.k.a
        public String b(String str) {
            return a.this.f430938c.getPath(str);
        }
    }

    @Override // s8.k
    public boolean a(File file) {
        return FileUtils.deleteFile(file);
    }

    @Override // s8.k
    public boolean e(File file, File file2) {
        return FileUtils.unzip(file, file2);
    }
}
