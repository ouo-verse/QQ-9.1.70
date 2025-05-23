package wr;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.b;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends fr.e {
    public static final String I;
    private SharedPreferences E;

    /* renamed from: d, reason: collision with root package name */
    public volatile AtomicInteger f446093d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    public final Object f446094e = new Object[0];

    /* renamed from: f, reason: collision with root package name */
    public final Queue<DoodleEmojiItem> f446095f = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public DoodleEmojiItem f446096h = null;

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, DoodleEmojiItem> f446097i = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public final List<DoodleEmojiItem> f446098m = new CopyOnWriteArrayList();
    public String C = "";
    public final int D = 50;
    protected List<Location> F = new ArrayList();
    j G = null;
    LbsManager.b H = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: wr.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11503a implements FileFilter {
        C11503a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().startsWith("emoji_folder_");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".bmp") || str.endsWith(".apng");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c extends i {
        c(DoodleEmojiItem doodleEmojiItem) {
            super(doodleEmojiItem);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResult(DoodleEmojiItem doodleEmojiItem) {
            a aVar;
            super.onResult(doodleEmojiItem);
            hd0.c.a("DoodleEmojiManager", "startDownload again");
            synchronized (a.this.f446094e) {
                aVar = a.this;
                aVar.f446096h = null;
            }
            aVar.C();
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class d implements LbsManager.b {
        d() {
        }

        @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.b
        public void a(boolean z16, com.tencent.biz.qqstory.model.lbs.a aVar) {
            a aVar2;
            j jVar;
            hd0.c.a("DoodleEmojiManager", "requestPoiFaces onLbsUpdate.");
            if (z16 && aVar != null && (jVar = (aVar2 = a.this).G) != null) {
                aVar2.w(aVar.f94079b, aVar.f94078a, jVar);
            } else {
                hd0.c.g("DoodleEmojiManager", "onLbsUpdate failed.");
            }
            LbsManager lbsManager = (LbsManager) com.tencent.biz.qqstory.model.i.c(9);
            if (lbsManager != null) {
                lbsManager.i(this);
            }
            a.this.G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class f implements FilenameFilter {
        f() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".bmp") || str.endsWith(".apng");
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class g extends com.tencent.biz.qqstory.base.a {
        public final long C;

        /* renamed from: e, reason: collision with root package name */
        public final DoodleEmojiItem f446105e;

        /* renamed from: f, reason: collision with root package name */
        public final int f446106f;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f446107h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f446108i;

        /* renamed from: m, reason: collision with root package name */
        public final long f446109m;

        public g(DoodleEmojiItem doodleEmojiItem, int i3, boolean z16, long j3, long j16) {
            this.f446105e = doodleEmojiItem;
            this.f446106f = i3;
            this.f446107h = z16;
            this.f446109m = j3;
            this.C = j16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class h extends com.tencent.biz.qqstory.base.a {

        /* renamed from: e, reason: collision with root package name */
        public final int f446110e;

        /* renamed from: f, reason: collision with root package name */
        public final List<bd0.a> f446111f;

        public h(int i3, List<bd0.a> list) {
            this.f446110e = i3;
            this.f446111f = new ArrayList(list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface j {
        void a(int i3, List<bd0.a> list);
    }

    static {
        String str = vc0.a.f441370j + "emoji";
        I = str;
        t(str);
    }

    public a() {
        BaseApplicationImpl b16 = QQStoryContext.h().b();
        if (b16 != null) {
            this.E = b16.getSharedPreferences("qqstory_emoji", 4);
            return;
        }
        throw new IllegalArgumentException("Context should not be null");
    }

    private static void A(a aVar, String str, String str2) {
        aVar.B("emoji_pack_name_" + str, str2);
    }

    private boolean f() {
        return this.f446093d.get() == 2;
    }

    protected static String i(String str) {
        return I + File.separator + "emoji_folder_" + str;
    }

    private static String j(File file) {
        return file.getName().substring(13);
    }

    protected static String k(String str) {
        return I + File.separator + "emoji_zip_" + str;
    }

    public static String l(a aVar, String str) {
        return aVar.p("emoji_pack_url_" + str, "");
    }

    public static String m(a aVar, String str) {
        return aVar.p("emoji_pack_config_" + str, "");
    }

    public static String n(a aVar, String str) {
        return aVar.p("emoji_pack_md5_" + str, "");
    }

    public static String o(a aVar, String str) {
        return aVar.p("emoji_pack_name_" + str, "");
    }

    private static void t(String str) {
        File file = new File(str);
        if (file.isFile()) {
            hd0.c.t("DoodleEmojiManager", "delete file : " + file.delete());
        }
        if (file.exists()) {
            return;
        }
        hd0.c.t("DoodleEmojiManager", "create folder : " + file.mkdirs());
    }

    private static void x(a aVar, String str, String str2) {
        aVar.B("emoji_pack_url_" + str, str2);
    }

    private static void y(a aVar, String str, String str2) {
        aVar.B("emoji_pack_config_" + str, str2);
    }

    public static void z(a aVar, String str, String str2) {
        aVar.B("emoji_pack_md5_" + str, str2);
    }

    public void B(String str, String str2) {
        this.E.edit().putString(str, str2).apply();
    }

    protected void C() {
        hd0.c.a("DoodleEmojiManager", "startDownload");
        synchronized (this.f446094e) {
            if (this.f446096h == null) {
                DoodleEmojiItem poll = this.f446095f.poll();
                this.f446096h = poll;
                if (poll != null) {
                    hd0.c.a("DoodleEmojiManager", "downloader startDownload : " + this.f446096h);
                    Bosses.get().postJob(new c(this.f446096h));
                }
            } else {
                hd0.c.a("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.f446096h);
            }
        }
    }

    public boolean g(String str, boolean z16) {
        if (!f()) {
            hd0.c.v("DoodleEmojiManager", "downloadEmojiPack init state = %d", Integer.valueOf(this.f446093d.get()));
        }
        if (str != null) {
            DoodleEmojiItem doodleEmojiItem = this.f446097i.get(str);
            if (doodleEmojiItem == null) {
                hd0.c.t("DoodleEmojiManager", "can not find pack item by id " + str);
                return false;
            }
            File file = new File(i(doodleEmojiItem.pack_id));
            if (s(file) && !z16) {
                hd0.c.t("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
                doodleEmojiItem.setLocalEmojiFolderPath(file.getPath());
                com.tencent.biz.qqstory.base.c.a().dispatch(new g(doodleEmojiItem, 0, true, 0L, 0L));
                return true;
            }
            if (!TextUtils.isEmpty(doodleEmojiItem.getLocalEmojiFolderPath())) {
                hd0.c.t("DoodleEmojiManager", "local emoji folder is missing");
                doodleEmojiItem.setLocalEmojiFolderPath(null);
            }
            if (TextUtils.isEmpty(doodleEmojiItem.download_url)) {
                hd0.c.t("DoodleEmojiManager", "can not start download because of empty download-url is found");
                return false;
            }
            synchronized (this.f446094e) {
                if (!this.f446095f.contains(doodleEmojiItem)) {
                    this.f446095f.offer(doodleEmojiItem);
                    hd0.c.a("DoodleEmojiManager", "downloadEmojiPack pack " + str + " enqueue");
                } else {
                    hd0.c.a("DoodleEmojiManager", "downloadEmojiPack pack " + str + " is already in pending list");
                }
            }
            C();
            return true;
        }
        throw new IllegalArgumentException("pack id should not be null");
    }

    public List<DoodleEmojiItem> h() {
        if (!f()) {
            hd0.c.a("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
            return Collections.EMPTY_LIST;
        }
        return this.f446098m;
    }

    public String p(String str, String str2) {
        return this.E.getString(str, str2);
    }

    public void q(List<DoodleEmojiItem> list) {
        AppInterface c16 = c();
        boolean z16 = false;
        if (c16 != null && ((IFeatureRuntimeService) c16.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_media_pre_download_sticker_emoji_on_startup", false)) {
            z16 = true;
        }
        v(list, z16);
    }

    public void u() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String decodeString = from.decodeString("pre_download_sticker_emoji_package_id", null);
        if (TextUtils.isEmpty(decodeString)) {
            return;
        }
        from.removeKey("pre_download_sticker_emoji_package_id");
        g(decodeString, false);
    }

    public void w(int i3, int i16, j jVar) {
        com.tencent.biz.qqstory.channel.b.a().b(new cd0.d(i3, i16), new e(new WeakReference(jVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class e implements b.InterfaceC0941b<cd0.d, dd0.d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f446103d;

        e(WeakReference weakReference) {
            this.f446103d = weakReference;
        }

        @Override // com.tencent.biz.qqstory.channel.b.InterfaceC0941b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void v(cd0.d dVar, dd0.d dVar2, ErrorMessage errorMessage) {
            if (dVar2 == null) {
                j jVar = (j) this.f446103d.get();
                if (jVar != null) {
                    jVar.a(errorMessage.errorCode, Collections.EMPTY_LIST);
                    return;
                }
                return;
            }
            j jVar2 = (j) this.f446103d.get();
            if (jVar2 != null) {
                jVar2.a(0, dVar2.f393630c);
            } else {
                hd0.c.k("DoodleEmojiManager", "requestPoiFaces callback is null");
            }
        }
    }

    @Override // fr.e
    public void d() {
        LbsManager.b bVar;
        LbsManager lbsManager = (LbsManager) com.tencent.biz.qqstory.model.i.c(9);
        if (lbsManager != null && (bVar = this.H) != null) {
            lbsManager.i(bVar);
        }
        this.G = null;
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static class i extends SimpleJob<DoodleEmojiItem> implements wc0.a {

        /* renamed from: d, reason: collision with root package name */
        private final wc0.b f446112d;

        /* renamed from: e, reason: collision with root package name */
        private final DoodleEmojiItem f446113e;

        /* renamed from: f, reason: collision with root package name */
        protected long f446114f;

        /* renamed from: h, reason: collision with root package name */
        private long f446115h;

        public i(DoodleEmojiItem doodleEmojiItem) {
            super("DownloadAndUnZipJob");
            this.f446115h = 0L;
            if (doodleEmojiItem != null) {
                wc0.c cVar = new wc0.c();
                this.f446112d = cVar;
                cVar.b(this);
                this.f446113e = doodleEmojiItem;
                return;
            }
            throw new IllegalArgumentException("doodleEmojiItem should not be null");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DoodleEmojiItem doInBackground(JobContext jobContext, Void... voidArr) {
            wc0.b bVar = this.f446112d;
            DoodleEmojiItem doodleEmojiItem = this.f446113e;
            bVar.a(doodleEmojiItem.download_url, a.k(doodleEmojiItem.pack_id), 0L);
            return this.f446113e;
        }

        @Override // wc0.a
        public void l(String str, String str2) {
            hd0.c.a("DoodleEmojiManager", "onDownloadStart : url = " + str + ", path = " + str2);
            this.f446114f = SystemClock.uptimeMillis();
        }

        @Override // wc0.a
        public void onProgress(String str, long j3, long j16) {
            DoodleEmojiItem doodleEmojiItem = this.f446113e;
            if (!TextUtils.equals(doodleEmojiItem.download_url, str)) {
                hd0.c.t("DoodleEmojiManager", "DownloadListener onProgress error : " + doodleEmojiItem);
                hd0.c.t("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + str);
                return;
            }
            if (j3 > this.f446115h + (j16 / 10)) {
                hd0.c.s("DoodleEmojiManager", "DownloadListener onProgress " + j3 + " / " + j16);
                com.tencent.biz.qqstory.base.c.a().dispatch(new g(doodleEmojiItem, 0, false, j16, j3));
                this.f446115h = j3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [int] */
        /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v6 */
        @Override // wc0.a
        public void q(String str, int i3) {
            int unZipFolder;
            String str2 = i3;
            DoodleEmojiItem doodleEmojiItem = this.f446113e;
            if (str2 == 0) {
                String k3 = a.k(doodleEmojiItem.pack_id);
                String i16 = a.i(doodleEmojiItem.pack_id);
                hd0.c.a("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + k3);
                hd0.c.a("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + i16);
                try {
                    try {
                        com.tencent.biz.qqstory.utils.d.v(i16);
                    } catch (Exception e16) {
                        hd0.c.v("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", i16, e16);
                    }
                    unZipFolder = ZipUtils.unZipFolder(k3, i16);
                } catch (Throwable th5) {
                    th = th5;
                    str2 = k3;
                    new File(str2).delete();
                    throw th;
                }
                try {
                    if (unZipFolder == 0) {
                        id0.a.k("edit_video", "face_download_timecost", 0, 0, doodleEmojiItem.pack_id, (SystemClock.uptimeMillis() - this.f446114f) + "");
                        id0.a.k("edit_video", "face_download_success", 0, 0, doodleEmojiItem.pack_id);
                        hd0.c.k("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
                        doodleEmojiItem.setLocalEmojiFolderPath(i16);
                        new File(i16).setLastModified(System.currentTimeMillis());
                        str2 = k3;
                        com.tencent.biz.qqstory.base.c.a().dispatch(new g(doodleEmojiItem, i3, true, 0L, 0L));
                    } else {
                        str2 = k3;
                        hd0.c.t("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
                        com.tencent.biz.qqstory.base.c.a().dispatch(new g(doodleEmojiItem, unZipFolder, false, 0L, 0L));
                        id0.a.k("edit_video", "face_download_success", 0, unZipFolder, doodleEmojiItem.pack_id);
                    }
                    new File((String) str2).delete();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    new File(str2).delete();
                    throw th;
                }
            }
            hd0.c.g("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + ((int) str2) + ", url = " + str);
            com.tencent.biz.qqstory.base.c.a().dispatch(new g(doodleEmojiItem, i3, true, 0L, 0L));
            id0.a.k("edit_video", "face_download_success", 0, str2, doodleEmojiItem.pack_id);
        }
    }

    private static boolean s(File file) {
        File[] listFiles;
        return file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new f())) != null && listFiles.length > 0;
    }

    public void r(boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initLocalPackages, doodle emoji path : ");
        String str = I;
        sb5.append(str);
        hd0.c.a("DoodleEmojiManager", sb5.toString());
        if (!this.f446093d.compareAndSet(0, 1)) {
            if (z16) {
                u();
                return;
            }
            return;
        }
        a aVar = (a) fr.f.c(14);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new C11503a());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    File[] listFiles2 = file2.listFiles(new b());
                    if (listFiles2 != null && listFiles2.length > 0) {
                        String j3 = j(file2);
                        DoodleEmojiItem doodleEmojiItem = new DoodleEmojiItem(j3, l(aVar, j3), o(aVar, j3), null, m(aVar, j3), n(aVar, j3));
                        doodleEmojiItem.setLocalEmojiFolderPath(file2.getPath());
                        this.f446097i.put(j3, doodleEmojiItem);
                        hd0.c.a("DoodleEmojiManager", "load local emoji pack : " + doodleEmojiItem);
                    } else {
                        try {
                            com.tencent.biz.qqstory.utils.d.v(file2.getPath());
                            hd0.c.t("DoodleEmojiManager", "find empty local emoji folder : " + file2.getName() + ", delete it");
                        } catch (Exception e16) {
                            hd0.c.t("DoodleEmojiManager", "find empty local emoji folder : " + file2.getName() + ", delete failed : " + e16);
                        }
                    }
                }
            }
        } else {
            hd0.c.t("DoodleEmojiManager", "local emoji folder is empty");
        }
        v(((com.tencent.aelight.camera.aioeditor.capture.paster.e) fr.f.c(1)).f(), z16);
        this.f446093d.set(2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x001b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v(List<DoodleEmojiItem> list, boolean z16) {
        DoodleEmojiItem doodleEmojiItem;
        DoodleEmojiItem doodleEmojiItem2;
        String str;
        DoodleEmojiItem doodleEmojiItem3;
        if (list == null) {
            return;
        }
        a aVar = (a) fr.f.c(14);
        ArrayList arrayList = new ArrayList(list.size());
        for (DoodleEmojiItem doodleEmojiItem4 : list) {
            if (doodleEmojiItem4.type != 1 || (doodleEmojiItem3 = this.f446097i.get(doodleEmojiItem4.pack_id)) == null) {
                doodleEmojiItem = doodleEmojiItem4;
            } else {
                String localEmojiFolderPath = doodleEmojiItem3.getLocalEmojiFolderPath();
                if (!TextUtils.equals(doodleEmojiItem3.md5, doodleEmojiItem4.md5)) {
                    hd0.c.c("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", doodleEmojiItem3.md5, doodleEmojiItem4.md5);
                    try {
                        com.tencent.biz.qqstory.utils.d.v(localEmojiFolderPath);
                        doodleEmojiItem = doodleEmojiItem4;
                        try {
                            g gVar = new g(doodleEmojiItem4, 0, false, 0L, 0L);
                            gVar.f446108i = true;
                            com.tencent.biz.qqstory.base.c.a().dispatch(gVar);
                        } catch (Exception e16) {
                            e = e16;
                            hd0.c.v("DoodleEmojiManager", "remove folder : %s failed. error: %s .", localEmojiFolderPath, e);
                            str = null;
                            doodleEmojiItem2 = doodleEmojiItem;
                            doodleEmojiItem2.setLocalEmojiFolderPath(str);
                            x(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.icon);
                            A(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.name);
                            y(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.config);
                            z(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.md5);
                            this.f446097i.put(doodleEmojiItem2.pack_id, doodleEmojiItem2);
                            if (!arrayList.contains(doodleEmojiItem2)) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        doodleEmojiItem = doodleEmojiItem4;
                    }
                } else {
                    doodleEmojiItem2 = doodleEmojiItem4;
                    str = localEmojiFolderPath;
                    doodleEmojiItem2.setLocalEmojiFolderPath(str);
                    x(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.icon);
                    A(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.name);
                    y(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.config);
                    z(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.md5);
                    this.f446097i.put(doodleEmojiItem2.pack_id, doodleEmojiItem2);
                    if (!arrayList.contains(doodleEmojiItem2)) {
                        arrayList.add(doodleEmojiItem2);
                    }
                }
            }
            str = null;
            doodleEmojiItem2 = doodleEmojiItem;
            doodleEmojiItem2.setLocalEmojiFolderPath(str);
            x(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.icon);
            A(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.name);
            y(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.config);
            z(aVar, doodleEmojiItem2.pack_id, doodleEmojiItem2.md5);
            this.f446097i.put(doodleEmojiItem2.pack_id, doodleEmojiItem2);
            if (!arrayList.contains(doodleEmojiItem2)) {
            }
        }
        synchronized (this.f446098m) {
            this.f446098m.clear();
            this.f446098m.addAll(arrayList);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DoodleEmojiManager", 2, "paster config processResponse " + this.f446098m.size());
        }
        if (arrayList.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleEmojiManager", 2, "processEmojiList  pack_id = ", ((DoodleEmojiItem) arrayList.get(0)).pack_id, ", needDownloadFirstEmojiPack = ", Boolean.valueOf(z16));
            }
            if (z16) {
                g(((DoodleEmojiItem) arrayList.get(0)).pack_id, false);
            } else {
                QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("pre_download_sticker_emoji_package_id", ((DoodleEmojiItem) arrayList.get(0)).pack_id);
            }
        }
    }

    @Override // fr.e
    public void e() {
    }
}
