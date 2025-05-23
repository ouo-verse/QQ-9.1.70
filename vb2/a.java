package vb2;

import android.text.TextUtils;
import com.tencent.mobileqq.now.netchannel.websso.ChannelCenter;
import com.tencent.mobileqq.now.netchannel.websso.e;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto$AnchorInfo;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto$GetAnchorOnline1Req;
import com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto$GetAnchorOnline1Rsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private boolean f441327b;

    /* renamed from: a, reason: collision with root package name */
    private int f441326a = 0;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f441328c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: vb2.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C11410a implements com.tencent.mobileqq.now.netchannel.websso.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ub2.a f441329a;

        C11410a(ub2.a aVar) {
            this.f441329a = aVar;
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onError(int i3, String str) {
            a.this.f441328c = false;
            a.this.f441327b = true;
            a.this.c(this.f441329a);
            if (QLog.isColorLevel()) {
                QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 errCode:" + i3 + " msg:" + str);
            }
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onRecv(byte[] bArr) {
            try {
                a.this.f441328c = false;
                a.this.f441327b = false;
                NowQQLiveFocusProto$GetAnchorOnline1Rsp nowQQLiveFocusProto$GetAnchorOnline1Rsp = new NowQQLiveFocusProto$GetAnchorOnline1Rsp();
                nowQQLiveFocusProto$GetAnchorOnline1Rsp.mergeFrom(bArr);
                List<NowQQLiveFocusProto$AnchorInfo> list = nowQQLiveFocusProto$GetAnchorOnline1Rsp.anchor_info.get();
                if (QLog.isColorLevel()) {
                    QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 anchorInfoList:" + list.size() + " rsp code:" + nowQQLiveFocusProto$GetAnchorOnline1Rsp.ret_info.err_code + " msg:" + nowQQLiveFocusProto$GetAnchorOnline1Rsp.ret_info.err_msg);
                }
                ArrayList arrayList = new ArrayList();
                for (NowQQLiveFocusProto$AnchorInfo nowQQLiveFocusProto$AnchorInfo : list) {
                    c cVar = new c();
                    cVar.o(nowQQLiveFocusProto$AnchorInfo.uin.get());
                    cVar.f(nowQQLiveFocusProto$AnchorInfo.anchor_logo_url.get());
                    cVar.g(nowQQLiveFocusProto$AnchorInfo.audience_sum.get());
                    cVar.i(nowQQLiveFocusProto$AnchorInfo.jump_url.get());
                    cVar.j(nowQQLiveFocusProto$AnchorInfo.nick_name.get());
                    cVar.k(nowQQLiveFocusProto$AnchorInfo.room_id.get());
                    cVar.l(nowQQLiveFocusProto$AnchorInfo.room_name.get());
                    cVar.m(nowQQLiveFocusProto$AnchorInfo.start_time.get());
                    cVar.p(nowQQLiveFocusProto$AnchorInfo.user_type.get());
                    cVar.n(nowQQLiveFocusProto$AnchorInfo.type.get());
                    cVar.h(nowQQLiveFocusProto$AnchorInfo.cover_url.get());
                    arrayList.add(cVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 nick_name:" + cVar.c() + " jump_url:" + cVar.b() + " anchor_logo_url: " + cVar.a() + " anchorInfo.jump_url.get():" + nowQQLiveFocusProto$AnchorInfo.jump_url.get());
                    }
                }
                this.f441329a.g(arrayList);
            } catch (Exception e16) {
                a.this.f441328c = false;
                a.this.f441327b = true;
                a.this.c(this.f441329a);
                if (QLog.isColorLevel()) {
                    QLog.d("FocusLiveStreamDataImpl", 2, "Focus cmd:28679 sub cmd:2 Exception:" + e16.getMessage());
                }
            }
        }
    }

    public void c(ub2.a aVar) {
        NowQQLiveFocusProto$GetAnchorOnline1Req nowQQLiveFocusProto$GetAnchorOnline1Req = new NowQQLiveFocusProto$GetAnchorOnline1Req();
        String g16 = e.g();
        if (TextUtils.isEmpty(g16) || this.f441328c) {
            return;
        }
        this.f441328c = true;
        if (this.f441327b) {
            int i3 = this.f441326a + 1;
            this.f441326a = i3;
            if (i3 >= 3) {
                aVar.a(-1, "retry fail");
                return;
            }
        }
        nowQQLiveFocusProto$GetAnchorOnline1Req.uin.set(Long.parseLong(g16));
        nowQQLiveFocusProto$GetAnchorOnline1Req.is_uid.set(1);
        nowQQLiveFocusProto$GetAnchorOnline1Req.source.set(1);
        nowQQLiveFocusProto$GetAnchorOnline1Req.need_kroom.set(0);
        ChannelCenter.e().h(28679, 2, nowQQLiveFocusProto$GetAnchorOnline1Req.toByteArray(), new C11410a(aVar));
    }
}
