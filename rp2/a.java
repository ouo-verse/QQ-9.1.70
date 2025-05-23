package rp2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rp2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lrp2/a;", "", "<init>", "()V", "a", "b", "c", "Lrp2/a$a;", "Lrp2/a$b;", "Lrp2/a$c;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lrp2/a$a;", "Lrp2/a;", "Lrp2/b;", "a", "Lrp2/b;", "()Lrp2/b;", "wordChangeEvent", "<init>", "(Lrp2/b;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rp2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C11153a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final KeyWordChangeEvent wordChangeEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11153a(@NotNull KeyWordChangeEvent wordChangeEvent) {
            super(null);
            Intrinsics.checkNotNullParameter(wordChangeEvent, "wordChangeEvent");
            this.wordChangeEvent = wordChangeEvent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final KeyWordChangeEvent getWordChangeEvent() {
            return this.wordChangeEvent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lrp2/a$b;", "Lrp2/a;", "Lrp2/c$a;", "a", "Lrp2/c$a;", "()Lrp2/c$a;", "keyWordData", "<init>", "(Lrp2/c$a;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c.SearchHistoryKeywordData keyWordData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c.SearchHistoryKeywordData keyWordData) {
            super(null);
            Intrinsics.checkNotNullParameter(keyWordData, "keyWordData");
            this.keyWordData = keyWordData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final c.SearchHistoryKeywordData getKeyWordData() {
            return this.keyWordData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lrp2/a$c;", "Lrp2/a;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends a {
        public c() {
            super(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
