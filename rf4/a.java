package rf4;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.timi.game.api.remoteres.BizId;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u001a&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\"\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/remoteres/BizId;", "bizId", "", WadlProxyConsts.RES_MD5, "resPath", "c", "d", "a", "b", "Ljava/lang/String;", "DEF_REMOTE_RES_DIR", "DEF_REMOTE_RES_TEMP_DIR", "timi-game-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final String f431416a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f431417b;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qqlive");
        String str = File.separator;
        sb5.append(str);
        sb5.append("remote_res");
        f431416a = sb5.toString();
        f431417b = "qqlive" + str + FaceUtil.IMG_TEMP;
    }

    @NotNull
    public static final String a(@NotNull Context context, @NotNull BizId bizId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(f431416a);
        sb5.append(str);
        sb5.append(d(bizId));
        return sb5.toString();
    }

    @NotNull
    public static final String b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getFilesDir().getAbsolutePath() + File.separator + f431417b;
    }

    @NotNull
    public static final String c(@NotNull Context context, @NotNull BizId bizId, @NotNull String resMd5, @NotNull String resPath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(resMd5, "resMd5");
        Intrinsics.checkNotNullParameter(resPath, "resPath");
        String a16 = a(context, bizId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a16);
        String str = File.separator;
        sb5.append(str);
        sb5.append(resMd5);
        sb5.append(str);
        sb5.append(resPath);
        return sb5.toString();
    }

    private static final String d(BizId bizId) {
        String name = bizId.name();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = name.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
