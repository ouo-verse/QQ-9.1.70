package zs1;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dq;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0!\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u001f\u0010\u000eR(\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\t\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lzs1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errMsg", "b", "I", "()I", "setState", "(I)V", "state", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "getSecurity", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "setSecurity", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;)V", "security", "d", "setTipsContent", "tipsContent", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "e", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setGameModes", "(Ljava/util/ArrayList;)V", "gameModes", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Ljava/lang/String;Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zs1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildAuthGameBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String errMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int state;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private IGProSecurityResult security;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String tipsContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<dq> gameModes;

    public GuildAuthGameBean(@NotNull String errMsg, int i3, @Nullable IGProSecurityResult iGProSecurityResult, @NotNull String tipsContent, @NotNull ArrayList<dq> gameModes) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(tipsContent, "tipsContent");
        Intrinsics.checkNotNullParameter(gameModes, "gameModes");
        this.errMsg = errMsg;
        this.state = i3;
        this.security = iGProSecurityResult;
        this.tipsContent = tipsContent;
        this.gameModes = gameModes;
    }

    @NotNull
    public final ArrayList<dq> a() {
        return this.gameModes;
    }

    /* renamed from: b, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTipsContent() {
        return this.tipsContent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAuthGameBean)) {
            return false;
        }
        GuildAuthGameBean guildAuthGameBean = (GuildAuthGameBean) other;
        if (Intrinsics.areEqual(this.errMsg, guildAuthGameBean.errMsg) && this.state == guildAuthGameBean.state && Intrinsics.areEqual(this.security, guildAuthGameBean.security) && Intrinsics.areEqual(this.tipsContent, guildAuthGameBean.tipsContent) && Intrinsics.areEqual(this.gameModes, guildAuthGameBean.gameModes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.errMsg.hashCode() * 31) + this.state) * 31;
        IGProSecurityResult iGProSecurityResult = this.security;
        if (iGProSecurityResult == null) {
            hashCode = 0;
        } else {
            hashCode = iGProSecurityResult.hashCode();
        }
        return ((((hashCode2 + hashCode) * 31) + this.tipsContent.hashCode()) * 31) + this.gameModes.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildAuthGameBean(errMsg=" + this.errMsg + ", state=" + this.state + ", security=" + this.security + ", tipsContent=" + this.tipsContent + ", gameModes=" + this.gameModes + ")";
    }
}
