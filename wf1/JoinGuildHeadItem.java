package wf1;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwf1/d;", "Lwf1/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "()I", "questionId", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "question", "f", "c", "questionHeadTips", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf1.d, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class JoinGuildHeadItem extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int questionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String question;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String questionHeadTips;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProGuildInfo guildInfo;

    public /* synthetic */ JoinGuildHeadItem(int i3, String str, String str2, IGProGuildInfo iGProGuildInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, iGProGuildInfo);
    }

    @Override // wf1.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getQuestion() {
        return this.question;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public String getQuestionHeadTips() {
        return this.questionHeadTips;
    }

    /* renamed from: d, reason: from getter */
    public int getQuestionId() {
        return this.questionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinGuildHeadItem)) {
            return false;
        }
        JoinGuildHeadItem joinGuildHeadItem = (JoinGuildHeadItem) other;
        if (getQuestionId() == joinGuildHeadItem.getQuestionId() && Intrinsics.areEqual(getQuestion(), joinGuildHeadItem.getQuestion()) && Intrinsics.areEqual(getQuestionHeadTips(), joinGuildHeadItem.getQuestionHeadTips()) && Intrinsics.areEqual(this.guildInfo, joinGuildHeadItem.guildInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((getQuestionId() * 31) + getQuestion().hashCode()) * 31) + getQuestionHeadTips().hashCode()) * 31) + this.guildInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinGuildHeadItem(questionId=" + getQuestionId() + ", question=" + getQuestion() + ", questionHeadTips=" + getQuestionHeadTips() + ", guildInfo=" + this.guildInfo + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildHeadItem(int i3, @NotNull String question, @NotNull String questionHeadTips, @NotNull IGProGuildInfo guildInfo) {
        super(i3, question, questionHeadTips, null);
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(questionHeadTips, "questionHeadTips");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        this.questionId = i3;
        this.question = question;
        this.questionHeadTips = questionHeadTips;
        this.guildInfo = guildInfo;
    }
}
