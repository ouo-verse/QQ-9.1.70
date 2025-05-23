package wj4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J&\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lwj4/b;", "", "Landroid/content/Context;", "context", "Lwj4/a;", DownloadInfo.spKey_Config, "Landroid/graphics/Paint;", "c", "b", "", "name", "paint", "", "d", "Landroid/graphics/Bitmap;", "bgBitmap", "level", "a", "g", "f", "e", "Lwj4/a;", "newConfig", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f445740a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MedalDrawConfig newConfig;

    b() {
    }

    private final Paint b(Context context, MedalDrawConfig config) {
        Paint paint = new Paint();
        paint.setTextSize(x.c(context, config.getLevelTextSize()));
        paint.setColor(config.getLeveTextColor());
        if (config.getIsLevelBold()) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return paint;
    }

    private final Paint c(Context context, MedalDrawConfig config) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(x.c(context, config.getNameTextSize()));
        paint.setColor(config.getNameTextColor());
        if (config.getIsNameBold()) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return paint;
    }

    private final int d(String name, Paint paint) {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) paint.measureText("\u7231\u98d8\u96f6"), (int) paint.measureText(name));
        return coerceAtMost;
    }

    @NotNull
    public final Bitmap a(@NotNull Bitmap bgBitmap, int level, @NotNull String name, @NotNull MedalDrawConfig config) {
        Intrinsics.checkNotNullParameter(bgBitmap, "bgBitmap");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(config, "config");
        Context context = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Paint b16 = b(context, config);
        Paint c16 = c(context, config);
        int measureText = (int) c16.measureText(String.valueOf(level));
        int d16 = d(name, c16);
        int c17 = x.c(context, config.getLoveWidth());
        int c18 = x.c(context, config.getLoveLeftPadding());
        int i3 = c18 + ((c17 - measureText) / 2);
        int c19 = c18 + c17 + x.c(context, config.getLoveToNamePadding());
        int c26 = x.c(context, config.getTotalHeight());
        int c27 = x.c(context, config.getTotalWidth());
        int textSize = (int) b16.getTextSize();
        int textSize2 = (int) c16.getTextSize();
        int c28 = (c26 - ((c26 - textSize) / 2)) - x.c(context, config.getLevelHOffset());
        int c29 = (c26 - ((c26 - textSize2) / 2)) - x.c(context, config.getNameHOffset());
        Matrix matrix = new Matrix();
        matrix.postScale((c27 * 1.0f) / bgBitmap.getWidth(), (c26 * 1.0f) / bgBitmap.getHeight());
        Bitmap mutableBitmap = Bitmap.createBitmap(bgBitmap, 0, 0, bgBitmap.getWidth(), bgBitmap.getHeight(), matrix, true);
        if (!mutableBitmap.isMutable()) {
            mutableBitmap = mutableBitmap.copy(Bitmap.Config.ARGB_8888, true);
            AegisLogger.INSTANCE.e("room_info|MedalUtil", "createFansMedalBitmap", "Copy to create bitmap.");
        }
        Canvas canvas = new Canvas(mutableBitmap);
        canvas.drawText(String.valueOf(level), i3, c28, b16);
        canvas.drawText(name, c19 + (((c27 - c19) - d16) / 2), c29, c16);
        Intrinsics.checkNotNullExpressionValue(mutableBitmap, "mutableBitmap");
        return mutableBitmap;
    }

    @NotNull
    public final MedalDrawConfig e() {
        if (newConfig == null) {
            newConfig = MedalDrawConfig.INSTANCE.b();
        }
        MedalDrawConfig medalDrawConfig = newConfig;
        Intrinsics.checkNotNull(medalDrawConfig);
        return medalDrawConfig;
    }

    @NotNull
    public final MedalDrawConfig f() {
        if (newConfig == null) {
            newConfig = MedalDrawConfig.INSTANCE.c();
        }
        MedalDrawConfig medalDrawConfig = newConfig;
        Intrinsics.checkNotNull(medalDrawConfig);
        return medalDrawConfig;
    }

    @NotNull
    public final MedalDrawConfig g() {
        return new MedalDrawConfig(60.0f, 21.0f, 8.0f, 10.0f, 4.0f, 1.5f, 1.5f, 9.0f, true, Color.parseColor("#FE66C2"), 10.0f, true, Color.parseColor("#FFFFFF"));
    }
}
