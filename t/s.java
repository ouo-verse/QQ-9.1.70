package t;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f435147a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f435148b;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f435149a;

        public a(Resources resources) {
            this.f435149a = resources;
        }

        @Override // t.o
        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f435149a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f435150a;

        public b(Resources resources) {
            this.f435150a = resources;
        }

        @Override // t.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f435150a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f435151a;

        public c(Resources resources) {
            this.f435151a = resources;
        }

        @Override // t.o
        @NonNull
        public n<Integer, InputStream> b(r rVar) {
            return new s(this.f435151a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f435152a;

        public d(Resources resources) {
            this.f435152a = resources;
        }

        @Override // t.o
        @NonNull
        public n<Integer, Uri> b(r rVar) {
            return new s(this.f435152a, v.b());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f435148b = resources;
        this.f435147a = nVar;
    }

    @Nullable
    private Uri c(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f435148b.getResourcePackageName(num.intValue()) + '/' + this.f435148b.getResourceTypeName(num.intValue()) + '/' + this.f435148b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e16) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e16);
                return null;
            }
            return null;
        }
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Integer num, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        Uri c16 = c(num);
        if (c16 == null) {
            return null;
        }
        return this.f435147a.a(c16, i3, i16, eVar);
    }

    @Override // t.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Integer num) {
        return true;
    }
}
