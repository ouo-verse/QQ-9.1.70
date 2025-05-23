package ze4;

import com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl;
import com.tencent.timi.game.accusation.impl.c;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static void a(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, String str2) {
        c cVar = new c(commonOuterClass$QQUserId, str, str2);
        cVar.f376206e = commonOuterClass$QQUserId;
        cVar.f376210i = "25108";
        cVar.f376209h = "qq_esports_king_chat_new";
        TimiGameAccusationImpl.i(cVar);
    }

    public static void b(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        c cVar = new c(commonOuterClass$QQUserId, "", "");
        cVar.f376206e = commonOuterClass$QQUserId;
        cVar.f376210i = "25107";
        cVar.f376209h = "qq_esports_king_uin_new";
        TimiGameAccusationImpl.i(cVar);
    }

    public static void c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
        String str;
        if (j3 == 0) {
            str = "";
        } else {
            str = String.valueOf(j3);
        }
        c cVar = new c(commonOuterClass$QQUserId, str, "");
        cVar.f376206e = commonOuterClass$QQUserId;
        cVar.f376210i = "25100";
        cVar.f376209h = "qq_esports_king_uin_voice";
        TimiGameAccusationImpl.i(cVar);
    }
}
