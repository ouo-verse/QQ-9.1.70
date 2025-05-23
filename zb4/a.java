package zb4;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import pu4.i;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013Jd\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u0014"}, d2 = {"Lzb4/a;", "", "", "id", "feedId", "uin", "", "uinType", WadlProxyConsts.RES_URL, "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "Lpu4/i;", "arkMeta", "contentType", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f452297a = new a();

    a() {
    }

    public final void a(String id5, String feedId, String uin, int uinType, String resUrl, boolean isVideo, i arkMeta, int contentType, ZootopiaSource source) {
        pu4.a aVar;
        pu4.a aVar2;
        pu4.a aVar3;
        pu4.a aVar4;
        pu4.a aVar5;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        QLog.d("ZplanDressShareHelper", 1, "share " + id5 + " , " + uin + ", " + uinType + " " + resUrl + " and " + isVideo + " contentType: " + contentType);
        HashMap hashMap = new HashMap();
        hashMap.put("KEY_DRESS_KEY_ID", id5);
        hashMap.put("KEY_DRESS_KEY_FEED_ID", feedId);
        hashMap.put("KEY_DRESS_KEY_CONTENT_TYPE", Integer.valueOf(contentType));
        int i3 = isVideo ? 3 : 2;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("id", id5);
        String str = arkMeta != null ? arkMeta.f427459g : null;
        String str2 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "arkMeta?.arkVersion ?: \"\"");
        }
        hashMap2.put("ark_version", str);
        String str3 = arkMeta != null ? arkMeta.f427455c : null;
        if (str3 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "arkMeta?.coverImg ?: \"\"");
        }
        hashMap2.put("cover_img", str3);
        String str4 = arkMeta != null ? arkMeta.f427457e : null;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "arkMeta?.desc ?: \"\"");
        }
        hashMap2.put("desc", str4);
        String str5 = arkMeta != null ? arkMeta.f427453a : null;
        if (str5 == null) {
            str5 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "arkMeta?.creatorHeadImg ?: \"\"");
        }
        hashMap2.put("creator_head_img", str5);
        String str6 = arkMeta != null ? arkMeta.f427456d : null;
        if (str6 == null) {
            str6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str6, "arkMeta?.logoImg ?: \"\"");
        }
        hashMap2.put("logo_img", str6);
        String str7 = arkMeta != null ? arkMeta.f427454b : null;
        if (str7 != null) {
            Intrinsics.checkNotNullExpressionValue(str7, "arkMeta?.creatorNickName ?: \"\"");
            str2 = str7;
        }
        hashMap2.put("creator_nick_name", str2);
        hashMap2.put("show_play_button", Boolean.valueOf(arkMeta != null ? arkMeta.f427460h : false));
        hashMap2.put("forward", Integer.valueOf((arkMeta == null || (aVar5 = arkMeta.f427461i) == null) ? 0 : aVar5.f427395a));
        hashMap2.put("round", Integer.valueOf((arkMeta == null || (aVar4 = arkMeta.f427461i) == null) ? 0 : aVar4.f427396b));
        hashMap2.put("width", Integer.valueOf((arkMeta == null || (aVar3 = arkMeta.f427461i) == null) ? 0 : aVar3.f427397c));
        hashMap2.put("height", Integer.valueOf((arkMeta == null || (aVar2 = arkMeta.f427461i) == null) ? 0 : aVar2.f427398d));
        hashMap2.put("autosize", Integer.valueOf((arkMeta == null || (aVar = arkMeta.f427461i) == null) ? 0 : aVar.f427399e));
        ZPlanShareLaunchParam zPlanShareLaunchParam = new ZPlanShareLaunchParam(2, uin, i3, resUrl, hashMap, hashMap2, source == null ? ZootopiaSource.INSTANCE.i() : source, new Integer[]{0}, Integer.valueOf(uinType), null, false, null, 3584, null);
        IZPlanShareApi iZPlanShareApi = (IZPlanShareApi) QRoute.api(IZPlanShareApi.class);
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.getContext();
        }
        Intrinsics.checkNotNullExpressionValue(topActivity, "Foreground.getTopActivit\u2026eApplication.getContext()");
        iZPlanShareApi.launchForShareMedia(topActivity, zPlanShareLaunchParam);
    }
}
