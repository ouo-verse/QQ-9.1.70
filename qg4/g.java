package qg4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ jg4.f f428920a;

        a(jg4.f fVar) {
            this.f428920a = fVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            g.f(this.f428920a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            g.e(this.f428920a, (String[]) list.toArray(new String[0]));
        }
    }

    public static void c(boolean z16) {
        l.i("TgLiveTag_TgLiveUtils", "abandonAvFocus - " + z16);
    }

    private static void d(jg4.f fVar, int i3, String str) {
        if (fVar != null) {
            fVar.onError(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(jg4.f fVar, String[] strArr) {
        if (fVar != null) {
            fVar.b(strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(jg4.f fVar) {
        if (fVar != null) {
            fVar.a();
        }
    }

    public static void g(QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType, jg4.f fVar) {
        String[] strArr;
        boolean z16;
        if (qQLiveAnchorStreamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH && qQLiveAnchorStreamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST) {
            strArr = f.f428919c;
        } else {
            strArr = f.f428918b;
        }
        QBaseActivity b16 = vf4.a.b();
        if (b16 == null) {
            d(fVar, -1, "\u68c0\u67e5\u6743\u9650\u5931\u8d25\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5");
            l.e("TgLiveTag_TgLiveUtils", "\u68c0\u67e5\u6743\u9650\u5931\u8d25 activity is null!");
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(b16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_LIVE, QQPermissionConstants.Business.SCENE.QQ_LIVE_GAME));
        if (qQPermission == null) {
            d(fVar, -1, "\u68c0\u67e5\u6743\u9650\u5931\u8d25\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5");
            l.i("TgLiveTag_TgLiveUtils", "\u68c0\u67e5\u6743\u9650\u5931\u8d25 \u83b7\u53d6qqPermission\u51fa\u9519\uff01");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (qQPermission.hasPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f(fVar);
        } else {
            qQPermission.requestPermissions((String[]) arrayList.toArray(new String[0]), 2, new a(fVar));
        }
    }

    public static boolean h(boolean z16) {
        l.i("TgLiveTag_TgLiveUtils", "requestAvFocus - " + z16);
        return true;
    }
}
