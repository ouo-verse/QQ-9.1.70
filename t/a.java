package t;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.tencent.oskplayer.datasource.AssetDataSource;
import java.io.InputStream;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final int f435073c = 22;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f435074a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC11264a<Data> f435075b;

    /* compiled from: P */
    /* renamed from: t.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC11264a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC11264a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f435076a;

        public b(AssetManager assetManager) {
            this.f435076a = assetManager;
        }

        @Override // t.a.InterfaceC11264a
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // t.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.f435076a, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c implements o<Uri, InputStream>, InterfaceC11264a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f435077a;

        public c(AssetManager assetManager) {
            this.f435077a = assetManager;
        }

        @Override // t.a.InterfaceC11264a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // t.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new a(this.f435077a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC11264a<Data> interfaceC11264a) {
        this.f435074a = assetManager;
        this.f435075b = interfaceC11264a;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(uri), this.f435075b.a(this.f435074a, uri.toString().substring(f435073c)));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !AssetDataSource.ASSET_SCHEME.equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
