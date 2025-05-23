package sx3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_body_resv;
import tencent.im.qqwallet.qqwalletaio_resv$qqwalletaio_elem_resv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_elem_resv;", "b", "Ltencent/im/qqwallet/qqwalletaio_resv$qqwalletaio_body_resv;", "a", "qwallet-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    @NotNull
    public static final qqwalletaio_resv$qqwalletaio_body_resv a(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        qqwalletaio_resv$qqwalletaio_body_resv qqwalletaio_resv_qqwalletaio_body_resv = new qqwalletaio_resv$qqwalletaio_body_resv();
        try {
            qqwalletaio_resv_qqwalletaio_body_resv.mergeFrom(bArr);
        } catch (Exception e16) {
            QLog.e("QWalletResvExt", 1, "aioResv: mergeFrom failed", e16);
        }
        return qqwalletaio_resv_qqwalletaio_body_resv;
    }

    @NotNull
    public static final qqwalletaio_resv$qqwalletaio_elem_resv b(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        qqwalletaio_resv$qqwalletaio_elem_resv qqwalletaio_resv_qqwalletaio_elem_resv = new qqwalletaio_resv$qqwalletaio_elem_resv();
        try {
            qqwalletaio_resv_qqwalletaio_elem_resv.mergeFrom(bArr);
        } catch (Exception e16) {
            QLog.e("QWalletResvExt", 1, "aioResv: mergeFrom failed", e16);
        }
        return qqwalletaio_resv_qqwalletaio_elem_resv;
    }
}
