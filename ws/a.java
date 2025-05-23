package ws;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J.\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\f"}, d2 = {"Lws/a;", "", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "", "Lcom/tencent/aio/data/msglist/a;", "list", "Landroid/os/Bundle;", "extra", "", "d", "g", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: ws.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C11505a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a aVar, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, List list, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    list = null;
                }
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                aVar.d(msgListRepoOpType, list, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyMsgChange");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(a aVar, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, List list, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    list = null;
                }
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                aVar.g(msgListRepoOpType, list, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyMsgChangeWithLocation");
        }
    }

    void d(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra);

    void g(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra);
}
