package u01;

import android.app.Application;
import android.content.res.AssetManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lu01/a;", "Lu01/d;", "Ljava/io/InputStream;", "a", "Landroid/content/res/AssetManager;", "Landroid/content/res/AssetManager;", "assetManager", "", "b", "Ljava/lang/String;", "path", "<init>", "(Ljava/lang/String;)V", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AssetManager assetManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String path;

    public a(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
        AssetManager assets = application.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "RFWApplication.getApplication().assets");
        this.assetManager = assets;
    }

    @Override // u01.d
    @NotNull
    public InputStream a() throws IOException {
        InputStream open = this.assetManager.open(this.path);
        Intrinsics.checkNotNullExpressionValue(open, "assetManager.open(path)");
        return open;
    }
}
