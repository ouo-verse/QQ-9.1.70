package wk1;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"Lwk1/h;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getFeedId", "()Ljava/lang/String;", "feedId", "getGuildId", "guildId", "getChannelId", "channelId", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "()Ljava/util/concurrent/ConcurrentHashMap;", "extDataMap", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "Lwk1/m;", "d", "()Lwk1/m;", "inputStyleConfig", "Lwk1/f;", "f", "()Lwk1/f;", "feedLikeManage", "Lwk1/e;", "c", "()Lwk1/e;", "dataReportManage", "Lwk1/a;", "b", "()Lwk1/a;", "guildBarDependency", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static InputStyleConfig a(@NotNull h hVar) {
            return null;
        }
    }

    @NotNull
    ConcurrentHashMap<String, Object> a();

    @Nullable
    wk1.a b();

    @Nullable
    e c();

    @Nullable
    InputStyleConfig d();

    @Nullable
    f f();

    @NotNull
    String getChannelId();

    @NotNull
    Context getContext();

    @NotNull
    i getDelegate();

    @NotNull
    String getFeedId();

    @NotNull
    String getGuildId();
}
