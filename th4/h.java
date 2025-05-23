package th4;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"", "", "", "a", "b", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class h {
    @NotNull
    public static final Map<String, Object> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(b());
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, String> b() {
        Map<String, String> mutableMapOf;
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (I0 != null && j06 != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("yes_game_id", String.valueOf(I0.o1())), TuplesKt.to("yes_room_id", String.valueOf(I0.ue())), TuplesKt.to("yes_room_type", String.valueOf(j06.room_type.get())), TuplesKt.to("yes_to_yes_uid", ((ll4.a) mm4.b.b(ll4.a.class)).M3()));
            return mutableMapOf;
        }
        return new LinkedHashMap();
    }
}
