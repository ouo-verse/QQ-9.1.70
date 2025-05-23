package yb3;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002J\u001b\u0010\u0016\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lyb3/d;", "", "Lyb3/c;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/config/ai;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "Lorg/json/JSONObject;", "jsonObject", "e", "f", "c", "Lorg/json/JSONArray;", "profileBtnList", "g", "Lyb3/b;", "tabConfig", "btnList", "a", "", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lyb3/c;", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f450028a = new d();

    d() {
    }

    private final void a(b tabConfig, JSONArray btnList) {
        JSONArray jSONArray = btnList;
        if (jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = btnList.length();
        int i3 = 0;
        while (i3 < length) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            int optInt = optJSONObject.optInt("btn_id");
            int optInt2 = optJSONObject.optInt("btn_index");
            String optString = optJSONObject.optString("btn_text");
            Intrinsics.checkNotNullExpressionValue(optString, "bottomObject.optString(Z\u2026opiaConfigConst.BTN_TEXT)");
            String optString2 = optJSONObject.optString("btn_select_icon");
            String optString3 = optJSONObject.optString("btn_default_icon");
            boolean optBoolean = optJSONObject.optBoolean("btn_default_select");
            boolean optBoolean2 = optJSONObject.optBoolean("btn_jump_enable");
            boolean optBoolean3 = optJSONObject.optBoolean("btn_show");
            String optString4 = optJSONObject.optString("btn_jump_target");
            Intrinsics.checkNotNullExpressionValue(optString4, "bottomObject.optString(Z\u2026figConst.BTN_JUMP_TARGET)");
            String optString5 = optJSONObject.optString("btn_toast");
            Intrinsics.checkNotNullExpressionValue(optString5, "bottomObject.optString(Z\u2026piaConfigConst.BTN_TOAST)");
            arrayList.add(new ZootopiaTabItemConfig(optInt, optInt2, optString, optString2, optString3, optBoolean, optBoolean2, optBoolean3, optString4, optString5));
            i3++;
            jSONArray = btnList;
        }
        tabConfig.c(arrayList);
    }

    private final void c(c config, JSONObject jsonObject) {
        JSONObject optJSONObject = jsonObject.optJSONObject("zootopia_buttons_config");
        if (optJSONObject == null) {
            QLog.e("ZootopiaConfigParser", 1, "btnModuleConfig \u914d\u7f6e\u5b57\u6bb5 error :", "zootopia_buttons_config");
        } else {
            a(config.getZootopiaBottomTabConfig(), optJSONObject.optJSONArray("bottom_buttons"));
            g(config, optJSONObject.optJSONArray("profile_buttons"));
        }
    }

    private final void d(c config, ai item) {
        if (TextUtils.isEmpty(item.f202268b)) {
            QLog.d("ZootopiaConfigParser", 1, "content is : ", item.f202268b);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(item.f202268b);
            c(config, jSONObject);
            f(config, jSONObject);
            e(config, jSONObject);
        } catch (JSONException e16) {
            QLog.e("ZootopiaConfigParser", 1, "parse error :", e16.getMessage());
        }
    }

    private final void e(c config, JSONObject jsonObject) {
        JSONObject optJSONObject = jsonObject.optJSONObject("redpack");
        if (optJSONObject == null) {
            QLog.e("ZootopiaConfigParser", 1, "redPacketModuleConfig \u914d\u7f6e\u5b57\u6bb5 error :", "redpack");
            return;
        }
        g zootopiaRedPacketConfig = config.getZootopiaRedPacketConfig();
        String optString = optJSONObject.optString("uploadUrlPrefix", "https://hongbao.meta.qq.com");
        Intrinsics.checkNotNullExpressionValue(optString, "redPacketModuleConfig.op\u2026EFAULT_UPLOAD_URL_PREFIX)");
        zootopiaRedPacketConfig.e(optString);
        g zootopiaRedPacketConfig2 = config.getZootopiaRedPacketConfig();
        String optString2 = optJSONObject.optString("coverUrlPrefix", "https://wuji-1258344701.file.myqcloud.com/redpackage/prod");
        Intrinsics.checkNotNullExpressionValue(optString2, "redPacketModuleConfig.op\u2026DEFAULT_COVER_URL_PREFIX)");
        zootopiaRedPacketConfig2.c(optString2);
        g zootopiaRedPacketConfig3 = config.getZootopiaRedPacketConfig();
        String optString3 = optJSONObject.optString("coverUrlTestPrefix", "https://wuji-1258344701.file.myqcloud.com/redpackage/test");
        Intrinsics.checkNotNullExpressionValue(optString3, "redPacketModuleConfig.op\u2026LT_COVER_URL_TEST_PREFIX)");
        zootopiaRedPacketConfig3.d(optString3);
    }

    private final void f(c config, JSONObject jsonObject) {
        JSONObject optJSONObject = jsonObject.optJSONObject("update_system_config");
        if (optJSONObject == null) {
            QLog.e("ZootopiaConfigParser", 1, "uploadModuleConfig \u914d\u7f6e\u5b57\u6bb5 error :", "update_system_config");
            return;
        }
        String uploadDefaultUrl = optJSONObject.optString("upload_default_url");
        if (!TextUtils.isEmpty(uploadDefaultUrl)) {
            i zootopiaUpgradeConfig = config.getZootopiaUpgradeConfig();
            Intrinsics.checkNotNullExpressionValue(uploadDefaultUrl, "uploadDefaultUrl");
            zootopiaUpgradeConfig.a(uploadDefaultUrl);
        }
    }

    private final void g(c config, JSONArray profileBtnList) {
        if (profileBtnList == null) {
            return;
        }
        config.getZootopiaProfileCustomerBottomConfig().a().clear();
        int length = profileBtnList.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = profileBtnList.optJSONObject(i3);
            config.getZootopiaProfileCustomerBottomConfig().a().add(new f(optJSONObject.getInt("btn_id"), optJSONObject.getBoolean("btn_show")));
        }
    }

    @NotNull
    public final c b(@NotNull ai[] confFiles) {
        boolean z16;
        Intrinsics.checkNotNullParameter(confFiles, "confFiles");
        c cVar = new c();
        if (confFiles.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("ZootopiaConfigParser", 1, "config is null", cVar);
            return cVar;
        }
        for (ai aiVar : confFiles) {
            f450028a.d(cVar, aiVar);
        }
        return cVar;
    }
}
