package wf1;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u001a\u0010\u0011\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\r\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lwf1/c;", "Lwf1/b;", "Lwf1/a;", "b", "", "f", "", "toString", "", "hashCode", "", "other", "equals", "d", "I", "e", "()I", "questionId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "question", "questionHeadTips", "", "g", "Ljava/util/List;", "c", "()Ljava/util/List;", "answerList", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf1.c, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class JoinGuildChoiceQuestion extends b {

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
    private final List<AnswerItem> answerList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildChoiceQuestion(int i3, @NotNull String question, @NotNull String questionHeadTips, @NotNull List<AnswerItem> answerList) {
        super(i3, question, questionHeadTips, null);
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(questionHeadTips, "questionHeadTips");
        Intrinsics.checkNotNullParameter(answerList, "answerList");
        this.questionId = i3;
        this.question = question;
        this.questionHeadTips = questionHeadTips;
        this.answerList = answerList;
    }

    @Override // wf1.b
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getQuestion() {
        return this.question;
    }

    @Nullable
    public final AnswerItem b() {
        Object obj;
        Iterator<T> it = this.answerList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((AnswerItem) obj).getIsSelected()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (AnswerItem) obj;
    }

    @NotNull
    public final List<AnswerItem> c() {
        return this.answerList;
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
        if (!(other instanceof JoinGuildChoiceQuestion)) {
            return false;
        }
        JoinGuildChoiceQuestion joinGuildChoiceQuestion = (JoinGuildChoiceQuestion) other;
        if (getQuestionId() == joinGuildChoiceQuestion.getQuestionId() && Intrinsics.areEqual(getQuestion(), joinGuildChoiceQuestion.getQuestion()) && Intrinsics.areEqual(getQuestionHeadTips(), joinGuildChoiceQuestion.getQuestionHeadTips()) && Intrinsics.areEqual(this.answerList, joinGuildChoiceQuestion.answerList)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        AnswerItem b16 = b();
        if (b16 != null) {
            return b16.getIsSelected();
        }
        return false;
    }

    public int hashCode() {
        return (((((getQuestionId() * 31) + getQuestion().hashCode()) * 31) + getQuestionHeadTips().hashCode()) * 31) + this.answerList.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinGuildChoiceQuestion(questionId=" + getQuestionId() + ", question=" + getQuestion() + ", questionHeadTips=" + getQuestionHeadTips() + ", answerList=" + this.answerList + ")";
    }
}
