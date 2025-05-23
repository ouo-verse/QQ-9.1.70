package qc1;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.flock.wink.FlockWinkOutputRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.winkpublish.util.LocalMediaInfoGenerator;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lqc1/a;", "", "Landroid/os/Bundle;", "", "a", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "limitImageCount", "pickerStartCountNum", "d", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "c", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f428842a = new a();

    a() {
    }

    private final void a(Bundle bundle) {
        bundle.putString("app_key", "");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "Flock");
        bundle.putString("wink_output_route", FlockWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 3L);
    }

    private final void b(Bundle bundle) {
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
    }

    public final void c(@NotNull Activity activity, @NotNull LocalMediaInfo media) {
        boolean z16;
        List listOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(media, "media");
        Bundle bundle = new Bundle();
        a aVar = f428842a;
        aVar.a(bundle);
        aVar.b(bundle);
        String str = media.missionID;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(media.path);
            bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, LocalMediaInfoGenerator.buildLocalMediaInfos(listOf));
        } else {
            bundle.putString(QQWinkConstants.MISSION_ID, media.missionID);
        }
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(activity, bundle);
    }

    public final void d(@NotNull Activity activity, int requestCode, int limitImageCount, int pickerStartCountNum) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundle = new Bundle();
        a aVar = f428842a;
        aVar.a(bundle);
        aVar.b(bundle);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.i(TabType.ONLY_IMAGE);
        aVar2.j(limitImageCount);
        aVar2.p(pickerStartCountNum);
        Unit unit = Unit.INSTANCE;
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", aVar2.a());
        bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, requestCode);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(activity, bundle);
    }
}
