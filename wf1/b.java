package wf1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B!\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000b\u0082\u0001\u0004\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lwf1/b;", "", "", "a", "I", "getQuestionId", "()I", "questionId", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "question", "c", "getQuestionHeadTips", "questionHeadTips", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "Lwf1/c;", "Lwf1/d;", "Lwf1/e;", "Lwf1/f;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int questionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String question;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String questionHeadTips;

    public /* synthetic */ b(int i3, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public String getQuestion() {
        return this.question;
    }

    b(int i3, String str, String str2) {
        this.questionId = i3;
        this.question = str;
        this.questionHeadTips = str2;
    }
}
