package xq;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.aekit.api.standard.filter.IZplanFilamentAbility;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.filament.light.camera.ZPlanFilamentRequestManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001d\u00a8\u0006\""}, d2 = {"Lxq/c;", "Lcom/tencent/aekit/api/standard/filter/IZplanFilamentAbility;", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "isFilamentMaterial", "isFilamentReady", "", "addZplanFilamentMaterialMap", "Lks/a;", "downloadListener", h.F, "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "dialog", "j", "c", "g", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "f", "e", "d", "", "b", "Ljava/util/Set;", "zplanFilamentMaterialHashSet", "Lmqq/util/WeakReference;", "mDialogWeakRef", "Z", "disableDialog", "isDialogShowing", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements IZplanFilamentAbility {

    /* renamed from: a, reason: collision with root package name */
    public static final c f448345a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> zplanFilamentMaterialHashSet = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile WeakReference<Dialog> mDialogWeakRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean disableDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isDialogShowing;

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(WeakReference dialog) {
        Activity topActivity;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (disableDialog || (topActivity = Foreground.getTopActivity()) == null || topActivity.isFinishing()) {
            return;
        }
        WeakReference<Dialog> weakReference = mDialogWeakRef;
        if ((weakReference != null ? weakReference.get() : null) != null) {
            return;
        }
        mDialogWeakRef = dialog;
        ms.a.f("AEQQFilamentManager", "showLoadingDialog mDialog == null disableDialog: " + disableDialog);
        Dialog dialog2 = (Dialog) dialog.get();
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: xq.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    c.l(dialogInterface);
                }
            });
        }
        Dialog dialog3 = (Dialog) dialog.get();
        if (dialog3 != null) {
            dialog3.show();
        }
    }

    @Override // com.tencent.aekit.api.standard.filter.IZplanFilamentAbility
    public void addZplanFilamentMaterialMap(String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        zplanFilamentMaterialHashSet.add(materialId);
    }

    public final void c() {
        Dialog dialog;
        ms.a.f("AEQQFilamentManager", "dismissLoadingDialog disableDialog: " + disableDialog);
        WeakReference<Dialog> weakReference = mDialogWeakRef;
        if (weakReference != null && (dialog = weakReference.get()) != null) {
            dialog.dismiss();
        }
        mDialogWeakRef = null;
    }

    public final String d(AEMaterialMetaData material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (f(material)) {
            String str = material.zplanRenderType;
            return str == null ? "1" : str;
        }
        return "null";
    }

    public final boolean e(AEMaterialMetaData material) {
        String str;
        Intrinsics.checkNotNullParameter(material, "material");
        if (!f(material) || (str = material.zplanRenderType) == null) {
            return false;
        }
        return str.equals("1");
    }

    public final boolean f(AEMaterialMetaData material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String str = material.isZplanMaterial;
        return str != null && str.equals("1");
    }

    public final void g() {
        f fVar = f.f448355a;
        fVar.b();
        fVar.d("1");
        c();
    }

    public final void h(ks.a downloadListener) {
        ZPlanFilamentRequestManager.Light3DFilamentRegisterDownloadImpl$default(new e(downloadListener), false, 2, null);
    }

    @Override // com.tencent.aekit.api.standard.filter.IZplanFilamentAbility
    public boolean isFilamentMaterial(String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        return zplanFilamentMaterialHashSet.contains(materialId);
    }

    @Override // com.tencent.aekit.api.standard.filter.IZplanFilamentAbility
    public boolean isFilamentReady() {
        LightSdkInitializer lightSdkInitializer = FeatureManager.Features.LIGHT_SDK;
        boolean isFunctionReady = lightSdkInitializer.isFunctionReady();
        if (isFunctionReady) {
            f fVar = f.f448355a;
            fVar.a("1");
            fVar.e();
            i(this, null, 1, null);
        } else {
            lightSdkInitializer.init();
        }
        return isFunctionReady;
    }

    public final void j(final WeakReference<Dialog> dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (isDialogShowing) {
            return;
        }
        isDialogShowing = true;
        ms.a.f("AEQQFilamentManager", "showLoadingDialog disableDialog: " + disableDialog);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: xq.a
            @Override // java.lang.Runnable
            public final void run() {
                c.k(WeakReference.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface) {
        isDialogShowing = false;
    }

    public static /* synthetic */ void i(c cVar, ks.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        cVar.h(aVar);
    }
}
