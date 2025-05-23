package zd4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005J.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0007R<\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lzd4/d;", "", "", "templatePath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assetData", "", "c", "b", "a", "", "Ljava/util/Map;", "allAssetData", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, HashMap<String, String>> allAssetData = new LinkedHashMap();

    public final void a() {
        this.allAssetData.clear();
    }

    @Nullable
    public final HashMap<String, String> b(@NotNull String templatePath) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        return this.allAssetData.get(templatePath);
    }

    public final void c(@NotNull String templatePath, @NotNull HashMap<String, String> assetData) {
        Intrinsics.checkParameterIsNotNull(templatePath, "templatePath");
        Intrinsics.checkParameterIsNotNull(assetData, "assetData");
        if (this.allAssetData.get(templatePath) == null) {
            this.allAssetData.put(templatePath, new HashMap<>());
        }
        HashMap<String, String> hashMap = this.allAssetData.get(templatePath);
        if (hashMap != null) {
            hashMap.putAll(assetData);
        }
    }
}
