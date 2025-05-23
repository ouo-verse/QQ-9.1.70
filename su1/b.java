package su1;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u000e"}, d2 = {"Lsu1/b;", "", "", "channelId", "", "c", "", "a", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "d", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f434766a = new b();

    b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long a(@NotNull String channelId) {
        DirectMessageNode C;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (TextUtils.isEmpty(channelId) || (C = DirectMessageNodeRepository.C(channelId)) == null || (r3 = C.getGuildId()) == null || longOrNull == null) {
            return 0L;
        }
        return longOrNull.longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long b(@NotNull String channelId) {
        DirectMessageNode C;
        MessageSource source;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (TextUtils.isEmpty(channelId) || (C = DirectMessageNodeRepository.C(channelId)) == null || (source = C.getSource()) == null || (r3 = source.getGuildId()) == null || longOrNull == null) {
            return 0L;
        }
        return longOrNull.longValue();
    }

    @JvmStatic
    public static final boolean c(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (DirectMessageNodeRepository.C(channelId) != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean d(@NotNull p sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (sessionInfo.b().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
            return true;
        }
        return false;
    }
}
