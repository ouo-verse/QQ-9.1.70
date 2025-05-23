package t14;

import com.google.gson.annotations.SerializedName;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lt14/c;", "", "", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setEntrance", "(Ljava/lang/String;)V", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    @SerializedName("adelie_community_rule_entrance")
    @NotNull
    private String entrance = "https://act.qzone.qq.com/v2/vip/tx/p/52081_70e8a14a?enteranceId=moren&_wv=3&_wwv=513";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getEntrance() {
        return this.entrance;
    }
}
