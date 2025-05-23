package u;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import t.n;
import t.o;
import t.r;

/* compiled from: P */
@RequiresApi(29)
/* loaded from: classes.dex */
public final class d<DataT> implements n<Uri, DataT> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f437976a;

    /* renamed from: b, reason: collision with root package name */
    private final n<File, DataT> f437977b;

    /* renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f437978c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<DataT> f437979d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f437980a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<DataT> f437981b;

        a(Context context, Class<DataT> cls) {
            this.f437980a = context;
            this.f437981b = cls;
        }

        @Override // t.o
        @NonNull
        public final n<Uri, DataT> b(@NonNull r rVar) {
            return new d(this.f437980a, rVar.d(File.class, this.f437981b), rVar.d(Uri.class, this.f437981b), this.f437981b);
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: u.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C11316d<DataT> implements com.bumptech.glide.load.data.d<DataT> {
        private static final String[] G = {"_data"};
        private final com.bumptech.glide.load.e C;
        private final Class<DataT> D;
        private volatile boolean E;

        @Nullable
        private volatile com.bumptech.glide.load.data.d<DataT> F;

        /* renamed from: d, reason: collision with root package name */
        private final Context f437982d;

        /* renamed from: e, reason: collision with root package name */
        private final n<File, DataT> f437983e;

        /* renamed from: f, reason: collision with root package name */
        private final n<Uri, DataT> f437984f;

        /* renamed from: h, reason: collision with root package name */
        private final Uri f437985h;

        /* renamed from: i, reason: collision with root package name */
        private final int f437986i;

        /* renamed from: m, reason: collision with root package name */
        private final int f437987m;

        C11316d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i3, int i16, com.bumptech.glide.load.e eVar, Class<DataT> cls) {
            this.f437982d = context.getApplicationContext();
            this.f437983e = nVar;
            this.f437984f = nVar2;
            this.f437985h = uri;
            this.f437986i = i3;
            this.f437987m = i16;
            this.C = eVar;
            this.D = cls;
        }

        @Nullable
        private n.a<DataT> c() throws FileNotFoundException {
            boolean isExternalStorageLegacy;
            Uri uri;
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            if (isExternalStorageLegacy) {
                return this.f437983e.a(f(this.f437985h), this.f437986i, this.f437987m, this.C);
            }
            if (e()) {
                uri = MediaStore.setRequireOriginal(this.f437985h);
            } else {
                uri = this.f437985h;
            }
            return this.f437984f.a(uri, this.f437986i, this.f437987m, this.C);
        }

        @Nullable
        private com.bumptech.glide.load.data.d<DataT> d() throws FileNotFoundException {
            n.a<DataT> c16 = c();
            if (c16 != null) {
                return c16.f435125c;
            }
            return null;
        }

        private boolean e() {
            if (this.f437982d.checkSelfPermission(QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION) == 0) {
                return true;
            }
            return false;
        }

        @NonNull
        private File f(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = ContactsMonitor.query(this.f437982d.getContentResolver(), uri, G, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        query.close();
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th5) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th5;
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.D;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> d16 = d();
                if (d16 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f437985h));
                    return;
                }
                this.F = d16;
                if (this.E) {
                    cancel();
                } else {
                    d16.b(priority, aVar);
                }
            } catch (FileNotFoundException e16) {
                aVar.c(e16);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.E = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.F;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.F;
            if (dVar != null) {
                dVar.cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f437976a = context.getApplicationContext();
        this.f437977b = nVar;
        this.f437978c = nVar2;
        this.f437979d = cls;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<DataT> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(uri), new C11316d(this.f437976a, this.f437977b, this.f437978c, uri, i3, i16, eVar, this.f437979d));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29 && q.b.b(uri)) {
            return true;
        }
        return false;
    }
}
