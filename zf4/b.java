package zf4;

import android.view.View;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$ShareArkMsg;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ4\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0017"}, d2 = {"Lzf4/b;", "", "Landroid/view/View;", "view", "Ltrpc/yes/common/MessageOuterClass$ShareArkMsg;", "arkInfo", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "", "toUserId", "yesUid", "", VirtualAppProxy.KEY_GAME_ID, "", "isClickReport", "", "c", "", "", "a", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f452467a = new b();

    b() {
    }

    @NotNull
    public final Map<String, String> a(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo, long toUserId, long yesUid, int gameId) {
        if (roomInfo != null) {
            ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(roomInfo);
            reportParam.put("yes_ref_room_id", String.valueOf(roomInfo.room_id.get()));
            reportParam.put("yes_ref_room_type", "5");
            reportParam.put("yes_to_uid", String.valueOf(toUserId));
            reportParam.put("yes_to_yes_uid", nn4.a.a(yesUid));
            reportParam.put("yes_game_id", String.valueOf(gameId));
            Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
            return reportParam;
        }
        return new LinkedHashMap();
    }

    @NotNull
    public final Map<String, String> b(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo, long toUserId, long yesUid, int gameId) {
        if (roomInfo != null) {
            ConcurrentHashMap<String, String> reportParam = YoloRoomUtil.L(roomInfo);
            reportParam.put("yes_room_id", String.valueOf(roomInfo.room_id.get()));
            reportParam.put("yes_room_type", "5");
            reportParam.put("yes_to_uid", String.valueOf(toUserId));
            reportParam.put("yes_to_yes_uid", nn4.a.a(yesUid));
            reportParam.put("yes_game_id", String.valueOf(gameId));
            Intrinsics.checkNotNullExpressionValue(reportParam, "reportParam");
            return reportParam;
        }
        return new LinkedHashMap();
    }

    public final void c(@NotNull View view, @Nullable MessageOuterClass$ShareArkMsg arkInfo, @Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo, long toUserId, long yesUid, int gameId, boolean isClickReport) {
        boolean z16;
        Map<String, String> a16;
        PBInt32Field pBInt32Field;
        PBInt32Field pBInt32Field2;
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z17 = true;
        if (arkInfo != null && (pBInt32Field2 = arkInfo.card_type) != null && pBInt32Field2.get() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (roomInfo == null || (pBInt32Field = roomInfo.room_type) == null || pBInt32Field.get() != 5) {
            z17 = false;
        }
        if (!z16) {
            return;
        }
        if (z17) {
            a16 = b(roomInfo, toUserId, yesUid, gameId);
        } else {
            a16 = a(roomInfo, toUserId, yesUid, gameId);
        }
        if (isClickReport) {
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("clck", view, a16);
            return;
        }
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.b((ug4.b) b16, view, false, null, "em_yes_chat_userprofile_sayhi", a16, 6, null);
    }
}
