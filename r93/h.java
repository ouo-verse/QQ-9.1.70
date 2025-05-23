package r93;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicDataSerializable;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J@\u0010\u0013\u001a\u00020\u000b2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J0\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u001e"}, d2 = {"Lr93/h;", "", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "Landroid/os/Bundle;", "bundle", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfoList", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "", "d", "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "bigTailParams", "b", "g", tl.h.F, "e", "f", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f430993a = new h();

    h() {
    }

    private final boolean a(WinkEditDataWrapper winkEditDataWrapper, Bundle bundle, List<? extends LocalMediaInfo> localMediaInfoList) {
        Object firstOrNull;
        MetaMaterial aiTemplate;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) winkEditDataWrapper.getEditDatas());
        WinkEditData winkEditData = (WinkEditData) firstOrNull;
        if (winkEditData != null && (aiTemplate = winkEditData.getAiTemplate()) != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO);
            hashMap.put(WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_TAB, "2");
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID, com.tencent.mobileqq.wink.editor.c.t(aiTemplate));
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, aiTemplate.f30533id);
            hashMap.put(WinkPublishMediaRecord.WINK_EDITOR_MAGIC_STUDIO, aiTemplate.f30533id);
            bundle.putSerializable("third_party_extend_map", hashMap);
            f430993a.b(localMediaInfoList, hashMap);
            bundle.putString("taguin", com.tencent.mobileqq.wink.editor.c.D0(aiTemplate));
            bundle.putString("tagtitle", com.tencent.mobileqq.wink.editor.c.C0(aiTemplate));
            return true;
        }
        return false;
    }

    private final void b(List<? extends LocalMediaInfo> localMediaInfoList, HashMap<String, String> bigTailParams) {
        if (localMediaInfoList != null) {
            Iterator<T> it = localMediaInfoList.iterator();
            while (it.hasNext()) {
                e93.i.s((LocalMediaInfo) it.next()).put("third_party_extend_map", bigTailParams);
            }
        }
    }

    private final void d(BasePartFragment hostFragment, Bundle bundle, List<? extends LocalMediaInfo> localMediaInfoList, WinkEditDataWrapper winkEditDataWrapper) {
        WinkEditorViewModel winkEditorViewModel = (WinkEditorViewModel) hostFragment.getViewModel(WinkEditorViewModel.class);
        if (g() && winkEditorViewModel != null && bundle != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            boolean z16 = false;
            Map<String, MetaMaterial> templateMaterialMap = winkEditDataWrapper.getEditDatas().get(0).getTemplateMaterialMap();
            if (winkEditorViewModel.getEditMode() == WinkEditorViewModel.EditMode.Image) {
                if (a(winkEditDataWrapper, bundle, localMediaInfoList)) {
                    return;
                }
                if (winkEditDataWrapper.getEditDatas().get(0).isAIElimination()) {
                    bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_EVENT);
                    bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, QQWinkConstants.QZONE_SHARE_VALUE_ELIMINATE_SCHEMA);
                    return;
                }
                if (templateMaterialMap == null || templateMaterialMap.isEmpty()) {
                    z16 = true;
                }
                if (!z16) {
                    hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, WinkPublishMediaRecord.WINK_REPORT_TYPE_IMAGE_TEMPLATE);
                    for (Map.Entry<String, MetaMaterial> entry : templateMaterialMap.entrySet()) {
                        String key = entry.getKey();
                        MetaMaterial value = entry.getValue();
                        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, key);
                        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_NAME, value.showName);
                        bundle.putString("taguin", com.tencent.mobileqq.wink.editor.c.D0(value));
                        bundle.putString("tagtitle", com.tencent.mobileqq.wink.editor.c.C0(value));
                    }
                    bundle.putSerializable("third_party_extend_map", hashMap);
                    b(localMediaInfoList, hashMap);
                    return;
                }
            }
            if (winkEditorViewModel.getIsFromMagicStudio()) {
                hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO);
                hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID, bundle.getString(QQWinkConstants.MAGIC_STUDIO_STYLE_ID, ""));
                hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, bundle.getString(QQWinkConstants.MAGIC_STUDIO_MATERIAL_ID, ""));
                if (bundle.getBoolean("aigc_img_mode", true)) {
                    hashMap.put(WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_TAB, "2");
                } else {
                    hashMap.put(WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_TAB, "0");
                }
                hashMap.put("xsj_generate_effect", bundle.getString("xsj_generate_effect", ""));
                hashMap.put("xsj_again_generate", bundle.getString("xsj_again_generate", ""));
                bundle.putSerializable("third_party_extend_map", hashMap);
                b(localMediaInfoList, hashMap);
                return;
            }
            String captureMaterialId = winkEditorViewModel.getCaptureMaterialId();
            String captureMaterialName = winkEditorViewModel.getCaptureMaterialName();
            if (TextUtils.isEmpty(captureMaterialId) && TextUtils.isEmpty(captureMaterialName)) {
                if (winkEditorViewModel.getIsFromTemplateLib() && templateMaterialMap != null) {
                    hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, "libTemplate");
                    for (Map.Entry<String, MetaMaterial> entry2 : templateMaterialMap.entrySet()) {
                        String key2 = entry2.getKey();
                        MetaMaterial value2 = entry2.getValue();
                        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, key2);
                        hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_NAME, com.tencent.mobileqq.wink.editor.c.a0(value2));
                    }
                    bundle.putSerializable("third_party_extend_map", hashMap);
                    b(localMediaInfoList, hashMap);
                    return;
                }
                return;
            }
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, "meterial");
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, captureMaterialId);
            hashMap.put(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_NAME, captureMaterialName);
            bundle.putSerializable("third_party_extend_map", hashMap);
            b(localMediaInfoList, hashMap);
        }
    }

    public final void c(@NotNull BasePartFragment hostFragment, @Nullable Bundle bundle, @Nullable List<? extends LocalMediaInfo> localMediaInfoList, @NotNull WinkEditDataWrapper winkEditDataWrapper) {
        String str;
        ArrayList<String> pathList;
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        WinkEditorViewModel winkEditorViewModel = (WinkEditorViewModel) hostFragment.getViewModel(WinkEditorViewModel.class);
        if (g() && winkEditorViewModel != null && bundle != null) {
            Object obj = WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE);
            if (obj instanceof String) {
                bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, (String) obj);
            }
            Object obj2 = WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE);
            if (obj2 instanceof Integer) {
                bundle.putInt(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE, ((Number) obj2).intValue());
            }
            ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
            boolean z16 = true;
            if (!editDatas.isEmpty()) {
                MosaicDataSerializable mosaicData = editDatas.get(0).getMosaicData();
                if (mosaicData == null || (pathList = mosaicData.getPathList()) == null || !(!pathList.isEmpty())) {
                    z16 = false;
                }
                String str2 = "1";
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_MOSAIC_CHANGED, str);
                if (!editDatas.get(0).isAIElimination()) {
                    str2 = "0";
                }
                bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED, str2);
            }
            d(hostFragment, bundle, localMediaInfoList, winkEditDataWrapper);
        }
    }

    @NotNull
    public final String e() {
        return "qzone_magic_studio";
    }

    @NotNull
    public final String f() {
        return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + "_PrivateProtoQzoneMagicNext";
    }

    public final boolean g() {
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (companion.l()) {
            return companion.d().u("QZONE");
        }
        return false;
    }

    public final boolean h(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return Intrinsics.areEqual("QZONE", bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME));
    }

    public final boolean i(@Nullable Activity activity) {
        return activity instanceof QQWinkActivity;
    }
}
