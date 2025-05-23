package uh2;

import com.tencent.mobileqq.qqguildsdk.data.fk;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\u0010"}, d2 = {"Luh2/e;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/fk;", "getQQMsgListChannels", "", "guildId", "channelId", "", "op", "Lvh2/cc;", "cb", "", "setQQMsgListChannel", "", "isQQMsgListChannel", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface e {
    @NotNull
    List<fk> getQQMsgListChannels();

    boolean isQQMsgListChannel(@NotNull String guildId, @NotNull String channelId);

    void setQQMsgListChannel(@NotNull String guildId, @NotNull String channelId, int op5, @NotNull cc cb5);
}
