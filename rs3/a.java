package rs3;

import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lrs3/a;", "", "", "getCmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "getRequestData", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {
    @NotNull
    String getCmd();

    @NotNull
    MessageMicro<?> getRequestData();
}
