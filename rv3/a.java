package rv3;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lrv3/a;", "", "Lcom/tencent/qqnt/avatar/business/bitmap/a;", "bitmapJointBuilder", "", "b", "", "Landroid/graphics/Bitmap;", "bitmaps", "c", "(Lcom/tencent/qqnt/avatar/business/bitmap/a;[Landroid/graphics/Bitmap;)V", "a", "<init>", "()V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f432564a = new a();

    a() {
    }

    private final void b(com.tencent.qqnt.avatar.business.bitmap.a bitmapJointBuilder) {
        c(bitmapJointBuilder, bitmapJointBuilder.g().c(bitmapJointBuilder.i(), bitmapJointBuilder.e(), bitmapJointBuilder.d(), bitmapJointBuilder.c()));
    }

    private final void c(com.tencent.qqnt.avatar.business.bitmap.a b16, Bitmap[] bitmaps) {
        Bitmap b17 = b16.g().b(b16.i(), b16.b(), b16.e(), b16.f(), bitmaps);
        sv3.a h16 = b16.h();
        if (h16 != null) {
            h16.a(b17);
        }
    }

    public final void a(@NotNull com.tencent.qqnt.avatar.business.bitmap.a bitmapJointBuilder) {
        Intrinsics.checkNotNullParameter(bitmapJointBuilder, "bitmapJointBuilder");
        bitmapJointBuilder.j(bitmapJointBuilder.g().a(bitmapJointBuilder.i(), bitmapJointBuilder.e(), bitmapJointBuilder.d()));
        sv3.a h16 = bitmapJointBuilder.h();
        if (h16 != null) {
            h16.onStart();
        }
        b(bitmapJointBuilder);
    }
}
