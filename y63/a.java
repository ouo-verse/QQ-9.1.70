package y63;

import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002\u00a8\u0006\u0007"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", "Lkotlin/collections/ArrayList;", "", "", "", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    @NotNull
    public static final Map<Integer, String> a(@NotNull ArrayList<MosaicData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        HashMap hashMap = new HashMap();
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            hashMap.put(Integer.valueOf(i3), ((MosaicData) obj).getResultPath());
            i3 = i16;
        }
        return hashMap;
    }
}
