package qb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PerfTracer;
import hb.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc.c;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0016\u00a8\u0006&"}, d2 = {"Lqb/a;", "Lcom/qzone/reborn/base/k;", "Lhb/d;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartResume", ExifInterface.LATITUDE_SOUTH, "action", "", "args", "handleBroadcastMessage", "onPartDestroy", "d", "Ljava/lang/String;", "pageName", "", "e", "J", "launchTime", "f", "pageShowTimeCost", h.F, "dataShowTimeCost", "i", "scene", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends k implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String pageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long launchTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long pageShowTimeCost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long dataShowTimeCost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String scene;

    public a(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        this.pageName = pageName;
        this.scene = "";
    }

    @Override // hb.d
    public void S() {
        long currentTimeMillis = System.currentTimeMillis() - this.launchTime;
        this.dataShowTimeCost = currentTimeMillis;
        QLog.d("QZAlbumxLaunchTimeCostPart", 1, "onItemFirstDraw  pageName=" + this.pageName + ", dataShowTimeCost=" + currentTimeMillis);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxLaunchTimeCostPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "update_page_pref_report_scene")) {
            this.scene = (String) args;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, d.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZAlbumxInitBean qZAlbumxInitBean = serializableExtra instanceof QZAlbumxInitBean ? (QZAlbumxInitBean) serializableExtra : null;
        if (qZAlbumxInitBean != null) {
            this.launchTime = qZAlbumxInitBean.getLaunchTime();
        }
        if (this.launchTime == 0) {
            this.launchTime = getActivity().getIntent().getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
        }
        QLog.d("QZAlbumxLaunchTimeCostPart", 1, "onPartCreate  pageName=" + this.pageName + ", launchTime=" + this.launchTime);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        c.f416541a.d(this.pageName, this.pageShowTimeCost, this.dataShowTimeCost, this.scene);
        QLog.d("QZAlbumxLaunchTimeCostPart", 1, "onPartDestroy  pageName=" + this.pageName + ", pageShowTimeCost=" + this.pageShowTimeCost + ", dataShowTimeCost=" + this.dataShowTimeCost + ", , scene=" + this.scene + ", activity=" + activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.pageShowTimeCost == 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.launchTime;
            this.pageShowTimeCost = currentTimeMillis;
            QLog.d("QZAlbumxLaunchTimeCostPart", 1, "onPartResume  pageName=" + this.pageName + ", pageShowTimeCost=" + currentTimeMillis + ", activity=" + activity);
        }
    }
}
