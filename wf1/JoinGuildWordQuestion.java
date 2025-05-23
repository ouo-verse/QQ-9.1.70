package wf1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u0015\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwf1/f;", "Lwf1/b;", "", "f", "", "toString", "", "hashCode", "", "other", "equals", "d", "I", "e", "()I", "questionId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "question", "questionHeadTips", "g", "c", "hint", h.F, "b", "(Ljava/lang/String;)V", "answer", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf1.f, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class JoinGuildWordQuestion extends b {

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
    private final String hint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String answer;

    public /* synthetic */ JoinGuildWordQuestion(int i3, String str, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? "" : str2, str3, (i16 & 16) != 0 ? "" : str4);
    }

    @Override // wf1.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getQuestion() {
        return this.question;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getHint() {
        return this.hint;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public String getQuestionHeadTips() {
        return this.questionHeadTips;
    }

    /* renamed from: e, reason: from getter */
    public int getQuestionId() {
        return this.questionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinGuildWordQuestion)) {
            return false;
        }
        JoinGuildWordQuestion joinGuildWordQuestion = (JoinGuildWordQuestion) other;
        if (getQuestionId() == joinGuildWordQuestion.getQuestionId() && Intrinsics.areEqual(getQuestion(), joinGuildWordQuestion.getQuestion()) && Intrinsics.areEqual(getQuestionHeadTips(), joinGuildWordQuestion.getQuestionHeadTips()) && Intrinsics.areEqual(this.hint, joinGuildWordQuestion.hint) && Intrinsics.areEqual(this.answer, joinGuildWordQuestion.answer)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.answer.length() > 0) {
            return true;
        }
        return false;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answer = str;
    }

    public int hashCode() {
        return (((((((getQuestionId() * 31) + getQuestion().hashCode()) * 31) + getQuestionHeadTips().hashCode()) * 31) + this.hint.hashCode()) * 31) + this.answer.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinGuildWordQuestion(questionId=" + getQuestionId() + ", question=" + getQuestion() + ", questionHeadTips=" + getQuestionHeadTips() + ", hint=" + this.hint + ", answer=" + this.answer + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildWordQuestion(int i3, @NotNull String question, @NotNull String questionHeadTips, @NotNull String hint, @NotNull String answer) {
        super(i3, question, questionHeadTips, null);
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(questionHeadTips, "questionHeadTips");
        Intrinsics.checkNotNullParameter(hint, "hint");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.questionId = i3;
        this.question = question;
        this.questionHeadTips = questionHeadTips;
        this.hint = hint;
        this.answer = answer;
    }
}
