package su3;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0001\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "c", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)I", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "base_proj_nt_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<AIOMsgItem> a(List<? extends AIOMsgItem> list, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        List<? extends AIOMsgItem> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (size <= 50) {
            return list;
        }
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (((AIOMsgItem) it.next()).getMsgSeq() == msgItem.getMsgSeq()) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            return list;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i3;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = i3;
        while (b(intRef2, intRef)) {
            if (intRef.element > 0 && b(intRef2, intRef)) {
                intRef.element--;
            }
            if (intRef2.element < size - 1 && b(intRef2, intRef)) {
                intRef2.element++;
            }
        }
        List<AIOMsgItem> subList = list.subList(intRef.element, intRef2.element + 1);
        QLog.d("enter preview list", 1, "size " + subList.size() + " cur " + i3 + " left " + intRef.element + " right " + intRef2.element);
        return subList;
    }

    private static final boolean b(Ref.IntRef intRef, Ref.IntRef intRef2) {
        return (intRef.element - intRef2.element) + 1 < 50;
    }

    public static final int c(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return com.tencent.nt.adapter.session.c.c(msgRecord.chatType);
    }

    public static final boolean d(AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        return aIOMsgItem.s0() == null;
    }
}
