package w42;

import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lw42/e;", "Lw42/f;", "", "id", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$SpeakerInfo;", "c", "message", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$TimMsgBody;", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface e extends f {
    @Nullable
    MessageOuterClass$TimMsgBody a();

    @NotNull
    LiveMessageData.SpeakerInfo c();

    @NotNull
    String id();

    @NotNull
    String message();
}
