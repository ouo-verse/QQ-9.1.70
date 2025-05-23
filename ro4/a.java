package ro4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.room.impl.util.c;
import com.tencent.timi.game.room.impl.util.d;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import gh4.e;
import java.util.concurrent.ConcurrentHashMap;
import mm4.b;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements qo4.a {

    /* compiled from: P */
    /* renamed from: ro4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11151a implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f431828a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f431829b;

        C11151a(IResultListener iResultListener, int i3) {
            this.f431828a = iResultListener;
            this.f431829b = i3;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            l.i("TeamSdkServiceImpl", "createTeam success : roomId == " + yoloRoomOuterClass$YoloRoomInfo.room_id.get());
            IResultListener iResultListener = this.f431828a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            String str2;
            l.e("TeamSdkServiceImpl", "createTeam failed : errorCode == " + i3 + ", errorMessage == " + str);
            IResultListener iResultListener = this.f431828a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
            if (!YoloRoomUtil.U(this.f431829b, i3, str)) {
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                } else if (eh4.a.e()) {
                    str2 = "\u521b\u5efa\u5931\u8d25\uff0c errorCode == " + i3 + " errorMessage == " + str;
                } else {
                    str2 = "\u521b\u5efa\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                }
                f.d(true, str2);
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("yes_fail_reason", str);
            concurrentHashMap.put("yes_room_type", String.valueOf(this.f431829b));
            concurrentHashMap.put("yes_game_id", String.valueOf(YoloRoomUtil.y(this.f431829b)));
            e I0 = ((gh4.f) b.b(gh4.f.class)).I0();
            if (I0 != null) {
                concurrentHashMap.putAll(I0.m0().E());
            }
            ((ug4.b) b.b(ug4.b.class)).reportEvent("ev_yes_team_create_fail", concurrentHashMap);
        }
    }

    @Override // qo4.a
    public void i1(Activity activity, d dVar, c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        YoloRoomUtil.I(activity, dVar, cVar, iResultListener);
    }

    @Override // qo4.a
    public void r3(YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        YoloRoomUtil.B(yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, null, new C11151a(iResultListener, yoloRoomOuterClass$YoloRoomParams.room_type.get()));
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
