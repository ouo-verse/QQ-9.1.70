package r73;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.utils.r;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.render.ComposeRenderLayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u53.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lr73/a;", "", "", "templatePath", "d", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "renderLayerHelper", "Lcom/tencent/videocut/model/MediaModel;", "newMediaModel", "", "c", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "DEFAULT_TEMPLATE_PATH", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f430927a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String DEFAULT_TEMPLATE_PATH = f.f438406s + File.separator + TemplateBean.TEMPLATE_JSON;

    a() {
    }

    @NotNull
    public final String a() {
        return DEFAULT_TEMPLATE_PATH;
    }

    @NotNull
    public final String b() {
        String str = DEFAULT_TEMPLATE_PATH;
        if (!FileUtils.fileExists(str)) {
            WinkExportUtils.g(str);
            r.b(BaseApplication.getContext(), "json/empty_template.json", str);
        }
        return str;
    }

    public final void c(@NotNull ComposeRenderLayer renderLayerHelper, @NotNull MediaModel newMediaModel) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(renderLayerHelper, "renderLayerHelper");
        Intrinsics.checkNotNullParameter(newMediaModel, "newMediaModel");
        Collection<StickerModel> values = renderLayerHelper.b().stickers.values();
        Collection<StickerModel> values2 = newMediaModel.stickers.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            StickerModel stickerModel = (StickerModel) obj;
            Collection<StickerModel> collection = values2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList2.add(((StickerModel) it.next()).id);
            }
            if (!arrayList2.contains(stickerModel.id)) {
                arrayList.add(obj);
            }
        }
        renderLayerHelper.f(arrayList);
    }

    @NotNull
    public final String d(@Nullable String templatePath) {
        boolean z16;
        List<String> split$default;
        boolean z17 = false;
        if (templatePath != null && templatePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            split$default = StringsKt__StringsKt.split$default((CharSequence) templatePath, new String[]{separator}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                if (z17) {
                    return str;
                }
                if (Intrinsics.areEqual(DKConfiguration.Directory.RESOURCES, str)) {
                    z17 = true;
                }
            }
            return "";
        }
        return "";
    }
}
