package ye2;

import af2.b;
import android.content.Context;
import com.tencent.ecommerce.base.permission.api.IPermission;
import com.tencent.ecommerce.base.permission.api.PermissionListener;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lye2/a;", "Lcom/tencent/ecommerce/base/permission/api/IPermission;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "hasPermission", "", "requestCode", "", "permissions", "", "grantResult", "", "onRequestPermissionResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/ecommerce/base/permission/api/PermissionListener;", "permissionListener", "requestPermissions", "(Landroid/content/Context;[Ljava/lang/String;Lcom/tencent/ecommerce/base/permission/api/PermissionListener;)V", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "a", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "b", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements IPermission {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BusinessConfig config = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_QSTORE_PACK_ADDRESS_INPUT);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QQPermission permission;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"ye2/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ye2.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11608a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PermissionListener f450223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f450224b;

        C11608a(PermissionListener permissionListener, a aVar) {
            this.f450223a = permissionListener;
            this.f450224b = aVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            this.f450223a.onAllGranted();
            this.f450224b.permission = null;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i3 = 0;
            for (Object obj : permissions) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                linkedHashMap.put((String) obj, Boolean.valueOf(results.get(i3).intValue() == 0));
                i3 = i16;
            }
            this.f450223a.onDenied(linkedHashMap);
            this.f450224b.permission = null;
        }
    }

    @Override // com.tencent.ecommerce.base.permission.api.IPermission
    public boolean hasPermission(Context activity, String permission) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return QQPermissionFactory.getQQPermission(b.f25996a.a(activity), this.config).hasPermission(permission) == 0;
    }

    @Override // com.tencent.ecommerce.base.permission.api.IPermission
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResult) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResult, "grantResult");
        QQPermission qQPermission = this.permission;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(requestCode, permissions, grantResult);
        }
    }

    @Override // com.tencent.ecommerce.base.permission.api.IPermission
    public void requestPermissions(Context activity, String[] permissions, PermissionListener permissionListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(permissionListener, "permissionListener");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(b.f25996a.a(activity), this.config);
        this.permission = qQPermission;
        if (qQPermission != null) {
            qQPermission.requestPermissions(permissions, 2, new C11608a(permissionListener, this));
        }
    }
}
