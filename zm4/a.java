package zm4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import pl4.c;
import pl4.d;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zm4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11700a implements d<YesGameInfoOuterClass$GetTeamConfigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f452783a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f452784b;

        C11700a(IResultListener iResultListener, int i3) {
            this.f452783a = iResultListener;
            this.f452784b = i3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp, @Nullable FromServiceMsg fromServiceMsg) {
            l.e("GetTeamConfigRequest", "GetTeamConfig failed : errorCode == " + i16 + ", errorMsg == " + str);
            IResultListener iResultListener = this.f452783a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp, FromServiceMsg fromServiceMsg) {
            if (yesGameInfoOuterClass$GetTeamConfigRsp == null) {
                IResultListener iResultListener = this.f452783a;
                if (iResultListener != null) {
                    iResultListener.onError(80000, "GetTeamConfig failed : response == null");
                    return;
                }
                return;
            }
            ((sm4.a) mm4.b.b(sm4.a.class)).x2(this.f452784b, yesGameInfoOuterClass$GetTeamConfigRsp);
            IResultListener iResultListener2 = this.f452783a;
            if (iResultListener2 != null) {
                iResultListener2.onSuccess(yesGameInfoOuterClass$GetTeamConfigRsp);
            }
        }
    }

    public static void a(int i3, IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> iResultListener) {
        l.i("GetTeamConfigRequest", "GetTeamConfig start");
        long h16 = ((ll4.a) mm4.b.b(ll4.a.class)).h();
        if (h16 == 0) {
            l.e("GetTeamConfigRequest", "self uid is 0");
        } else {
            ((c) mm4.b.b(c.class)).F1(b.d(i3, h16), YesGameInfoOuterClass$GetTeamConfigRsp.class, new C11700a(iResultListener, i3));
        }
    }
}
