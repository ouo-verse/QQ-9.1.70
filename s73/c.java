package s73;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\"8\u0010\n\u001a\u00020\u0004*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\"8\u0010\r\u001a\u00020\u0004*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\"<\u0010\u0013\u001a\u0004\u0018\u00010\u000e*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"<\u0010\u0019\u001a\u0004\u0018\u00010\u0014*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"<\u0010\u001c\u001a\u0004\u0018\u00010\u0014*\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000j\u0002`\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018*\"\u0010\u001e\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002`\u001d2\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u00a8\u0006\u001f"}, d2 = {"Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/wink/editor/view/video/WinkTavCutExtraParam;", "", "value", "c", "(Ljava/util/HashMap;)Z", h.F, "(Ljava/util/HashMap;Z)V", "needUpdateTransition", "b", "g", "needRecoveryTemplateFromDraft", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "a", "(Ljava/util/HashMap;)Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "f", "(Ljava/util/HashMap;Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;)V", "mediaPickerScene", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "d", "(Ljava/util/HashMap;)Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "i", "(Ljava/util/HashMap;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "pickTemplateMedialModel", "e", "j", "textFontMaterial", "Lkotlin/collections/HashMap;", "WinkTavCutExtraParam", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {
    @Nullable
    public static final MediaPickerScene a(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Object obj = hashMap.get(QQWinkConstants.MEDIA_PICKER_SCENE);
        if (obj instanceof MediaPickerScene) {
            return (MediaPickerScene) obj;
        }
        return null;
    }

    public static final boolean b(@NotNull HashMap<String, Object> hashMap) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Object obj = hashMap.get("need_recovery_template_from_draft");
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean c(@NotNull HashMap<String, Object> hashMap) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Object obj = hashMap.get("need_update_transition");
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Nullable
    public static final MetaMaterial d(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Object obj = hashMap.get(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (obj instanceof MetaMaterial) {
            return (MetaMaterial) obj;
        }
        return null;
    }

    @Nullable
    public static final MetaMaterial e(@NotNull HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Object obj = hashMap.get(QQWinkConstants.EDITOR_TEXT_MATERIAL);
        if (obj instanceof MetaMaterial) {
            return (MetaMaterial) obj;
        }
        return null;
    }

    public static final void f(@NotNull HashMap<String, Object> hashMap, @Nullable MediaPickerScene mediaPickerScene) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        if (mediaPickerScene != null) {
            hashMap.put(QQWinkConstants.MEDIA_PICKER_SCENE, mediaPickerScene);
        }
    }

    public static final void g(@NotNull HashMap<String, Object> hashMap, boolean z16) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        hashMap.put("need_recovery_template_from_draft", Boolean.valueOf(z16));
    }

    public static final void h(@NotNull HashMap<String, Object> hashMap, boolean z16) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        hashMap.put("need_update_transition", Boolean.valueOf(z16));
    }

    public static final void i(@NotNull HashMap<String, Object> hashMap, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        if (metaMaterial != null) {
            hashMap.put(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, metaMaterial);
        }
    }

    public static final void j(@NotNull HashMap<String, Object> hashMap, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        if (metaMaterial != null) {
            hashMap.put(QQWinkConstants.EDITOR_TEXT_MATERIAL, metaMaterial);
        }
    }
}
