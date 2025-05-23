package xh0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b \u0018\u0000 -2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014\u00a8\u0006."}, d2 = {"Lxh0/a;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "I", "getRespCode", "()I", "a", "(I)V", "respCode", "", "e", "Ljava/lang/String;", "getRespMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "respMsg", "f", "Z", "isQualified", "()Z", "setQualified", "(Z)V", h.F, "isSample", "setSample", "i", "getToken", "setToken", "token", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getToastText", "setToastText", "toastText", BdhLogUtil.LogTag.Tag_Conn, "getToastRefLink", "setToastRefLink", "toastRefLink", "<init>", "()V", "D", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int respCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String respMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isQualified;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String isSample = "1";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String token = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String toastText = "";

    /* renamed from: C, reason: from kotlin metadata */
    private String toastRefLink = "";

    public final void a(int i3) {
        this.respCode = i3;
    }

    public final void b(String str) {
        this.respMsg = str;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECCheckQualifiedResp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        boolean optBoolean = data.optBoolean("qualified", false);
        this.isQualified = optBoolean;
        if (optBoolean) {
            this.token = data.optString("token", "");
            return true;
        }
        JSONObject optJSONObject = data.optJSONObject("toast");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.toastText = optJSONObject.optString("toast_text");
        this.toastRefLink = optJSONObject.optString("ref_link");
        return true;
    }
}
