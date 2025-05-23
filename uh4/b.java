package uh4;

import android.graphics.Bitmap;
import android.view.WindowManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Luh4/b;", "", "", "a", UserInfo.SEX_FEMALE, "c", "()F", "g", "(F)V", "centerX", "b", "d", h.F, "centerY", "f", "j", "size", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "e", "()Landroid/graphics/Bitmap;", "i", "(Landroid/graphics/Bitmap;)V", "preDrawBitmap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static b f438989f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static b f438990g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float centerX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float centerY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float size;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap preDrawBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Luh4/b$a;", "", "Luh4/b;", "DEFAULT_TEAM", "Luh4/b;", "b", "()Luh4/b;", "setDEFAULT_TEAM", "(Luh4/b;)V", "DEFAULT_EXPAND_HALL", "a", "setDEFAULT_EXPAND_HALL", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uh4.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f438990g;
        }

        @NotNull
        public final b b() {
            return b.f438989f;
        }

        Companion() {
        }
    }

    static {
        WindowManager windowManager;
        WindowManager windowManager2 = null;
        b bVar = new b();
        Object systemService = BaseApplication.context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        if (windowManager != null) {
            bVar.centerY = (windowManager.getDefaultDisplay().getHeight() - fh4.b.d(60)) - fh4.b.d(32);
            bVar.centerX = (windowManager.getDefaultDisplay().getWidth() - fh4.b.d(1)) - fh4.b.d(47);
        }
        bVar.size = fh4.b.d(46);
        f438989f = bVar;
        b bVar2 = new b();
        Object systemService2 = BaseApplication.context.getSystemService("window");
        if (systemService2 instanceof WindowManager) {
            windowManager2 = (WindowManager) systemService2;
        }
        if (windowManager2 != null) {
            bVar2.centerY = (windowManager2.getDefaultDisplay().getHeight() - fh4.b.d(60)) - fh4.b.d(32);
            bVar2.centerX = (windowManager2.getDefaultDisplay().getWidth() - fh4.b.d(1)) - fh4.b.d(47);
        }
        bVar2.size = fh4.b.d(46);
        f438990g = bVar2;
    }

    /* renamed from: c, reason: from getter */
    public final float getCenterX() {
        return this.centerX;
    }

    /* renamed from: d, reason: from getter */
    public final float getCenterY() {
        return this.centerY;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Bitmap getPreDrawBitmap() {
        return this.preDrawBitmap;
    }

    /* renamed from: f, reason: from getter */
    public final float getSize() {
        return this.size;
    }

    public final void g(float f16) {
        this.centerX = f16;
    }

    public final void h(float f16) {
        this.centerY = f16;
    }

    public final void i(@Nullable Bitmap bitmap) {
        this.preDrawBitmap = bitmap;
    }

    public final void j(float f16) {
        this.size = f16;
    }
}
