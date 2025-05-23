package rb;

import android.content.Intent;
import android.content.res.Configuration;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxCreateAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.view.g;
import com.qzone.reborn.base.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lrb/e;", "Lcom/qzone/reborn/base/k;", "", "uin", "", "D9", "action", "", "args", "handleBroadcastMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/albumx/qzonex/view/g;", "d", "Lcom/qzone/reborn/albumx/qzonex/view/g;", "createAlbumDialog", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private g createAlbumDialog;

    private final void D9(String uin) {
        g gVar = new g(getActivity(), new QZAlbumxCreateAlbumInitBean(uin));
        gVar.E0(new g.a() { // from class: rb.d
            @Override // com.qzone.reborn.albumx.qzonex.view.g.a
            public final void a(boolean z16, AlbumInfo albumInfo) {
                e.E9(e.this, z16, albumInfo);
            }
        });
        gVar.show();
        this.createAlbumDialog = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(e this$0, boolean z16, AlbumInfo albumInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (albumInfo == null) {
            str = "";
        } else {
            str = "name:" + albumInfo.name + ", desc:" + albumInfo.desc + ", spaceId:" + albumInfo.owner;
        }
        QLog.d("QZAlbumxUploadSelectAlbumCreateAlbumPart", 1, "isSuccess:" + z16 + ", albumInfo -> " + str);
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            this$0.broadcastMessage("ACTION_CREATE_ALBUM_SUCCEED", new db.b(albumInfo, false, 2, null));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "ACTION_CREATE_ALBUM") && (args instanceof String)) {
            D9((String) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        g gVar = this.createAlbumDialog;
        if (gVar != null) {
            gVar.A0(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g gVar = this.createAlbumDialog;
        if (gVar != null) {
            gVar.dismiss();
        }
    }
}
