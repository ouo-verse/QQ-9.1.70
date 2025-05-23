package zf0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016JK\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\rj\u0002`\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lzf0/b;", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader;", "Landroid/content/Context;", "context", "", "path", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/ecommerce/base/imageloader/api/IECImageLoader$b;", "option", "", "load", "cleanCache", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "fetchDrawable", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECImageLoader {
    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void cleanCache() {
        throw new NotImplementedError("SDK \u56fe\u7247\u52a0\u8f7d\u5668\u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void fetchDrawable(@NotNull Context context, @NotNull String path, @Nullable IECImageLoader.ImageLoaderOption option, @NotNull Function1<? super Drawable, Unit> callback) {
        throw new NotImplementedError("SDK \u56fe\u7247\u52a0\u8f7d\u5668\u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");
    }

    @Override // com.tencent.ecommerce.base.imageloader.api.IECImageLoader
    public void load(@NotNull Context context, @NotNull String path, @NotNull ImageView imageView, @NotNull IECImageLoader.ImageLoaderOption option) {
        throw new NotImplementedError("SDK \u56fe\u7247\u52a0\u8f7d\u5668\u4e3a\u5fc5\u8981\u63a5\u53e3\uff0c\u8bf7\u7b2c\u4e09\u65b9\u5bbf\u4e3b\u5b9e\u73b0\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528\u3002");
    }
}
