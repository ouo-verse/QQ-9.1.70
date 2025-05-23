package sw1;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import mqq.app.AppRuntime;
import sw1.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010\u0016\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016\u00a8\u0006\u001e"}, d2 = {"Lsw1/c;", "Lsw1/g;", "", "path", "", "j", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "a", "curType", "Landroid/content/Intent;", h.F, "downType", "e", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements g {
    private final boolean j(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.e(msgRecord)) == null) {
            return;
        }
        int i3 = type == 1 ? 2 : 1;
        i(msgRecord, msgElement.elementId, i3, i3 == 2 ? 720 : 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormatType, i iVar) {
        g.a.c(this, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormatType, iVar);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        if (msgElement == null && (msgElement = k.f415564a.e(msgRecord)) == null) {
            return arrayList;
        }
        PicElement picElement = msgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
        if (MsgExtKt.u(picElement)) {
            return arrayList;
        }
        AIOImageData aIOImageData = new AIOImageData();
        rw1.e.f432610a.a(msgRecord, aIOImageData);
        aIOImageData.f179578i0 = msgRecord.senderUid;
        aIOImageData.f179582m0 = msgRecord.peerUid;
        int i3 = msgRecord.sendType;
        aIOImageData.Q = i3 == 1;
        aIOImageData.f179581l0 = i3 == 1 || i3 == 2;
        aIOImageData.f179631h = picElement.fileSize;
        aIOImageData.S = picElement.picWidth;
        aIOImageData.T = picElement.picHeight;
        aIOImageData.X = picElement.md5HexStr;
        Integer num = picElement.picType;
        Intrinsics.checkNotNullExpressionValue(num, "picElement.picType");
        aIOImageData.P = num.intValue();
        String thumbImagePath720 = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getThumbImagePath720(msgElement);
        aIOImageData.F = thumbImagePath720;
        String originImagePath = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
        if (picElement.original) {
            aIOImageData.H = originImagePath;
            aIOImageData.G = thumbImagePath720;
        } else {
            aIOImageData.G = thumbImagePath720;
        }
        aIOImageData.I = originImagePath;
        aIOImageData.f179629e = subId;
        arrayList.add(aIOImageData);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage chatMessage, MsgRecord msgRecord, QBaseActivity qBaseActivity, AppRuntime appRuntime) {
        return g.a.g(this, chatMessage, msgRecord, qBaseActivity, appRuntime);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int type, int downType) {
        if (type == 24 && downType == 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int i3, boolean z16) {
        return g.a.e(this, msgRecord, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = k.f415564a.e(msgRecord)) == null) {
            return;
        }
        QLog.i("AIOPicProvider", 2, "[download] msgSeq: " + msgRecord.msgSeq + ", type: " + type + ", msgId: " + msgRecord.msgId + ", elemId: " + msgElement.elementId);
        if (type == 1) {
            String thumbImagePath720 = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getThumbImagePath720(msgElement);
            if (j(thumbImagePath720)) {
                if (cb5 != null) {
                    cb5.a(1, thumbImagePath720);
                    return;
                }
                return;
            }
        } else if (type == 2) {
            String thumbImagePath7202 = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getThumbImagePath720(msgElement);
            if (j(thumbImagePath7202)) {
                if (cb5 != null) {
                    cb5.a(1, thumbImagePath7202);
                    return;
                }
                return;
            }
        } else if (type == 4) {
            String originImagePath = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
            if (j(originImagePath)) {
                if (cb5 != null) {
                    cb5.a(1, originImagePath);
                    return;
                }
                return;
            }
        } else if (type == 24) {
            String originImagePath2 = ((IGuildPicApi) QRoute.api(IGuildPicApi.class)).getOriginImagePath(msgElement);
            if (j(originImagePath2)) {
                if (cb5 != null) {
                    cb5.a(1, originImagePath2);
                    return;
                }
                return;
            }
        }
        int i3 = (type == 1 || type == 2) ? 2 : 1;
        k(msgRecord, msgElement, i3, i3 == 2 ? 720 : 0);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return null;
    }

    public void i(MsgRecord msgRecord, long j3, int i3, int i16) {
        g.a.b(this, msgRecord, j3, i3, i16);
    }

    @Override // sw1.g
    public boolean isSelfGuest(String str, String str2) {
        return g.a.f(this, str, str2);
    }

    public void k(MsgRecord msgRecord, MsgElement msgElement, int i3, int i16) {
        g.a.d(this, msgRecord, msgElement, i3, i16);
    }
}
