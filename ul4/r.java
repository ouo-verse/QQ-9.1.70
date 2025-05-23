package ul4;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lul4/r;", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "roomId", "", "yesGameId", "Landroid/content/Context;", "context", "", "b", "", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f439199a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "ProfileJumpHelper_";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ul4/r$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomInfo result) {
            com.tencent.timi.game.utils.l.i(r.TAG, "joinYoloRoom - success");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e(r.TAG, "joinYoloRoom - onError -" + errorCode + "-" + errorMessage);
        }
    }

    r() {
    }

    public final void b(@NotNull CommonOuterClass$QQUserId userId, long roomId, int yesGameId, @NotNull Context context) {
        fm4.c cVar;
        long j3;
        PBUInt64Field pBUInt64Field;
        ExpandHallLaunchParam O;
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            int i3 = 2;
            if (userId.user_from.get() != 2) {
                i3 = 1;
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = null;
            if (I0 != null && (O = I0.O()) != null) {
                cVar = new gh4.d(O).i();
            } else {
                cVar = null;
            }
            fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
            if (gVar != null) {
                yoloRoomOuterClass$YoloRoomInfo = gVar.j0(5);
            }
            if (yoloRoomOuterClass$YoloRoomInfo != null && (pBUInt64Field = yoloRoomOuterClass$YoloRoomInfo.room_id) != null) {
                j3 = pBUInt64Field.get();
            } else {
                j3 = 0;
            }
            int J = ((fm4.g) mm4.b.b(fm4.g.class)).J(yesGameId);
            if (J == 0) {
                J = 1;
            }
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = roomId;
            dVar.f379325b = i3;
            dVar.f379326c = 1;
            dVar.f379328e = J;
            dVar.f379329f = cVar;
            dVar.f379327d = false;
            dVar.f379330g = j3;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
            cVar2.f379322a = 0;
            cVar2.f379323b = new ArrayList();
            ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, (Activity) context, dVar, cVar2, new a());
        }
    }
}
