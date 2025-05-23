package un;

import android.content.Context;
import android.content.Intent;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import ho.i;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends a {

    /* renamed from: b, reason: collision with root package name */
    com.qzone.publish.ui.model.d f439252b;

    public f(com.qzone.publish.ui.model.d dVar) {
        super(dVar.c());
        this.f439252b = dVar;
    }

    @Override // un.a
    public int b() {
        return 4;
    }

    @Override // un.a
    public void c(Context context) {
        e(context);
    }

    public com.qzone.publish.ui.model.d d() {
        return this.f439252b;
    }

    public static void e(Context context) {
        Intent D = ak.D(context, 0, null, null, 11);
        D.putExtra("IsBack", true);
        D.putExtra(QzoneVideoBeaconReport.BEACON_SOURCE, QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM);
        D.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, 0);
        D.putExtra("refer", "toolBar");
        D.putExtra(QZoneHelper.QZoneReeditConstants.KEY_IS_JUMP_REEDIT_PUBLISH_FLOW, true);
        if (lc.b.d()) {
            i.x().l(context, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), D);
        } else {
            i.w().h(context, new QZonePublishMoodInitBean(System.currentTimeMillis()), D);
        }
    }
}
