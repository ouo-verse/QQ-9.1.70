package ud1;

import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019\u00a8\u0006&"}, d2 = {"Lud1/b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "f", "toString", "", "d", "Z", "e", "()Z", "setShowGameRank", "(Z)V", "showGameRank", "", "I", "()I", "setGameRankPageType", "(I)V", "gameRankPageType", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setGameRankH5Url", "(Ljava/lang/String;)V", "gameRankH5Url", h.F, "c", "setGameRankHippyPageUrl", "gameRankHippyPageUrl", "i", "b", "setGameRankHippyPageErrorUrl", "gameRankHippyPageErrorUrl", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ud1.b, reason: from toString */
/* loaded from: classes12.dex */
public final class GameRankConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showGameRank;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int gameRankPageType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameRankH5Url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameRankHippyPageUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String gameRankHippyPageErrorUrl;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getGameRankH5Url() {
        return this.gameRankH5Url;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getGameRankHippyPageErrorUrl() {
        return this.gameRankHippyPageErrorUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getGameRankHippyPageUrl() {
        return this.gameRankHippyPageUrl;
    }

    /* renamed from: d, reason: from getter */
    public final int getGameRankPageType() {
        return this.gameRankPageType;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getShowGameRank() {
        return this.showGameRank;
    }

    public final void f(@NotNull String content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("GameRankConfig", 1, "parse config: " + content);
        try {
            JSONObject optJSONObject = new JSONObject(content).optJSONObject("gameRankConfig");
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "configRootJson.optJSONObject(CONFIG_GAME_RANK)");
            if (optJSONObject.optInt("showGameRankEntrance") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.showGameRank = z16;
            this.gameRankPageType = optJSONObject.optInt("pageType", 0);
            this.gameRankH5Url = optJSONObject.optString("h5Url");
            this.gameRankHippyPageUrl = optJSONObject.optString("hippyPageUrl");
            this.gameRankHippyPageErrorUrl = optJSONObject.optString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
        } catch (Exception e16) {
            QLog.e("GameRankConfig", 1, "parse error:", e16);
        }
    }

    @NotNull
    public String toString() {
        return "GameRankConfig(showGameRank=" + this.showGameRank + ", gameRankPageType=" + this.gameRankPageType + ", gameRankH5Url=" + this.gameRankH5Url + ", gameRankHippyPageUrl=" + this.gameRankHippyPageUrl + ", gameRankHippyPageErrorUrl=" + this.gameRankHippyPageErrorUrl + ')';
    }
}
