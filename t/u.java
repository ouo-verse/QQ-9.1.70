package t;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.InputStream;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f435154a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // t.o
        public n<String, AssetFileDescriptor> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // t.o
        @NonNull
        public n<String, ParcelFileDescriptor> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c implements o<String, InputStream> {
        @Override // t.o
        @NonNull
        public n<String, InputStream> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f435154a = nVar;
    }

    @Nullable
    private static Uri d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return e(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return e(str);
        }
        return parse;
    }

    private static Uri e(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull String str, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        Uri d16 = d(str);
        if (d16 != null && this.f435154a.handles(d16)) {
            return this.f435154a.a(d16, i3, i16, eVar);
        }
        return null;
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull String str) {
        return true;
    }
}
