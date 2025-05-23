package w32;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a extends IQQLiveModule {

    /* compiled from: P */
    /* renamed from: w32.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC11457a {
        void a(boolean z16);
    }

    String a(ToServiceMsg toServiceMsg, String str, String str2);

    String c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void e(InterfaceC11457a interfaceC11457a);

    String i(LiveBaseRequest liveBaseRequest, QQLiveResponse qQLiveResponse);

    boolean isInit();

    String j(LiveBaseRequest liveBaseRequest);
}
