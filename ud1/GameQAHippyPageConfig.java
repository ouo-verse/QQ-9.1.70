package ud1;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\u0018\u0000 !2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u0019\u0010\fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\f\u00a8\u0006\""}, d2 = {"Lud1/a;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "f", "toString", "d", "Ljava/lang/String;", "getHomepageUrl", "()Ljava/lang/String;", "setHomepageUrl", "(Ljava/lang/String;)V", "homepageUrl", "e", "c", "setMoreQuestionUrl", "moreQuestionUrl", "setQuestionUrl", "questionUrl", h.F, "a", "setAnswerUrl", "answerUrl", "i", "setQuestionErrorUrl", "questionErrorUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "setDomain", "domain", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ud1.a, reason: from toString */
/* loaded from: classes12.dex */
public final class GameQAHippyPageConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String homepageUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String moreQuestionUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String questionUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String answerUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String questionErrorUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String domain;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAnswerUrl() {
        return this.answerUrl;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getMoreQuestionUrl() {
        return this.moreQuestionUrl;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getQuestionErrorUrl() {
        return this.questionErrorUrl;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getQuestionUrl() {
        return this.questionUrl;
    }

    public final void f(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GameQAHippyPageConfig", 1, "parse config: " + content);
        try {
            JSONObject jSONObject = new JSONObject(content);
            this.homepageUrl = jSONObject.optString("homepageUrl");
            this.moreQuestionUrl = jSONObject.optString("moreQuestionUrl");
            this.questionUrl = jSONObject.optString("questionUrl");
            this.answerUrl = jSONObject.optString("answerUrl");
            this.questionErrorUrl = jSONObject.optString("questionErrorUrl");
            this.domain = jSONObject.optString("domain");
        } catch (Exception e16) {
            QLog.e("GameQAHippyPageConfig", 1, "parse error:", e16);
        }
    }

    @NotNull
    public String toString() {
        return "GameQAHippyPageConfig(homepageUrl=" + this.homepageUrl + ", moreQuestionUrl=" + this.moreQuestionUrl + ", questionUrl=" + this.questionUrl + ", answerUrl=" + this.answerUrl + ", questionErrorUrl=" + this.questionErrorUrl + ", domain=" + this.domain + ')';
    }
}
