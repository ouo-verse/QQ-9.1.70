package yz3;

import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a {
    @JvmDefault
    public static boolean a(IMediaShowStrategyProvider iMediaShowStrategyProvider) {
        return false;
    }

    @JvmDefault
    public static boolean b(IMediaShowStrategyProvider iMediaShowStrategyProvider) {
        return true;
    }

    @JvmDefault
    public static boolean c(IMediaShowStrategyProvider iMediaShowStrategyProvider, @NotNull RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        return false;
    }

    @JvmDefault
    public static boolean d(IMediaShowStrategyProvider iMediaShowStrategyProvider) {
        return true;
    }

    @JvmDefault
    public static boolean e(IMediaShowStrategyProvider iMediaShowStrategyProvider) {
        return true;
    }
}
