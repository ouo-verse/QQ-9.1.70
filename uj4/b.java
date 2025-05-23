package uj4;

import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Luj4/b;", "", "", "roomId", "", "roomType", "", "e", "d", "", "b", "Z", "showMedal", "c", "showActivityMedal", "", "Ljava/lang/String;", "medalUrlPattern", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f439096a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean showMedal = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean showActivityMedal = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String medalUrlPattern = "";

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
        Boolean bool;
        Boolean bool2;
        String str;
        List<g> list;
        Integer num = null;
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.f273757b);
        } else {
            bool = null;
        }
        if (bVar != null) {
            bool2 = Boolean.valueOf(bVar.f273758c);
        } else {
            bool2 = null;
        }
        if (bVar != null) {
            str = bVar.f273759d;
        } else {
            str = null;
        }
        if (bVar != null && (list = bVar.f273762g) != null) {
            num = Integer.valueOf(list.size());
        }
        QLog.i("MedalConfig", 1, "showMedal:" + bool + ",showActivityMedal:" + bool2 + ",medalUrlPattern:" + str + ",medalSize:" + num);
        if (bVar != null) {
            showMedal = bVar.f273757b;
            showActivityMedal = bVar.f273758c;
            medalUrlPattern = bVar.f273759d;
        }
    }

    public final void b(long roomId, int roomType) {
        QLog.i("MedalConfig", 1, "refreshSelfMedal,roomId:" + roomId + ",roomType:" + roomType);
        long G = c.f272176a.G();
        if (G == -1) {
            QLog.e("MedalConfig", 1, "selfUid is -1");
        } else {
            QQLiveMedalServiceSupplier.f377955a.a().a(G, roomId, roomType, new d.a() { // from class: uj4.a
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
                public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    b.c(bVar);
                }
            });
        }
    }

    public final boolean d(long roomId, int roomType) {
        return showActivityMedal;
    }

    public final boolean e(long roomId, int roomType) {
        return showMedal;
    }
}
