package uh2;

import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.data.genc.fh;
import com.tencent.mobileqq.qqguildsdk.data.genc.n;
import com.tencent.mobileqq.qqguildsdk.data.genc.o;
import com.tencent.mobileqq.qqguildsdk.data.genc.q;
import java.util.ArrayList;
import wh2.ad;
import wh2.ah;
import wh2.dv;
import wh2.em;
import wh2.er;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface b {
    void addSpeakOrderByUser(fc fcVar, er erVar);

    void cancelSpeakOrderByAdmin(o oVar, wh2.c cVar);

    void cancelUserHandUpForAdmin(o oVar, wh2.c cVar);

    void checkAVState(fc fcVar, er erVar);

    void dealHandUpRequestForAdmin(o oVar, boolean z16, wh2.c cVar);

    void fetchAudioLiveChannelUserList(q qVar, ad adVar);

    void fetchChannelAuthControlRoleList(long j3, long j16, int i3, ah ahVar);

    void inviteUserHandUpForAdmin(o oVar, wh2.c cVar);

    void inviteUserQueueForAdmin(o oVar, wh2.c cVar);

    void queryAVState(fc fcVar, er erVar);

    void removeSpeakOrderByUser(fc fcVar, er erVar);

    void reportAVState(n nVar, er erVar);

    void setAVChannelSpeakOrder(long j3, long j16, fh fhVar, em emVar);

    void setChannelAuthControlRoleList(long j3, long j16, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i3, dv dvVar);

    void topSpeakOrderByAdmin(o oVar, wh2.c cVar);

    void userDealSpeakInvitation(fc fcVar, er erVar);

    void userHandUp(fc fcVar, er erVar);
}
