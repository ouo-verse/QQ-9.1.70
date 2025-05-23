package ud1;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u0000 02\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b\u0007\u0010$\"\u0004\b)\u0010&R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b,\u0010\f\u00a8\u00061"}, d2 = {"Lud1/e;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", h.F, "toString", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setBundleName", "(Ljava/lang/String;)V", "bundleName", "Lorg/json/JSONObject;", "e", "Lorg/json/JSONObject;", "f", "()Lorg/json/JSONObject;", "setOpenHippyInfo", "(Lorg/json/JSONObject;)V", "openHippyInfo", "g", "setOpenKuilyInfo", "openKuilyInfo", "", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "setForbiddenVersionList", "(Ljava/util/List;)V", "forbiddenVersionList", "i", "I", "b", "()I", "setDestroyDelay", "(I)V", "destroyDelay", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setHippyEngineLoadType", "hippyEngineLoadType", BdhLogUtil.LogTag.Tag_Conn, "setKuiklyPageName", AdMetricTag.Kuikly.PAGE_NAME, "<init>", "()V", "D", "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ud1.e, reason: from toString */
/* loaded from: classes12.dex */
public final class MetaDreamHippyConfig implements IConfigData {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private String kuiklyPageName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String bundleName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject openHippyInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject openKuilyInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<Integer> forbiddenVersionList = new ArrayList();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int destroyDelay = 3000;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int hippyEngineLoadType;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBundleName() {
        return this.bundleName;
    }

    /* renamed from: b, reason: from getter */
    public final int getDestroyDelay() {
        return this.destroyDelay;
    }

    @NotNull
    public final List<Integer> c() {
        return this.forbiddenVersionList;
    }

    /* renamed from: d, reason: from getter */
    public final int getHippyEngineLoadType() {
        return this.hippyEngineLoadType;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getKuiklyPageName() {
        return this.kuiklyPageName;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final JSONObject getOpenHippyInfo() {
        return this.openHippyInfo;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final JSONObject getOpenKuilyInfo() {
        return this.openKuilyInfo;
    }

    public final void h(@NotNull String content) {
        String str;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("MetaDreamHippyConfig", 1, "parse config: " + content);
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.bundleName = jSONObject.optString("bundleName");
            this.openHippyInfo = jSONObject.optJSONObject("openHippyInfo");
            this.openKuilyInfo = jSONObject.optJSONObject("openKuikyInfo");
            JSONArray optJSONArray = jSONObject.optJSONArray("forbiddenVersion");
            boolean z16 = false;
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    this.forbiddenVersionList.add(Integer.valueOf(optJSONArray.getInt(i3)));
                }
            }
            this.destroyDelay = jSONObject.optInt("destroyDelay", 3000);
            this.hippyEngineLoadType = jSONObject.optInt("hippyEnginePreloadType", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("kuiklyConfig");
            String str2 = null;
            if (optJSONObject != null) {
                str = optJSONObject.optString("pageName");
            } else {
                str = null;
            }
            this.kuiklyPageName = str;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (z16) {
                JSONObject jSONObject2 = this.openKuilyInfo;
                if (jSONObject2 != null) {
                    str2 = jSONObject2.optString("page_name");
                }
                this.kuiklyPageName = str2;
            }
        } catch (Exception e16) {
            QLog.e("MetaDreamHippyConfig", 1, "parse error:", e16);
        }
    }

    @NotNull
    public String toString() {
        return "MetaDreamHippyConfig(bundleName=" + this.bundleName + ", openHippyInfo=" + this.openHippyInfo + ", openKuilyInfo=" + this.openKuilyInfo + ", forbiddenVersionList=" + this.forbiddenVersionList + ", destroyDelay=" + this.destroyDelay + ", hippyEngineLoadType=" + this.hippyEngineLoadType + ", kuiklyPageName=" + this.kuiklyPageName + ')';
    }
}
