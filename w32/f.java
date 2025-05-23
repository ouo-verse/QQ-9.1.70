package w32;

import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    public static String a(c cVar, Span span) {
        if (span != null && span.getSpanContext() != null) {
            try {
                SpanContext spanContext = span.getSpanContext();
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[4];
                int i3 = 0;
                objArr[0] = "00";
                objArr[1] = spanContext.getTraceId();
                objArr[2] = spanContext.getSpanId();
                if (cVar.k(span)) {
                    i3 = 1;
                }
                objArr[3] = Integer.valueOf(i3);
                String format = String.format(locale, "%s-%s-%s-0%d", objArr);
                QLog.i("ICGameSpanWrapper", 1, "traceInfo:" + format);
                return format;
            } catch (Throwable th5) {
                QLog.e("SpanWrapper", 1, "getTraceInfo error:" + th5.toString());
            }
        }
        return "";
    }
}
