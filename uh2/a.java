package uh2;

import com.tencent.qqnt.kernel.api.j;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J.\u0010\u000f\u001a\u00020\u00042\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\b\u001a\u0004\u0018\u00010\u000eH&J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u0014"}, d2 = {"Luh2/a;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelDirectSessionListener;", "listener", "", "addKernelDirectSessionListener", "removeKernelDirectSessionListener", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "cb", "getDirectSessionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "guilds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;", "fetchDirectSessionList", "", "guildId", "channelId", "deleteDirectMsgRecordsAndDirectSession", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface a extends j {
    void addKernelDirectSessionListener(@Nullable IKernelDirectSessionListener listener);

    void deleteDirectMsgRecordsAndDirectSession(@Nullable String guildId, @Nullable String channelId, @Nullable IGuildOperateCallback cb5);

    void fetchDirectSessionList(@Nullable ArrayList<Long> guilds, @Nullable IFetchListCallback cb5);

    void getDirectSessionList(@Nullable IGuildOperateCallback cb5);

    void removeKernelDirectSessionListener(@Nullable IKernelDirectSessionListener listener);
}
