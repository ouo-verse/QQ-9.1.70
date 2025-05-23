package ru3;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOMediaApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.richmedia.provider.AIOFileProvider;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J=\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b\u00a8\u0006\u0015"}, d2 = {"Lru3/c;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "elemIndex", "", "localPath", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "b", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/List;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "d", "data", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f432503a = new c();

    c() {
    }

    public final void a(MsgRecord msgRecord, AIORichMediaData data) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(data, "data");
        data.f179628d = msgRecord.msgId;
        data.f179630f = msgRecord.msgTime;
        data.f179632i = msgRecord.msgSeq;
        data.f179633m = com.tencent.nt.adapter.session.c.c(msgRecord.chatType);
        data.C = false;
        data.D = false;
        data.E = msgRecord.sendStatus == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<AIORichMediaData> b(AppRuntime app, MsgRecord msgRecord, Integer elemIndex, String localPath) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (elemIndex == null) {
            elemIndex = 0;
            int i3 = msgRecord.msgType;
            if (i3 == 2 || i3 == 9 || i3 == 31) {
                elemIndex = Integer.valueOf(msgRecord.elements.size());
            }
        }
        com.tencent.qqnt.aio.adapter.richmedia.provider.h d16 = d(msgRecord, localPath);
        List c16 = d16 != null ? d16.c(app, msgRecord, null, elemIndex.intValue()) : null;
        return c16 != null ? c16 : new ArrayList();
    }

    public final com.tencent.qqnt.aio.adapter.richmedia.provider.h d(MsgRecord msgRecord, String localPath) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgRecord.chatType == 4) {
            return (com.tencent.qqnt.aio.adapter.richmedia.provider.h) ((IGuildAIOMediaApi) QRoute.api(IGuildAIOMediaApi.class)).getGuildAIOMediaProvider(msgRecord.msgType);
        }
        int i3 = msgRecord.msgType;
        if (i3 == 2) {
            return new com.tencent.qqnt.aio.adapter.richmedia.provider.c();
        }
        if (i3 == 3) {
            AIOFileProvider aIOFileProvider = new AIOFileProvider();
            if (!TextUtils.isEmpty(localPath)) {
                aIOFileProvider.r(localPath);
            }
            return aIOFileProvider;
        }
        if (i3 == 7) {
            return new com.tencent.qqnt.aio.adapter.richmedia.provider.g();
        }
        if (i3 == 9) {
            return new com.tencent.qqnt.aio.adapter.richmedia.provider.e();
        }
        if (i3 != 31) {
            return null;
        }
        return new com.tencent.qqnt.aio.adapter.richmedia.provider.c();
    }

    public static /* synthetic */ com.tencent.qqnt.aio.adapter.richmedia.provider.h e(c cVar, MsgRecord msgRecord, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return cVar.d(msgRecord, str);
    }

    public static /* synthetic */ List c(c cVar, AppRuntime appRuntime, MsgRecord msgRecord, Integer num, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        return cVar.b(appRuntime, msgRecord, num, str);
    }
}
