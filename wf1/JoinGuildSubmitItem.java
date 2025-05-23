package wf1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ;\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\"\u0004\b\u0019\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lwf1/e;", "Lwf1/b;", "", "questionId", "", "question", "questionHeadTips", "guildId", "", "enable", "b", "toString", "hashCode", "", "other", "equals", "d", "I", "g", "()I", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", h.F, "Z", "()Z", "(Z)V", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf1.e, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class JoinGuildSubmitItem extends b {

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
    private final String guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enable;

    public /* synthetic */ JoinGuildSubmitItem(int i3, String str, String str2, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "\u63d0\u4ea4" : str, (i16 & 4) != 0 ? "" : str2, str3, (i16 & 16) != 0 ? false : z16);
    }

    public static /* synthetic */ JoinGuildSubmitItem c(JoinGuildSubmitItem joinGuildSubmitItem, int i3, String str, String str2, String str3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = joinGuildSubmitItem.getQuestionId();
        }
        if ((i16 & 2) != 0) {
            str = joinGuildSubmitItem.getQuestion();
        }
        String str4 = str;
        if ((i16 & 4) != 0) {
            str2 = joinGuildSubmitItem.getQuestionHeadTips();
        }
        String str5 = str2;
        if ((i16 & 8) != 0) {
            str3 = joinGuildSubmitItem.guildId;
        }
        String str6 = str3;
        if ((i16 & 16) != 0) {
            z16 = joinGuildSubmitItem.enable;
        }
        return joinGuildSubmitItem.b(i3, str4, str5, str6, z16);
    }

    @Override // wf1.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getQuestion() {
        return this.question;
    }

    @NotNull
    public final JoinGuildSubmitItem b(int questionId, @NotNull String question, @NotNull String questionHeadTips, @NotNull String guildId, boolean enable) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(questionHeadTips, "questionHeadTips");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return new JoinGuildSubmitItem(questionId, question, questionHeadTips, guildId, enable);
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinGuildSubmitItem)) {
            return false;
        }
        JoinGuildSubmitItem joinGuildSubmitItem = (JoinGuildSubmitItem) other;
        if (getQuestionId() == joinGuildSubmitItem.getQuestionId() && Intrinsics.areEqual(getQuestion(), joinGuildSubmitItem.getQuestion()) && Intrinsics.areEqual(getQuestionHeadTips(), joinGuildSubmitItem.getQuestionHeadTips()) && Intrinsics.areEqual(this.guildId, joinGuildSubmitItem.guildId) && this.enable == joinGuildSubmitItem.enable) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public String getQuestionHeadTips() {
        return this.questionHeadTips;
    }

    /* renamed from: g, reason: from getter */
    public int getQuestionId() {
        return this.questionId;
    }

    public final void h(boolean z16) {
        this.enable = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int questionId = ((((((getQuestionId() * 31) + getQuestion().hashCode()) * 31) + getQuestionHeadTips().hashCode()) * 31) + this.guildId.hashCode()) * 31;
        boolean z16 = this.enable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return questionId + i3;
    }

    @NotNull
    public String toString() {
        return "JoinGuildSubmitItem(questionId=" + getQuestionId() + ", question=" + getQuestion() + ", questionHeadTips=" + getQuestionHeadTips() + ", guildId=" + this.guildId + ", enable=" + this.enable + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildSubmitItem(int i3, @NotNull String question, @NotNull String questionHeadTips, @NotNull String guildId, boolean z16) {
        super(i3, question, questionHeadTips, null);
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(questionHeadTips, "questionHeadTips");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.questionId = i3;
        this.question = question;
        this.questionHeadTips = questionHeadTips;
        this.guildId = guildId;
        this.enable = z16;
    }
}
