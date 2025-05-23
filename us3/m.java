package us3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tJ\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\r\u00a8\u0006\u0018"}, d2 = {"Lus3/m;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "j", "", "key", tl.h.F, "strKey", "k", "", "i", "", "g", "", "l", "strVal", "o", "longVal", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "c", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f439991a = new m();

    m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x0018, B:9:0x002a, B:11:0x0033, B:16:0x0042, B:18:0x0045, B:24:0x004b, B:26:0x0052), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d() {
        boolean startsWith$default;
        boolean z16;
        boolean startsWith$default2;
        try {
            String[] allKeyArr = f439991a.j().allKeyArr();
            ArrayList arrayList = null;
            if (allKeyArr != null) {
                ArrayList arrayList2 = new ArrayList();
                for (String it : allKeyArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, "MibiBox_", false, 2, null);
                    if (!startsWith$default) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(it, "MiniBox_", false, 2, null);
                        if (!startsWith$default2 || Intrinsics.areEqual(it, "isClearMiBiBox")) {
                            z16 = false;
                            if (!z16) {
                                arrayList2.add(it);
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null && (!arrayList.isEmpty())) {
                f439991a.j().removeKeyList(arrayList);
            }
        } catch (Exception e16) {
            QLog.e("MiniBoxMMkvUtils", 1, "clearExpiredKVSync: exception.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        boolean startsWith$default;
        try {
            m mVar = f439991a;
            if (mVar.g("isClearMiBiBox")) {
                return;
            }
            String[] allKeyArr = mVar.j().allKeyArr();
            ArrayList arrayList = null;
            int i3 = 0;
            if (allKeyArr != null) {
                ArrayList arrayList2 = new ArrayList();
                for (String it : allKeyArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it, "MibiBox_", false, 2, null);
                    if (startsWith$default) {
                        arrayList2.add(it);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList != null && (!arrayList.isEmpty())) {
                m mVar2 = f439991a;
                mVar2.j().removeKeyList(arrayList);
                mVar2.m("isClearMiBiBox", true);
            }
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("clearExpiredKV: clear size=");
                if (arrayList != null) {
                    i3 = arrayList.size();
                }
                sb5.append(i3);
                QLog.d("MiniBoxMMkvUtils", 4, sb5.toString());
            }
        } catch (Exception e16) {
            QLog.e("MiniBoxMMkvUtils", 1, "clearExpiredKVSync: exception.", e16);
        }
    }

    private final String h(String key) {
        return "MiniBox_" + key;
    }

    private final MMKVOptionEntity j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        return from;
    }

    public final void c() {
        ThreadManagerV2.excute(new Runnable() { // from class: us3.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d();
            }
        }, 64, null, false);
    }

    public final void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: us3.k
            @Override // java.lang.Runnable
            public final void run() {
                m.f();
            }
        }, 64, null, false);
    }

    public final boolean g(@NotNull String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        return j().decodeBool(h(strKey), false);
    }

    public final long i(@NotNull String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i("MiniBoxMMkvUtils", 2, "getLong " + strKey);
        }
        return j().decodeLong(h(strKey), 0L);
    }

    @NotNull
    public final String k(@NotNull String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i("MiniBoxMMkvUtils", 2, "getString " + strKey);
        }
        String decodeString = j().decodeString(h(strKey), "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getQMMkv().decodeString(getKey(strKey), \"\")");
        return decodeString;
    }

    public final void l(@NotNull String strKey) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i("MiniBoxMMkvUtils", 2, "remove " + strKey);
        }
        j().removeKey(h(strKey));
    }

    public final void m(@NotNull String strKey, boolean strVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        j().encodeBool(h(strKey), strVal);
    }

    public final void n(@NotNull String strKey, long longVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        if (QLog.isColorLevel()) {
            QLog.i("MiniBoxMMkvUtils", 2, "saveLong " + strKey + util.base64_pad_url + longVal);
        }
        j().encodeLong(h(strKey), longVal);
    }

    public final void o(@NotNull String strKey, @NotNull String strVal) {
        Intrinsics.checkNotNullParameter(strKey, "strKey");
        Intrinsics.checkNotNullParameter(strVal, "strVal");
        if (QLog.isColorLevel()) {
            QLog.i("MiniBoxMMkvUtils", 2, "saveString " + strKey + util.base64_pad_url + strVal);
        }
        j().encodeString(h(strKey), strVal);
    }
}
