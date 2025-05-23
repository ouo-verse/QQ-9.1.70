package yu3;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.d;
import java.util.List;
import kotlin.Metadata;
import mqq.app.Packet;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J&\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H&J&\u0010\u0011\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0014"}, d2 = {"Lyu3/c;", "", "", "Lcom/tencent/qqnt/aio/assistedchat/model/AssistedChatSwitch;", "switchList", "", "switchValue", "Lmqq/app/Packet;", "packet", "", "a", "", "uin", "d", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "rsp", "", "b", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface c {
    void a(List<AssistedChatSwitch> switchList, int switchValue, Packet packet);

    boolean b(List<AssistedChatSwitch> switchList, int switchValue, FromServiceMsg rsp);

    List<d> c(String uin, List<AssistedChatSwitch> switchList, FromServiceMsg rsp);

    void d(String uin, List<AssistedChatSwitch> switchList, Packet packet);
}
