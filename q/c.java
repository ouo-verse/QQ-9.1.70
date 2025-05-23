package q;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* renamed from: d, reason: collision with root package name */
    private final Uri f428098d;

    /* renamed from: e, reason: collision with root package name */
    private final e f428099e;

    /* renamed from: f, reason: collision with root package name */
    private InputStream f428100f;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class a implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f428101b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f428102a;

        a(ContentResolver contentResolver) {
            this.f428102a = contentResolver;
        }

        @Override // q.d
        public Cursor a(Uri uri) {
            return ContactsMonitor.query(this.f428102a, MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f428101b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class b implements d {

        /* renamed from: b, reason: collision with root package name */
        private static final String[] f428103b = {"_data"};

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f428104a;

        b(ContentResolver contentResolver) {
            this.f428104a = contentResolver;
        }

        @Override // q.d
        public Cursor a(Uri uri) {
            return ContactsMonitor.query(this.f428104a, MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f428103b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f428098d = uri;
        this.f428099e = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.c(context).j().g(), dVar, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static c d(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c e(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream f() throws FileNotFoundException {
        int i3;
        InputStream d16 = this.f428099e.d(this.f428098d);
        if (d16 != null) {
            i3 = this.f428099e.a(this.f428098d);
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            return new g(d16, i3);
        }
        return d16;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream f16 = f();
            this.f428100f = f16;
            aVar.d(f16);
        } catch (FileNotFoundException e16) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e16);
            }
            aVar.c(e16);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        InputStream inputStream = this.f428100f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
