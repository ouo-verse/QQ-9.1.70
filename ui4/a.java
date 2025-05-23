package ui4;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$RoomTabInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bR?\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000eR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000eR4\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\nj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019\u00a8\u0006%"}, d2 = {"Lui4/a;", "", "", "roomId", "", "b", "", "c", "", "a", "Ljava/util/HashMap;", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$RoomTabInfo;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getRoomTabCongMap", "()Ljava/util/HashMap;", "roomTabCongMap", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "getRoomTabConfig", "()Landroidx/lifecycle/MutableLiveData;", "roomTabConfig", "d", "Ljava/lang/String;", "tips", "e", "roomTypeMap", "f", "showWarningMap", "g", "roomDefaultTabConfigMap", h.F, "curAnnounce", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439039a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, List<PremadesTeamServerOuterClass$RoomTabInfo>> roomTabCongMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Map<Long, List<PremadesTeamServerOuterClass$RoomTabInfo>>> roomTabConfig = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String tips = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Integer> roomTypeMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Boolean> showWarningMap = new HashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, String> roomDefaultTabConfigMap = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String curAnnounce = "";

    a() {
    }

    @NotNull
    public final String a() {
        JSONObject jsonString;
        String string;
        if (TextUtils.isEmpty(curAnnounce)) {
            ToggleProxy toggleProxy = VasToggle.QQLIVE_ROOM_ANNOUNCE_CONFIG;
            if (toggleProxy.isEnable(false) && (jsonString = toggleProxy.getJsonString()) != null && (string = jsonString.getString("announce")) != null && !TextUtils.isEmpty(string)) {
                curAnnounce = string;
            }
            if (TextUtils.isEmpty(curAnnounce)) {
                curAnnounce = ht3.a.d("general_community_policy", "\u5e73\u53f0\u5bf9\u76f4\u64ad\u5185\u5bb9\u548c\u8bc4\u8bba\u8fdb\u884c24\u5c0f\u65f6\u5de1\u67e5\uff0c\u4e25\u7981\u4f20\u64ad\u653f\u6cbb\u3001\u5c01\u5efa\u8ff7\u4fe1\u3001\u66b4\u529b\u8840\u8165\u3001\u4f4e\u4fd7\u8272\u60c5\u3001\u62db\u5ad6\u8bc8\u9a97\u3001\u865a\u5047\u5145\u503c\u7b49\u4e0d\u826f\u5185\u5bb9\uff0c\u82e5\u6709\u8fdd\u53cd\uff0c\u5c06\u5e73\u53f0\u89c4\u5219\u7ed9\u4e88\u7981\u64ad\u3001\u5c01\u53f7\u7b49\u5904\u7406\u3002\u8bf7\u52ff\u8f7b\u4fe1\u5404\u7c7b\u62db\u8058\u5f81\u5a5a\u3001\u4ee3\u7ec3\u4ee3\u62bd\u3001\u8d2d\u4e70\u793c\u5305\u7801\u3001\u6e38\u620f\u5e01\u7b49\u5e7f\u544a\u4fe1\u606f\uff0c\u8bf7\u8c28\u614e\u5224\u65ad\u4ee5\u514d\u4e0a\u5f53\u53d7\u9a97\u3002");
            }
        }
        return curAnnounce;
    }

    public final int b(long roomId) {
        Integer num = roomTypeMap.get(Long.valueOf(roomId));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final boolean c() {
        BaseRoomInfo q16 = ((jg4.b) mm4.b.b(jg4.b.class)).q(0L);
        if (q16 != null) {
            return Intrinsics.areEqual(showWarningMap.get(Long.valueOf(q16.getRoomId())), Boolean.TRUE);
        }
        return true;
    }
}
