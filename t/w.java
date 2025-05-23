package t;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.oskplayer.datasource.RawResourceDataSource;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f435158b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", RawResourceDataSource.RAW_RESOURCE_SCHEME, "content")));

    /* renamed from: a, reason: collision with root package name */
    private final c<Data> f435159a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f435160a;

        public a(ContentResolver contentResolver) {
            this.f435160a = contentResolver;
        }

        @Override // t.w.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f435160a, uri);
        }

        @Override // t.o
        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f435161a;

        public b(ContentResolver contentResolver) {
            this.f435161a = contentResolver;
        }

        @Override // t.w.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.f435161a, uri);
        }

        @Override // t.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f435162a;

        public d(ContentResolver contentResolver) {
            this.f435162a = contentResolver;
        }

        @Override // t.w.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.f435162a, uri);
        }

        @Override // t.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f435159a = cVar;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(uri), this.f435159a.a(uri));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        return f435158b.contains(uri.getScheme());
    }
}
