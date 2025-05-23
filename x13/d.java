package x13;

import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.state.square.api.MsgType;
import com.tencent.state.square.api.SummaryData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u00042\u001e\u0010\u0003\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0000j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u0002\u001a\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\t\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "Lkotlin/collections/ArrayList;", "contents", "Lcom/tencent/state/square/api/MsgType;", "a", "", "elementType", "c", "(Ljava/lang/Integer;)Lcom/tencent/state/square/api/MsgType;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "info", "Lcom/tencent/state/square/api/SummaryData;", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public static final SummaryData b(g info) {
        boolean z16;
        Intrinsics.checkNotNullParameter(info, "info");
        ArrayList<MsgAbstractElement> arrayList = info.s().abstractContent;
        Intrinsics.checkNotNullExpressionValue(arrayList, "info.originData.abstractContent");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgAbstractElement) it.next()).elementType == 6) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        String obj = info.v().f().toString();
        String e16 = info.v().e();
        Integer d16 = info.v().d();
        return new SummaryData(z16, e16, obj, d16 != null ? d16.intValue() : 0, info.v().h(), info.s().chatType == 2);
    }

    public static final MsgType a(ArrayList<MsgAbstractElement> arrayList) {
        Object obj = null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MsgAbstractElement msgAbstractElement = (MsgAbstractElement) next;
                if (c(msgAbstractElement != null ? Integer.valueOf(msgAbstractElement.elementType) : null) == MsgType.PTT) {
                    obj = next;
                    break;
                }
            }
            obj = (MsgAbstractElement) obj;
        }
        if (obj != null) {
            return MsgType.PTT;
        }
        return MsgType.TEXT;
    }

    public static final MsgType c(Integer num) {
        if (num != null && num.intValue() == 1) {
            return MsgType.TEXT;
        }
        if (num != null && num.intValue() == 4) {
            return MsgType.PTT;
        }
        return MsgType.TEXT;
    }
}
