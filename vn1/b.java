package vn1;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B;\b\u0004\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0001\u0007 !\"#$%&\u00a8\u0006'"}, d2 = {"Lvn1/b;", "Lvn1/c;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lvn1/a;", "newItem", "", "c", "", "getItemId", "Lvn1/d;", "Lvn1/d;", "e", "()Lvn1/d;", "ext", "d", "J", "f", "()J", "seq", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "g", "()Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", tl.h.F, "(Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;)V", "taskProgressState", "data", "", "type", "<init>", "(Lqj1/h;Lvn1/d;JILcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;)V", "Lvn1/f;", "Lvn1/g;", "Lvn1/h;", "Lvn1/i;", "Lvn1/j;", "Lvn1/k;", "Lvn1/l;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b extends c<qj1.h> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TopicDataExt ext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long seq;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildTaskProgressState taskProgressState;

    public /* synthetic */ b(qj1.h hVar, TopicDataExt topicDataExt, long j3, int i3, GuildTaskProgressState guildTaskProgressState, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, topicDataExt, j3, i3, guildTaskProgressState);
    }

    @Override // vn1.a
    public boolean c(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof b) {
            b bVar = (b) newItem;
            if (Intrinsics.areEqual(bVar.d().getFeedId(), d().getFeedId()) && Intrinsics.areEqual(bVar.ext, this.ext) && bVar.seq == this.seq && Intrinsics.areEqual(bVar.taskProgressState, this.taskProgressState)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TopicDataExt getExt() {
        return this.ext;
    }

    /* renamed from: f, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final GuildTaskProgressState getTaskProgressState() {
        return this.taskProgressState;
    }

    @Override // vn1.a
    public long getItemId() {
        return d().getFeedId().hashCode();
    }

    public final void h(@Nullable GuildTaskProgressState guildTaskProgressState) {
        this.taskProgressState = guildTaskProgressState;
    }

    b(qj1.h hVar, TopicDataExt topicDataExt, long j3, int i3, GuildTaskProgressState guildTaskProgressState) {
        super(hVar, i3);
        this.ext = topicDataExt;
        this.seq = j3;
        this.taskProgressState = guildTaskProgressState;
    }
}
