package q54;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m64.c;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lq54/a;", "", "", "c", "d", "", "chatUid", "", "b", "Lm64/a;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "featureInfo", "", "functionType", "e", "Lcom/tencent/util/LRULinkedHashMap;", "Lm64/c;", "Lcom/tencent/util/LRULinkedHashMap;", "mChatFunctionCache", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LRULinkedHashMap<String, c> mChatFunctionCache = new LRULinkedHashMap<>(3);

    public a() {
        c();
    }

    private final void c() {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
        String value = from.decodeString("SLASH_STORAGE_FUNCTION", "");
        Intrinsics.checkNotNullExpressionValue(value, "value");
        if (value.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            try {
                JSONArray jSONArray = new JSONArray(value);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String jsonString = jSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
                    c cVar = new c(jsonString, true);
                    this.mChatFunctionCache.put(cVar.c(), cVar);
                }
            } catch (JSONException e16) {
                QLog.e("SlashStorageHelper", 1, "initChatRobotIdCache error ! e = " + e16.getMessage());
            }
        }
    }

    private final void d() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Map.Entry<String, c>> it = this.mChatFunctionCache.entrySet().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().getValue().j());
            }
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_GUILD)");
            from.encodeString("SLASH_STORAGE_FUNCTION", jSONArray.toString());
        } catch (JSONException e16) {
            QLog.e("SlashStorageHelper", 1, "saveChatFunctionCache error! e = " + e16.getMessage());
        }
    }

    @NotNull
    public final List<m64.a> a(@NotNull String chatUid) {
        List<m64.a> d16;
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        c cVar = this.mChatFunctionCache.get(chatUid);
        if (cVar == null || (d16 = cVar.d()) == null) {
            return new ArrayList();
        }
        return d16;
    }

    @NotNull
    public final List<String> b(@NotNull String chatUid) {
        List<String> e16;
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        c cVar = this.mChatFunctionCache.get(chatUid);
        if (cVar == null || (e16 = cVar.e()) == null) {
            return new ArrayList();
        }
        return e16;
    }

    public final void e(@NotNull String chatUid, @NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo featureInfo, int functionType) {
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(featureInfo, "featureInfo");
        c cVar = this.mChatFunctionCache.get(chatUid);
        if (cVar == null) {
            cVar = new c(chatUid);
        }
        String valueOf = String.valueOf(robotInfo.uin);
        String str = featureInfo.name;
        Intrinsics.checkNotNullExpressionValue(str, "featureInfo.name");
        cVar.k(valueOf, str, functionType);
        this.mChatFunctionCache.put(chatUid, cVar);
        d();
    }
}
