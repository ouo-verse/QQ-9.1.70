package qr0;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lqr0/g;", "", "Landroid/os/Bundle;", "bundle", "", "e", "", "themeId", "", "c", "(Ljava/lang/String;)Z", EmojiManagerServiceProxy.EPID, "d", "b", "Ljava/lang/String;", "getCurThemeId", "()Ljava/lang/String;", "setCurThemeId", "(Ljava/lang/String;)V", "curThemeId", "a", "currentThemeId", "()Landroid/os/Bundle;", "currentThemeInfo", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f429342a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String curThemeId;

    static {
        g gVar = new g();
        f429342a = gVar;
        curThemeId = gVar.a();
    }

    g() {
    }

    private final void e(Bundle bundle) {
        bundle.putString("themeId", QQTheme.getNewSimpleThemeId());
    }

    @Nullable
    public final String a() {
        String string = b().getString("themeId");
        if (Intrinsics.areEqual("1001", string)) {
            string = QQTheme.getCurrentThemeId();
        }
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        curThemeId = string;
        return string;
    }

    @NotNull
    public final Bundle b() {
        boolean endsWith$default;
        boolean contains$default;
        int lastIndexOf$default;
        Bundle bundle = new Bundle();
        try {
            bundle.putString("themeId", "1000");
            bundle.putString("version", "0");
            String currentThemeResPath = SkinEngine.getInstances().getSkinRootPath();
            bundle.putString("themePath", currentThemeResPath);
            if (currentThemeResPath != null && currentThemeResPath.length() > 0) {
                String separator = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator, "separator");
                String str = null;
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(currentThemeResPath, separator, false, 2, null);
                if (endsWith$default) {
                    currentThemeResPath = currentThemeResPath.substring(0, currentThemeResPath.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(currentThemeResPath, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                Intrinsics.checkNotNullExpressionValue(currentThemeResPath, "currentThemeResPath");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) currentThemeResPath, (CharSequence) QQTheme.INTERNAL_THEME_DIR_810, false, 2, (Object) null);
                if (contains$default) {
                    Intrinsics.checkNotNullExpressionValue(currentThemeResPath, "currentThemeResPath");
                    Intrinsics.checkNotNullExpressionValue(separator, "separator");
                    Object[] array = new Regex(separator).split(currentThemeResPath, 0).toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    if (strArr.length >= 3) {
                        str = strArr[strArr.length - 3];
                    }
                    if (!TextUtils.isEmpty(str) && d(str)) {
                        bundle.putString("themeId", str);
                        bundle.putString("version", "20000000");
                        if (c(str)) {
                            e(bundle);
                        }
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(currentThemeResPath, "currentThemeResPath");
                    Intrinsics.checkNotNullExpressionValue(currentThemeResPath, "currentThemeResPath");
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) currentThemeResPath, "/", 0, false, 6, (Object) null);
                    String substring = currentThemeResPath.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    if (substring != null) {
                        Object[] array2 = new Regex("_").split(substring, 0).toArray(new String[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length == 2) {
                            bundle.putString("themeId", strArr2[0]);
                            bundle.putString("version", strArr2[1]);
                            if (c(strArr2[0])) {
                                e(bundle);
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e(ThemeUtil.TAG, 1, "getCurrentThemeInfo, exception:", e16);
        }
        return bundle;
    }

    public final boolean c(@Nullable String themeId) {
        return Intrinsics.areEqual("1001", themeId);
    }

    public final boolean d(@Nullable String epId) {
        try {
            Intrinsics.checkNotNull(epId);
            Integer.parseInt(epId);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
