package w93;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lw93/a;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "isSuccess", "", "retCode", "", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "pbRequest", "pbResponse", "", "a", "(ZJLjava/lang/String;Lcom/tencent/biz/richframework/network/request/BaseRequest;Lcom/tencent/mobileqq/pb/MessageMicro;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a<T extends MessageMicro<T>> {
    void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable T pbResponse);
}
