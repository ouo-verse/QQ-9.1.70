package qu3;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u001c"}, d2 = {"Lqu3/i;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/data/ChatMessage;", "a", "", QQBrowserActivity.KEY_MSG_TYPE, "Lqu3/d;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "elementId", "i", "k", "b", "f", "l", "j", tl.h.F, "d", "g", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f429570a = new i();

    i() {
    }

    @JvmStatic
    public static final ChatMessage a(AppRuntime app, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        d c16 = f429570a.c(msgRecord.msgType);
        if (c16 != null) {
            return c16.a(app, msgRecord, null);
        }
        return null;
    }

    @JvmStatic
    public static final MsgElement e(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.fileElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement b(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.arkElement != null || next.textGiftElement != null || next.liveGiftElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement d(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.faceElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement f(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.markdownElement != null || next.inlineKeyboardElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement g(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.markdownElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement h(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.marketFaceElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement i(MsgRecord msgRecord, long elementId) {
        Object obj;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MsgElement) obj).elementId == elementId) {
                break;
            }
        }
        return (MsgElement) obj;
    }

    public final MsgElement j(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.multiForwardMsgElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement k(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.picElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement l(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.pttElement != null) {
                return next;
            }
        }
        return null;
    }

    public final MsgElement m(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return null;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.videoElement != null) {
                return next;
            }
        }
        return null;
    }

    private final d c(int msgType) {
        if (msgType == 2) {
            return new h();
        }
        if (msgType == 3) {
            return new b();
        }
        if (msgType == 17) {
            return new g();
        }
        if (msgType != 31) {
            switch (msgType) {
                case 5:
                    return new c();
                case 6:
                    return new m();
                case 7:
                    return new p();
                case 8:
                    return new j();
                case 9:
                    return new n();
                case 10:
                    return new q();
                case 11:
                    return new a();
                default:
                    return new o();
            }
        }
        return new f();
    }
}
