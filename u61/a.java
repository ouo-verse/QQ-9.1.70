package u61;

import android.app.Activity;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import com.tencent.qqnt.aio.shortcutbar.f;
import com.tencent.qqnt.aio.shortcutbar.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lu61/a;", "Lcom/tencent/qqnt/aio/shortcutbar/f;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "business", "", "permissions", "", "notifyType", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "listener", "", "a", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;ILcom/tencent/qqnt/aio/shortcutbar/j;)V", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\u000b\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H\u0016J,\u0010\r\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\f2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fH\u0016J$\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\fH\u0016J\u0017\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"u61/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "uncertainPermission", "onUncertain", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "", "onDeniedWithoutShowDlg", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestView;", "requestView", "deniedPermissions", "onViewShow", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "", "getRequestPermissions", "()[Ljava/lang/String;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u61.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C11326a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f438471a;

        C11326a(j jVar) {
            this.f438471a = jVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        @Nullable
        public String[] getRequestPermissions() {
            j jVar = this.f438471a;
            if (jVar != null) {
                return jVar.a();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.c(permissions, results);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDeniedWithoutShowDlg(permissions, results);
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.d(permissions, results);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.e(dialog, deniedPermissions);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onUncertain(@Nullable String uncertainPermission) {
            super.onUncertain(uncertainPermission);
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.f(uncertainPermission);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onViewShow(@Nullable PermissionRequestView requestView, @Nullable List<String> deniedPermissions) {
            super.onViewShow(requestView, deniedPermissions);
            j jVar = this.f438471a;
            if (jVar != null) {
                jVar.g(requestView, deniedPermissions);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.qqnt.aio.shortcutbar.f
    public void a(@NotNull Activity activity, @NotNull String business, @NotNull String[] permissions, int notifyType, @Nullable j listener) {
        BusinessConfig businessConfig;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        switch (business.hashCode()) {
            case -1367751899:
                if (business.equals("camera")) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_CAMERA, QQPermissionConstants.Business.SCENE.AIO_PANEL_TAKE_PHOTO);
                    break;
                }
                businessConfig = null;
                break;
            case 111344:
                if (business.equals("ptt")) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_RECORD_AUDIO_PANEL);
                    break;
                }
                businessConfig = null;
                break;
            case 3143036:
                if (business.equals("file")) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.DATALINE, "dataline");
                    break;
                }
                businessConfig = null;
                break;
            case 92896879:
                if (business.equals("album")) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM);
                    break;
                }
                businessConfig = null;
                break;
            default:
                businessConfig = null;
                break;
        }
        int i3 = 1;
        if (businessConfig == null) {
            PermissionMonitor.requestPermissions(activity, permissions, 1);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, businessConfig);
        int length = permissions.length;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (qQPermission.hasPermission(permissions[i16]) == 0) {
                    i16++;
                }
            } else {
                z16 = true;
            }
        }
        if (z16) {
            if (listener != null) {
                listener.b();
            }
        } else {
            if (notifyType != 1) {
                i3 = 2;
            }
            qQPermission.requestPermissions(permissions, i3, new C11326a(listener));
        }
    }
}
