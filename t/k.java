package t;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.File;
import java.io.FileNotFoundException;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f435112a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f435113a;

        public a(Context context) {
            this.f435113a = context;
        }

        @Override // t.o
        @NonNull
        public n<Uri, File> b(r rVar) {
            return new k(this.f435113a);
        }
    }

    public k(Context context) {
        this.f435112a = context;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<File> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(uri), new b(this.f435112a, uri));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        return q.b.b(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements com.bumptech.glide.load.data.d<File> {

        /* renamed from: f, reason: collision with root package name */
        private static final String[] f435114f = {"_data"};

        /* renamed from: d, reason: collision with root package name */
        private final Context f435115d;

        /* renamed from: e, reason: collision with root package name */
        private final Uri f435116e;

        b(Context context, Uri uri) {
            this.f435115d = context;
            this.f435116e = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = ContactsMonitor.query(this.f435115d.getContentResolver(), this.f435116e, f435114f, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f435116e));
                return;
            }
            aVar.d(new File(str));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
