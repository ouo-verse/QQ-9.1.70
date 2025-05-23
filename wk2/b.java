package wk2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b implements Handler.Callback, com.tencent.mobileqq.qwallet.hb.aio.elem.a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile b f445765i = null;

    /* renamed from: m, reason: collision with root package name */
    public static float f445766m = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<Object> f445767d = new SparseArray<>(5);

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.cache.api.collection.a<String, c> f445768e = new com.tencent.cache.api.collection.a<>(Business.AIO, "InterfaceRedPkgElem", 30);

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<Object, a.b> f445770h = new HashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private Handler f445769f = new Handler(Looper.getMainLooper(), this);

    public b() {
        f445766m = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }

    public static b c() {
        if (f445765i == null) {
            synchronized (b.class) {
                if (f445765i == null) {
                    f445765i = new b();
                }
            }
        }
        return f445765i;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.elem.a
    public void a(RedPacketInfo redPacketInfo) {
        if (this.f445769f != null && redPacketInfo != null) {
            if (QLog.isColorLevel()) {
                QLog.d("CustomizeStrategyFactory", 2, "notifyCustomizeFinish-type:" + redPacketInfo.type + " isAnimation:" + redPacketInfo.f277228f);
            }
            Message obtainMessage = this.f445769f.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = redPacketInfo;
            this.f445769f.sendMessage(obtainMessage);
        }
    }

    public void b() {
        HashMap<Object, a.b> hashMap = this.f445770h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        d dVar;
        if (message.what == 1) {
            RedPacketInfo redPacketInfo = (RedPacketInfo) message.obj;
            a.b remove = this.f445770h.remove(redPacketInfo);
            if (QLog.isColorLevel()) {
                QLog.d("CustomizeStrategyFactory", 2, "handleMessage info type=" + redPacketInfo.type + "| listener=" + remove + "| templateId=" + redPacketInfo.templateId + "| content=" + redPacketInfo.f277226d + "| info=" + redPacketInfo + "|" + System.currentTimeMillis());
            }
            if (!this.f445768e.b(redPacketInfo.f277231m)) {
                if (redPacketInfo.type == 7) {
                    dVar = new d(redPacketInfo.f277231m);
                    dVar.a(redPacketInfo);
                } else {
                    dVar = null;
                }
                if (dVar != null && dVar.isValid()) {
                    this.f445768e.f(redPacketInfo.f277231m, dVar);
                }
            }
            if (remove != null) {
                remove.a(redPacketInfo.type, redPacketInfo);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.elem.a
    public void onDestroy() {
        b();
        com.tencent.cache.api.collection.a<String, c> aVar = this.f445768e;
        if (aVar != null) {
            aVar.d();
        }
        SparseArray<Object> sparseArray = this.f445767d;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.f445769f = null;
        f445765i = null;
    }
}
