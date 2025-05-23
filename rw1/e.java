package rw1;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J1\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lrw1/e;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "elemIndex", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "b", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/Integer;)Ljava/util/List;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "d", "data", "", "a", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f432610a = new e();

    e() {
    }

    public void a(MsgRecord msgRecord, AIORichMediaData data) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(data, "data");
        data.f179628d = msgRecord.msgId;
        data.f179630f = msgRecord.msgTime;
        data.f179632i = msgRecord.msgSeq;
        data.f179633m = 10014;
        data.C = false;
        data.D = false;
        data.E = msgRecord.sendStatus == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<AIORichMediaData> b(AppRuntime app, MsgRecord msgRecord, Integer elemIndex) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (elemIndex == null) {
            elemIndex = 0;
            if (msgRecord.msgType == 2) {
                elemIndex = Integer.valueOf(msgRecord.elements.size());
            }
        }
        h d16 = d(msgRecord);
        List c16 = d16 != null ? d16.c(app, msgRecord, null, elemIndex.intValue()) : null;
        return c16 != null ? c16 : new ArrayList();
    }

    public final h d(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = msgRecord.msgType;
        if (i3 == 2) {
            return new sw1.b();
        }
        if (i3 == 3) {
            return new sw1.a();
        }
        if (i3 == 7) {
            return new sw1.f();
        }
        if (i3 != 9) {
            return null;
        }
        return new sw1.d();
    }

    public static /* synthetic */ List c(e eVar, AppRuntime appRuntime, MsgRecord msgRecord, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        return eVar.b(appRuntime, msgRecord, num);
    }
}
