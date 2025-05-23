package sw1;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import sw1.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J,\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\bH\u0016J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u001e"}, d2 = {"Lsw1/d;", "Lsw1/g;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "a", "curType", "Landroid/content/Intent;", h.F, "Lcom/tencent/mobileqq/data/ChatMessage;", "cm", "Lcom/tencent/mobileqq/app/QBaseActivity;", "topActivity", "", "d", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements g {
    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == subId) {
                    if (msgRecord.elements.get(i3).videoElement != null) {
                        new f().a(msgRecord, subId, type, msgRecord.elements.get(i3));
                    } else if (msgRecord.elements.get(i3).picElement != null) {
                        new c().a(msgRecord, subId, type, msgRecord.elements.get(i3));
                    }
                }
            }
        }
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
        ArrayList<MsgElement> arrayList2 = msgRecord.elements;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = msgRecord.elements.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (msgRecord.elements.get(i3).videoElement != null) {
                    arrayList.addAll(new f().c(app, msgRecord, msgRecord.elements.get(i3), i3));
                } else if (msgRecord.elements.get(i3).picElement != null) {
                    arrayList.addAll(new c().c(app, msgRecord, msgRecord.elements.get(i3), i3));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage cm5, MsgRecord msgRecord, QBaseActivity topActivity, AppRuntime app) {
        MessageForMixedMsg messageForMixedMsg;
        List<MessageRecord> list;
        Intrinsics.checkNotNullParameter(cm5, "cm");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(topActivity, "topActivity");
        Intrinsics.checkNotNullParameter(app, "app");
        if (!(cm5 instanceof MessageForMixedMsg) || (list = (messageForMixedMsg = (MessageForMixedMsg) cm5).msgElemList) == null || list.size() != 1 || !(messageForMixedMsg.msgElemList.get(0) instanceof MessageForPic)) {
            return false;
        }
        ArrayList arrayList = new ArrayList(1);
        MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(0);
        Intrinsics.checkNotNull(messageRecord, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPic");
        arrayList.add((MessageForPic) messageRecord);
        BaseActivity baseActivity = (BaseActivity) topActivity;
        WeiyunAIOUtils.s((QQAppInterface) app, baseActivity, baseActivity.getTitleBarHeight(), arrayList, null);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int i3, int i16) {
        return g.a.a(this, i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int i3, boolean z16) {
        return g.a.e(this, msgRecord, i3, z16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        int size = msgRecord.elements.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == subId) {
                if (msgRecord.elements.get(i3).videoElement != null) {
                    new f().g(msgRecord, subId, type, msgRecord.elements.get(i3), cb5);
                } else if (msgRecord.elements.get(i3).picElement != null) {
                    new c().g(msgRecord, subId, type, msgRecord.elements.get(i3), cb5);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = msgRecord.elements.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == subId) {
                if (msgRecord.elements.get(i3).videoElement != null) {
                    return new f().h(msgRecord, subId, msgRecord.elements.get(i3), curType);
                }
                if (msgRecord.elements.get(i3).picElement != null) {
                    return new c().h(msgRecord, subId, msgRecord.elements.get(i3), curType);
                }
            }
        }
        return null;
    }

    @Override // sw1.g
    public boolean isSelfGuest(String str, String str2) {
        return g.a.f(this, str, str2);
    }
}
