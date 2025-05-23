package zf0;

import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.imageloader.api.IECApngLoader;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lzf0/a;", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader;", "", "url", "Landroid/graphics/drawable/Drawable;", "getAnimDrawable", "src", "Lcom/tencent/ecommerce/base/imageloader/api/IECApngLoader$a;", "option", "filePath", "getApngDrawable", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECApngLoader {
    @Override // com.tencent.ecommerce.base.imageloader.api.IECApngLoader
    @Nullable
    public Drawable getAnimDrawable(@NotNull String url) {
        throw new NotImplementedError("Apng Loader \u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECApngLoader
    @Nullable
    public Drawable getApngDrawable(@NotNull String src, @NotNull IECApngLoader.a option, @NotNull String filePath) {
        return null;
    }
}
