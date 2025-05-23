package t74;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lt74/m;", "", "Landroid/content/res/AssetManager;", "mgr", "", "path", "Landroid/graphics/Typeface;", "g", "d", "c", "e", "f", "b", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mTypefaceCache", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f435564a = new m();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Typeface> mTypefaceCache = new ConcurrentHashMap<>();

    m() {
    }

    private final Typeface g(AssetManager mgr, String path) {
        Typeface newTypeface;
        ConcurrentHashMap<String, Typeface> concurrentHashMap = mTypefaceCache;
        Typeface typeface = concurrentHashMap.get(path);
        if (typeface != null) {
            return typeface;
        }
        try {
            newTypeface = Typeface.createFromAsset(mgr, path);
            Intrinsics.checkNotNullExpressionValue(newTypeface, "newTypeface");
            concurrentHashMap.put(path, newTypeface);
        } catch (Exception e16) {
            QLog.e("TypefaceUtils", 1, "Exception occurred when creating typeface: ", e16);
            newTypeface = Typeface.DEFAULT;
        }
        Typeface typeface2 = newTypeface;
        Intrinsics.checkNotNullExpressionValue(typeface2, "try {\n            val ne\u2026ypeface.DEFAULT\n        }");
        return typeface2;
    }

    public final Typeface a(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    public final Typeface b(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    public final Typeface c(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    public final Typeface d(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    public final Typeface e(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }

    public final Typeface f(AssetManager mgr) {
        Intrinsics.checkNotNullParameter(mgr, "mgr");
        return g(mgr, "fonts/DIN-NextLT-Pro-QQ.ttf");
    }
}
