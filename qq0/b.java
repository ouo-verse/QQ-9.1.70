package qq0;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2 = {"Lqq0/b;", "Lat/d;", "<init>", "()V", "a", "b", "c", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class b implements at.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lqq0/b$a;", "Lqq0/b;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lqq0/b$b;", "Lqq0/b;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: qq0.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C11093b extends b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lqq0/b$c;", "Lqq0/b;", "", "d", "J", "a", "()J", "msgSeq", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: a, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lqq0/b$d;", "Lqq0/b;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "a", "()Landroid/content/Context;", "mContext", "", "e", "J", "b", "()J", "msgSeq", "<init>", "(Landroid/content/Context;J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context mContext;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        public d(@NotNull Context mContext, long j3) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.mContext = mContext;
            this.msgSeq = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Context getMContext() {
            return this.mContext;
        }

        /* renamed from: b, reason: from getter */
        public final long getMsgSeq() {
            return this.msgSeq;
        }
    }
}
