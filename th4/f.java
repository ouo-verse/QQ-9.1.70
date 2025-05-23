package th4;

import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.ui.widget.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013\u00a8\u0006\u0018"}, d2 = {"Lth4/f;", "", "", "roomId", "Lcom/tencent/timi/game/ui/widget/e;", "dialog", "", "e", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "Lgh4/e;", "hall", "Lth4/a;", "pendingTask", "", "j", "Lth4/m;", "leaveParam", "f", "", "roomCreateFrom", "i", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f436343a = new f();

    f() {
    }

    private final void e(long roomId, com.tencent.timi.game.ui.widget.e dialog) {
        gh4.d V0 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(roomId);
        if (V0 == null) {
            return;
        }
        HashMap<String, String> E = V0.E();
        ((ug4.b) mm4.b.b(ug4.b.class)).b(dialog.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), V0.C(), V0.D());
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, dialog.getNegativeButton(), false, null, V0.m(), E, 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b17, dialog.getPositiveButton(), false, null, V0.n(), E, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HallLeaveParam leaveParam, DialogInterface dialogInterface, int i3) {
        gh4.d V0;
        gh4.d V02;
        Intrinsics.checkNotNullParameter(leaveParam, "$leaveParam");
        if (leaveParam.getIsSelfOnMic() && (V02 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(leaveParam.getRoomId())) != null) {
            V02.V();
        }
        leaveParam.getPendingTask().run();
        if (leaveParam.getIsSelfOnMic() && (V0 = ((gh4.f) mm4.b.b(gh4.f.class)).V0(leaveParam.getRoomId())) != null) {
            V0.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(gh4.e hall, QBaseActivity qBaseActivity, a pendingTask, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(hall, "$hall");
        Intrinsics.checkNotNullParameter(qBaseActivity, "$qBaseActivity");
        Intrinsics.checkNotNullParameter(pendingTask, "$pendingTask");
        dialogInterface.dismiss();
        f436343a.f(qBaseActivity, new HallLeaveParam(hall.y4(), pendingTask, hall.ue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QBaseActivity qBaseActivity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "$qBaseActivity");
        com.tencent.timi.game.utils.g.g(qBaseActivity);
    }

    public final boolean f(@NotNull QBaseActivity qBaseActivity, @NotNull final HallLeaveParam leaveParam) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        Intrinsics.checkNotNullParameter(leaveParam, "leaveParam");
        if (!leaveParam.getIsSelfOnMic()) {
            com.tencent.timi.game.utils.l.e("ExpandHallExitUtil_", "onExitHall exit directly! leaveParam:" + leaveParam);
            return leaveParam.getPendingTask().run();
        }
        e.a aVar = new e.a(qBaseActivity);
        aVar.j("\u4f60\u6b63\u5728\u9ea6\u4f4d\u4e0a\uff0c\u786e\u5b9a\u8981\u79bb\u5f00\u5927\u5385?");
        aVar.k(17);
        aVar.n("\u53d6\u6d88");
        aVar.m(new DialogInterface.OnClickListener() { // from class: th4.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.g(dialogInterface, i3);
            }
        });
        aVar.p("\u786e\u5b9a");
        aVar.o(new DialogInterface.OnClickListener() { // from class: th4.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                f.h(HallLeaveParam.this, dialogInterface, i3);
            }
        });
        com.tencent.timi.game.ui.widget.e c16 = aVar.c();
        e(leaveParam.getRoomId(), c16);
        c16.show();
        return true;
    }

    public final void i(int roomCreateFrom) {
        boolean z16;
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        com.tencent.timi.game.utils.l.h("ExpandHallLeaveUtil_", 1, "exitCurrentExpandRoom currentRoomInfo:" + j06);
        if (j06 == null) {
            return;
        }
        if (j06.room_data_info.create_from.get() == roomCreateFrom) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.h("ExpandHallLeaveUtil_", 1, "exitCurrentExpandRoom isExpandRoom:" + z16);
        if (z16) {
            ((fm4.g) mm4.b.b(fm4.g.class)).T2(j06.room_id.get(), true, 0, null, false);
        }
    }

    public final boolean j(@NotNull final QBaseActivity qBaseActivity, @NotNull final gh4.e hall, @NotNull final a pendingTask) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        Intrinsics.checkNotNullParameter(hall, "hall");
        Intrinsics.checkNotNullParameter(pendingTask, "pendingTask");
        boolean c16 = com.tencent.timi.game.utils.g.c(qBaseActivity);
        if (hall.O().b(2)) {
            if (c16) {
                hall.ha(true);
                pendingTask.run();
            } else {
                hall.ha(false);
                e.a aVar = new e.a(qBaseActivity);
                aVar.j("\u6536\u8d77\u623f\u95f4\u9700\u5f00\u542f\u60ac\u6d6e\u7403\u6743\u9650\uff0c\u5426\u5219\u5c06\u9000\u51fa\u623f\u95f4");
                aVar.k(17);
                aVar.n("\u9000\u51fa\u623f\u95f4");
                aVar.m(new DialogInterface.OnClickListener() { // from class: th4.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        f.k(gh4.e.this, qBaseActivity, pendingTask, dialogInterface, i3);
                    }
                });
                aVar.p("\u53bb\u5f00\u542f");
                aVar.o(new DialogInterface.OnClickListener() { // from class: th4.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        f.l(QBaseActivity.this, dialogInterface, i3);
                    }
                });
                aVar.c().show();
            }
        } else {
            f(qBaseActivity, new HallLeaveParam(hall.y4(), pendingTask, hall.ue()));
        }
        return true;
    }
}
