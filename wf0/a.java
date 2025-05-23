package wf0;

import android.content.Context;
import com.tencent.ecommerce.base.account.api.IECFaceVerification;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J;\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lwf0/a;", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification;", "", "psKey", "uin", "idNum", "name", "", "nonce", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;", "requestForFaceVerificationConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "identificationConfig", "Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$a;", "startFaceVerification", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/account/api/IECFaceVerification$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onRelease", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECFaceVerification {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445555a = new a();

    a() {
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    public void onRelease(@NotNull Context context) {
        throw new NotImplementedError("\u4eba\u8138\u8bc6\u522b\u80fd\u529b\u662f\u5fc5\u8981\u63a5\u53e3\uff0c\u9700\u8981\u5bbf\u4e3b\u63d0\u4f9b\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528");
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    @Nullable
    public Object requestForFaceVerificationConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j3, @NotNull Continuation<? super IECFaceVerification.IdentificationConfig> continuation) {
        throw new NotImplementedError("\u4eba\u8138\u8bc6\u522b\u80fd\u529b\u662f\u5fc5\u8981\u63a5\u53e3\uff0c\u9700\u8981\u5bbf\u4e3b\u63d0\u4f9b\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528");
    }

    @Override // com.tencent.ecommerce.base.account.api.IECFaceVerification
    @Nullable
    public Object startFaceVerification(@NotNull Context context, @NotNull IECFaceVerification.IdentificationConfig identificationConfig, @NotNull Continuation<? super IECFaceVerification.FaceVerificationResult> continuation) {
        throw new NotImplementedError("\u4eba\u8138\u8bc6\u522b\u80fd\u529b\u662f\u5fc5\u8981\u63a5\u53e3\uff0c\u9700\u8981\u5bbf\u4e3b\u63d0\u4f9b\uff0c\u5426\u5219\u65e0\u6cd5\u4f7f\u7528");
    }
}
