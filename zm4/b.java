package zm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {
    public static NewIntent d(int i3, long j3) {
        YesGameInfoOuterClass$GetTeamConfigReq yesGameInfoOuterClass$GetTeamConfigReq = new YesGameInfoOuterClass$GetTeamConfigReq();
        yesGameInfoOuterClass$GetTeamConfigReq.game_id.set(i3);
        yesGameInfoOuterClass$GetTeamConfigReq.uid.set(j3);
        return a.C11028a.a(yesGameInfoOuterClass$GetTeamConfigReq, b.class);
    }

    @Override // pl4.a
    protected int b() {
        return 324;
    }
}
