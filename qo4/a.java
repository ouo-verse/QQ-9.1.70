package qo4;

import android.app.Activity;
import com.tencent.timi.game.room.impl.util.c;
import com.tencent.timi.game.room.impl.util.d;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends mm4.a {
    void i1(Activity activity, d dVar, c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);

    void r3(YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);
}
