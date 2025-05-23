package v24;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J3\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a8\u0006\u0012"}, d2 = {"Lv24/a;", "", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "", "permissions", "Lkotlin/Function0;", "", "grantedCallback", "b", "(Lcom/tencent/mobileqq/qqpermission/QQPermission;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/Fragment;", "fragment", "business", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f440822a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"v24/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: v24.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11390a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f440823a;

        C11390a(Function0<Unit> function0) {
            this.f440823a = function0;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f440823a.invoke();
        }
    }

    a() {
    }

    private final void b(QQPermission permission, String[] permissions, Function0<Unit> grantedCallback) {
        permission.requestPermissions(permissions, 2, new C11390a(grantedCallback));
    }

    public final void a(@NotNull Fragment fragment, @NotNull String business, @NotNull Function0<Unit> grantedCallback) {
        String[] strArr;
        BusinessConfig businessConfig;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(grantedCallback, "grantedCallback");
        if (Intrinsics.areEqual(business, "album")) {
            strArr = new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        } else if (Intrinsics.areEqual(business, "ptt")) {
            strArr = new String[]{QQPermissionConstants.Permission.RECORD_AUDIO};
        } else {
            return;
        }
        int hashCode = business.hashCode();
        if (hashCode != -1367751899) {
            if (hashCode != 111344) {
                if (hashCode == 92896879 && business.equals("album")) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM);
                } else {
                    return;
                }
            } else if (business.equals("ptt")) {
                businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_RECORD_AUDIO_PANEL);
            } else {
                return;
            }
        } else if (!business.equals("camera")) {
            return;
        } else {
            businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_CAMERA, QQPermissionConstants.Business.SCENE.AIO_PANEL_TAKE_PHOTO);
        }
        QQPermission permission = QQPermissionFactory.getQQPermission(fragment, businessConfig);
        int length = strArr.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (permission.hasPermission(strArr[i3]) != 0) {
                    break;
                } else {
                    i3++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            grantedCallback.invoke();
        } else {
            Intrinsics.checkNotNullExpressionValue(permission, "permission");
            b(permission, strArr, grantedCallback);
        }
    }
}
