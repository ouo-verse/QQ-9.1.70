package we2;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryLogger;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lwe2/c;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryLogger;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", TtmlNode.TAG_SPAN, "", "message", "", "attributes", "", "logMessage", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements IECOpenTelemetryLogger {
    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryLogger
    public void logMessage(IECSpan span, String message, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
    }
}
