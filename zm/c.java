package zm;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017JP\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u0007H\u0002JP\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u0007H\u0002JP\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u0007H\u0002JX\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002JZ\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u0007H\u0002JX\u0010\u0014\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u00072\u0006\u0010\u000f\u001a\u00020\u000eJF\u0010\u0015\u001a\u00020\u00062>\u0010\t\u001a:\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004j$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\b`\u0007\u00a8\u0006\u0018"}, d2 = {"Lzm/c;", "", "Landroid/content/Intent;", "intent", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "gameplayList", "", "a", "c", "b", "", "isEditPage", "e", "function", "functionValue", "d", "g", "f", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f452770a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"zm/c$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        a() {
        }
    }

    c() {
    }

    public final String f(ArrayList<HashMap<String, Object>> gameplayList) {
        Intrinsics.checkNotNullParameter(gameplayList, "gameplayList");
        String json = new Gson().toJson(gameplayList, new a().getType());
        QLog.i("QZPublishGamePlayRecordUtil", 1, "parseAddPublisherGamePlayData  json = " + json);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        return json;
    }

    public final void g(Intent intent, ArrayList<HashMap<String, Object>> gameplayList, boolean isEditPage) {
        Intrinsics.checkNotNullParameter(gameplayList, "gameplayList");
        if (intent == null) {
            return;
        }
        e(intent, gameplayList, isEditPage);
        b(intent, gameplayList);
        c(intent, gameplayList);
        a(intent, gameplayList);
    }

    private final void a(Intent intent, ArrayList<HashMap<String, Object>> gameplayList) {
        d(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE, String.valueOf(intent.getIntExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUT_SIZE, 0)), gameplayList);
        d(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE), gameplayList);
        d(WinkDaTongReportConstant.ElementParamKey.XSJ_MOSAIC_CHANGED, intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_MOSAIC_CHANGED), gameplayList);
        d(WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED, intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_ELIMINATE_CHANGED), gameplayList);
    }

    private final void b(Intent intent, ArrayList<HashMap<String, Object>> gameplayList) {
        ArrayList arrayList;
        try {
            arrayList = (ArrayList) intent.getSerializableExtra(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA);
        } catch (Exception e16) {
            QLog.e("QZPublishGamePlayRecordUtil", 1, "parseAddPublisherGamePlayData editWinkList e = " + e16);
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it5 = ((ArrayList) it.next()).iterator();
            while (it5.hasNext()) {
                WinkPublishMediaRecord winkPublishMediaRecord = (WinkPublishMediaRecord) it5.next();
                if (Intrinsics.areEqual("template", winkPublishMediaRecord.mediaType) || Intrinsics.areEqual("filter", winkPublishMediaRecord.mediaType) || Intrinsics.areEqual("sticker", winkPublishMediaRecord.mediaType) || Intrinsics.areEqual("text", winkPublishMediaRecord.mediaType)) {
                    List<String> list = winkPublishMediaRecord.mediaId;
                    if (!(list == null || list.isEmpty())) {
                        Iterator<String> it6 = winkPublishMediaRecord.mediaId.iterator();
                        while (it6.hasNext()) {
                            d("mediaId", it6.next(), gameplayList);
                        }
                    }
                }
            }
        }
    }

    private final void c(Intent intent, ArrayList<HashMap<String, Object>> gameplayList) {
        d(QQWinkConstants.IS_IMAGE_MODEL, String.valueOf(intent.getBooleanExtra(QQWinkConstants.IS_IMAGE_MODEL, false)), gameplayList);
    }

    private final void e(Intent intent, ArrayList<HashMap<String, Object>> gameplayList, boolean isEditPage) {
        HashMap hashMap;
        List split$default;
        try {
            hashMap = (HashMap) intent.getSerializableExtra("third_party_extend_map");
        } catch (Exception e16) {
            QLog.e("QZPublishGamePlayRecordUtil", 1, "parseAddPublisherGamePlayData thirdPartyMap e = " + e16);
            hashMap = null;
        }
        if (hashMap != null) {
            String str = (String) hashMap.get(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE);
            if (Intrinsics.areEqual(str, WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO)) {
                CharSequence charSequence = (CharSequence) hashMap.get(WinkPublishMediaRecord.WINK_EDITOR_MAGIC_STUDIO);
                if (true ^ (charSequence == null || charSequence.length() == 0)) {
                    str = WinkPublishMediaRecord.WINK_EDITOR_MAGIC_STUDIO;
                } else if (isEditPage) {
                    return;
                }
            }
            d(WinkPublishMediaRecord.QZONE_PUBLISH_TYPE, str, gameplayList);
            d(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID, (String) hashMap.get(WinkPublishMediaRecord.QZONE_PUBLISH_STYLE_ID), gameplayList);
            d(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID, (String) hashMap.get(WinkPublishMediaRecord.QZONE_PUBLISH_MATERIAL_ID), gameplayList);
            String str2 = (String) hashMap.get("xsj_generate_effect");
            if (str2 != null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{WinkPublishMediaRecord.QZONE_MAGIC_STUDIO_GENERATE_EFFECT_SEPARATOR}, false, 0, 6, (Object) null);
                Iterator it = split$default.iterator();
                while (it.hasNext()) {
                    d("xsj_generate_effect", (String) it.next(), gameplayList);
                }
            }
            d("xsj_again_generate", (String) hashMap.get("xsj_again_generate"), gameplayList);
        }
    }

    private final void d(String function, String functionValue, ArrayList<HashMap<String, Object>> gameplayList) {
        List listOf;
        HashMap<String, Object> next;
        Object obj;
        if (functionValue == null || functionValue.length() == 0) {
            return;
        }
        QLog.i("QZPublishGamePlayRecordUtil", 1, "addPublisherGamePlayEntry  | function = " + function + " | functionValue = " + functionValue);
        try {
            Iterator<HashMap<String, Object>> it = gameplayList.iterator();
            do {
                if (it.hasNext()) {
                    next = it.next();
                    obj = next.get("function");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                } else {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("function", function);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(functionValue);
                    hashMap.put("function_value", new ArrayList(listOf));
                    gameplayList.add(hashMap);
                    return;
                }
            } while (!TextUtils.equals((String) obj, function));
            Object obj2 = next.get("function_value");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            TypeIntrinsics.asMutableList(obj2).add(functionValue);
        } catch (Exception e16) {
            QLog.e("QZPublishGamePlayRecordUtil", 1, "addPublisherGamePlayEntry  e = " + e16);
        }
    }
}
