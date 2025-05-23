package x;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import com.tencent.oskplayer.datasource.RawResourceDataSource;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.f<Uri, Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f446809a;

    public e(Context context) {
        this.f446809a = context.getApplicationContext();
    }

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.f446809a.getPackageName())) {
            return this.f446809a;
        }
        try {
            return this.f446809a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            if (str.contains(this.f446809a.getPackageName())) {
                return this.f446809a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e16);
        }
    }

    @DrawableRes
    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e16) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e16);
        }
    }

    @DrawableRes
    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.f
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q<Drawable> b(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        Context d16 = d(uri, uri.getAuthority());
        return d.b(a.b(this.f446809a, d16, g(d16, uri)));
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.e eVar) {
        return uri.getScheme().equals(RawResourceDataSource.RAW_RESOURCE_SCHEME);
    }
}
